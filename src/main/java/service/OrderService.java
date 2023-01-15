package service;

import dao.interfaces.MainDAO;
import entity.Order;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements MainService<Order> {
    private MainDAO<Order> daoOrder;

    public OrderService(MainDAO<Order> daoOrder) {
        this.daoOrder = daoOrder;
    }

    @Override
    public boolean addObject(Order obj) throws SQLException {
        if (true) {
            daoOrder.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        daoOrder.deleteObject(id);
    }

    @Override
    public void updateObject(Order obj) {
        daoOrder.updateObject(obj);
    }

    @Override
    public Order getObjectById(int id) throws SQLException {
        return daoOrder.getObjectById(id);
    }

    @Override
    public List<Order> getObjects() throws SQLException {
        return daoOrder.getObjects();
    }

    @Override
    public List<Order> getByItem(Order obj) throws SQLException {
        return daoOrder.getByItem(obj);
    }
}
