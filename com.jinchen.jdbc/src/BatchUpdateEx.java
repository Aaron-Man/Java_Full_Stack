import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdateEx {
    public static void main(String[] args) throws Exception
    {
        // Loading and Registering the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        // Connection Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");
        System.out.println("Connection Established Successfully");
        con.setAutoCommit(false);

        // Creation of Simple Statement
        Statement st = con.createStatement();
        st.addBatch("insert into emp (id, name) values (2021, 'Jinchen Duan')");
        st.addBatch("insert into emp (id, name) values (2022, 'Qiuying Jiang')");
        st.executeBatch();
        con.commit();
        System.out.println("Successfully inserted into the database");

        // Closing the connection
        con.close();
    }
}
