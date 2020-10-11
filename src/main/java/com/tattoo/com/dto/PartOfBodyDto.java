package com.tattoo.com.dto;

import com.tattoo.com.entity.order.EPartOfBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartOfBodyDto {
    private Long id;
    private EPartOfBody part;
    private Double rate;
}
