

import java.util.List;

public class AdminService {
    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(String name, double price, int stockQuantity) {
        Product product = new Product(0, name, price, stockQuantity);
        productDAO.addProduct(product);
        System.out.println("Product added successfully!");
    }

    public void viewProducts() {
        List<Product> products = productDAO.getAllProducts();
        products.forEach(System.out::println);
    }
}
