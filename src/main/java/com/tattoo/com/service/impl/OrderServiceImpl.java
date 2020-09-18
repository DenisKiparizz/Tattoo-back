package com.tattoo.com.service.impl;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.entity.order.EStatus;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.entity.user.User;
import com.tattoo.com.exception.OrderNotFoundException;
import com.tattoo.com.exception.TattooNotFoundException;
import com.tattoo.com.mapper.OrderMapper;
import com.tattoo.com.repository.OrderRepository;
import com.tattoo.com.repository.TattooRepository;
import com.tattoo.com.repository.UserRepository;
import com.tattoo.com.service.OrderService;
import com.tattoo.com.validation.OrderValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final TattooRepository tattooRepository;
    private final UserRepository userRepository;
    private final OrderMapper mapper;
    private final OrderValidation orderValidation;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAll() {
        return mapper.mapList(orderRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDto getById(Long id) {
        return mapper.toDto(orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public void create(OrderDto orderDto) {
        orderValidation.validate(orderDto);
        Set<User> userSet = new HashSet<>();
        setUserForOrder(orderDto, userSet);
        Order order = mapper.toResource(orderDto);
        order.setStatus(EStatus.ACTIVE);
        order.setUsers(userSet);
        setDefaultOrderValues(order);
        orderRepository.save(order);
    }

    /**
     * This is util method for "create"
     *
     * @param order = this param generate in method "create"
     *              In this case we set price and date param appropriate business logic
     *              Date - now
     *              Price - calculate according value in EPartOfBody
     */
    private void setDefaultOrderValues(Order order) {
        Tattoo cost = tattooRepository
                .findById(order.getTattoo().getId())
                .orElseThrow(() -> new TattooNotFoundException(order.getTattoo().getId()));
        order.setPrice(Math.round(order.getPart().value * cost.getCost() * 100.0) / 100.0);
        order.setCreated(Date.from(Instant.now()));
    }

    /**
     * This is util method for "create"
     *
     * @param orderDto - took from "create"
     * @param userSet  - took from "create"
     */
    private void setUserForOrder(OrderDto orderDto, Set<User> userSet) {
        userSet.add(userRepository.findUserById(orderDto.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User with this id not found")));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getByUserId(Long id) {
        orderValidation.checkPositiveId(id);
        return mapper.mapList(orderRepository.findAll())
                .stream()
                .filter(orderDto -> orderDto.getUserId().equals(id))
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {
        orderValidation.checkPositiveId(id);
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrderStatusClose(Long id) {
        orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(EStatus.CLOSED);
                    return order;
                })
                .orElseThrow(() -> new NullPointerException("Order not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Double getTotalPrice(Long user_id) {
        orderValidation.checkPositiveId(user_id);
        return (orderRepository.getTotalPrice(user_id) != null)
                ? orderRepository.getTotalPrice(user_id)
                : 0;
    }
}
