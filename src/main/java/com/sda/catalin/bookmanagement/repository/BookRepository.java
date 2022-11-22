package com.sda.catalin.bookmanagement.repository;

import com.sda.catalin.bookmanagement.model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book>{
    Optional<Book> findByTitle(String title);
}