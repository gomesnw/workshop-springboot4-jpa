package com.devgomes.project.repository;

import com.devgomes.project.entities.OrderItem;
import com.devgomes.project.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
