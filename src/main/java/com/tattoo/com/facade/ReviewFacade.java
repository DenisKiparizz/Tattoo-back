package com.tattoo.com.facade;

import com.tattoo.com.dto.ReviewDto;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.review.Review;
import com.tattoo.com.entity.user.User;
import com.tattoo.com.mapper.ReviewMapper;
import com.tattoo.com.service.OrderService;
import com.tattoo.com.service.ReviewService;
import com.tattoo.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ReviewFacade {
    public final ReviewService reviewService;
    public final UserService userService;
    public final OrderService orderService;
    public final ReviewMapper reviewMapper;

    public List<ReviewDto> getAll() {
        return reviewMapper.mapList(reviewService.getAll());
    }

    public void create(ReviewDto reviewDto) {
        Set<User> userSet = new HashSet<>();
        userSet.add(userService.getById(reviewDto.getUserId()));
        Review review = reviewMapper.toResource(reviewDto);
        review.setUsers(userSet);
        final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        review.setCreated(LocalDate.parse(LocalDate.now().toString(), DATE_FORMAT));
        Order order = orderService.getById(reviewDto.getOrderId());
        review.setOrder(order);
        reviewService.create(review);
    }

    public Optional<ReviewDto> getReviewByOrderId(Long id) {
        return reviewService.getReviewByOrderId(id)
                .map(reviewMapper::toDto);
    }

    public void delete(Long id) {
        reviewService.delete(id);
    }
}
