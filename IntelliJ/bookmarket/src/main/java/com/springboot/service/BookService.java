package com.springboot.service;

import com.springboot.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface BookService{
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);
    void setNewBook(Book book);
}
