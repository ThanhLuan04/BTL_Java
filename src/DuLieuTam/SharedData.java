package DuLieuTam;

public class SharedData {
    private String maKH;
    private String tenKH;
    private boolean gioiTinh;

    // Constructor
    public SharedData(String maKH, String tenKH, boolean gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
    }

    // Getter methods
    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }
}

