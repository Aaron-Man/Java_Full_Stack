import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTextFileToMySQL {
    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
        String username = "root";
        String password = "asm2u4bt";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void main(String[] args) throws Exception {
        String id = "007";
        String fileName = "/Users/celestial/Desktop/Test.txt";

        FileInputStream fis = null;
        PreparedStatement pstmt = null;
        Connection conn = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            File file = new File(fileName);
            fis = new FileInputStream(file);

            pstmt = conn.prepareStatement("insert into DataFiles(id, fileName, fileBody) values (?, ?, ?)");
            pstmt.setString(1, id);
            pstmt.setString(2, fileName);
            pstmt.setAsciiStream(3, fis, (int) file.length());
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Successfully inserted the file into the database!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            pstmt.close();
            fis.close();
            conn.close();
        }
    }
}
