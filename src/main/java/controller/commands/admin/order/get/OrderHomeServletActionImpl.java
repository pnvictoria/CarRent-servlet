package controller.commands.admin.order.get;

import controller.commands.admin.user.get.UserHomeServletActionImpl;
import controller.interfaces.ServletAction;
import entity.Order;
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
import java.util.List;

public class OrderHomeServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(UserHomeServletActionImpl.class);
    private final MainService<Order> orderService;
    private final String ADMIN_ORDER_HOME_PAGE;

    public OrderHomeServletActionImpl(MainService<Order> orderService) {
        this.orderService = orderService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_ORDER_HOME_PAGE = propertyPage.getPageProperty("ADMIN_ORDER_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> allOrders = null;
        try {
            allOrders = orderService.getObjects();
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        req.setAttribute("allOrders", allOrders);
        return ADMIN_ORDER_HOME_PAGE;
    }
}