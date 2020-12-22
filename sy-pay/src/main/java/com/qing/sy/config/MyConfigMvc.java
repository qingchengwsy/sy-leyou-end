package com.qing.sy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: sy-leyou-end
 * @description: 配置web映射器
 * @author: qing
 * @create: 2020-11-13 14:26
 **/
@Configuration
public class MyConfigMvc implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/gw/wxpay/pay").setViewName("/pay.html");
        registry.addViewController("/gw/wxpay/fail").setViewName("/fail.html");
        registry.addViewController("/gw/wxpay/success").setViewName("/success.html");
    }
}
