package com.tattoo.com.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StyleDto implements StyleInterface {
    @ApiModelProperty(hidden = true)
    private Long id;
    private String style;
}
