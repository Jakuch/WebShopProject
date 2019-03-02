package pl.sdacademy.servlet;

import pl.sdacademy.database.OrderDatabase;
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

@WebServlet(value = "/Order", name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderDatabase orderDatabase;

    @Override
    public void init() throws ServletException {
        orderDatabase = OrderDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //httpServletRequest.getRequestDispatcher("/order.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession(false);
        User user = (User) session.getAttribute("user");
        String address = httpServletRequest.getParameter("address");
        String userMail = httpServletRequest.getParameter("userMail");
        Map<Product, Integer> cart = (Map<Product, Integer>) httpServletRequest.getSession().getAttribute("cart");

        if (user != null && cart != null) {
            orderDatabase.createOrder(user.getEmail(), address, cart);
            session.setAttribute("address", address);
            session.setAttribute("orderId", orderDatabase.getOrdersFromUser(user.getEmail()).size() - 1);
            httpServletResponse.sendRedirect("/Order");
        } else if (user == null && cart != null) {
            orderDatabase.createOrder(userMail, address, cart);
            httpServletRequest.setAttribute("userMail", userMail);
            httpServletRequest.setAttribute("address", address);
            httpServletRequest.getRequestDispatcher("/order.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }
}
