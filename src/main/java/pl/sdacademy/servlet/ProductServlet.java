package pl.sdacademy.servlet;

import pl.sdacademy.database.ProductDatabase;
import pl.sdacademy.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
    private ProductDatabase productDatabase;

    @Override
    public void init() throws ServletException {
        productDatabase = ProductDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String idValue = httpServletRequest.getParameter("id");

        if (idValue != null) {
            Product product = productDatabase.getProducts().get(Integer.parseInt(idValue));
            setProductParameters(httpServletRequest, product);
        }
        httpServletResponse.addCookie(new Cookie("lastViewed", idValue));
        httpServletRequest.getRequestDispatcher("/product.jsp").forward(httpServletRequest, httpServletResponse);
    }


    private void setProductParameters(HttpServletRequest httpServletRequest, Product product) {
        httpServletRequest.setAttribute("name", product.getName());
        httpServletRequest.setAttribute("price", product.getPrice());
        httpServletRequest.setAttribute("description", product.getDescription());
        httpServletRequest.setAttribute("category", product.getCategory());
        httpServletRequest.setAttribute("quantity", product.getQuantity());
    }


}