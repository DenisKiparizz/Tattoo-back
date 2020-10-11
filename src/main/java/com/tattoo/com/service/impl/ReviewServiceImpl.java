package com.tattoo.com.service.impl;

import com.tattoo.com.entity.review.Review;
import com.tattoo.com.exception.ReviewNotFoundException;
import com.tattoo.com.repository.ReviewRepository;
import com.tattoo.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Transactional(readOnly = true)
    public Optional<Review> getReviewByOrderId(Long id) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getOrder().getId().equals(id))
                .findFirst();
    }

    public void delete(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()
                        -> new ReviewNotFoundException(id));
        reviewRepository.delete(review);
    }
}
