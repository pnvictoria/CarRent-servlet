package controller.commands.admin.level.get;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LevelAddGetServletActionImpl implements ServletAction {
    private final String ADMIN_LEVEL_ADD_PAGE;

    public LevelAddGetServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LEVEL_ADD_PAGE = propertyPage.getPageProperty("ADMIN_LEVEL_ADD_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ADMIN_LEVEL_ADD_PAGE;
    }
}
