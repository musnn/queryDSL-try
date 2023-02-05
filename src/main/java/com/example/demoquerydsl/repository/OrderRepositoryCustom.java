package com.example.demoquerydsl.repository;

import com.example.demoquerydsl.model.Order;
import com.example.demoquerydsl.model.User;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findOrdersByUser(User user);

    public long deleteOrder(Long id);
}
