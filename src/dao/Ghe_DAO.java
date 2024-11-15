package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.Ghe;
import entity.Phim;
import entity.Phong;

public class Ghe_DAO {
	public List<Ghe> getGheList() {
        List<Ghe> gheList = new ArrayList<>();
        String query = "SELECT * FROM Ghe Where MaLichChieu = '02' ORDER BY CAST(MaGhe AS INT) ASC;";
        
        // Sử dụng kết nối từ ConnectDB
        try (Connection conn = ConnectDB.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(query);
        		ResultSet rs = stmt.executeQuery()) {

            // Duyệt qua các kết quả và tạo danh sách phim
            while (rs.next()) {
            	String maghe = rs.getString("MaGhe");
                String soghe = rs.getString("SoGhe");
                boolean trangthai = rs.getBoolean("TrangThai");
                String malichchieu = rs.getString("MaLichChieu");
//                phimList.add(new Phim(maPhim, tenPhim, thoiLuong, giaVe, hinhAnh,giochieu));
                gheList.add(new Ghe(maghe, soghe, trangthai, malichchieu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn dữ liệu!");
        }
        
        return gheList;
    }

}
