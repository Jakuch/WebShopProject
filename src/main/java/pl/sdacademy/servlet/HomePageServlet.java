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
import java.util.List;

@WebServlet("/HomePage")
public class HomePageServlet extends HttpServlet {
    private ProductDatabase products;


    @Override
    public void init() throws ServletException {
        this.products = ProductDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Product> products = this.products.getProducts();

        if (products != null) {
            httpServletRequest.setAttribute("products", products);
        }

        if (httpServletRequest.getCookies() != null) {
            for (final Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("lastViewed")) {
                    Long aLong = Long.valueOf(cookie.getValue());
                    this.products.getProducts().stream()
                            .filter(product -> aLong.equals(product.getId()))
                            .findFirst()
                            .ifPresent(product -> httpServletRequest.setAttribute("lastViewed", product));
                }
            }
        }

        httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
