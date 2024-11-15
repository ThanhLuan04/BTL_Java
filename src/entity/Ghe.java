package entity;

public class Ghe {
	public String MaGhe;
	public String SoGhe;
	public boolean TrangThai;
	public String MaLichChieu;
	public String getMaGhe() {
		return MaGhe;
	}
	public void setMaGhe(String maGhe) {
		MaGhe = maGhe;
	}
	public String getSoGhe() {
		return SoGhe;
	}
	public void setSoGhe(String soGhe) {
		SoGhe = soGhe;
	}
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	public String getMaLichChieu() {
		return MaLichChieu;
	}
	public void setMaLichChieu(String maLichChieu) {
		MaLichChieu = maLichChieu;
	}
	public Ghe(String maGhe, String soGhe, boolean trangThai, String maLichChieu) {
		super();
		MaGhe = maGhe;
		SoGhe = soGhe;
		TrangThai = trangThai;
		MaLichChieu = maLichChieu;
	}
	public Ghe(String maLichChieu) {
		super();
		MaLichChieu = maLichChieu;
	}
	
	
	
	
}
