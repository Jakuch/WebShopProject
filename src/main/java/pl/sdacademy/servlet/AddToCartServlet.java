package pl.sdacademy.servlet;

import pl.sdacademy.database.ProductDatabase;
import pl.sdacademy.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
    private ProductDatabase productDatabase;

    @Override
    public void init() throws ServletException {
        productDatabase = ProductDatabase.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Long id = Long.valueOf(httpServletRequest.getParameter("id"));
        Integer quantity = Integer.valueOf(httpServletRequest.getParameter("quantity"));
        Optional<Product> productById = productDatabase.getProductById(id);

        if (productById.isPresent() && quantity > 0) {
            final Product product = productById.get();
            if (cartExists(httpServletRequest)) {
                final Map<Product, Integer> cart = getCart(httpServletRequest);
                cart.put(product, quantity);
                if (cart.containsKey(product)) {
                    Integer oldQuantity = cart.get(product);
                    cart.remove(product);
                    cart.put(product, oldQuantity + quantity);
                }
            } else {
                createNewCartAndAddProduct(httpServletRequest, quantity, product);
            }


        } else {
            httpServletRequest.setAttribute("error", "Product not found!");
        }
        httpServletResponse.sendRedirect("/Cart");
//        httpServletRequest.getRequestDispatcher("/Cart").forward(httpServletRequest, httpServletResponse);


    }

    private Map<Product, Integer> getCart(HttpServletRequest httpServletRequest) {
        return (Map<Product, Integer>) httpServletRequest.getSession().getAttribute("cart");
    }

    private void createNewCartAndAddProduct(HttpServletRequest httpServletRequest, Integer quantity, Product product) {
        final Map<Product, Integer> newCart = new HashMap<>();
        newCart.put(product, quantity);
        httpServletRequest.getSession().setAttribute("cart", newCart);
    }

    private boolean cartExists(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession().getAttribute("cart") != null;
    }
}
