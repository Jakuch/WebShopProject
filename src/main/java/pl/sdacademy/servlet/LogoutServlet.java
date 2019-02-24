package pl.sdacademy.servlet;

import pl.sdacademy.database.UserDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    private UserDatabase userDatabase;

    @Override
    public void init() {
        userDatabase = UserDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletRequest.getSession().invalidate();
        httpServletResponse.sendRedirect("/HomePage");
    }
}
