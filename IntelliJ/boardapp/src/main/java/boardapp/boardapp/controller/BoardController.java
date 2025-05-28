package boardapp.boardapp.controller;

import boardapp.boardapp.dto.BoardDto;
import boardapp.boardapp.entity.Board;
import boardapp.boardapp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 첫 글 작성 모델 보이기
    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("boardDto", new BoardDto());
        return "boards/create";
    }
    // 글 작성하기
    @PostMapping("/new")
    public String createF(@ModelAttribute BoardDto dto){
        boardService.create(dto);
        return "redirect:/boards";
    }
    //글 수정화면 불러오기
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model){
        Board board = boardService.findById(id);
        if (board == null) {
            return "redirect:/boards";
        }
        BoardDto dto = new BoardDto(board.getId(), board.getTitle(), board.getContent(), board.getWriter());
        model.addAttribute("boardDto", dto);
        return "boards/edit";
    }
    // 작성한 글들 보이기
    @GetMapping
    public String list(Model model){
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "boards/list";
    }
    //글 수정하기
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute BoardDto dto){
        boardService.update(id, dto);
        return "redirect:/boards";
    }

    //글 삭제하기
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "redirect:/boards";
    }
}
