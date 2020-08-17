package com.tattoo.com.repository;

import com.tattoo.com.entity.tattoo.Tattoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TattooRepository extends JpaRepository<Tattoo, Long> {
}
