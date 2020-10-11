package com.tattoo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<com.tattoo.com.entity.order.Order, Long> {

    @Query(value = SqlQuery.Order.GET_TOTAL_PRICE, nativeQuery = true)
    Double getTotalPrice(Long id);

    @Query(value = SqlQuery.Order.GET_ORDERS_BY_USER_ID, nativeQuery = true)
    List<com.tattoo.com.entity.order.Order> getByUserId(Long id);

    @Modifying
    @Query(value = SqlQuery.Order.UPDATE_ORDER_STATUS_CLOSED, nativeQuery = true)
    void updateOrderStatusClose(Long id);
}
