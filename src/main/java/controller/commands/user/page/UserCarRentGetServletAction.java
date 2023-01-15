package controller.commands.user.page;

import controller.interfaces.ServletAction;
import entity.Order;
import entity.User;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserCarRentGetServletAction implements ServletAction {
    private MainService<Order> orderService;
    private final String USER_CAR_RENT_PAGE;

    public UserCarRentGetServletAction(MainService<Order> orderService) {
        this.orderService = orderService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        USER_CAR_RENT_PAGE = propertyPage.getPageProperty("USER_CAR_RENT_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = null;
        Order order = Order.newBuilder()
                .setUser((User) req.getSession().getAttribute("user"))
                .build();
        try {
            orderList = orderService.getByItem(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("orderList", orderList);
        return USER_CAR_RENT_PAGE;
    }
}
