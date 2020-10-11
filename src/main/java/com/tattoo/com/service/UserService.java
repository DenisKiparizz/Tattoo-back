package com.tattoo.com.service;

import com.tattoo.com.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    void delete(Long id);
}
