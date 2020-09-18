package com.tattoo.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewUtilDto {
    private Long reviewId;
    private String reviewComment;
    private Integer reviewMark;
    private Date reviewDate;
    private String orderPart;
    private Integer orderPrice;
    private String tattooPicture;
    private String tattooPictureUrl;
    private Long userId;
    private String userUsername;
}
