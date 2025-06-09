package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.dto.CommentDto;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import com.example.firstProject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j //로깅
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("articles/new")
    public String newArticle(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticleForm form){
//        System.out.println("입력한 내용: " + form.toString());
        log.info("입력한 내용: " + form.toString());
//        dto -> entity
        Article article = form.toEntity();
//        System.out.println("저장을 시도하는 내용: " + article.toString());
        log.info("저장을 시도하는 내용: " + article.toString());
        
//        repository에서 변환된 entity를  db에 저장, db설정을 안해놓으면 메모리에 저장됨
        Article saved = articleRepository.save(article);
//        System.out.println("저장된 내용: " + saved.toString());
        log.info("저장된 내용: " + saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);

        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentDtos);
        return "articles/show";
    }

    @GetMapping("articles")
    public String index(Model model){
        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }

    @GetMapping("articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());
//        dto -> entity
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
//        entity를 db에 저장
//        db에서 기존 데이터를 가져옴
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
//        기존 데이터가 있으면 값을 갱신
        if (target != null){
            articleRepository.save(articleEntity);
        }
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청 들어옴");
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        if (target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료");
        }
        return "redirect:/articles";
    }
}
