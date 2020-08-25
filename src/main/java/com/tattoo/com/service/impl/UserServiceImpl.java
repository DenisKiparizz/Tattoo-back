package com.tattoo.com.service.impl;

import com.tattoo.com.dto.UserDto;
import com.tattoo.com.mapper.UserMapper;
import com.tattoo.com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAll() {
        return userMapper.mapListToDto(userRepository.findAll());
    }

    public UserDto getById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found")));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
