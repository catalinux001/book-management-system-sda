package com.sda.catalin.bookmanagement.repository;

import com.sda.catalin.bookmanagement.model.Author;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author> implements AuthorRepository{
    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}