package entity;

public class Phong {
	public String MaPhong;
	public String TenPhong;
	
	public String getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}
	public String getTenPhong() {
		return TenPhong;
	}
	public void setTenPhong(String tenPhong) {
		TenPhong = tenPhong;
	}
	public Phong(String maPhong, String tenPhong) {
		super();
		MaPhong = maPhong;
		TenPhong = tenPhong;
	}
	public Phong(String maPhong) {
		super();
		MaPhong = maPhong;
	}
	
	
}
