package com.tattoo.com.controller;

import com.tattoo.com.dto.StyleDto;
import com.tattoo.com.service.impl.StyleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("style")
public class StyleController {
    private final StyleServiceImpl service;

    @GetMapping
    public List<StyleDto> getAll() {
        return service.getAll();
    }
}
