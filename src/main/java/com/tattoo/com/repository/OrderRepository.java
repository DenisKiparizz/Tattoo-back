package com.tattoo.com.repository;

import com.tattoo.com.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT sum(price) AS total FROM orders JOIN order_user ou ON orders.id = ou.order_id WHERE ou.user_id = :id",
            nativeQuery = true)
    Double getTotalPrice(Long id);
}
