package com.tattoo.com.mapper;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.entity.tattoo.Tattoo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TattooMapper {

    public final ModelMapper modelMapper;
    public final StyleMapper styleMapper;

    public TattooDto setTattooRequestParam(
            TattooRequest tattooRequest
            , Tattoo tattoo) {
        tattoo.setStyle(styleMapper.toResource(tattooRequest.getStyle()));
        modelMapper.map(tattooRequest, tattoo);
        TattooDto tattooDto = modelMapper.map(tattooRequest, TattooDto.class);
        tattooDto.setId(tattoo.getId());
        return tattooDto;
    }

    public Tattoo toResource(TattooDto tattooDto) {
        Tattoo tattoos = modelMapper.map(tattooDto, Tattoo.class);
        tattoos.setStyle(styleMapper.toResource(tattooDto.getStyle()));
        return tattoos;
    }

    public TattooDto toDto(Tattoo tattoo) {
        TattooDto tattooDto = modelMapper.map(tattoo, TattooDto.class);
        tattooDto.setStyle(styleMapper.toTattooStyleDto(tattoo.getStyle()));
        return tattooDto;
    }

    public List<TattooDto> mapListToDto(List<Tattoo> tattooList) {
        return tattooList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
