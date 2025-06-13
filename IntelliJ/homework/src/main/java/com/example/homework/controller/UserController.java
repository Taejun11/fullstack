package com.example.homework.controller;

import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


//    로그인 페이지 불러오는 부분
    @GetMapping("login")
    public String login(){
        return "user/login";
    }

//    회원가입 페이지 불러오는 부분
    @GetMapping("singIn")
    public String singIn(){
        return "user/singIn";
    }

    @PostMapping
}
