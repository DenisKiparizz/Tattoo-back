package com.tattoo.com.controller;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderFacade orderFacade;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<OrderDto> getAll() {
        return orderFacade.getAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public OrderDto getById(@PathVariable Long id) {
        return orderFacade.getById(id);
    }

    @GetMapping("/user{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<OrderDto> getByUserId(@PathVariable Long id) {
        return orderFacade.getByUserId(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void save(@RequestBody OrderDto order) {
        orderFacade.create(order);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        orderFacade.delete(id);
    }

    @GetMapping("price/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Double getTotalPrice(@PathVariable Long id) {
        return orderFacade.getTotalPrice(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateOrderStatusClose(@PathVariable Long id) {
        orderFacade.updateOrderStatusClose(id);
    }
}
