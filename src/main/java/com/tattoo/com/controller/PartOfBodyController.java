package com.tattoo.com.controller;

import com.tattoo.com.annotation.GetPartOfBodyDescription;
import com.tattoo.com.annotation.SwaggerAnnotation;
import com.tattoo.com.dto.PartOfBodyDto;
import com.tattoo.com.facade.PartOfBodyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("partOfBody")
public class PartOfBodyController {
    private final PartOfBodyFacade partOfBodyFacade;

    @GetMapping
    @GetPartOfBodyDescription
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<PartOfBodyDto> getAll() {
        return partOfBodyFacade.getAll();
    }

    @GetMapping("{id}")
    @SwaggerAnnotation
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public PartOfBodyDto getById(@PathVariable Long id) {
        return partOfBodyFacade.getById(id);
    }
}
