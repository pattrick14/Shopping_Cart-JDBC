import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean validateUser(String username, String password, String userType) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ? AND userType = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, userType);

            ResultSet rs = pst.executeQuery();
            return rs.next(); // If a record exists, credentials are valid.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
