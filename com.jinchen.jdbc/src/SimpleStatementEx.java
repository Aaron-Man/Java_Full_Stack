import java.sql.*;

public class SimpleStatementEx {
    public static void main(String[] args) throws Exception {
        // Loading and Registering the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        // Connection Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");
        System.out.println("Connection Established Successfully");

        // Creation of Simple Statement
        Statement st = con.createStatement();
        int x = st.executeUpdate("insert into emp(id, name) values(2021, 'Jinchen Duan')");
        // int x = st.executeUpdate("delete from emp where id=2021");
        // int x = st.executeUpdate("update emp set id=2021 where id=2020");
        System.out.println(x);
        System.out.println("Successfully inserted into the database");

        // Creation of ResultSet
        ResultSet rs = st.executeQuery("select * from emp");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }

        // Closing the connection
        con.close();
    }
}
