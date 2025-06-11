package com.springboot.controller;

import com.springboot.domain.Mem;
import com.springboot.domain.Member;
import com.springboot.domain.Product;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class Ex01Controller {

//    @RequestMapping(value = "/exam01", method = RequestMethod.GET)
//    public String requestMethod(){
//        return "viewPage01";
//    }
//
//    @GetMapping("exam01")
//    public String requestMethod(@RequestParam("id") String userId,
//                                @RequestParam("password") String userPw,
//                                Model model){
//        model.addAttribute("data1", "@RequestParam 예제");
//        model.addAttribute("data2", "요청 아이디 값: " + userId +
//                                                            "<br> 요청 패스워드 값: " + userPw);
//        return "viewPage";
//    }
//
//    @GetMapping("/exam03/{id}")
//    public String requestMethod(@PathVariable("id") String userId, Model model){
//        model.addAttribute("data1", "@PathVariable 예제");
//        model.addAttribute("data2", "경로 변수 id 값: " + userId);
//
//        return "viewPage03";
//    }
//
//    @GetMapping("/exam05/{id}")
//    public String requestMethod05(@PathVariable("id") String userId,
//                                  @MatrixVariable("password") String userPw,
//                                  Model model){
//        model.addAttribute("data1", "@MatrixVariable 예제");
//        model.addAttribute("data2", "경로 변수 id 값: " + userId + "<br> 요청 매트릭스 변수 패스워드 값: " + userPw);
//
//        return "viewPage03";
//    }
//
//    @GetMapping("/member")
//    public String showForm(){
//        return "viewPage02";
//    }
//
//    @PostMapping("/member")
//    public String submitForm(@ModelAttribute Member member, Model model){
//        model.addAttribute("member", member);
//
//        return "viewPage021";
//    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setAllowedFields("id", "passwd", "city", "sex", "greetings");
////        binder.setDisallowedFields("hobby");
//    }
//
//    @GetMapping("/exam01/form")
//    public String requestForm() {
//        return "viewPage71";
//    }
//
//    @PostMapping("/exam01/form")
//    public String submitForm(MultipartHttpServletRequest request, Model model){
//        String name = request.getParameter("name");
//        MultipartFile file = request.getFile("fileImage");
//        String filename   = file.getOriginalFilename();
//        File saveFile = new File("c:\\upload\\" + name + "_" + filename );
//
//        try {
//            file.transferTo(saveFile);
//            model.addAttribute("data1","MultipartHttpServletRequest 예졔" );
//            model.addAttribute("data2",filename);
//            model.addAttribute("data3", saveFile.getName() );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "viewPage_process";
//    }
//
//
//    @GetMapping("/exam/form1")
//    public String requestForm71() {
//        return "viewPage71";
//    }
//
//    @PostMapping("/exam/form1")
//    public String submitForm(@RequestParam("name") String name,
//                             @RequestParam("fileImage") MultipartFile file, Model model) {
//        String filename = file.getOriginalFilename();
//        File saveFile = new File("c:\\upload\\" + name + "_" + filename);
//
//        try {
//            file.transferTo(saveFile);
//
//            model.addAttribute("data1","@RequestParam 예제" );
//            model.addAttribute("data2",filename);
//            model.addAttribute("data3", saveFile.getName() );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "viewPage_process";
//    }
//
//    @GetMapping("/exam02/form2")
//    public String requestForm72() {
//        return "viewPage72";
//    }
//
//    @PostMapping("/exam02/form2")
//    public String submitForm2(@ModelAttribute Mem mem, Model model){
//        String name = mem.getName();
//        MultipartFile file = mem.getFileImage();
//        String filename = file.getOriginalFilename();
//        File saveFile = new File("c:\\upload\\" + name + "_" + filename);
//
//        try {
//            file.transferTo(saveFile);
//
//            model.addAttribute("data1","@RequestParam 예제" );
//            model.addAttribute("data2",filename);
//            model.addAttribute("data3", saveFile.getName() );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "viewPage_process";
//    }

//    @GetMapping("/ex01")
//    public String ShowFrom(Model model){
//        model.addAttribute("product", new Product());
//        return "view01";
//    }
//
//    @PostMapping("/ex01")
//    public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
//
//        if(bindingResult.hasErrors())
//            return "view01";
//
//        model.addAttribute("product", product);
//        return "view01_result";
//    }
//
//    @GetMapping("/ex03")
//    public String ShowFrom3(Model model){
//        model.addAttribute("member", new Member());
//        return "viewpage03";
//    }
//
//    @PostMapping("/ex03")
//    public String submit3(@Valid @ModelAttribute Member member, BindingResult bindingResult, Model model){
//
//        if(bindingResult.hasErrors())
//            return "viewpage03";
//
////        model.addAttribute("member", member);
//        return "viewpage03_result";
//    }
}
