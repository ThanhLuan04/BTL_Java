package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_Dao {
	ArrayList<TaiKhoan> list;
	public TaiKhoan_Dao() {
		list = new ArrayList<TaiKhoan>();
	} 
	public ArrayList<TaiKhoan> getDSTaiKhoan() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM TaiKhoan";
			CallableStatement myCall = con.prepareCall(sql);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String tenDN = rs.getString(1);
				String mk = rs.getString(2);
				TaiKhoan tk = new TaiKhoan(tenDN, mk);
				list.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public TaiKhoan getTaiKhoanTheoTen(String ten) {
		TaiKhoan tk = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, ten);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String tenDN = rs.getString(1);
				String mk = rs.getString(2);
				tk = new TaiKhoan(tenDN, mk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	public void addTaiKhoan(TaiKhoan tk) throws Exception {
		Connection con = ConnectDB.getConnection();

		String sql = "INSERT INTO TaiKhoan VALUES (?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);

		statement.setString(1, tk.getTenDangNhap());
		statement.setString(2, tk.getMatKhau());

		statement.executeUpdate();
	}
	public boolean updateTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set MatKhau = ?"
					+ "where TenDangNhap = ?");
			stmt.setString(1, tk.getMatKhau());
			stmt.setString(2, tk.getTenDangNhap());
			n = stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}
			catch(SQLException e) {	
				e.printStackTrace();
			}
		}
		return n>0;
	}

}
