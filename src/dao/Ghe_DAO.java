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
	public List<Ghe> getGheList(String MaLichChieu) {
        List<Ghe> gheList = new ArrayList<>();
        String query = "SELECT * FROM Ghe Where MaLichChieu = ? ORDER BY CAST(MaGhe AS INT) ASC;";
        
        // Sử dụng kết nối từ ConnectDB
        try (Connection conn = ConnectDB.getConnection()){
        	try (PreparedStatement stmt = conn.prepareStatement(query)){
    			
        		stmt.setString(1, MaLichChieu);
        		ResultSet rs = stmt.executeQuery();

            // Duyệt qua các kết quả và tạo danh sách phim
                while (rs.next()) {
                	String maghe = rs.getString("MaGhe");
                    String soghe = rs.getString("SoGhe");
                    boolean trangthai = rs.getBoolean("TrangThai");
                    String malichchieu = rs.getString("MaLichChieu");
                    gheList.add(new Ghe(maghe, soghe, trangthai, malichchieu));
                }
            }catch(SQLException e) {
    			e.printStackTrace();
    		}	
        }catch(SQLException e) {
        	e.printStackTrace();
            System.out.println("Lỗi truy vấn dữ liệu!");
		}	      	
        return gheList;
    }
	public static void updateTrangThai(List<String> selectedSeats, String malichchieu) {
		String query = "UPDATE Ghe SET TrangThai = 1 WHERE SoGhe = ? AND MaLichChieu = ?";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Lặp qua từng ghế và thực hiện cập nhật
            for (String soghe : selectedSeats) {
                stmt.setString(1, soghe);      // Gán giá trị cho SoGhe
                stmt.setString(2, malichchieu); // Gán giá trị cho MaLichChieu
                stmt.executeUpdate();         // Thực thi câu lệnh SQL
            }

            System.out.println("Cập nhật trạng thái ghế thành công!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi cập nhật trạng thái ghế!");
        }
	}

}
