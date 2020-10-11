package com.tattoo.com.controller;

import com.tattoo.com.dto.ReviewDto;
import com.tattoo.com.facade.ReviewFacade;
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
    private final ReviewFacade reviewFacade;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<ReviewDto> getAll() {
        return reviewFacade.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void create(@RequestBody ReviewDto reviewDto) {
        reviewFacade.create(reviewDto);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Optional<ReviewDto> getReviewByOrderId(@PathVariable Long id) {
        return reviewFacade.getReviewByOrderId(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        reviewFacade.delete(id);
    }
}
