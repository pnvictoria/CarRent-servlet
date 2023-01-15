package service.dto;

import dao.interfaces.FilterDAO;
import dto.CarFilterDTO;
import entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.interfaces.FilterService;

import java.sql.SQLException;
import java.util.List;

public class CarFilterService implements FilterService<Car, CarFilterDTO> {
    private static final Logger LOG = LoggerFactory.getLogger(CarFilterService.class);

    private FilterDAO<Car, CarFilterDTO> filterDAO;
    public CarFilterService(FilterDAO<Car, CarFilterDTO> filterDAO) {
        this.filterDAO = filterDAO;
    }
    @Override
    public List<Car> getFilteredObjects(CarFilterDTO dto) {
        try {
            return filterDAO.getFilteredObjects(dto);
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return List.of(Car.newBuilder().build());
    }
}
