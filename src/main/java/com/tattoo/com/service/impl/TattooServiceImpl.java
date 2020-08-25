package com.tattoo.com.service.impl;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.exception.TattooNotFoundException;
import com.tattoo.com.mapper.StyleMapper;
import com.tattoo.com.mapper.TattooMapper;
import com.tattoo.com.repository.TattooRepository;
import com.tattoo.com.service.TattooService;
import com.tattoo.com.validation.TattooValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TattooServiceImpl implements TattooService {

    public final TattooRepository tattooRepository;
    public final TattooMapper mapper;
    public final TattooValidation validation;
    public final StyleMapper styleMapper;

    @Transactional(readOnly = true)
    public List<TattooDto> getAll() {
        return mapper.mapListToDto(tattooRepository.findAll());
    }

    public TattooDto create(TattooDto tattooDto) {
        validation.validate(tattooDto);
        Tattoo tattoo = mapper.toResource(tattooDto);
        Tattoo save = tattooRepository.save(tattoo);
        return mapper.toDto(save);
    }

    public TattooDto update(Long id,
                            TattooRequest request) {
        validation.checkPositiveId(id);
        validation.validate(request);
        return tattooRepository.findById(id)
                .map(tattoo -> mapper.setTattooRequestParam(request, tattoo))
                .orElseThrow(() -> new TattooNotFoundException(id));
    }

    public void delete(Long id) {
        validation.checkPositiveId(id);
        tattooRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<TattooDto> findByStyle(String style) {
        return mapper.mapListToDto(tattooRepository.findAll().stream()
                .filter(tattoo -> tattoo.getStyle().getStyle().equalsIgnoreCase(style))
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public List<TattooDto> getByStyleId(Long style) {
        return mapper.mapListToDto(tattooRepository.findAll().stream()
                .filter(tattoo -> tattoo.getStyle().getId().equals(style))
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public List<TattooDto> findByPicture(String picture) {
        return mapper.mapListToDto(tattooRepository.findAll().stream()
                .filter(tattoo -> tattoo.getPicture().equalsIgnoreCase(picture))
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public TattooDto getById(Long id) {
        return mapper.toDto(tattooRepository.findById(id)
                .orElseThrow(() -> new TattooNotFoundException(id)));
    }
}
