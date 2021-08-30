import java.sql.*;

public class PreparedStatementEX {
    public static void main(String[] args) throws Exception {
        // Loading and Registering the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        // Connection Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");
        System.out.println("Connection Established Successfully");

        // Creation of Simple Statement
        PreparedStatement ps = con.prepareStatement("insert into emp values(?, ?)");
        ps.setInt(1, 2021);
        ps.setString(2, "Jinchen Duan");
        // update -> update emp set name=?, where id=?
        // delete -> delete from emp where id=?;
        int x = ps.executeUpdate();
        System.out.println(x);
        System.out.println("Successfully inserted into the database");

        // Creation of ResultSet
        ResultSetMetaData rsmd = ps.getMetaData();
        System.out.println("Total number of Columns count is: " + rsmd.getColumnCount());
        System.out.println("Column Name of 1st is: " + rsmd.getColumnName(1));
        System.out.println("Column Tyoe of 1st is: " + rsmd.getColumnType(1));

        // ResultSet rs = ps.executeQuery("select * from emp");
        // while (rs.next()) {
        // 	System.out.println(rs.getInt(1) + " " + rs.getString(2));
        // }

        // Closing the connection
        con.close();
    }
}
