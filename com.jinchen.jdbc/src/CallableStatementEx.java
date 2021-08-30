import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementEx {
    public static void main(String[] args) throws Exception
    {
        // Loading and Registering the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        // Connection Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");
        System.out.println("Connection Established Successfully");

        // Creation of Simple Statement
        CallableStatement st = con.prepareCall("{call insertN(?,?)}");
        st.setInt(1, 2021);
        st.setString(2, "Jinchen Duan");
        st.execute();
        System.out.println("Successfully inserted into the database");
        // show procedure status where db="demo";

        // Closing the connection
        con.close();
    }
}
