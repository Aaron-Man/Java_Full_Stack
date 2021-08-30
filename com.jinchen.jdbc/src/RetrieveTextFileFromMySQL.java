import java.io.FileWriter;
import java.io.Reader;
import java.sql.*;

public class RetrieveTextFileFromMySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC", "root", "asm2u4bt");

            PreparedStatement ps = con.prepareStatement("select * from datafiles");
            ResultSet rs = ps.executeQuery();
            rs.next();// now on 1st row

            Clob c = rs.getClob(3);
            Reader r = c.getCharacterStream();

            FileWriter fw = new FileWriter("/Users/celestial/Desktop/Test.txt");

            int i;
            while ((i = r.read()) != -1) {
                fw.write((char) i);
            }

            fw.close();
            con.close();

            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
