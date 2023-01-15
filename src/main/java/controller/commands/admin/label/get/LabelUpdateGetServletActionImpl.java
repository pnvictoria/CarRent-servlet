package controller.commands.admin.label.get;

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

public class LabelUpdateGetServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(LabelUpdateGetServletActionImpl.class);

    private final String ADMIN_LABEL_UPDATE_PAGE;
    private final MainService<Label> labelService;

    public LabelUpdateGetServletActionImpl(MainService<Label> labelService) {
        this.labelService = labelService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_UPDATE_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_UPDATE_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            Label label = labelService.getObjectById(Integer.parseInt(id));
            request.setAttribute("label", label);
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return ADMIN_LABEL_UPDATE_PAGE;
    }
}
