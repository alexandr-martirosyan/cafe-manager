package com.company.cafemanager.service;

import com.company.cafemanager.entity.cafe.*;
import com.company.cafemanager.entity.user.Waiter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface WaiterService {
    List<Table> seeAssignedTables(Waiter waiter);

    List<Table> seeAssignedTables(UUID managerId);

    Order createOrder(Order order);

    Order createOrder(UUID tableId);

    Order cancelOrder(UUID orderId);

    Order cancelOrder(Order order);

    Order closeOrder(UUID orderId);

    Order closeOrder(Order order);

    ProductInOrder createProductInOrder(ProductInOrder productInOrder);

    ProductInOrder createProductInOrder(UUID productId, UUID orderId, int amount);

    ProductInOrder changeProductInOrderAmount(ProductInOrderId productInOrderId, int amount);

    ProductInOrder changeProductInOrderAmount(UUID productId, UUID orderId, int amount);

    ProductInOrder changeProductInOrderStatus(ProductInOrderId productInOrderId, ProductInOrderStatus status);

    ProductInOrder changeProductInOrderStatus(UUID productId, UUID orderId, ProductInOrderStatus status);

    ProductInOrder deleteProductInOrder(ProductInOrderId productInOrderId);

    ProductInOrder deleteProductInOrder(ProductInOrder productInOrder);

    ProductInOrder deleteProductInOrder(UUID productId, UUID orderId);
}
