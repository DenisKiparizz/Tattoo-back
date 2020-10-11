package com.tattoo.com.service.impl;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.entity.order.EStatus;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.order.PartOfBody;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.entity.user.User;
import com.tattoo.com.exception.OrderNotFoundException;
import com.tattoo.com.mapper.OrderMapper;
import com.tattoo.com.mapper.PartOfBodyMapper;
import com.tattoo.com.mapper.TattooMapper;
import com.tattoo.com.repository.OrderRepository;
import com.tattoo.com.repository.UserRepository;
import com.tattoo.com.service.OrderService;
import com.tattoo.com.service.PartOfBodyService;
import com.tattoo.com.service.TattooService;
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

/**
 * Create directory like a FASADE and add this layer
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final TattooService tattooRepository;
    private final TattooService tattooService;
    private final TattooMapper tattooMapper;
    private final UserRepository userRepository;
    private final PartOfBodyService partOfBodyService;
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
//        orderValidation.validate(orderDto);
        Set<User> userSet = new HashSet<>();
        setUserForOrder(orderDto, userSet);
        var order = mapper.toResource(orderDto);
        var partOfBody = getPartOfBody(orderDto);
        var tattoo = getTattoo(orderDto);

        order.setUsers(userSet);
        order.setStatus(EStatus.ACTIVE);
        order.setPartOfBody(getPartOfBody(orderDto));
        order.setCreated(Date.from(Instant.now()));
        order.setPrice(Math.round(partOfBody.getRate() * tattoo.getCost() * 100.0) / 100.0);
        orderRepository.save(order);
    }

    /**
     * This is util method for "create"
     */
    private Tattoo getTattoo(OrderDto orderDto) {
        return tattooService.getById(orderDto.getTattooId());
    }

    /**
     * This is util method for "create"
     */
    private PartOfBody getPartOfBody(OrderDto orderDto) {
        return partOfBodyService.getByPart(orderDto.getPart());
    }

    /**
     * This is util method for "create"
     */
    private void setUserForOrder(OrderDto orderDto, Set<User> userSet) {
        userSet.add(userRepository.findUserById(orderDto.getUserId())
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with this id not found")));
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
