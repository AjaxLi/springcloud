package com.aaa.lhm.springcloud.controller;

import com.aaa.lhm.springcloud.model.User;
import com.aaa.lhm.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        Map<String, Object> resultMap = userService.selectAllUsers();
        if(200 == (Integer) resultMap.get("code")){
            List<User> result = (List<User>) resultMap.get("result");
            return result;
        }
        return null;
    }
}
