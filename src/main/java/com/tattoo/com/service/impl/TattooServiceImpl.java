package com.tattoo.com.service.impl;

import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.entity.tattoo.Style;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.exception.TattooNotFoundException;
import com.tattoo.com.repository.TattooRepository;
import com.tattoo.com.service.TattooService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TattooServiceImpl implements TattooService {
    public final TattooRepository tattooRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Tattoo> getAll() {
        return tattooRepository.findAll();
    }

    @Override
    public Tattoo create(Tattoo tattoo) {
        return tattooRepository.save(tattoo);
    }

    public Tattoo update(Long id, TattooRequest request) {
        return tattooRepository.findById(id)
                .map(tattoo -> updateEachTattoo(request, tattoo))
                .orElseThrow(() -> new TattooNotFoundException(id));
    }
    /**
     * This is method for update each tattoo
     */
    private Tattoo updateEachTattoo(TattooRequest tattooRequest, Tattoo tattoo) {
        ModelMapper mapper = new ModelMapper();
        tattoo.setStyle(mapper.map(tattooRequest.getStyle(), Style.class));
        mapper.map(tattooRequest, tattoo);
        Tattoo returnTattoo = mapper.map(tattooRequest, Tattoo.class);
        returnTattoo.setId(tattoo.getId());
        return returnTattoo;
    }

    @Override
    public void delete(Long id) {
        tattooRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tattoo> getByStyleId(Long style) {
        return tattooRepository.findAll().stream()
                .filter(tattoo -> tattoo.getStyle().getId().equals(style))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Tattoo getById(Long id) {
        return tattooRepository.findById(id)
                .orElseThrow(()
                        -> new TattooNotFoundException(id));
    }
}
