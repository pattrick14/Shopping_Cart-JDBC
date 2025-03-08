import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Shoppingdb";
    private static final String USER = "root";  // Change this to your actual MySQL username
    private static final String PASSWORD = "Pattrick";  // Change this to your MySQL password

    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver (important for older Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Connection is successful.");
            // Establish the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found! Make sure mysql-connector-java-9.2.0.jar is added.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed! Check MySQL status and credentials.");
            e.printStackTrace();
        }
        return null;
    }
}
