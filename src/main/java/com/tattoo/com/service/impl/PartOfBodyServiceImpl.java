package com.tattoo.com.service.impl;

import com.tattoo.com.entity.order.EPartOfBody;
import com.tattoo.com.entity.order.PartOfBody;
import com.tattoo.com.exception.PartOfBodyNotFoundException;
import com.tattoo.com.repository.PartOfBodyRepository;
import com.tattoo.com.service.PartOfBodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PartOfBodyServiceImpl implements PartOfBodyService {
    private final PartOfBodyRepository partOfBodyRepository;

    @Transactional(readOnly = true)
    public List<PartOfBody> getAll() {
        return partOfBodyRepository.findAll();
    }


    @Transactional(readOnly = true)
    public PartOfBody getById(Long id) {
        return partOfBodyRepository.findById(id)
                .orElseThrow(()
                        -> new PartOfBodyNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public PartOfBody getByPart(EPartOfBody part) {
        return partOfBodyRepository.findByPart(part).orElseThrow(()
                -> new PartOfBodyNotFoundException(part));
    }
}
