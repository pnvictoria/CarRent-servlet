package controller.commands.general.get;

import controller.interfaces.ServletAction;
import entity.Label;
import entity.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorPageGetServletAction implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(MainPageGetServletActionImpl.class);
    private final String ERROR_PAGE;

    public ErrorPageGetServletAction() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ERROR_PAGE = propertyPage.getPageProperty("ERROR_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }
}
