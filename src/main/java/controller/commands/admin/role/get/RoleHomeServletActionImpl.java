package controller.commands.admin.role.get;

import controller.interfaces.ServletAction;
import dao.RoleDAO;
import entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.RoleService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoleHomeServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(RoleHomeServletActionImpl.class);

    private MainService<Role> roleService;
    private final String ADMIN_ROLE_HOME_PAGE;

    public RoleHomeServletActionImpl(MainService<Role> roleService) {
        this.roleService = roleService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_ROLE_HOME_PAGE = propertyPage.getPageProperty("ADMIN_ROLE_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> allRoles = null;
        try {
            allRoles = roleService.getObjects();
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        req.setAttribute("allRoles", allRoles);
        return ADMIN_ROLE_HOME_PAGE;
    }
}
