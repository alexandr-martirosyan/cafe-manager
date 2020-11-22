package com.company.cafemanager.dao.user;

import com.company.cafemanager.entity.user.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ManagerDaoImpl extends UserDaoImpl<Manager> {
    @Autowired
    public ManagerDaoImpl(final EntityManager entityManager) {
        super(entityManager, Manager.class);
    }
}
