package com.example.homework.repository;

import com.example.homework.entity.Board;
import com.example.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
