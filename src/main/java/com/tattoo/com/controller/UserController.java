package com.tattoo.com.controller;

import com.tattoo.com.dto.UserDto;
import com.tattoo.com.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserFacade userFacade;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDto> getAll() {
        return userFacade.getAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public UserDto getById(@PathVariable Long id) {
        return userFacade.getById(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        userFacade.delete(id);
    }
}
