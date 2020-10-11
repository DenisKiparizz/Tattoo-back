package com.tattoo.com.dto;

import com.tattoo.com.entity.order.EPartOfBody;
import com.tattoo.com.entity.order.EStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private EStatus status;
    @ApiModelProperty(hidden = true)
    private Date created;
    private Long tattooId;
    private Long userId;
}
