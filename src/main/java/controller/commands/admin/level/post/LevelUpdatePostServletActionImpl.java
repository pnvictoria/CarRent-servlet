package controller.commands.admin.level.post;

import controller.interfaces.ServletAction;
import dao.LevelDAO;
import entity.Level;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LevelUpdatePostServletActionImpl implements ServletAction {
    private MainService<Level> levelService;
    private final String ADMIN_LEVEL_HOME_PAGE;

    public LevelUpdatePostServletActionImpl(MainService<Level> levelService) {
        this.levelService = levelService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LEVEL_HOME_PAGE = propertyPage.getCommandsProperty("ADMIN_LEVEL_HOME");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Level Level = entity.Level.newBuilder()
                .setId(Integer.parseInt(req.getParameter("id")))
                .setName(req.getParameter("name"))
                .build();
        levelService.updateObject(Level);
        return ADMIN_LEVEL_HOME_PAGE;
    }
}
