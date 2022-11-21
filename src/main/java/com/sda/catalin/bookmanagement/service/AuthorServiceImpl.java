package com.sda.catalin.bookmanagement.service;

import com.sda.catalin.bookmanagement.model.Author;
import com.sda.catalin.bookmanagement.repository.AuthorRepository;
import com.sda.catalin.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.catalin.bookmanagement.service.exception.InvalidParameterException;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + firstName + " is invalid!");
        }
        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid!");
        }

        authorRepository.create(new Author(firstName, lastName));
    }

    @Override
    public void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException {
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid!");
        }
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + firstName + " is invalid!");
        }
        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid!");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with id: " + authorId + "was not found!");
        }
        Author author = authorOptional.get();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.update(author);
    }

    @Override
    public void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException {
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid!");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with id: " + authorId + " was not found!");
        }
        Author author = authorOptional.get();
        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}