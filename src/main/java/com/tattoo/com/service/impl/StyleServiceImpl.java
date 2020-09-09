package com.tattoo.com.service.impl;

import com.tattoo.com.dto.StyleDto;
import com.tattoo.com.mapper.StyleMapper;
import com.tattoo.com.repository.StyleRepository;
import com.tattoo.com.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StyleServiceImpl implements StyleService {
    private final StyleRepository styleRepository;
    private final StyleMapper styleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StyleDto> getAll() {
        return styleMapper.mapListToDto(styleRepository.findAll());
    }
}
