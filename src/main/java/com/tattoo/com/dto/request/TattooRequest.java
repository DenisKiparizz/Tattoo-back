package com.tattoo.com.dto.request;

import com.tattoo.com.dto.TattooStyleDto;
import com.tattoo.com.entity.interfaces.TattooInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TattooRequest implements TattooInterface {
    private String picture;
    private String description;
    private String pictureUrl;
    private Integer cost;
    private TattooStyleDto style;
}
