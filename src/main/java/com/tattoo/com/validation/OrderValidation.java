package com.tattoo.com.validation;
import com.tattoo.com.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderValidation implements ValidatorInterface<OrderDto> {

    @Override
    public void validate(OrderDto orderService) {
        checkPositiveId(orderService.getTattooId());
        checkPositiveId(orderService.getUserId());
    }

    @Override
    public void checkPositiveId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id has to be positive");
        }
    }
}
