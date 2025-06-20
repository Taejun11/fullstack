package com.example.homework.service;

import com.example.homework.dto.UserDto;
import com.example.homework.entity.User;
import com.example.homework.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    public boolean login(UserDto userDto) {
        if (userDto.getPassword().equals(userDto.getId())){
            return true;
        }else {
            return false;
        }
    }
}
