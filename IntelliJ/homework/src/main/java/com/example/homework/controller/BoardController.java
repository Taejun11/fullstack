package com.example.homework.controller;

import com.example.homework.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

//    메인페이지 불러오는 부분
    @GetMapping("index")
    public String index(){
        return "index";
    }
//    글목록 불러오는 부분
    @GetMapping("list")
    public String boardList(){
        return "/board/listBoard";
    }
//    글작성 불러오는 부분
    @GetMapping("write")
    public String boardWrite(){
        return "/board/writeBoard";
    }
}
