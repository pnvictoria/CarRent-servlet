package service;

import dao.interfaces.MainDAO;
import entity.Car;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class CarService implements MainService<Car> {

    private MainDAO<Car> daoCars;

    public CarService(MainDAO<Car> daoCars) {
        this.daoCars = daoCars;
    }

    @Override
    public boolean addObject(Car obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или логину
        Car car = daoCars.getObjectById(obj.getId());
        if (true) {
            daoCars.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
       daoCars.deleteObject(id);
    }

    @Override
    public void updateObject(Car obj) {
        daoCars.updateObject(obj);
    }

    @Override
    public Car getObjectById(int id) throws SQLException {
        return daoCars.getObjectById(id);
    }

    @Override
    public List<Car> getObjects() throws SQLException {
        return daoCars.getObjects();
    }

    @Override
    public List<Car> getByItem(Car obj) throws SQLException {
        return daoCars.getByItem(obj);
    }
}
