package com.company.cafemanager.dao.user;

import com.company.cafemanager.entity.user.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class WaiterDaoImpl extends UserDaoImpl<Waiter> {
    @Autowired
    public WaiterDaoImpl(final EntityManager entityManager) {
        super(entityManager, Waiter.class);
    }
}
