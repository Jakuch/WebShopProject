package pl.sdacademy.servlet;

import pl.sdacademy.database.UserDatabase;
import pl.sdacademy.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private UserDatabase userDatabase;

    @Override
    public void init() throws ServletException {
        userDatabase = UserDatabase.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");

        Optional<User> checkLogin = userDatabase.checkLogin(login, password);

        if (checkLogin.isPresent()) {
            final User user = checkLogin.get();
            httpServletRequest.getSession().setAttribute("user", user);
            httpServletResponse.sendRedirect("/HomePage");
        } else {
            httpServletRequest.setAttribute("login_error", "Wrong login or password!");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }
}
