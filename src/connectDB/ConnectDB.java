package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB { 
	public static Connection con= null;
	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	} 

	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLyRapPhim;trustServerCertificate=true;encript=true$";
		String user = "sa";
		String pass = "sapassword";
		con = DriverManager.getConnection(url, user, pass);
		
	}

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				  System.out.println("Database connection failed");
			}
		}
	}

	public static Connection getConnection() {
		if (con == null) {
            try {
                // Assuming you are using JDBC
                String url = "jdbc:sqlserver://yourserver;databaseName=yourdb";
                String user = "username";
                String password = "password";
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
	}
	public static void closeConnection() {
        if (con != null) {
            try {
            	con.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
