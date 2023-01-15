package controller.commands.admin.level.get;

import controller.interfaces.ServletAction;
import dao.LevelDAO;
import entity.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LevelUpdateGetServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(LevelUpdateGetServletActionImpl.class);

    private final String ADMIN_LEVEL_UPDATE_PAGE;
    private final MainService<Level> levelService;

    public LevelUpdateGetServletActionImpl(MainService<Level> levelService) {
        this.levelService = levelService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LEVEL_UPDATE_PAGE = propertyPage.getPageProperty("ADMIN_LEVEL_UPDATE_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String labelId = request.getParameter("id");
        try {
            Level level = levelService.getObjectById(Integer.parseInt(labelId));
            request.setAttribute("level", level);
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return ADMIN_LEVEL_UPDATE_PAGE;
    }
}
