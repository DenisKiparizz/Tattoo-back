package com.tattoo.com.controller;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.service.TattooService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("tattoo")
public class TattooController {

    private final TattooService tattooService;

    @GetMapping
//    @GetAllTattoosApi
    public List<TattooDto> getAll() {
        return tattooService.getAll();
    }

    @PostMapping
//    @CreateTattooApi
    public TattooDto create(TattooDto tattoo) {
        return tattooService.create(tattoo);
    }

    @PutMapping("{id}")
//    @UpdateTattooApi
    public TattooDto update(@ApiParam(value = "Tattoo ID. Make sure that value is positive", required = true, example = "1")
                            @PathVariable Long id,
                            TattooRequest tattooRequest) {
        return tattooService.update(id, tattooRequest);
    }

    @DeleteMapping("{id}")
//    @DeleteTattooApi
    public void delete(@ApiParam(value = "Tattoo ID. Make sure that value is positive", required = true, example = "1")
                       @PathVariable Long id) {
        tattooService.delete(id);
    }

    @GetMapping("{id}")
    public List<TattooDto> getByStyleId(@PathVariable Long id) {
        return tattooService.getByStyleId(id);
    }
}
