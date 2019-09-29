package com.aaa.lhm.springcloud.mapper;

import com.aaa.lhm.springcloud.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
