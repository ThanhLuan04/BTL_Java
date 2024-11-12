package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import connectDB.ConnectDB;
import entity.Phim;


public class Phim_Dao {

	public List<Phim> getPhimList() {
        List<Phim> phimList = new ArrayList<>();
        String query = "SELECT * FROM Phim";
        
        // Sử dụng kết nối từ ConnectDB
        try (Connection conn = ConnectDB.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(query);
        		ResultSet rs = stmt.executeQuery()) {

            // Duyệt qua các kết quả và tạo danh sách phim
            while (rs.next()) {
            	String maPhim = rs.getString("MaPhim");
                String tenPhim = rs.getString("TenPhim");
                int thoiLuong = rs.getInt("ThoiLuong");
                double giaVe = rs.getDouble("GiaTien");
                String hinhAnh = rs.getString("AnhPoster");
                phimList.add(new Phim(maPhim, tenPhim, thoiLuong, giaVe, hinhAnh));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn dữ liệu!");
        }
        
        return phimList;
    }

}
