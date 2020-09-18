package com.tattoo.com.service;

import com.tattoo.com.dto.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDto> getAll();

    void create(ReviewDto reviewDto);

    Optional<ReviewDto> getReviewByOrderId(Long id);

    void delete(Long id);
}
