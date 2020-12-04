package com.company.cafemanager.service;

import com.company.cafemanager.dao.cafe.ProductDaoImpl;
import com.company.cafemanager.dao.cafe.TableDaoImpl;
import com.company.cafemanager.dao.user.ManagerDaoImpl;
import com.company.cafemanager.dao.user.WaiterDaoImpl;
import com.company.cafemanager.entity.cafe.Product;
import com.company.cafemanager.entity.cafe.Table;
import com.company.cafemanager.entity.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerDaoImpl managerDao;
    private final WaiterDaoImpl waiterDao;
    private final TableDaoImpl tableDao;
    private final ProductDaoImpl productDao;

    @Autowired
    public ManagerServiceImpl(
        ManagerDaoImpl managerDao,
        WaiterDaoImpl waiterDao,
        TableDaoImpl tableDao,
        ProductDaoImpl productDao
    ) {
        this.managerDao = managerDao;
        this.waiterDao = waiterDao;
        this.tableDao = tableDao;
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<Manager> getAllManagers() {
        return managerDao.getAll();
    }

    @Override
    @Transactional
    public List<Manager> getAllManagersInRange(int startIndex, int count) {
        return managerDao.getAllFromRange(startIndex, count);
    }

    @Override
    @Transactional
    public Manager getManager(UUID managerId) {
        return managerDao.get(managerId);
    }

    @Override
    @Transactional
    public Manager addManager(Manager manager) {
        return managerDao.save(manager);
    }

    @Override
    @Transactional
    public Manager updateManager(Manager manager) {
        return managerDao.update(manager);
    }

    @Override
    @Transactional
    public Manager deleteManager(Manager manager) {
        return managerDao.delete(manager);
    }

    @Override
    @Transactional
    public Manager deleteManager(UUID managerId) {
        return deleteManager(getManager(managerId));
    }

    @Override
    @Transactional
    public List<Waiter> getAllWaiters() {
        return waiterDao.getAll();
    }

    @Override
    @Transactional
    public List<Waiter> getAllWaitersInRange(int startIndex, int count) {
        return waiterDao.getAllFromRange(startIndex, count);
    }

    @Override
    @Transactional
    public Waiter getWaiter(UUID waiterId) {
        return waiterDao.get(waiterId);
    }

    @Override
    @Transactional
    public Waiter addWaiter(Waiter waiter) {
        return waiterDao.save(waiter);
    }

    @Override
    @Transactional
    public Waiter updateWaiter(Waiter waiter) {
        return waiterDao.update(waiter);
    }

    @Override
    @Transactional
    public Waiter deleteWaiter(Waiter waiter) {
        return waiterDao.delete(waiter);
    }

    @Override
    @Transactional
    public Waiter deleteWaiter(UUID waiterId) {
        return deleteWaiter(getWaiter(waiterId));
    }

    @Override
    @Transactional
    public List<Table> getAllTables() {
        return tableDao.getAll();
    }

    @Override
    @Transactional
    public List<Table> getAllTablesInRange(int startIndex, int count) {
        return tableDao.getAllFromRange(startIndex, count);
    }

    @Override
    @Transactional
    public Table getTable(UUID tableId) {
        return tableDao.get(tableId);
    }

    @Override
    @Transactional
    public Table addTable(Table table) {
        return tableDao.save(table);
    }

    @Override
    @Transactional
    public Table assignTableToWaiter(Table table, Waiter waiter) {
        table.setWaiter(waiter);
        return tableDao.update(table);
    }

    @Override
    @Transactional
    public Table updateTable(Table table) {
        return tableDao.update(table);
    }

    @Override
    @Transactional
    public Table deleteTable(Table table) {
        return tableDao.delete(table);
    }

    @Override
    @Transactional
    public Table deleteTable(UUID tableId) {
        return deleteTable(getTable(tableId));
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    @Transactional
    public List<Product> getAllProductsInRange(int startIndex, int count) {
        return productDao.getAllFromRange(startIndex, count);
    }

    @Override
    @Transactional
    public Product getProduct(UUID productId) {
        return productDao.get(productId);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        return productDao.update(product);
    }

    @Override
    @Transactional
    public Product deleteProduct(Product product) {
        return productDao.delete(product);
    }

    @Override
    @Transactional
    public Product deleteProduct(UUID productId) {
        return deleteProduct(getProduct(productId));
    }
}
