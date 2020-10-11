package com.tattoo.com.service;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;
import com.tattoo.com.entity.tattoo.Tattoo;

import java.util.List;

public interface TattooService {
    List<Tattoo> getAll();

    Tattoo create(Tattoo tattoo);

    Tattoo update(Long id, TattooRequest request);

    void delete(Long id);

    List<Tattoo> getByStyleId(Long id);

    Tattoo getById(Long id);
}
