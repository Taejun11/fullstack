package RestingapiBoard.board1.service;

import RestingapiBoard.board1.dto.BoardDto;
import RestingapiBoard.board1.entity.Board;
import RestingapiBoard.board1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public Long save(BoardDto dto) {
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .createTime(LocalDateTime.now())
                .build();

        return boardRepository.save(board).getId();
    }

    public List<BoardDto> findAll() {
        return boardRepository.findAll().stream()
                .map(board -> BoardDto.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .writer(board.getWriter())
                        .createTime(board.getCreateTime())
                        .build())
                .collect(Collectors.toList());
    }

    public BoardDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createTime(board.getCreateTime())
                .build();
    }

    public void update(Long id, BoardDto dto) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(dto.getWriter());
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
