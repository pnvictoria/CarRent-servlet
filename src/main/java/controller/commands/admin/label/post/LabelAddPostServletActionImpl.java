package controller.commands.admin.label.post;

import controller.commands.admin.label.get.LabelUpdateGetServletActionImpl;
import controller.interfaces.ServletAction;
import dao.LabelDAO;
import entity.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LabelAddPostServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(LabelAddPostServletActionImpl.class);

    private MainService<Label> labelService;
    private final String ADMIN_LABEL_HOME_PAGE;
    private final String ADMIN_LABEL_ADD_PAGE;

    public LabelAddPostServletActionImpl(MainService<Label> labelService) {
        this.labelService = labelService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = property.getCommandsProperty("ADMIN_LABEL_HOME");
        ADMIN_LABEL_ADD_PAGE = property.getCommandsProperty("ADMIN_LABEL_ADD");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Label label = Label.newBuilder()
                    .setName(req.getParameter("name"))
                    .build();
            if(labelService.addObject(label)) {
                return ADMIN_LABEL_HOME_PAGE;
            }
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return ADMIN_LABEL_ADD_PAGE;
    }
}
