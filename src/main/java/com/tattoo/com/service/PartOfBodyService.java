package com.tattoo.com.service;

import com.tattoo.com.entity.order.EPartOfBody;
import com.tattoo.com.entity.order.PartOfBody;

import java.util.List;

public interface PartOfBodyService {
    List<PartOfBody> getAll();

    PartOfBody getById(Long id);

    PartOfBody getByPart(EPartOfBody part);
}
