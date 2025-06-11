package com.example.homework.dto;

import com.example.homework.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CommentDto {
    private Long id;
    @JsonProperty("board_id")
    private Long boardId;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getBoard().getId(), comment.getBody());
    }
}
