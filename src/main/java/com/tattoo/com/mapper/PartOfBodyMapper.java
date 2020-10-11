package com.tattoo.com.mapper;

import com.tattoo.com.dto.PartOfBodyDto;
import com.tattoo.com.entity.order.PartOfBody;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PartOfBodyMapper {

    private final ModelMapper modelMapper;

    public PartOfBody toResource(PartOfBodyDto partOfBodyDto) {
        return modelMapper.map(partOfBodyDto, PartOfBody.class);
    }

    public PartOfBodyDto toDto(PartOfBody partOfBody) {
        return modelMapper.map(partOfBody, PartOfBodyDto.class);
    }

    public List<PartOfBodyDto> mapListToDto(List<PartOfBody> partOfBodies) {
        return partOfBodies.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
