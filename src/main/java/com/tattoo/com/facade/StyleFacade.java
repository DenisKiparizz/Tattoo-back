package com.tattoo.com.facade;

import com.tattoo.com.dto.StyleDto;
import com.tattoo.com.mapper.StyleMapper;
import com.tattoo.com.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StyleFacade {
    private final StyleService styleService;
    private final StyleMapper styleMapper;

    public List<StyleDto> getAll() {
        return styleMapper.mapListToDto(styleService.getAll());
    }
}
