package com.company.cafemanager.dao.cafe;

import com.company.cafemanager.dao.DaoImpl;
import com.company.cafemanager.entity.cafe.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class TableDaoImpl extends DaoImpl<Table, UUID> {
    @Autowired
    public TableDaoImpl(final EntityManager entityManager) {
        super(entityManager, Table.class);
    }
}
