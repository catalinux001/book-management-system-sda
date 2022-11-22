package com.sda.catalin.bookmanagement.service;

import com.sda.catalin.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.catalin.bookmanagement.service.exception.InvalidParameterException;

public interface BookReviewService {
    void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException;
}