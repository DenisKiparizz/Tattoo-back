package com.tattoo.com.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TattooStyleDto {
    private Long id;
    @ApiModelProperty(hidden = true)
    private String style;
}
