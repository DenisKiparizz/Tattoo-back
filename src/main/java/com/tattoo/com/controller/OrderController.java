package com.tattoo.com.controller;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderServiceImpl service;

    @GetMapping
    public List<OrderDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void save(OrderDto order) {
        service.add(order);
    }
}
