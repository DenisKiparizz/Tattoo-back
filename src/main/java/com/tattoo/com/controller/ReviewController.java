package com.tattoo.com.controller;

import com.tattoo.com.dto.ReviewDto;
import com.tattoo.com.dto.ReviewUtilDto;
import com.tattoo.com.entity.review.Review;
import com.tattoo.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void create(@RequestBody ReviewDto reviewDto) {
        reviewService.create(reviewDto);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Optional<ReviewDto> getReviewByOrderId(@PathVariable Long id) {
        return reviewService.getReviewByOrderId(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
