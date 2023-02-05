package com.example.demoquerydsl.repository.impl;

import com.example.demoquerydsl.model.Order;
import com.example.demoquerydsl.model.QOrder;
import com.example.demoquerydsl.model.User;
import com.example.demoquerydsl.repository.OrderRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Order> findOrdersByUser(User user) {
        QOrder order = QOrder.order;
        JPAQuery<Order> query = new JPAQuery<>(entityManager);
        query.select(order)
                .from(order)
                .where(order.user.eq(user))
                .orderBy(order.id.asc());
        return query.fetch();
    }

    @Override
    public long deleteOrder(Long id) {
        QOrder order = QOrder.order;
        return queryFactory.delete(order)
                .where(order.id.eq(id))
                .execute();
    }
}

