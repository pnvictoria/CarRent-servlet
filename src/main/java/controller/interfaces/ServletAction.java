package controller.interfaces;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface ServletAction {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
