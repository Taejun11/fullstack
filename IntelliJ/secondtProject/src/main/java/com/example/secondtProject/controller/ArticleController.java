package com.example.secondtProject.controller;

import com.example.secondtProject.dto.ArticleForm;
import com.example.secondtProject.entity.Article;
import com.example.secondtProject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;

//    게시글 목록
    @GetMapping("articles")
    public String index(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "articles/index";
    }

//    게시글 작성 페이지
    @GetMapping("articles/new")
    public String newArticle(){
        return "articles/new";
    }
//    게시글 작성 실행
    @PostMapping("articles/create")
    public String postArticle(ArticleForm form){
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles/" + saved.getId();
    }

//    게시글 상세 페이지
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/show";
    }
    
//    게시글 수정 페이지
    @GetMapping("articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/edit";
    }
//    게시글 수정 실행
    @PostMapping("articles/update")
    public String update(ArticleForm form){
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles/" + saved.getId();
    }

//    게시글 삭제 실행
    @GetMapping("articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        Article target = articleRepository.findById(id).orElse(null);
        articleRepository.delete(target);
        rttr.addFlashAttribute("msg", "삭제 완료");
        return "redirect:/articles";
    }
}
