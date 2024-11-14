package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;

public class LichChieuPhim_DAO {
	
	public static String getMaLichChieuByMaPhim(String maphim) {
        String malichchieu = null;
        Connection conn = ConnectDB.getConnection();
        
        if (conn != null) {
            String sql = "SELECT TOP 1 LichChieuPhim.MaLichChieu " +
                         "FROM Phim " +
                         "JOIN LichChieuPhim ON Phim.MaPhim = LichChieuPhim.MaPhim " +
                         "WHERE Phim.Maphim = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, maphim);  // Thiết lập giá trị cho maphim
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    malichchieu = rs.getString("MaLichChieu");  // Lấy giá trị đầu tiên tìm được
                }
            } catch (SQLException e) {
                System.out.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
            }
        }
        return malichchieu;
    }
	public static String getMaPhongByMaLichChieu(String malichchieu) {
        String maPhong = null;
        Connection conn = ConnectDB.getConnection();
        
        if (conn != null) {
            String sql = "SELECT MaPhong FROM LichChieuPhim WHERE MaLichChieu = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, malichchieu);  // Thiết lập giá trị cho malichchieu
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    maPhong = rs.getString("maPhong");  // Lấy giá trị maPhong
                }
            } catch (SQLException e) {
                System.out.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
                }
            }
        }
        
        return maPhong;
    }
}
