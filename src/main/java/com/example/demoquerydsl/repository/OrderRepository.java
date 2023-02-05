package com.example.demoquerydsl.repository;

import com.example.demoquerydsl.model.Order;
import com.example.demoquerydsl.model.QOrder;
import com.example.demoquerydsl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, QuerydslPredicateExecutor<Order> {
    List<Order> findByUser(User user);
}
