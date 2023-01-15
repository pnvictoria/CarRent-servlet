package controller.commands.user.sign_up;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpGetServletAction implements ServletAction {
    private final String SIGN_UP_PAGE;

    public SignUpGetServletAction() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        SIGN_UP_PAGE = propertyPage.getPageProperty("SIGN_UP_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return SIGN_UP_PAGE;
    }
}
