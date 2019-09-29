package com.aaa.lhm.springcloud.controller;

import com.aaa.lhm.springcloud.model.User;
import com.aaa.lhm.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 所有的RestFul风格的服务提供者，都必须使用的是RestController标识，
 * 如果标识了Controller则Restful调用不到
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        Map<String, Object> resultMap = userService.selectAllUsers();
        if(200 == (Integer) resultMap.get("code")){
            List<User> result = (List<User>) resultMap.get("result");
            System.out.println(8081);
            return result;
        }
        return null;
    }

}
