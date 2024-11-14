package entity;

import java.util.Date;

public class Phim {
	public String MaPhim;
	public String TenPhim;
	public int ThoiLuong;
	public double Giave;
	public String Duongdan;
	public String GioChieu;
	public String getMaPhim() {
		return MaPhim;
	}
	public void setMaPhim(String maPhim) {
		MaPhim = maPhim;
	}
	public String getTenPhim() {
		return TenPhim;
	}
	public void setTenPhim(String tenPhim) {
		TenPhim = tenPhim;
	}
	public int getThoiLuong() {
		return ThoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		ThoiLuong = thoiLuong;
	}
	public double getGiave() {
		return Giave;
	}
	public void setGiave(double giave) {
		Giave = giave;
	}
	public String getDuongdan() {
		return Duongdan;
	}
	public void setDuongdan(String duongdan) {
		Duongdan = duongdan;
	}
	public String getGioChieu() {
		return GioChieu;
	}
	public void setGioChieu(String gioChieu) {
		GioChieu = gioChieu;
	}
	public Phim(String maPhim, String tenPhim, int thoiLuong, double giave, String duongdan, String gioChieu) {
		super();
		MaPhim = maPhim;
		TenPhim = tenPhim;
		ThoiLuong = thoiLuong;
		Giave = giave;
		Duongdan = duongdan;
		GioChieu = gioChieu;
	}
	public Phim(String maPhim) {
		super();
		MaPhim = maPhim;
	}
	
	

}
