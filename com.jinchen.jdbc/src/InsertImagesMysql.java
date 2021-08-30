import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertImagesMysql {
    public static void main(String[] args) {
        System.out.println("Insert Image Example!");
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
        String dbName = "demo";
        String userName = "root";
        String password = "asm2u4bt";
        Connection con = null;

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = con.createStatement();
            File imgfile = new File("/Users/celestial/Desktop/Bytecode.png");

            FileInputStream fin = new FileInputStream(imgfile);
            PreparedStatement pre = con.prepareStatement("insert into Image values(?,?,?)");

            pre.setString(1, "test");
            pre.setInt(2, 3);
            pre.setBinaryStream(3, (InputStream) fin, (int) imgfile.length());
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

            pre.close();
            con.close();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}
