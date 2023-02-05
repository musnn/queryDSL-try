package com.example.demoquerydsl.DAO;

import com.example.demoquerydsl.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderDao {

    Optional<Order> get(int id);
    Collection<Order> getAll();
    int save(Order order);
    void update(Order order);
    void delete(Order order);
}
