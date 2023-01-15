package controller.commands.admin.car.post;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import entity.Car;
import service.CarService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CarDeleteServletActionImpl implements ServletAction {
    private MainService<Car> carService;
    private final String ADMIN_CAR_HOME_PAGE;

    public CarDeleteServletActionImpl(MainService<Car> carService) {
        this.carService = carService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_CAR_HOME_PAGE = property.getCommandsProperty("ADMIN_CAR_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            carService.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_CAR_HOME_PAGE;
    }
}
