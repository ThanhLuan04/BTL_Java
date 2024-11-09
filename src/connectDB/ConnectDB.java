package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection con = null;
    private static ConnectDB instance = new ConnectDB();

    // Private constructor để đảm bảo không tạo thêm instance bên ngoài
    public ConnectDB() {}

    public static ConnectDB getInstance() {
        return instance;
    }

    // Phương thức để kết nối đến cơ sở dữ liệu
    public static Connection getConnection() {
        if (con == null) {
            try {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyRapPhim;trustServerCertificate=true;encrypt=true";
                String user = "sa";
                String pass = "123456";
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Kết nối cơ sở dữ liệu thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Kết nối cơ sở dữ liệu thất bại!");
            }
        }
        return con;
    }

    // Phương thức để đóng kết nối
    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
                con = null;
                System.out.println("Đã đóng kết nối cơ sở dữ liệu.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Đóng kết nối cơ sở dữ liệu thất bại!");
            }
        }
    }
}
