package com.aaa.lhm.springcloud.controller;

import com.aaa.lhm.springcloud.model.User;
import com.aaa.lhm.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        return iUserService.selectAllUsers();
    }
}
