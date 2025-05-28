package boardapp.boardapp.service;

import boardapp.boardapp.dto.BoardDto;
import boardapp.boardapp.entity.Board;
import boardapp.boardapp.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void create(BoardDto dto) {
        Board board = new Board(dto);
        boardRepository.save(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public void update(Long id, BoardDto dto) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        if (boardOptional.isPresent()){
            Board board = boardOptional.get();
            board.updateFromDto(dto);
            boardRepository.save(board);
        }
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }


}
