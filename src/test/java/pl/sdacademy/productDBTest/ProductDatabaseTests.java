package pl.sdacademy.productDBTest;

import org.junit.Test;
import pl.sdacademy.database.ProductDatabase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDatabaseTests {

    @Test
    public void testCreateDatabase() {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        ProductDatabase productDatabase1 = ProductDatabase.getInstance();
        assertEquals(productDatabase, productDatabase1);
    }

    @Test
    public void testAddProduct() {
        ProductDatabase productDatabase = ProductDatabase.getInstance();
        assertEquals(productDatabase.addProduct("Name", "Description", 5L, "Category"), productDatabase.getProducts().get(0).getId());
        assertTrue(!productDatabase.getProducts().isEmpty());
    }


}
