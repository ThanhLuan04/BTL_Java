package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.Phim;
import entity.Phong;

public class Phong_DAO {
	public static Phong getPhongByMaPhong(String maPhong) {
	    Phong phong = null;
	    String query = "SELECT * FROM Phong WHERE MaPhong = ?";
	    
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, maPhong);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            String MaPhong = rs.getString("MaPhong");
	            String TenPhong = rs.getString("TenPhong");
	            phong = new Phong(MaPhong,TenPhong);
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Lỗi truy vấn dữ liệu phim theo mã!");
	    } 
	    return phong;
	}
}
