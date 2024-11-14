package entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private boolean gioiTinh;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public KhachHang(String maKH, String hoTenKH, boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.gioiTinh = gioiTinh;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	 
	
}
