package com.tattoo.com.facade;

import com.tattoo.com.dto.PartOfBodyDto;
import com.tattoo.com.mapper.PartOfBodyMapper;
import com.tattoo.com.service.PartOfBodyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartOfBodyFacade {
    private final PartOfBodyService partOfBodyService;
    private final PartOfBodyMapper mapper;

    public List<PartOfBodyDto> getAll() {
        return mapper.mapListToDto(partOfBodyService.getAll());
    }

    public PartOfBodyDto getById(Long id) {
        return mapper.toDto(partOfBodyService.getById(id));
    }
}
