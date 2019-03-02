package pl.sdacademy.servlet;

import pl.sdacademy.database.ProductDatabase;
import pl.sdacademy.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/Search")
public class SearchProductServlet extends HttpServlet {
    private ProductDatabase productDatabase;

    @Override
    public void init() throws ServletException {
        productDatabase = ProductDatabase.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/search.jsp").forward(httpServletRequest, httpServletResponse);
    }


    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //TODO
        String searchOption = httpServletRequest.getParameter("searchOption");
        String searchPhrase = httpServletRequest.getParameter("searchPhrase");
        List<Product> productList = new LinkedList<>();

        switch (searchOption) {
            case "name":
                productList = productDatabase.getProducts().stream()
                        .filter(product -> product.getName().equalsIgnoreCase(searchPhrase))
                        .collect(Collectors.toList());
                break;
            case "price":
                productList = productDatabase.getProducts().stream()
                        .filter(product -> product.getPrice() <= Integer.parseInt(searchPhrase))
                        .collect(Collectors.toList());
                break;
            case "category":
                productList = productDatabase.getProducts().stream()
                        .filter(product -> product.getCategory().equalsIgnoreCase(searchPhrase))
                        .collect(Collectors.toList());
                break;
        }

        httpServletRequest.setAttribute("products", productList);
        httpServletRequest.getRequestDispatcher("/Product").forward(httpServletRequest, httpServletResponse);


    }
}
