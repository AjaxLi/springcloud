package com.aaa.lhm.springcloud.controller;

import com.aaa.lhm.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers(){
        // 调用service，consumer项目的controller调用的是provider项目的controller(Http协议)
        // 如果可以模拟Http协议，就可以实现两个controller之间的调用
        // getForObject:(使用get请求方式)该方法有两个参数
        // 第一个参数:url(请求路径(localhost:8081/userAll))
        // 第二个参数:规定返回值的类型
        return restTemplate.getForObject("http://localhost:8081/userAll", List.class);
    }
}
