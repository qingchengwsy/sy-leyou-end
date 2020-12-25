package com.sy.qing;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: sy-leyou-end
 * @description:
 * @author: Su.Qing
 * @create: 2020-12-23 10:46
 **/
@SpringBootApplication
@EnableSwagger2Doc
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class,args);
    }
}
