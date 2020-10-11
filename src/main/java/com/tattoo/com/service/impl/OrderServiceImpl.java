package com.tattoo.com.service.impl;

import com.tattoo.com.entity.order.Order;
import com.tattoo.com.exception.OrderNotFoundException;
import com.tattoo.com.repository.OrderRepository;
import com.tattoo.com.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> getByUserId(Long id) {
        return orderRepository.getByUserId(id);
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderRepository.delete(order);
    }

    @Override
    public void updateOrderStatusClose(Long id) {
        orderRepository.updateOrderStatusClose(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Double getTotalPrice(Long user_id) {
        return orderRepository.getTotalPrice(user_id);
    }
}
