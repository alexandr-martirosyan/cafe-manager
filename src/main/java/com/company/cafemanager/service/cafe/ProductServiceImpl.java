package com.company.cafemanager.service.cafe;

import com.company.cafemanager.dao.Dao;
import com.company.cafemanager.dao.cafe.ProductDaoImpl;
import com.company.cafemanager.entity.cafe.Product;
import com.company.cafemanager.service.CafeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl extends CafeServiceImpl<Product, UUID> {
    @Autowired
    public ProductServiceImpl(ProductDaoImpl productDao) {
        super(productDao, Product.class);
    }
}
