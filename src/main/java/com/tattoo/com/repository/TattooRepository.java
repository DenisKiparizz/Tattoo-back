package com.tattoo.com.repository;

import com.tattoo.com.entity.tattoo.Tattoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TattooRepository extends JpaRepository<Tattoo, Long> {
    @Query(value = SqlQuery.Tattoo.GET_TATTOO_BY_STYLE_ID, nativeQuery = true)
    List<Tattoo> getTattooByStyleId(Long style_id);
}
