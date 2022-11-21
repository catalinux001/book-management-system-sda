package com.sda.catalin.bookmanagement.service;


import com.sda.catalin.bookmanagement.model.Book;
import com.sda.catalin.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.catalin.bookmanagement.service.exception.InvalidParameterException;

import java.util.List;

public interface BookService {
    void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException;

    List<Book> getAllBooks();
}