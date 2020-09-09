package com.tattoo.com.service;

import com.tattoo.com.dto.TattooDto;
import com.tattoo.com.dto.request.TattooRequest;

import java.util.List;

public interface TattooService extends CrudService<TattooDto, TattooRequest> {

    List<TattooDto> getByStyleId(Long id);

    TattooDto getById(Long id);
}
