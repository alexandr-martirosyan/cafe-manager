package com.company.cafemanager.service;

import com.company.cafemanager.entity.cafe.Product;
import com.company.cafemanager.entity.cafe.Table;
import com.company.cafemanager.entity.user.Manager;
import com.company.cafemanager.entity.user.Waiter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ManagerService {
    List<Manager> getAllManagers();

    List<Manager> getAllManagersInRange(int startIndex, int count);

    Manager getManager(UUID managerId);

    Manager addManager(Manager manager);

    Manager updateManager(Manager manager);

    Manager deleteManager(UUID managerId);

    List<Waiter> getAllWaiters();

    List<Waiter> getAllWaitersInRange(int startIndex, int count);

    Waiter getWaiter(UUID managerId);

    Waiter addWaiter(Waiter waiter);

    Waiter updateWaiter(Waiter waiter);

    Waiter deleteWaiter(UUID waiterId);

    List<Table> getAllTables();

    List<Table> getAllTablesInRange(int startIndex, int count);

    Table getTable(UUID tableId);

    Table addTable(Table table);

    Table assignTableToWaiter(UUID tableId, UUID waiterId);

    Table updateTable(Table table);

    Table deleteTable(UUID tableId);

    List<Product> getAllProducts();

    List<Product> getAllProductsInRange(int startIndex, int count);

    Product getProduct(UUID productId);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(UUID productId);
}