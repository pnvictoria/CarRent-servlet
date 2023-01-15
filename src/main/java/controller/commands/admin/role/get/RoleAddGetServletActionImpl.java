package controller.commands.admin.role.get;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoleAddGetServletActionImpl implements ServletAction {
    private final String ADMIN_ROLE_ADD_PAGE;

    public RoleAddGetServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_ROLE_ADD_PAGE = propertyPage.getPageProperty("ADMIN_ROLE_ADD_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ADMIN_ROLE_ADD_PAGE;
    }
}
