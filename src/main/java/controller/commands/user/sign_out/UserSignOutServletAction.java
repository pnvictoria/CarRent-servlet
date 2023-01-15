package controller.commands.user.sign_out;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSignOutServletAction implements ServletAction {
    private final String SIGN_OUT_PAGE;

    public UserSignOutServletAction() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        SIGN_OUT_PAGE = propertyPage.getCommandsProperty("MAIN");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        return SIGN_OUT_PAGE;
    }
}
