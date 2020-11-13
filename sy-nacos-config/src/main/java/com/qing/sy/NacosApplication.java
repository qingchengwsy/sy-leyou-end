package com.qing.sy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sy-leyou-end
 * @description:
 * @author: qing
 * @create: 2020-11-02 10:45
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class,args);
    }

    @Value("${nacos.config}")
    private String config;

    @RequestMapping("/getValue")
    public String getValue() {
        return config;
    }
}
