package com.tattoo.com.controller;

import com.tattoo.com.dto.OrderDto;
import com.tattoo.com.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderFacade orderFacade;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @Operation(summary = "Get all orders")
    public List<OrderDto> getAll() {
        return orderFacade.getAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @Operation(summary = "Get order by id",
            description = "Admin uses this one for find particular order and change status . Users can get ability to see reviev with help this one")
    public OrderDto getById(@PathVariable Long id) {
        return orderFacade.getById(id);
    }

    @GetMapping("/user{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @Operation(summary = "Get all orders for particular user")
    public List<OrderDto> getByUserId(@PathVariable Long id) {
        return orderFacade.getByUserId(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @Operation(summary = "Save order")
    public void save(@RequestBody OrderDto order) {
        orderFacade.create(order);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete order")
    public void delete(@PathVariable Long id) {
        orderFacade.delete(id);
    }

    @GetMapping("price/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @Operation(summary = "Getting total prise for all orders from a user")
    public Double getTotalPrice(@PathVariable Long id) {
        return orderFacade.getTotalPrice(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "change status - set close",
            description = "When user got some kind of service(in this case - tattoo) admin can change status for this order")
    public void updateOrderStatusClose(@PathVariable Long id) {
        orderFacade.updateOrderStatusClose(id);
    }
}
