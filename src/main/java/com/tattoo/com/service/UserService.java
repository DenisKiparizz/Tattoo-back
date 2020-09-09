package com.tattoo.com.service;

import com.tattoo.com.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(Long id);

    void delete(Long id);
}
