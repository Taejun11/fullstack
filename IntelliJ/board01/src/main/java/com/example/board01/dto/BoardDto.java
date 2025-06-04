package com.example.board01.dto;

import com.example.board01.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdDate;

    public BoardDto() {
    }

    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
    }

//    dto를 entity로 바꾸는 함수
    public Board toEntity(){
//        생성자 방식
//        return new Board(id, title, content, writer, createdDate);

//        빌더 방식(lombok 필요)
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .createdDate(LocalDateTime.now())
                .build();
    }
}
