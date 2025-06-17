package com.example.homework.dto;

import com.example.homework.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private String id;
    private String password;

    public User toEntity(){
        return new User(id, password);
    }
}
