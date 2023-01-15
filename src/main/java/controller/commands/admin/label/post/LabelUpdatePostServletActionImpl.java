package controller.commands.admin.label.post;

import controller.interfaces.ServletAction;
import dao.LabelDAO;
import entity.Label;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LabelUpdatePostServletActionImpl implements ServletAction {
    private MainService<Label> labelService;
    private final String ADMIN_LABEL_HOME_PAGE;

    public LabelUpdatePostServletActionImpl(MainService<Label> labelService) {
        this.labelService = labelService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = propertyPage.getCommandsProperty("ADMIN_LABEL_HOME");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Label label = Label.newBuilder()
                .setId(Integer.parseInt(req.getParameter("id")))
                .setName(req.getParameter("name"))
                .build();
        labelService.updateObject(label);
        return ADMIN_LABEL_HOME_PAGE;
    }
}
