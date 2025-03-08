
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void addProduct(Product product) {
        String query = "INSERT INTO Products (name, price, stockQuantity) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, product.getName());
            pst.setDouble(2, product.getPrice());
            pst.setInt(3, product.getStockQuantity());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                productList.add(new Product(
                    rs.getInt("productId"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stockQuantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
