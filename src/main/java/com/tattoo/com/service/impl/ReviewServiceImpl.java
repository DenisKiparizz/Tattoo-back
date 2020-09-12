package com.tattoo.com.service.impl;

import com.tattoo.com.dto.ReviewDto;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.review.Review;
import com.tattoo.com.entity.user.User;
import com.tattoo.com.mapper.ReviewMapper;
import com.tattoo.com.repository.OrderRepository;
import com.tattoo.com.repository.ReviewRepository;
import com.tattoo.com.repository.UserRepository;
import com.tattoo.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public List<ReviewDto> getAll() {
        return reviewMapper.mapList(reviewRepository.findAll());
    }

    public void create(ReviewDto reviewDto) {
        Set<User> userSet = new HashSet<>();
        setUserForReview(reviewDto, userSet);
        Review review = reviewMapper.toResource(reviewDto);
        review.setUsers(userSet);
        final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        review.setCreated(LocalDate.parse(LocalDate.now().toString(), DATE_FORMAT));
        Order order = orderRepository.findById(reviewDto.getOrderId()).orElseThrow(()
                -> new NullPointerException("Dont have order with this id"));
        review.setOrder(order);
        reviewRepository.save(review);
    }

    private void setUserForReview(ReviewDto reviewDto, Set<User> userSet) {
        userSet.add(userRepository.findUserById(reviewDto.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User with this id not found")));
    }

    @Transactional(readOnly = true)
    public Optional<ReviewDto> getReviewByOrderId(Long id) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getOrder().getId().equals(id))
                .map(reviewMapper::toDto)
                .findFirst();
    }
}
