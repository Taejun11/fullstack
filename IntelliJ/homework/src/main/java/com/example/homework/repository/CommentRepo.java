package com.example.homework.repository;

import com.example.homework.entity.Board;
import com.example.homework.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
