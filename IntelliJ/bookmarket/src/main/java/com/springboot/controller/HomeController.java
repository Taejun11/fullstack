package com.springboot.controller;

import com.springboot.domain.Member;
import com.springboot.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public String welcome(Model model, Authentication authentication,
                          HttpServletRequest httpServletRequest){
        if (authentication == null){
            return "welcome";
        }
//        로그인된 사용자 정보 가져옴
        User user = (User) authentication.getPrincipal();
        String userId = user.getUsername();
//        로그인된 사용자가 없으면 로그인페이지로 이동
        if (userId == null){
            return "redirect:/login";
        }

        Member member = memberService.getMemberById(userId);

        // 세션을 생성하기 전에 기존의 세션 파기
        //httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("userLoginInfo", member);
        return "welcome";
    }
}
