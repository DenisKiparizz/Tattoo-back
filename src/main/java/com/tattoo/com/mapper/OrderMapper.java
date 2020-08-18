package com.tattoo.com.mapper;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.entity.order.Order;
import com.tattoo.com.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ModelMapper modelMapper;

    public Order toResource(OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }

    public OrderDto toDto(Order order) {
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        Long userId = order.getUsers().stream()
                .map(User::getId)
                .findFirst().orElseThrow(() ->
                        new UsernameNotFoundException("User with this Id doesnt exist"));
        orderDto.setUserId(userId);
        return orderDto;
    }

    public List<OrderDto> mapList(List<Order> orderList) {
        return orderList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
