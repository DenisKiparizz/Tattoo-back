package com.tattoo.com.service;

import com.tattoo.com.entity.review.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAll();

    void create(Review review);

    Optional<Review> getReviewByOrderId(Long id);

    void delete(Long id);
}
