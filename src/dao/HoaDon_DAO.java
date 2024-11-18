package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.ConnectDB;

public class HoaDon_DAO {
	public boolean saveHoaDon(String MaHD,String NgayTao, Double TongTien,String MaKH,String MaLichChieu ) {
        Connection conn = ConnectDB.getConnection();
        if (conn == null) {
            return false;
        }
        String sql = "INSERT INTO HoaDon (MaHD, NgayTao, TongTien, MaKH, MaVe) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, MaHD);  // Số điện thoại (mã khách hàng)
            pstmt.setString(2, NgayTao);  // Tên khách hàng
            pstmt.setDouble(3, TongTien);  // Giới tính (true là Nam, false là Nữ)
            pstmt.setString(4, MaKH);  // Số điện thoại (mã khách hàng)
            pstmt.setString(5, MaLichChieu);  // Tên khách hàng

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi lưu hóa đơn: " + e.getMessage());
            return false;
        }
    }
}
