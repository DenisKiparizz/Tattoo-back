package com.tattoo.com.controller;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.facade.TattooFacade;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("tattoo")
public class TattooController {

    private final TattooFacade tattooFacade;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<TattooDto> getAll() {
        return tattooFacade.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TattooDto create(@RequestBody TattooDto tattoo) {
        return tattooFacade.create(tattoo);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TattooDto update(@ApiParam(value = "Tattoo ID. Make sure that value is positive", required = true, example = "1")
                            @PathVariable Long id,
                            @RequestBody TattooRequest tattooRequest) {
        return tattooFacade.update(id, tattooRequest);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@ApiParam(value = "Tattoo ID. Make sure that value is positive", required = true, example = "1")
                       @PathVariable Long id) {
        tattooFacade.delete(id);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<TattooDto> getByStyleId(@PathVariable Long id) {
        return tattooFacade.getByStyleId(id);
    }

    @GetMapping("/tattoo/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public TattooDto getById(@PathVariable Long id) {
        return tattooFacade.getById(id);
    }
}
