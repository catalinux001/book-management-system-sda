package com.sda.catalin.bookmanagement.repository;

import com.sda.catalin.bookmanagement.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);   // aici nu ma era nevoie de parametrizare deoarece aici cunoastem cu ce entitate lucram, adica cu book
    }
}