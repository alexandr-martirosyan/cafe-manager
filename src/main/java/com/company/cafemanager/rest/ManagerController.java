package com.company.cafemanager.rest;

import com.company.cafemanager.entity.cafe.Product;
import com.company.cafemanager.entity.cafe.Table;
import com.company.cafemanager.entity.user.ERole;
import com.company.cafemanager.entity.user.Manager;
import com.company.cafemanager.entity.user.Role;
import com.company.cafemanager.entity.user.Waiter;
import com.company.cafemanager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    // Manager mappings
    @GetMapping("/managers")
    public List<Manager> getAllManagers(
        @RequestParam(value = "startIndex", required = false) Integer startIndex,
        @RequestParam(value = "count", required = false) Integer count
    ) {
        if (startIndex == null || count == null) {
            return managerService.getAllManagers();
        }
        return managerService.getAllManagersInRange(startIndex, count);
    }

    @GetMapping("/manager/{managerId}")
    public Manager getManager(@PathVariable UUID managerId) {
        return managerService.getManager(managerId);
    }

    @PostMapping("/manager")
    public Manager addManager(@RequestBody Manager manager) {
        manager.addRole(new Role(ERole.MANAGER));
        return managerService.addManager(manager);
    }

    @PutMapping("/manager")
    public Manager updateManager(@RequestBody Manager manager) {
        return managerService.updateManager(manager);
    }

    @DeleteMapping("/manager/{managerId}")
    public Manager deleteManager(@PathVariable UUID managerId) {
        return managerService.deleteManager(managerId);
    }

    // Waiter Mappings
    @GetMapping("/waiters")
    public List<Waiter> getAllWaiters(
        @RequestParam(value = "startIndex", required = false) Integer startIndex,
        @RequestParam(value = "count", required = false) Integer count
    ) {
        if (startIndex == null || count == null) {
            return managerService.getAllWaiters();
        }
        return managerService.getAllWaitersInRange(startIndex, count);
    }

    @GetMapping("/waiter/{waiterId}")
    public Waiter getWaiter(@PathVariable UUID waiterId) {
        return managerService.getWaiter(waiterId);
    }

    @PostMapping("/waiter")
    public Waiter addWaiter(@RequestBody Waiter waiter) {
            waiter.addRole(new Role(ERole.WAITER));
        return managerService.addWaiter(waiter);
    }

    @PutMapping("/waiter")
    public Waiter updateWaiter(@RequestBody Waiter waiter) {
        return managerService.updateWaiter(waiter);
    }

    @DeleteMapping("/waiter/{waiterId}")
    public Waiter deleteWaiter(@PathVariable UUID waiterId) {
        return managerService.deleteWaiter(waiterId);
    }

    // Table Mappings
    @GetMapping("/tables")
    public List<Table> getAllTables(
        @RequestParam(value = "startIndex", required = false) Integer startIndex,
        @RequestParam(value = "count", required = false) Integer count
    ) {
        if (startIndex == null || count == null) {
            return managerService.getAllTables();
        }
        return managerService.getAllTablesInRange(startIndex, count);
    }

    @GetMapping("/table/{tableId}")
    public Table getTable(@PathVariable UUID tableId) {
        return managerService.getTable(tableId);
    }

    @PostMapping("/table")
    public Table addTable(
        @RequestParam(value = "capacity") Integer capacity
    ) {
        return managerService.addTable(capacity);
    }

    @PutMapping("/table")
    public Table updateTable(@RequestBody Table table) {
        return managerService.updateTable(table);
    }

    @PutMapping("/table/assign-to-waiter")
    public Table assignTableToWaiter(
        @RequestParam(value = "tableId") UUID tableId,
        @RequestParam(value = "waiterId") UUID waiterId
    ) {
        return managerService.assignTableToWaiter(tableId, waiterId);
    }

    @DeleteMapping("/table/{tableId}")
    public Table deleteTable(@PathVariable UUID tableId) {
        return managerService.deleteTable(tableId);
    }

    // Product mappings
    @GetMapping("/products")
    public List<Product> getAllProducts(
        @RequestParam(value = "startIndex", required = false) Integer startIndex,
        @RequestParam(value = "count", required = false) Integer count
    ) {
        if (startIndex == null || count == null) {
            return managerService.getAllProducts();
        }
        return managerService.getAllProductsInRange(startIndex, count);
    }

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable UUID productId) {
        return managerService.getProduct(productId);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return managerService.addProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return managerService.updateProduct(product);
    }

    @DeleteMapping("/product/{productId}")
    public Product deleteProduct(@PathVariable UUID productId) {
        return managerService.deleteProduct(productId);
    }

}
