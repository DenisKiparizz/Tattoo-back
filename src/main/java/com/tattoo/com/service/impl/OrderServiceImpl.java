package com.tattoo.com.service.impl;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.entity.user.User;
import com.tattoo.com.exception.TattooNotFoundException;
import com.tattoo.com.mapper.OrderMapper;
import com.tattoo.com.repository.OrderRepository;
import com.tattoo.com.repository.TattooRepository;
import com.tattoo.com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl {
    private final OrderRepository orderRepository;
    private final TattooRepository tattooRepository;
    private final UserRepository userRepository;
    private final OrderMapper mapper;

    public void add(OrderDto request) {
        Set<User> userSet = new HashSet<>();
        userSet.add(userRepository.findUserById(request.getUserId()));
        Order order = mapper.toResource(request);
        order.setUsers(userSet);
        Tattoo cost = tattooRepository.findById(order.getTattoo().getId())
                .orElseThrow(TattooNotFoundException::new);
        order.setPrice(Math.round(order.getPart().value * cost.getCost() * 100.0) / 100.0);
        order.setCreated(Date.from(Instant.now()));
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getAll() {
        return mapper.mapList(orderRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getByUserId(Long id) {
        return mapper.mapList(orderRepository.findAll())
                .stream()
                .filter(orderDto -> orderDto.getUserId().equals(id))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
