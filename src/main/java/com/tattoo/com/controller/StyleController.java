package com.tattoo.com.controller;

import com.tattoo.com.dto.StyleDto;
import com.tattoo.com.facade.StyleFacade;
import com.tattoo.com.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("style")
public class StyleController {
    private final StyleFacade styleFacade;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<StyleDto> getAll() {
        return styleFacade.getAll();
    }
}
