package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.Phong;

public class KhachHang_DAO {
	public static KhachHang getKhachHangByMaKH(String maKH) {
	    KhachHang khachhang = null;
	    String query = "SELECT * FROM KhachHang WHERE MaKH = ?";
	    
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, maKH);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            String MaKH = rs.getString("MaKH");
	            String TenKH = rs.getString("TenKH");
	            boolean GioiTinh = rs.getBoolean("GioiTinh");
	            khachhang = new KhachHang(MaKH, TenKH, GioiTinh);
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Lỗi truy vấn dữ liệu phim theo mã!");
	    } 
	    return khachhang;
	}
	 public boolean saveKhachHang(String maKH, String tenKH, boolean gioiTinh) {
	        Connection conn = ConnectDB.getConnection();
	        if (conn == null) {
	            return false;
	        }
	        String sql = "INSERT INTO KhachHang (MaKH, TenKH, GioiTinh) VALUES (?, ?, ?)";
	        try {
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, maKH);  // Số điện thoại (mã khách hàng)
	            pstmt.setString(2, tenKH);  // Tên khách hàng
	            pstmt.setBoolean(3, gioiTinh);  // Giới tính (true là Nam, false là Nữ)

	            int rowsAffected = pstmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            System.out.println("Lỗi khi lưu khách hàng: " + e.getMessage());
	            return false;
	        }
	    }
}
