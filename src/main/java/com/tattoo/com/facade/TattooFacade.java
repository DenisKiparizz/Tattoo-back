package com.tattoo.com.facade;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.mapper.StyleMapper;
import com.tattoo.com.mapper.TattooMapper;
import com.tattoo.com.service.TattooService;
import com.tattoo.com.validation.TattooValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TattooFacade {
    private final TattooService tattooService;
    private final TattooMapper tattooMapper;
    private final TattooValidation validation;
    private final StyleMapper styleMapper;

    public List<TattooDto> getAll() {
        return tattooMapper.mapListToDto(tattooService.getAll());
    }

    public TattooDto create(TattooDto tattooDto) {
        validation.validate(tattooDto);
        Tattoo tattoo = tattooMapper.toResource(tattooDto);
        Tattoo save = tattooService.create(tattoo);
        return tattooMapper.toDto(save);
    }

    /**
     * Have to Fix
     */
    public TattooDto update(Long id, TattooRequest request) {
        validation.checkPositiveId(id);
        validation.validate(request);
        return tattooMapper.toDto(tattooService.update(id, request));
    }

    public void delete(Long id) {
        validation.checkPositiveId(id);
        tattooService.delete(id);
    }

    public List<TattooDto> getByStyleId(Long style) {
        return tattooMapper.mapListToDto(tattooService.getByStyleId(style));
    }

    public TattooDto getById(Long id) {
        return tattooMapper.toDto(tattooService.getById(id));
    }
}
