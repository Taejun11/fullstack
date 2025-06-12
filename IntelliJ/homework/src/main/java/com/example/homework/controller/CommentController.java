package com.example.homework.controller;

import com.example.homework.service.BoardService;
import com.example.homework.service.CommentService;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardController boardController;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;
}
