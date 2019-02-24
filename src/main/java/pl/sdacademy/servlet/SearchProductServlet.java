package pl.sdacademy.servlet;

import pl.sdacademy.database.ProductDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        switch (searchOption){
            case "name":
                productDatabase.getProducts().stream()
                        .filter(product -> product.getName().equalsIgnoreCase(searchPhrase));
                break;
            case "price":
                productDatabase.getProducts().stream()
                        .filter(product -> product.getPrice() <= Integer.parseInt(searchPhrase));
                break;
            case "category":
                productDatabase.getProducts().stream()
                        .filter(product -> product.getCategory().equalsIgnoreCase(searchPhrase));
                break;
        }


    }
}
