package controller.commands.user.rent;

import controller.interfaces.ServletAction;
import entity.Car;
import entity.Order;
import entity.State;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CarRentPostServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(CarRentPostServletActionImpl.class);
    private final MainService<Order> orderService;
    private final MainService<Car> carService;
    private final String USER_MAIN_PAGE;

    //TODO
    private int STATE = 1;

    public CarRentPostServletActionImpl(MainService<Order> orderService, MainService<Car> carService) {
        this.orderService = orderService;
        this.carService = carService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        USER_MAIN_PAGE = propertyPage.getCommandsProperty("USER_MAIN");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        try {
            Order order = Order.newBuilder()
                    .setUser((User) req.getSession().getAttribute("user"))
                    .setCar(getCar(req.getParameter("car_id")))
                    .setPhone(req.getParameter("phone"))
                    .setState(
                            State.newBuilder()
                                    .setId(STATE)
                                    .build()
                    )
                    .build();
            if(orderService.addObject(order)) {
                return USER_MAIN_PAGE;
            }
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return USER_MAIN_PAGE;
    }

    private Car getCar(String id) throws SQLException {
        return carService.getObjectById(Integer.parseInt(id));
    }
}
