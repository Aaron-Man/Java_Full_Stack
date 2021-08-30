import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionEx {
    public static void main(String[] args) throws Exception {
        // Loading and Registering the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        // Connection Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");
        System.out.println("Connection Established Successfully");
        con.setAutoCommit(false);

        // Creation of Prepared Statement
        PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the ID : ");
            String x = br.readLine();
            int id = Integer.parseInt(x);
            System.out.println("Enter the Name : ");
            String name = br.readLine();
            System.out.println("Enter the Salary : ");
            String y = br.readLine();
            int sal = Integer.parseInt(y);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, sal);
            ps.executeUpdate();
            System.out.println("commit/rollback");
            String z = br.readLine();
            if (z.equals("commit")) {
                con.commit();
            }
            if (z.equals("rollback")) {
                con.rollback();
            }
            System.out.println("If you want to add some more new records y/n");
            String z1 = br.readLine();
            if (z1.equals("n")) {
                break;
            }
        }

        con.commit();
        System.out.println("Records Inserted Successfully to the Database");

        // Closing the connection
        con.close();
    }
}
