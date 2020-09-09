package com.tattoo.com.mapper;

import com.tattoo.com.dto.StyleDto;
import com.tattoo.com.dto.TattooStyleDto;
import com.tattoo.com.entity.tattoo.Style;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StyleMapper {

    private final ModelMapper modelMapper;

    public Style toResource(TattooStyleDto style) {
        return modelMapper.map(style, Style.class);
    }

    public StyleDto toDto(Style style) {
        return modelMapper.map(style, StyleDto.class);
    }

    public TattooStyleDto toTattooStyleDto(Style style) {
        return modelMapper.map(style, TattooStyleDto.class);
    }

    public List<StyleDto> mapListToDto(List<Style> styles) {
        return styles.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
