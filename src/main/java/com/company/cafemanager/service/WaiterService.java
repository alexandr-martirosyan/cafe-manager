package com.company.cafemanager.service;

import com.company.cafemanager.entity.cafe.*;

import java.util.List;
import java.util.UUID;

public interface WaiterService {
    List<Table> seeAssignedTables(UUID waiterId);

    Order createOrder(UUID tableId);

    Order cancelOrder(UUID orderId);

    Order closeOrder(UUID orderId);

    ProductInOrder createProductInOrder(ProductInOrder productInOrder);

    ProductInOrder createProductInOrder(UUID productId, UUID orderId, int amount);

    ProductInOrder changeProductInOrderAmount(ProductInOrderId productInOrderId, int amount);

    ProductInOrder changeProductInOrderAmount(UUID productId, UUID orderId, int amount);

    ProductInOrder changeProductInOrderStatus(ProductInOrderId productInOrderId, ProductInOrderStatus status);

    ProductInOrder changeProductInOrderStatus(UUID productId, UUID orderId, ProductInOrderStatus status);

    ProductInOrder deleteProductInOrder(ProductInOrderId productInOrderId);

    ProductInOrder deleteProductInOrder(UUID productId, UUID orderId);
}
