package com.tattoo.com.facade;

import com.tattoo.com.dto.UserDto;
import com.tattoo.com.mapper.UserMapper;
import com.tattoo.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserMapper userMapper;
    private final UserService userService;

    public List<UserDto> getAll() {
        return userMapper.mapListToDto(userService.getAll());
    }

    public UserDto getById(Long id) {
        return userMapper.toDto(userService.getById(id));
    }

    public void delete(Long id) {
        userService.delete(id);
    }
}
