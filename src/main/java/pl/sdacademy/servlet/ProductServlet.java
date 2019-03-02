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

@WebServlet(value = "/Product", name = "ProductServlet")
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
            httpServletRequest.setAttribute("name", product.getName());
            httpServletRequest.setAttribute("price", product.getPrice());
            httpServletRequest.setAttribute("description", product.getDescription());
            httpServletRequest.setAttribute("category", product.getCategory());
            httpServletRequest.setAttribute("quantity", product.getQuantity());
            httpServletRequest.setAttribute("imageUrl", product.getImageUrl());

        }
        httpServletResponse.addCookie(new Cookie("lastViewed", idValue));
        httpServletRequest.getRequestDispatcher("/product.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
