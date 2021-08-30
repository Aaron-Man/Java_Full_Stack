import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveImagesMysql {
    public static void main(String[] args) {
        System.out.println("Retrive Image Example!");

        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
        String dbName = "demo";
        String userName = "root";
        String password = "asm2u4bt";
        Connection con = null;

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url + dbName, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select image from image");

            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File("/Users/celestial/Desktop/abc" + i + ".jpg"));
                i++;
                int c = 0;
                while ((c = in.read()) > -1) {
                    f.write(c);
                }
                f.close();
                in.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
