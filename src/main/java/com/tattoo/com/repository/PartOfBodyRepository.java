package com.tattoo.com.repository;

import com.tattoo.com.entity.order.EPartOfBody;
import com.tattoo.com.entity.order.PartOfBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartOfBodyRepository extends JpaRepository<PartOfBody, Long> {
    Optional<PartOfBody> findByPart(EPartOfBody part);
}
