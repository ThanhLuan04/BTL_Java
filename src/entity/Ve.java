package entity;

public class Ve {
	public String MaVe;
	public String MaPhong;;
	public String MaPhim;
	public String SoGhe;
	public Ve(String maVe, String maPhong, String maPhim, String soGhe) {
		super();
		MaVe = maVe;
		MaPhong = maPhong;
		MaPhim = maPhim;
		SoGhe = soGhe;
	}
	public String getMaVe() {
		return MaVe;
	}
	public void setMaVe(String maVe) {
		MaVe = maVe;
	}
	public String getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}
	public String getMaPhim() {
		return MaPhim;
	}
	public void setMaPhim(String maPhim) {
		MaPhim = maPhim;
	}
	public String getSoGhe() {
		return SoGhe;
	}
	public void setSoGhe(String soGhe) {
		SoGhe = soGhe;
	}
}
