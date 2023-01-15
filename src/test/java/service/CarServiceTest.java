package service;

import dao.interfaces.MainDAO;
import entity.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    MainDAO<Car> carDao;

    @InjectMocks
    CarService carService;

    @Test
    void addObject() {
    }

    @Test
    void deleteObject() throws SQLException {
        int expectedId = 1;
        carService.deleteObject(expectedId);
        Mockito.verify(carDao).deleteObject(expectedId);
    }

    @Test
    void updateObject() {

    }

    @Test
    void getObjectById() {
    }

    @Test
    void getObjects() {
    }

    @Test
    void getByItem() {
    }
}