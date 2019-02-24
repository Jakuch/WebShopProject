package pl.sdacademy.servlet;

import pl.sdacademy.database.UserDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Register", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserDatabase userDatabase;

    @Override
    public void init() throws ServletException {
        userDatabase = UserDatabase.getInstance();
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

        httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);


    }
}
