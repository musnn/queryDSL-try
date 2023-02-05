package com.example.demoquerydsl.repository.impl;

import com.example.demoquerydsl.model.Order;
import com.example.demoquerydsl.model.QOrder;
import com.example.demoquerydsl.model.User;
import com.example.demoquerydsl.repository.OrderRepository;
import com.example.demoquerydsl.repository.OrderRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Order> findOrdersByUser(User user) {
        QOrder order = QOrder.order;
        return queryFactory.selectFrom(order)
                .where(order.user.eq(user))
                .fetch();
    }

    @Override
    public long deleteOrder(Long id) {
        QOrder order = QOrder.order;
        return queryFactory.delete(order)
                .where(order.id.eq(id))
                .execute();
    }
}

