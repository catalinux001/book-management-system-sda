package com.sda.catalin.bookmanagement.service;

import com.sda.catalin.bookmanagement.model.Author;
import com.sda.catalin.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.catalin.bookmanagement.service.exception.InvalidParameterException;

import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException;

    List<Author> getAllAuthors();

}