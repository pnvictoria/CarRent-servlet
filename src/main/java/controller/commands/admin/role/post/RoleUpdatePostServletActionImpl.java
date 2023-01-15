package controller.commands.admin.role.post;

import controller.interfaces.ServletAction;
import dao.RoleDAO;
import entity.Role;
import service.RoleService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleUpdatePostServletActionImpl implements ServletAction {
    private MainService<Role> roleService;
    private final String ADMIN_ROLE_HOME_PAGE;

    public RoleUpdatePostServletActionImpl(MainService<Role> roleService) {
        this.roleService = roleService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_ROLE_HOME_PAGE = propertyPage.getCommandsProperty("ADMIN_ROLE_HOME");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = Role.newBuilder()
                .setId(Integer.parseInt(req.getParameter("id")))
                .setName(req.getParameter("name"))
                .build();
        roleService.updateObject(role);
        return ADMIN_ROLE_HOME_PAGE;
    }
}
