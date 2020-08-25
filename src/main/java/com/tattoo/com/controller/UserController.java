package com.tattoo.com.controller;

import com.tattoo.com.dto.UserDto;
import com.tattoo.com.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserServiceImpl service;

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public UserDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
