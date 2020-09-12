package com.tattoo.com.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    @ApiModelProperty(hidden = true)
    private Long id;
    private String comment;
    private Integer mark;
    @ApiModelProperty(hidden = true)
    private LocalDate created;
    private Long orderId;
    private Long userId;
}
