package com.naruto.web.cpu;

import com.naruto.service.channel.ChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@Slf4j
@RequestMapping("/cpu")
public class CpuRest {

    @Autowired
    ChannelService channelService;

    @GetMapping("/test")
    public String test(){
        int i = 2;
        while (i > 0){
            new Thread(this::testTrue).start();
            i--;
        }
        return "执行成功";
    }

    public ConcurrentHashMap map = new ConcurrentHashMap();
    public void testTrue(){
        while (true){
            int i = 200000;
            while (i > 0){
                map.put(Thread.currentThread().getName() + i, i);
                i--;
            }
            System.out.println(map.size());
        }
    }

    public static void main(String[] args) {
        CpuRest rest = new CpuRest();
        rest.test();
    }
    
}
