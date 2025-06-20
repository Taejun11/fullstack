package com.example.homework.controller;

import com.example.homework.dto.UserDto;
import com.example.homework.entity.User;
import com.example.homework.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    로그인 하는 부분
    @PostMapping("login")
    public String loginSuccess(UserDto userDto, HttpSession httpSession){
//        if (userDto.getPassword().equals())
        if (userService.login(userDto)){
            httpSession.setAttribute("loginSession", userDto);
            return "redirect:/index";
        }else {
            return "redirect:/login";
        }
    }
//    로그아웃 하는 부분
    @GetMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/index";
    }

//    회원가입 페이지 불러오는 부분
    @GetMapping("signIn")
    public String signIn(Model model){
        model.addAttribute("userDto",new UserDto());
        return "user/signIn";
    }

//    회원가입 하는 부분
    @PostMapping("signIn")
    public String signInAction(UserDto userDto, Model model){
        User user = User.signIn(userDto);
        userService.save(user);
        return "redirect:/index";
    }
}
