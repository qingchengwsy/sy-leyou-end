package com.sy.qing;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

/**
 *
 * @program: sy-leyou-end
 * @description:
 * @author: Su.Qing
 * @create: 2020-12-23 10:46
 **/
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
@EnableSwagger2Doc
@EnableDiscoveryClient
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class,args);
    }
}
