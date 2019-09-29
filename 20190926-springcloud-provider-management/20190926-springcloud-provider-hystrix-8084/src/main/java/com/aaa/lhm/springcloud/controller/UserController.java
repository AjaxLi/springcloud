package com.aaa.lhm.springcloud.controller;

import com.aaa.lhm.springcloud.model.User;
import com.aaa.lhm.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 模拟controller调用service的时候抛出异常
     *     selectAllUsers():一定会抛出异常
     *      ---->consumer调用provider的selectAllUsers方法抛出异常
     *      ---->调用selectAllUsers方法的备用方法
     * @return
     */
    @RequestMapping("/userAll")
    //@HystrixCommand(fallbackMethod = "selectAllUsersFallBack")
    public List<User> selectAllUsers() throws Exception {
        Map<String, Object> resultMap = userService.selectAllUsers();
        if(200 == (Integer) resultMap.get("code")){
            //说明查询到数据
            throw new Exception("模拟异常，使用容断处理");

        }
        return null;
    }


    /**
     *当selectAllUsers方法进入异常阶段，hystrix会让consumer
     * 就会不再调用selectAllUsers,直接会调用selectAllUsersFallBack方法
     *
     *     后备方法(备胎):
     *     !!!就算获取不到数据，也一定必须保证正确率能达到100%!!!
     *     后备方法的返回值一定要和常用方法的返回值一模一样
     *     consumer--->常用方法
     *     后备方法的参数一定要和常用方法的参数一模一样
     *      (无论是参数类型，还是顺序，还是个数)
     *
     * @return
     */
    public List<User> selectAllUsersFallBack(){
        List<User> userList  = new ArrayList<User>();
        User user = new User();
        user.setId(1314L);
        user.setUsername("测试熔断-->用户名");
        user.setPassword("测试熔断-->密码");
        userList.add(user);
        return userList;
    }
}


