package com.xebia.order.repository;

import com.xebia.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
