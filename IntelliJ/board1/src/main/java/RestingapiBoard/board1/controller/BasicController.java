package RestingapiBoard.board1.controller;

import RestingapiBoard.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/form")
    public String formPage(){
        return "form";
    }
//    @GetMapping("/list")
//    public String formPage1(){
//        return "list";
//    } //list1과 매핑
    @GetMapping("/list")
    public String formPage(Model model){
        model.addAttribute("boards", boardService.findAll());
        return "list";
    }

//    @GetMapping("/update")
//    public String updatePage(@RequestParam Long id, Model model){
//        model.addAttribute("board", boardService.findById(id));
//        return "update";
//    } // 주소가 /update?id=숫자 로 감
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "update";
    } // 주소가 /update/숫자 로 감


    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.findById(id));
        return "detail";
    }
}
