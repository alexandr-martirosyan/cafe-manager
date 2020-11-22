package com.company.cafemanager.service.user;

import com.company.cafemanager.dao.user.ManagerDaoImpl;
import com.company.cafemanager.entity.user.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends UserServiceImpl<Manager> {
    @Autowired
    public ManagerServiceImpl(ManagerDaoImpl managerDao) {
        super(managerDao, Manager.class);
    }
}
