package controller.commands.general.get;

import controller.commands.admin.car.post.CarAddPostServletActionImpl;
import controller.interfaces.ServletAction;
import dao.LabelDAO;
import dao.LevelDAO;
import entity.Label;
import entity.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.LabelService;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class MainPageGetServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(MainPageGetServletActionImpl.class);

    private final MainService<Label> labelService;
    private final MainService<Level> levelService;
    private final String MAIN_PAGE;

    public MainPageGetServletActionImpl(MainService<Label> labelService, MainService<Level> levelService) {
        this.labelService = labelService;
        this.levelService = levelService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        MAIN_PAGE = propertyPage.getPageProperty("MAIN_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Label> allLabels = null;
        List<Level> allLevels = null;
        try {
            allLabels = labelService.getObjects();
            allLevels = levelService.getObjects();
            req.setAttribute("allLabels", allLabels);
            req.setAttribute("allLevels", allLevels);
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return MAIN_PAGE;
    }
}

