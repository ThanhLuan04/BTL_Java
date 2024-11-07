package entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private boolean gioiTinh;
	private String diaChi;
	private int soDienThoai;
	private String loaiKH;
	private String chuThich;
	 public KhachHang() {
		// TODO Auto-generated constructor stub
	
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	public KhachHang(String maKH, String hoTenKH, boolean gioiTinh, String diaChi, int soDienThoai, String loaiKH,
			String chuThich) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.loaiKH = loaiKH;
		this.chuThich = chuThich;
	}
	public KhachHang(String maKH, String hoTenKH) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
	}
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getLoaiKH() {
		return loaiKH;
	}
	public void setLoaiKH(String loaiKH) {
		this.loaiKH = loaiKH;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTenKH=" + hoTenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", loaiKH=" + loaiKH + ", chuThich=" + chuThich + "]";
	}
	
}
