package pl.sdacademy.filters;

import pl.sdacademy.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminSecurityFilter", servletNames = {"AddProductServlet"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (httpServletRequest.getMethod().equalsIgnoreCase("POST") || httpServletRequest.getMethod().equalsIgnoreCase("GET")) {
            final User user = (User) httpServletRequest.getSession().getAttribute("user");

            if (user != null && user.getRoles().contains("admin")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if ( user == null) {
                httpServletRequest.setAttribute("error", "You need to be logged in!");
                httpServletRequest.getRequestDispatcher("/Login").forward(httpServletRequest, httpServletResponse);
            } else {
                httpServletRequest.setAttribute("error", "You need to be logged as admin!");
                httpServletRequest.getRequestDispatcher("/Login").forward(httpServletRequest, httpServletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
