package com.tattoo.com.service;

import com.tattoo.com.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll();

    void create(OrderDto orderDto);

    List<OrderDto> getByUserId(Long id);

    void delete(Long id);

    Double getTotalPrice(Long id);

    void updateOrderStatusClose(Long id);

}
