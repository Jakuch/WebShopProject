package pl.sdacademy.servlet;

import pl.sdacademy.database.OrderDatabase;
import pl.sdacademy.database.ProductDatabase;
import pl.sdacademy.model.Order;
import pl.sdacademy.model.Product;
import pl.sdacademy.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet(value = "/Order", name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderDatabase orderDatabase;
    private ProductDatabase productDatabase;

    @Override
    public void init() throws ServletException {
        orderDatabase = OrderDatabase.getInstance();
        productDatabase = ProductDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/order.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession(false);
        User user = (User) session.getAttribute("user");
        String address = httpServletRequest.getParameter("address");
        String userMail = httpServletRequest.getParameter("userMail");
        Map<Product, Integer> cart = (Map<Product, Integer>) httpServletRequest.getSession().getAttribute("cart");

//        for (Map.Entry<Product, Integer> product : cart.entrySet()) {
//                Optional<Product> first = productDatabase.getProducts().stream()
//                        .filter(prod -> prod.getId().equals(product.getKey().getId()))
//                        .findFirst();
//                if (first.isPresent()){
//                    Product existingProduct = first.get();
//                    if(existingProduct.getQuantity() - product.getValue() >= 0) {
//                        orderDatabase.createOrder(user.getEmail(),address,cart);
//                        httpServletResponse.sendRedirect("/order.jsp");
//                    } else {
//                        httpServletResponse.sendRedirect("/error.jsp");
//                    }
//                } else {
//                    httpServletResponse.sendRedirect("/error.jsp");
//                }
//        }

        if (user != null && cart != null) {
            Long id = orderDatabase.createOrder(user.getEmail(), address, cart);
            httpServletRequest.getSession().setAttribute("address", address);
            httpServletResponse.sendRedirect(String.format("/Order?id=%s", id));
        } else if (user == null && cart != null) {
            Long id = orderDatabase.createOrder(userMail, address, cart);
            httpServletRequest.setAttribute("orderID",id);
            httpServletRequest.setAttribute("userMail",userMail);
            httpServletRequest.setAttribute("address",address);
            httpServletRequest.setAttribute("cart", null);
            httpServletRequest.getRequestDispatcher("/order.jsp").forward(httpServletRequest,httpServletResponse);
        } else {
            httpServletResponse.sendRedirect("/HomePage");
        }
    }
}
