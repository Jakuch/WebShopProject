package pl.sdacademy.servlet;

import pl.sdacademy.database.ProductDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
    private ProductDatabase productDatabase;

    @Override
    public void init() throws ServletException {
        this.productDatabase = ProductDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/addProduct.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String name = httpServletRequest.getParameter("name");
        String description = httpServletRequest.getParameter("description");
        long price = Long.valueOf(httpServletRequest.getParameter("price"));
        String category = httpServletRequest.getParameter("category");
        int quantity = Integer.parseInt(httpServletRequest.getParameter("quantity"));

        productDatabase.addProduct(name, description, price, category, quantity);
        int size = productDatabase.getProducts().size();
        httpServletRequest.setAttribute("desc", "New product created!");
        httpServletResponse.sendRedirect("/Product?id=" + (size - 1));
    }
}
