package com.tattoo.com.service.impl;

import com.tattoo.com.entity.user.User;
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

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
