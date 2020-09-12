package com.tattoo.com.controller;

import com.tattoo.com.dto.ReviewDto;
import com.tattoo.com.entity.review.Review;
import com.tattoo.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }

    @PostMapping
    public void create(@RequestBody ReviewDto reviewDto) {
        reviewService.create(reviewDto);
    }

    @GetMapping("{id}")
    public Optional<ReviewDto> getReviewByOrderId(@PathVariable Long id) {
        return reviewService.getReviewByOrderId(id);
    }
}
