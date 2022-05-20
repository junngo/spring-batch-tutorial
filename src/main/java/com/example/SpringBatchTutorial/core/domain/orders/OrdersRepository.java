package com.example.SpringBatchTutorial.core.domain.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository  extends JpaRepository<Orders, Integer> {
}
