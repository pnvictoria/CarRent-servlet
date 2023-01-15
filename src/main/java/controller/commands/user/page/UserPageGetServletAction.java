package controller.commands.user.page;

import controller.interfaces.ServletAction;
import entity.Order;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageGetServletAction implements ServletAction {
    private final String USER_MAIN_PAGE;

    public UserPageGetServletAction() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        USER_MAIN_PAGE = propertyPage.getPageProperty("USER_MAIN_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return USER_MAIN_PAGE;
    }
}
