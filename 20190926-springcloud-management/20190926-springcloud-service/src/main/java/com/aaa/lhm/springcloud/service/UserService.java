package com.aaa.lhm.springcloud.service;

import com.aaa.lhm.springcloud.mapper.UserMapper;
import com.aaa.lhm.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Map<String,Object> selectAllUsers() {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<User> users = userMapper.selectAll();
        if(users != null){
            resultMap.put("code",200);
            resultMap.put("result",users);
        }else {
            resultMap.put("code",400);
        }
        return resultMap;
    }
}
