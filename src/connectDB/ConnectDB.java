package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB { 
    private static Connection con = null;
    private static ConnectDB instance = new ConnectDB();

    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyRapPhim;encrypt=false;trustServerCertificate=true";
    private final String user = "sa";
    private final String pass = "11111";

    // Singleton instance
    public static ConnectDB getInstance() {
        return instance;
    } 

    // Establish a new connection
    public void connect() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established");
        }
    }

    // Close the connection
    public void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Database disconnection failed");
            }
        }
    }

    // Get the existing connection or establish a new one if it's closed
    public static Connection getConnection() {
        if (con == null || !instance.isConnected()) {
            try {
                instance.connect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    // Check if the connection is still active
    private boolean isConnected() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    // Close connection (alternative to disconnect)
    public static void closeConnection() {
        instance.disconnect();
    }
}
