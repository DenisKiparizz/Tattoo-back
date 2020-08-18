package com.tattoo.com.repository;

import com.tattoo.com.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findUserById(Long is);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
