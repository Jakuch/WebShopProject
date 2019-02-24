package pl.sdacademy.filters;

import org.apache.commons.validator.routines.EmailValidator;
import pl.sdacademy.database.UserDatabase;
import pl.sdacademy.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebFilter(filterName = "EmailValidation", servletNames = {"RegisterServlet"})
public class LoginValidationFilter implements Filter {
    private UserDatabase userDatabase;
    private EmailValidator emailValidator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDatabase = UserDatabase.getInstance();
        emailValidator = EmailValidator.getInstance();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String userName = httpServletRequest.getParameter("userName");
        String userMail = httpServletRequest.getParameter("userMail");
        String userPassword = httpServletRequest.getParameter("userPassword");
        String userPassConfirm = httpServletRequest.getParameter("userPassConfirm");


        if (httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            if (userName == null || userName.isEmpty() || userMail == null || userMail.isEmpty() || userPassword == null || userPassword.isEmpty()) {
                httpServletRequest.setAttribute("error", "Incorrectly filled form!");
                httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);

            } else if (!userPassword.equals(userPassConfirm)) {
                httpServletRequest.setAttribute("error", "Password and Confirm password must be equal!");
                httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);

            } else if (userDatabase.checkIfExists(userName, userMail)) {
                httpServletRequest.setAttribute("error", "User or email already exists!");
                httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);

            } else if (emailValidator.isValid(userMail)) {
                final User newUser = userDatabase.addUser(userName, userMail, userPassword, Collections.singletonList("User"));
                httpServletRequest.getSession().setAttribute("user", newUser);
                httpServletResponse.sendRedirect("/HomePage");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
