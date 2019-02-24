package pl.sdacademy.servlet;

import pl.sdacademy.database.ProductDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
    private ProductDatabase productDatabase;

    @Override
    public void init() throws ServletException {
        productDatabase = ProductDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/cart.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
