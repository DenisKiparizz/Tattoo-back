package com.tattoo.com.dto;

import com.tattoo.com.entity.order.EPartOfBody;
import com.tattoo.com.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    @ApiModelProperty(hidden = true)
    private Long id;
    private EPartOfBody part;
    @ApiModelProperty(hidden = true)
    private Double price;
    private Long tattooId;
    private Long userId;
}
