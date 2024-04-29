package com.lcx.controller;

import com.lcx.pojo.Result;
import com.lcx.pojo.User;
import com.lcx.service.UserService;
import com.lcx.util.JwtUtil;
import com.lcx.util.Md5Util;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public Result login(Integer mobile, String password, HttpServletResponse hsr) {
        User loginUser = userService.find(mobile);
        if (loginUser == null) return Result.error("手机号不存在");
        else if (!loginUser.getPassword().equals(Md5Util.getMD5String(password)))
            return Result.error("密码错误");
        else {
            Map<String, Object> claims = new HashMap<>();
            claims.put("mobile", mobile);
            String token = JwtUtil.genToken(claims);
            hsr.setHeader("Authorization", token);
            return Result.success();
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody @Validated(User.add.class) User user) {
        System.out.println(user);
        if (userService.find(user.getMobile()) != null) return Result.error("手机号已注册");
        user.setPassword(Md5Util.getMD5String(user.getPassword()));
        userService.add(user);
        return Result.success();
    }

    @RequestMapping
    public String hello(){
        return "hello";
    }
}
