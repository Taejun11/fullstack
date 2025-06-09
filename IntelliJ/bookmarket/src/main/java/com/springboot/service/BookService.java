package com.springboot.service;

import com.springboot.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService{
    List<Book> getAllBookList();


}
