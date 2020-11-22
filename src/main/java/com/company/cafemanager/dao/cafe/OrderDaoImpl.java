package com.company.cafemanager.dao.cafe;

import com.company.cafemanager.dao.DaoImpl;
import com.company.cafemanager.entity.cafe.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class OrderDaoImpl extends DaoImpl<Order, UUID> {
    @Autowired
    public OrderDaoImpl(final EntityManager entityManager) {
        super(entityManager, Order.class);
    }
}
