package com.company.cafemanager.service.user;

import com.company.cafemanager.dao.user.WaiterDaoImpl;
import com.company.cafemanager.entity.user.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaiterServiceImpl extends UserServiceImpl<Waiter> {
    @Autowired
    public WaiterServiceImpl(WaiterDaoImpl waiterDao) {
        super(waiterDao, Waiter.class);
    }
}
