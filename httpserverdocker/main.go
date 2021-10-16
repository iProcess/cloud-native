package main

import (
	"fmt"
	"io"
	"log"
	"net"
	"net/http"
	"os"
)

func main() {
	fmt.Println("entering http server main")
	http.HandleFunc("/", getRequestHeader)
	http.HandleFunc("/getEnv", getEnv)
	http.HandleFunc("/recordLog", recordLog)
	http.HandleFunc("/healthz", healthz)
	err := http.ListenAndServe(":80", nil)
	if err != nil {
		log.Fatal(err)
	}
}

//1. 接收客户端 request，并将 request 中带的 header 写入 response header
func getRequestHeader(w http.ResponseWriter, r *http.Request) {
	fmt.Println("entering getRequestHeader")
	io.WriteString(w, "========== Details of the http request header ============\n")
	for k, v := range r.Header {
		io.WriteString(w, fmt.Sprintf("%s = %s\n", k, v))
	}
}

//2. 读取当前系统的环境变量中的 VERSION 配置，并写入 response header
func getEnv(w http.ResponseWriter, r *http.Request) {
	fmt.Println("entering getEnv")
	io.WriteString(w, "========== Details of the env ============\n")
	version := os.Getenv("GOVERSION")
	if version != "" {
		io.WriteString(w, fmt.Sprintf("version is: %s\n", version))
	} else {
		io.WriteString(w, "version is nil\n")
	}
	fmt.Println(version)
}

//3. Server 端记录访问日志包括客户端 IP，HTTP 返回码，输出到 server 端的标准输出
func recordLog(w http.ResponseWriter, r *http.Request) {
	fmt.Println("entering recordLog")
	io.WriteString(w, "========== Details of the request log ============\n")
	ip, port, err := net.SplitHostPort(r.RemoteAddr)
	if err != nil {
		fmt.Printf("get req.RemoteAddr %s", err)
		return
	}
	fmt.Printf("get req.RemoteAddr found IP:%s; Port:%s", ip, port)
	io.WriteString(w, fmt.Sprintf("IP = %s\n", ip))
}

//4. 当访问 localhost/healthz 时，应返回200
func healthz(w http.ResponseWriter, r *http.Request) {
	fmt.Println("entering healthz")
	io.WriteString(w, "========== Details of the health ============\n")
	io.WriteString(w, "200\n")
}
