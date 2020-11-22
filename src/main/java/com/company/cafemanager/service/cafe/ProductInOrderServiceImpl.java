package com.company.cafemanager.service.cafe;

import com.company.cafemanager.dao.cafe.ProductInOrderDaoImpl;
import com.company.cafemanager.entity.cafe.ProductInOrder;
import com.company.cafemanager.entity.cafe.ProductInOrderId;
import com.company.cafemanager.service.CafeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInOrderServiceImpl extends CafeServiceImpl<ProductInOrder, ProductInOrderId> {
    @Autowired
    public ProductInOrderServiceImpl(ProductInOrderDaoImpl productInOrderDao) {
        super(productInOrderDao, ProductInOrder.class);
    }
}
