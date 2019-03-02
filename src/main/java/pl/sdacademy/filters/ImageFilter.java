package pl.sdacademy.filters;

import pl.sdacademy.model.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ImageFilter", servletNames = {""})
public class ImageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (httpServletRequest.getAttribute("Product") != null) {
            final Product product = (Product) httpServletRequest.getAttribute("product");
            if (product.getImageUrl() == null) {
                product.setImageUrl("/resources/owl.jpg");
            }
        }
        //TODO not working properly
    }

    @Override
    public void destroy() {

    }
}
