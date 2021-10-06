package com.dev.ms.customer.order.core.repository;

import com.dev.ms.customer.order.core.entity.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, UUID> {
}
