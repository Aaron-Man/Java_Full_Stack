import java.sql.*;

public class SampleJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Loading and Registration the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        // Connection Established
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");
        System.out.println("Connection Established Successfully");

        // Close the connection
        con.close();
    }
}
