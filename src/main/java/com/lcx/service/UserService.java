package com.lcx.service;

import com.lcx.pojo.User;

public interface UserService {
    User find(int mobile);

    void add(User user);
}
