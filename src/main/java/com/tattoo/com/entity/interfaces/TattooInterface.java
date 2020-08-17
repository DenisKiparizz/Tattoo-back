package com.tattoo.com.entity.interfaces;

import com.tattoo.com.dto.TattooStyleDto;

public interface TattooInterface {

    String getPicture();

    String getPictureUrl();

    String getDescription();

    TattooStyleDto getStyle();
}
