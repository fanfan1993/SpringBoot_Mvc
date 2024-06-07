package com.example.demo.service;

import com.example.demo.dao.Book;
import com.example.demo.dto.BookDTO;

public interface IBookService {
    BookDTO getBookById(long id);

    Long addBook(BookDTO bookDTO);

    void deleteBookById(long id);

    BookDTO updateBookById(long id, String name, String author, Double price);
}