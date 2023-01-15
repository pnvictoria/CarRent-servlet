package filter;

import entity.User;
import utils.ReadPropertiesFile;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    private final String ROLE_ADMIN;
    private final String SIGN_IN_PAGE;

    public LoginFilter() {
        ReadPropertiesFile property= new ReadPropertiesFile();
        ROLE_ADMIN = property.getConstantProperty("ROLE_ADMIN");
        SIGN_IN_PAGE = property.getCommandsProperty("SIGN_IN");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && ROLE_ADMIN.equals(user.getRole().getName())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/main/pages/error.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
