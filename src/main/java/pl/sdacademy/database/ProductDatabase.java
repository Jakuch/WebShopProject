package pl.sdacademy.database;

import pl.sdacademy.model.Product;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductDatabase {
    private static class SingletonHelper {
        private static final ProductDatabase INSTANCE = new ProductDatabase();
    }
    private static long currentId = 0L;
    private List<Product> products;

    private ProductDatabase() {
        this.products = new LinkedList<>();

        addProduct("Product1", "Very good product", 1000, "Good Products", 5);
        addProduct("Product2", "Also very good", 1200, "Good Products", 10);
        addProduct("Product3", "Very very good product", 1300, "Good Products", 12);
    }

    public List<Product> getProducts() {
        return products;
    }

    public long addProduct(final String name, final String description, final long price, final String category, int quantity) {
        long productId = currentId++;
        Product newProduct = new Product(productId, LocalDateTime.now(), name, description, price, category, quantity);
        products.add(newProduct);
        return productId;
    }

    public Optional<Product> getProductById(final long id){
        return getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
    public static ProductDatabase getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
