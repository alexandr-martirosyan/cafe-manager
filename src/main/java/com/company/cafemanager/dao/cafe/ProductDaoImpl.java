package com.company.cafemanager.dao.cafe;

import com.company.cafemanager.dao.DaoImpl;
import com.company.cafemanager.entity.cafe.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class ProductDaoImpl extends DaoImpl<Product, UUID> {
    @Autowired
    public ProductDaoImpl(final EntityManager entityManager) {
        super(entityManager, Product.class);
    }
}
