package com.example.board01.service;

import com.example.board01.dto.BoardDto;
import com.example.board01.entity.Board;
import com.example.board01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    //    private final BoardRepository boardRepository;


    public void save(BoardDto dto) {
//    생성자 방식
/*        Board board = new Board(dto.getId(), dto.getTitle(), dto.getContent(), dto.getWriter(), LocalDateTime.now());
        boardRepository.save(board);
*/
//    Setter 방식
/*        Board board = new Board();
        board.setId(dto.getId());
        board.setContent(dto.getContent());
        board.setTitle(dto.getTitle());
        board.setWriter(dto.getWriter());
        board.setCreatedDate(LocalDateTime.now());
        boardRepository.save(board);
*/
//        빌더 방식
        boardRepository.save(dto.toEntity());
    }


    public List<BoardDto> findAll() {
//        생성자 방식1
/*        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board board : boardList){
            BoardDto dto = new BoardDto(
                    board.getId(), board.getContent(), board.getTitle(), board.getWriter(), board.getCreatedDate()
            );
            boardDtoList.add(dto);
       }
        return boardDtoList;
*/
//        생성자 방식2
/*        return boardRepository.findAll().stream()
                .map(board -> new BoardDto(board.getId(), board.getTitle(), board.getContent(), board.getWriter(), board.getCreatedDate()))
                .collect(Collectors.toList());
*/
//        Setter 방식
/*        return boardRepository.findAll().stream()
                .map(board -> {
                    BoardDto dto = new BoardDto();
                    dto.setId(board.getId());
                    dto.setContent(board.getContent());
                    dto.setWriter(board.getWriter());
                    dto.setTitle(board.getTitle());
                    dto.setCreatedDate(board.getCreatedDate());
                    return dto;
                }).collect(Collectors.toList());
*/
//        빌더 방식
        return boardRepository.findAll().stream()
                .map(board -> BoardDto.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .writer(board.getWriter())
                        .createdDate(board.getCreatedDate())
                        .build()
                ).collect(Collectors.toList());
    }

    public BoardDto findById(Long id) {
//        생성자 방식
/*        Board board = boardRepository.findById(id).orElseThrow();
        return new BoardDto(
                board.getId(), board.getContent(), board.getTitle(), board.getWriter(), board.getCreatedDate()
        );
*/
//        Setter 방식
/*       Board board = boardRepository.findById(id).orElseThrow();
        BoardDto dto = new BoardDto();
        dto.setId(board.getId());
        dto.setContent(board.getContent());
        dto.setWriter(board.getWriter());
        dto.setTitle(board.getTitle());
        dto.setCreatedDate(board.getCreatedDate());
        return dto;
*/
//        빌더 방식
        Board board = boardRepository.findById(id).orElseThrow();
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .build();
    }

    public void update(Long id, BoardDto dto) {
        Board board = boardRepository.findById(id).orElseThrow(()->new RuntimeException("수정할 글이 없습니다."));
        board.update(dto.getTitle(), dto.getContent());
//        board.setTitle(dto.getTitle());
//        board.setContent(dto.getContent());
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
