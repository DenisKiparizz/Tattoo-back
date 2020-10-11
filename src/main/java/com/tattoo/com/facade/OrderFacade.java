package com.tattoo.com.facade;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.entity.order.EStatus;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.order.PartOfBody;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.entity.user.User;
import com.tattoo.com.mapper.OrderMapper;
import com.tattoo.com.service.OrderService;
import com.tattoo.com.service.PartOfBodyService;
import com.tattoo.com.service.TattooService;
import com.tattoo.com.service.UserService;
import com.tattoo.com.validation.OrderValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final PartOfBodyService partOfBodyService;
    private final TattooService tattooService;
    private final UserService userService;
    private final OrderMapper orderMapper;
    private final OrderValidation orderValidation;

    public List<OrderDto> getAll() {
        return orderMapper.mapList(orderService.getAll());
    }

    public OrderDto getById(Long id) {
        return orderMapper.toDto(orderService.getById(id));
    }

    public void create(OrderDto orderDto) {
        orderValidation.validate(orderDto);
        Set<User> userSet = new HashSet<>();
        userSet.add(userService.getById(orderDto.getUserId()));
        Order order = orderMapper.toResource(orderDto);
        PartOfBody partOfBody = partOfBodyService.getByPart(orderDto.getPart());
        Tattoo tattoo = tattooService.getById(orderDto.getTattooId());

        order.setUsers(userSet);
        order.setStatus(EStatus.ACTIVE);
        order.setPartOfBody(partOfBody);
        order.setCreated(Date.from(Instant.now()));
        order.setPrice(Math.round(partOfBody.getRate() * tattoo.getCost() * 100.0) / 100.0);
        orderService.save(order);
    }

    public List<OrderDto> getByUserId(Long id) {
        orderValidation.checkPositiveId(id);
        return orderMapper.mapList(orderService.getByUserId(id));
    }

    public void delete(Long id) {
        orderValidation.checkPositiveId(id);
        orderService.delete(id);
    }

    public void updateOrderStatusClose(Long id) {
        orderValidation.checkPositiveId(id);
        orderService.updateOrderStatusClose(id);
    }

    public Double getTotalPrice(Long user_id) {
        orderValidation.checkPositiveId(user_id);
        return (orderService.getTotalPrice(user_id) != null)
                ? orderService.getTotalPrice(user_id)
                : 0;
    }
}
