package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class LocalizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter("sessionLocale") != null) {
            req.getSession().setAttribute("locale", req.getParameter("sessionLocale"));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
