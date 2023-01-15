package controller.commands.user.sign_in;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SignInPostServletAction implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(SignInPostServletAction.class);
    private MainService<User> userService;
    private final String ROLE_ADMIN;
    private final String ROLE_USER;

    private final String ADMIN_PAGE;
    private final String MAIN_PAGE;
    private final String SIGN_IN_PAGE;


    public SignInPostServletAction(MainService<User> userService) {
        this.userService = userService;

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        MAIN_PAGE = propertyPage.getCommandsProperty("MAIN");
        ADMIN_PAGE = propertyPage.getCommandsProperty("ADMIN_CAR_HOME");
        SIGN_IN_PAGE = propertyPage.getCommandsProperty("SIGN_IN");

        ReadPropertiesFile propertyRole= new ReadPropertiesFile();
        ROLE_ADMIN = propertyRole.getConstantProperty("ROLE_ADMIN");
        ROLE_USER = propertyRole.getConstantProperty("ROLE_USER");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;
        try {
            users = userService.getByItem(User.newBuilder().setEmail(req.getParameter("email")).build());
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        if(users != null && !users.isEmpty()) {
            User user = users.get(0);

            if ((req.getParameter("email").equals(user.getEmail())
                    && req.getParameter("password").equals(user.getPassword()))) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                String roleName = user.getRole().getName();
                if (ROLE_ADMIN.equals(roleName)) {
                    return ADMIN_PAGE;
                }
                if (ROLE_USER.equals(roleName)) {
                    return MAIN_PAGE;
                }
            }
        }
        return SIGN_IN_PAGE;
    }
}
