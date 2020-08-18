package com.tattoo.com.repository;

import com.tattoo.com.entity.tattoo.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
}
