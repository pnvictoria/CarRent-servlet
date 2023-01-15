package controller.commands.admin.label.get;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LabelAddGetServletActionImpl implements ServletAction {
    private final String ADMIN_LABEL_ADD_PAGE;

    public LabelAddGetServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_ADD_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_ADD_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ADMIN_LABEL_ADD_PAGE;
    }
}
