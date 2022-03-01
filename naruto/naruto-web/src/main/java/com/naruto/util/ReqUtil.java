package com.naruto.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReqUtil {
    /**
     * production环境配置
     */
    private static final String PRODUCTION_ENV = "production";

    @Value("${spring.profiles.active}")
    public void setEnv(String env) {
        ReqUtil.env = env;
    }

    private static String env;


}
