package RestingapiBoard.board1.controller;

import RestingapiBoard.board1.dto.BoardDto;
import RestingapiBoard.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardDto> list(){
        return boardService.findAll();
    }

    @PostMapping
    public Long create(@RequestBody BoardDto dto){
        return boardService.save(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BoardDto dto){
        boardService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}
