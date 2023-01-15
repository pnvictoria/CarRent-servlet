package controller.commands.user.rent;

import controller.commands.admin.label.get.LabelUpdateGetServletActionImpl;
import controller.interfaces.ServletAction;
import entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CarRentGetServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(CarRentGetServletActionImpl.class);
    private final MainService<Car> carService;
    private final String CAR_RENT_PAGE;

    public CarRentGetServletActionImpl(MainService<Car> carService) {
        this.carService = carService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        CAR_RENT_PAGE = propertyPage.getPageProperty("CAR_RENT_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        try {
            Car car = carService.getObjectById(Integer.parseInt(carId));
            req.setAttribute("car", car);
            req.setAttribute("user", req.getSession().getAttribute("user"));
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return CAR_RENT_PAGE;
    }
}
