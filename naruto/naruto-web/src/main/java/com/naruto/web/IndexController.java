package com.naruto.web;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Slf4j如不指定topic，会打印在catalina中
 */
@Slf4j(topic = "indexControllerLog")
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("index")
    public @ResponseBody
    String index(){
        log.info("IndexController-->index");
        return "index";
    }

    @RequestMapping("findBoy")
    public Map findBoy(){
        Map<String, Object> boyMap = new HashMap<>();
        boyMap.put("name", "test");
        boyMap.put("facevalue", 100);
        log.info("IndexController-->findBoy, boyMap:{}", JSON.toJSONString(boyMap));
        return boyMap;
    }

}
