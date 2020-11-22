package com.company.cafemanager.service.cafe;

import com.company.cafemanager.dao.Dao;
import com.company.cafemanager.dao.cafe.OrderDaoImpl;
import com.company.cafemanager.entity.cafe.Order;
import com.company.cafemanager.service.CafeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl extends CafeServiceImpl<Order, UUID> {
    @Autowired
    public OrderServiceImpl(OrderDaoImpl orderDao) {
        super(orderDao, Order.class);
    }
}
