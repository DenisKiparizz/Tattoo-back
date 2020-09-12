package com.tattoo.com.mapper;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.dto.ReviewDto;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.review.Review;
import com.tattoo.com.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewMapper {
    private final ModelMapper modelMapper;

    public Review toResource(ReviewDto reviewDto) {
        return modelMapper.map(reviewDto, Review.class);
    }

    public ReviewDto toDto(Review review) {
        ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
        Long userId = review.getUsers().stream()
                .map(User::getId)
                .findFirst().orElseThrow(() ->
                        new UsernameNotFoundException("User with this Id doesnt exist"));
        reviewDto.setUserId(userId);
        return reviewDto;
    }

    public List<ReviewDto> mapList(List<Review> reviewList) {
        return reviewList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
