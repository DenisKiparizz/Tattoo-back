package com.tattoo.com.service;

import com.tattoo.com.entity.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getById(Long id);

    void save(Order order);

    List<Order> getByUserId(Long id);

    void delete(Long id);

    Double getTotalPrice(Long id);

    void updateOrderStatusClose(Long id);
}
