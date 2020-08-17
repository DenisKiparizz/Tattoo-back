package com.tattoo.com.dto;

import com.tattoo.com.entity.interfaces.TattooInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TattooDto implements TattooInterface {
    @ApiModelProperty(hidden = true)
    private Long id;
    private String picture;
    private String pictureUrl;
    private String description;
    private Integer cost;
    private TattooStyleDto style;
}
