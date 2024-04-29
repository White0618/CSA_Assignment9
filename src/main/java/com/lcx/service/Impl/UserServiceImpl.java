package com.lcx.service.Impl;


import com.lcx.mapper.UserMapper;
import com.lcx.pojo.User;
import com.lcx.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User find(int mobile) {
        return userMapper.find(mobile);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }
}
