package com.company.cafemanager.service.cafe;

import com.company.cafemanager.dao.cafe.TableDaoImpl;
import com.company.cafemanager.entity.cafe.Table;
import com.company.cafemanager.service.CafeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TableServiceImpl extends CafeServiceImpl<Table, UUID> {
    @Autowired
    public TableServiceImpl(TableDaoImpl tableDao) {
        super(tableDao, Table.class);
    }
}
