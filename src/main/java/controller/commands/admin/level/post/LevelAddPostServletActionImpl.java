package controller.commands.admin.level.post;

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

public class LevelAddPostServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(LevelAddPostServletActionImpl.class);

    private MainService<Level> levelService;
    private final String ADMIN_LEVEL_HOME_PAGE;
    private final String ADMIN_LEVEL_ADD_PAGE;

    public LevelAddPostServletActionImpl(MainService<Level> levelService) {
        this.levelService = levelService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_LEVEL_HOME_PAGE = property.getCommandsProperty("ADMIN_LEVEL_HOME");
        ADMIN_LEVEL_ADD_PAGE = property.getCommandsProperty("ADMIN_LEVEL_ADD");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Level level = Level.newBuilder()
                    .setName(req.getParameter("name"))
                    .build();
            if(levelService.addObject(level)) {
                return ADMIN_LEVEL_HOME_PAGE;
            }
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return ADMIN_LEVEL_ADD_PAGE;
    }
}
