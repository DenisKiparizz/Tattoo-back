package com.tattoo.com.controller;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.service.TattooService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("tattoo")
public class TattooController {

    private final TattooService tattooService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<TattooDto> getAll() {
        return tattooService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TattooDto create(@RequestBody TattooDto tattoo) {
        return tattooService.create(tattoo);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TattooDto update(@ApiParam(value = "Tattoo ID. Make sure that value is positive", required = true, example = "1")
                            @PathVariable Long id,
                            @RequestBody TattooRequest tattooRequest) {
        return tattooService.update(id, tattooRequest);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@ApiParam(value = "Tattoo ID. Make sure that value is positive", required = true, example = "1")
                       @PathVariable Long id) {
        tattooService.delete(id);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<TattooDto> getByStyleId(@PathVariable Long id) {
        return tattooService.getByStyleId(id);
    }

    @GetMapping("/tattoo/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public TattooDto getById(@PathVariable Long id) {
        return tattooService.getById(id);
    }
}
