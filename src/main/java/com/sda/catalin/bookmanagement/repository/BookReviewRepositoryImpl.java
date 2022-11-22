package com.sda.catalin.bookmanagement.repository;

import com.sda.catalin.bookmanagement.model.Review;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository{
    public BookReviewRepositoryImpl() {
        super(Review.class);
    }
}