package com.company.cafemanager.dao.cafe;

import com.company.cafemanager.dao.DaoImpl;
import com.company.cafemanager.entity.cafe.ProductInOrder;
import com.company.cafemanager.entity.cafe.ProductInOrderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ProductInOrderDaoImpl extends DaoImpl<ProductInOrder, ProductInOrderId> {
    @Autowired
    public ProductInOrderDaoImpl(final EntityManager entityManager) {
        super(entityManager, ProductInOrder.class);
    }
}
