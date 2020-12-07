package com.company.cafemanager.rest;

import com.company.cafemanager.entity.cafe.*;
import com.company.cafemanager.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/waiter")
public class WaiterController {
    private final WaiterService waiterService;

    @Autowired
    public WaiterController(final WaiterService waiterService) {
        this.waiterService = waiterService;
    }

    @GetMapping("/tables/{waiterId}")
    public List<Table> seeAssignedTables(@PathVariable UUID waiterId) {
        return waiterService.seeAssignedTables(waiterId);
    }

    @PostMapping("/order/createOrder/{tableId}")
    public Order createOrder(@PathVariable UUID tableId) {
        return waiterService.createOrder(tableId);
    }

    @DeleteMapping("/order/cancelOrder/{orderId}")
    public Order cancelOrder(@PathVariable UUID orderId) {
        return waiterService.cancelOrder(orderId);
    }

    @DeleteMapping("/order/closeOrder/{orderId}")
    public Order closeOrder(@PathVariable UUID orderId) {
        return waiterService.closeOrder(orderId);
    }

    @PostMapping("/productInOrder")
    public ProductInOrder createProductInOrder(ProductInOrder productInOrder) {
        return waiterService.createProductInOrder(productInOrder);
    }

    @PostMapping("/productInOrder")
    public ProductInOrder createProductInOrder(
        @RequestParam(value = "productId") UUID productId,
        @RequestParam(value = "orderId") UUID orderId,
        @RequestParam(value = "amount") int amount
    ) {
        return waiterService.createProductInOrder(productId, orderId, amount);
    }

    @PutMapping("/productInOrder/changeAmount/{amount}")
    public ProductInOrder changeProductInOrderAmount(
        @RequestBody ProductInOrderId productInOrderId,
        @PathVariable int amount
    ) {
        return waiterService.changeProductInOrderAmount(productInOrderId, amount);
    }

    @PutMapping("/productInOrder/changeAmount")
    public ProductInOrder changeProductInOrderAmount(
        @RequestParam(value = "productId") UUID productId,
        @RequestParam(value = "orderId") UUID orderId,
        @RequestParam(value = "amount") int amount
    ) {
        return waiterService.changeProductInOrderAmount(productId, orderId, amount);
    }

    @PutMapping("/productInOrder/changeStatus/{status}")
    public ProductInOrder changeProductInOrderStatus(
        @RequestBody ProductInOrderId productInOrderId,
        @PathVariable ProductInOrderStatus status
    ) {
        return waiterService.changeProductInOrderStatus(productInOrderId, status);
    }

    @PutMapping("/productInOrder/changeStatus")
    public ProductInOrder changeProductInOrderStatus(
        @RequestParam(value = "productId") UUID productId,
        @RequestParam(value = "orderId") UUID orderId,
        @RequestParam(value = "status") ProductInOrderStatus status
    ) {
        return waiterService.changeProductInOrderStatus(productId, orderId, status);
    }

    @DeleteMapping("/productInOrder")
    public ProductInOrder deleteProductInOrder(@RequestBody ProductInOrderId productInOrderId) {
        return waiterService.deleteProductInOrder(productInOrderId);
    }

    @DeleteMapping("/productInOrder")
    public ProductInOrder deleteProductInOrder(
        @RequestParam(value = "productId") UUID productId,
        @RequestParam(value = "orderId") UUID orderId
    ) {
        return waiterService.deleteProductInOrder(productId, orderId);
    }
}
