package com.naruto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 将外部资源文件引入springboot中
 * 在入口类的可扫描环境下
 */
@Configuration
@ImportResource(value={"classpath*:spring-config.xml"})
public class XMLSource {

}
