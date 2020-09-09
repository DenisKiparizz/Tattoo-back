package com.tattoo.com.service.impl;

import com.tattoo.com.dto.UserDto;
import com.tattoo.com.mapper.UserMapper;
import com.tattoo.com.repository.UserRepository;
import com.tattoo.com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userMapper.mapListToDto(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found")));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
