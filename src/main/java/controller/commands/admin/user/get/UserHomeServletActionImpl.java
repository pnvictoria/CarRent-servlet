package controller.commands.admin.user.get;

import controller.commands.admin.role.post.RoleAddPostServletActionImpl;
import controller.interfaces.ServletAction;
import dao.UserDAO;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserHomeServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(UserHomeServletActionImpl.class);
    private final MainService<User> userService;
    private final String ADMIN_USER_HOME_PAGE;

    public UserHomeServletActionImpl(MainService<User> userService) {
        this.userService = userService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_USER_HOME_PAGE = propertyPage.getPageProperty("ADMIN_USER_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = null;
        try {
            allUsers = userService.getObjects();
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        req.setAttribute("allUsers", allUsers);
        return ADMIN_USER_HOME_PAGE;
    }
}
