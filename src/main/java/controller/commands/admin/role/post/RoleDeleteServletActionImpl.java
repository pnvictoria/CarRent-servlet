package controller.commands.admin.role.post;

import controller.interfaces.ServletAction;
import dao.RoleDAO;
import entity.Role;
import service.RoleService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RoleDeleteServletActionImpl implements ServletAction {
    private MainService<Role> roleService;
    private final String ADMIN_ROLE_HOME_PAGE;

    public RoleDeleteServletActionImpl(MainService<Role> roleService) {
        this.roleService = roleService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_ROLE_HOME_PAGE = property.getCommandsProperty("ADMIN_ROLE_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            roleService.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_ROLE_HOME_PAGE;
    }
}