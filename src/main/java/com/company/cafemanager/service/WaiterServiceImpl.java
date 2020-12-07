package com.company.cafemanager.service;

import com.company.cafemanager.dao.cafe.OrderDaoImpl;
import com.company.cafemanager.dao.cafe.ProductDaoImpl;
import com.company.cafemanager.dao.cafe.ProductInOrderDaoImpl;
import com.company.cafemanager.dao.cafe.TableDaoImpl;
import com.company.cafemanager.dao.user.WaiterDaoImpl;
import com.company.cafemanager.entity.cafe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WaiterServiceImpl implements WaiterService {
    private final WaiterDaoImpl waiterDao;
    private final OrderDaoImpl orderDao;
    private final TableDaoImpl tableDao;
    private final ProductInOrderDaoImpl productInOrderDao;
    private final ProductDaoImpl productDao;

    @Autowired
    public WaiterServiceImpl(
        WaiterDaoImpl waiterDao,
        OrderDaoImpl orderDao,
        TableDaoImpl tableDao,
        ProductInOrderDaoImpl productInOrderDao,
        ProductDaoImpl productDao
    ) {
        this.waiterDao = waiterDao;
        this.orderDao = orderDao;
        this.tableDao = tableDao;
        this.productInOrderDao = productInOrderDao;
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<Table> seeAssignedTables(UUID waiterId) {
        return waiterDao.get(waiterId).getTables();
    }

    @Override
    @Transactional
    public Order createOrder(UUID tableId) {
        Table table = tableDao.get(tableId);
        if (table.getOrders().stream().anyMatch(order -> order.getStatus() == OrderStatus.OPEN)) {
            throw new IllegalStateException("Table has an order witch is already open.");
        }
        Order order = new Order(
            table,
            OrderStatus.OPEN
        );
        return orderDao.save(order);
    }

    @Override
    @Transactional
    public Order cancelOrder(UUID orderId) {
        Order order = orderDao.get(orderId);
        order.setStatus(OrderStatus.CANCELLED);
        return orderDao.delete(order);
    }

    @Override
    @Transactional
    public Order closeOrder(UUID orderId) {
        Order order = orderDao.get(orderId);
        order.setStatus(OrderStatus.CLOSED);
        return orderDao.delete(order);
    }

    @Override
    @Transactional
    public ProductInOrder createProductInOrder(ProductInOrder productInOrder) {
        return productInOrderDao.save(productInOrder);
    }

    @Override
    @Transactional
    public ProductInOrder createProductInOrder(UUID productId, UUID orderId, int amount) {
        ProductInOrder productInOrder = new ProductInOrder(
            new ProductInOrderId(
                productDao.get(productId),
                orderDao.get(orderId)
            ),
            amount
        );
        return productInOrderDao.save(productInOrder);
    }

    @Override
    @Transactional
    public ProductInOrder changeProductInOrderAmount(ProductInOrderId productInOrderId, int amount) {
        ProductInOrder productInOrder = productInOrderDao.get(productInOrderId);
        productInOrder.setAmount(amount);
        return productInOrderDao.update(productInOrder);
    }

    @Override
    @Transactional
    public ProductInOrder changeProductInOrderAmount(UUID productId, UUID orderId, int amount) {
        return changeProductInOrderAmount(
            new ProductInOrderId(
                productDao.get(productId),
                orderDao.get(orderId)
            ),
            amount
        );
    }

    @Override
    @Transactional
    public ProductInOrder changeProductInOrderStatus(ProductInOrderId productInOrderId, ProductInOrderStatus status) {
        ProductInOrder productInOrder = productInOrderDao.get(productInOrderId);
        productInOrder.setStatus(status);
        return productInOrderDao.update(productInOrder);
    }

    @Override
    @Transactional
    public ProductInOrder changeProductInOrderStatus(UUID productId, UUID orderId, ProductInOrderStatus status) {
        return changeProductInOrderStatus(
            new ProductInOrderId(
                productDao.get(productId),
                orderDao.get(orderId)
            ),
            status
        );
    }

    @Override
    @Transactional
    public ProductInOrder deleteProductInOrder(ProductInOrderId productInOrderId) {
        return productInOrderDao.delete(productInOrderDao.get(productInOrderId));
    }

    @Override
    @Transactional
    public ProductInOrder deleteProductInOrder(UUID productId, UUID orderId) {
        return deleteProductInOrder(
            new ProductInOrderId(
                productDao.get(productId),
                orderDao.get(orderId)
            )
        );
    }
}
