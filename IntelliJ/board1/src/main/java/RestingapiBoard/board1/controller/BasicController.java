package RestingapiBoard.board1.controller;

import RestingapiBoard.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/form")
    public String formPage(){
        return "form";
    }
    @GetMapping("/list")
    public String formPage1(){
        return "list";
    }
    @GetMapping("/update")
    public String updataPage(@RequestParam Long id, Model model){
        model.addAttribute("board", boardService.findById(id));
        return "update";
    }


}
