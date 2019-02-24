package pl.sdacademy.servlet;

import org.apache.commons.validator.routines.EmailValidator;
import pl.sdacademy.database.UserDatabase;
import pl.sdacademy.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private UserDatabase userDatabase;
    private EmailValidator emailValidator;

    @Override
    public void init() throws ServletException {
        userDatabase = UserDatabase.getInstance();
        emailValidator = EmailValidator.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String userName = httpServletRequest.getParameter("userName");
        String userMail = httpServletRequest.getParameter("userMail");
        String userPassword = httpServletRequest.getParameter("userPassword");
        String userPassConfirm = httpServletRequest.getParameter("userPassConfirm");

        if (userName == null || userName.isEmpty() || userMail == null || userMail.isEmpty() || userPassword == null || userPassword.isEmpty()) {
            httpServletRequest.setAttribute("error", "Incorrectly filled form!");
            httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);

        } else if (userDatabase.checkIfExists(userName, userMail)) {
            httpServletRequest.setAttribute("error", "User or user email already exists!");
            httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);

        } else if (!userPassword.equals(userPassConfirm)) {
            httpServletRequest.setAttribute("error", "Password and Confirm password must be equal!");
        } else {
            if (emailValidator.isValid(userMail)) {
                final User newUser = userDatabase.addUser(userName, userMail, userPassword, Collections.singletonList("User"));
                httpServletRequest.getSession().setAttribute("user", newUser);
                httpServletResponse.sendRedirect("/HomePage");
            }
        }
    }

}
