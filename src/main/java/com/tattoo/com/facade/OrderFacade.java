package com.tattoo.com.facade;

import com.tattoo.com.mapper.OrderMapper;
import com.tattoo.com.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderFacade {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

}
