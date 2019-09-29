package com.aaa.lhm.springcloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 因为ConfigRest是配置类，所以必须要加上@Configuration/@SpringBootApplication
 *
 *  @SpringBootApplication+@Bean-->相当于application.xml配置文件
 *
 *  RestTemplate:就是模拟了Http协议，使两个controller之间实现调用
 *  post
 *  get
 *  ....
 */
@SpringBootApplication
public class ConfigRest {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
