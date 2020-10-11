package com.tattoo.com.facade;

import com.tattoo.com.dto.StyleDto;
import com.tattoo.com.mapper.StyleMapper;
import com.tattoo.com.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StyleFacade {
    public final StyleService styleService;
    public final StyleMapper styleMapper;

    public List<StyleDto> getAll() {
        return styleMapper.mapListToDto(styleService.getAll());
    }
}
