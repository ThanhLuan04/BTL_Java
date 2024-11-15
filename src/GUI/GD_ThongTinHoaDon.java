package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

//import DuLieuTam.SharedData;
//import DuLieuTam.SharedDataHolder;
import dao.KhachHang_DAO;
import dao.LichChieuPhim_DAO;
import dao.Phim_Dao;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.Phim;
import entity.Phong;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GD_ThongTinHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaHD;
	private JTextField txtTenKH;
	private JTextField txtNgayMua;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private JTextField txtTenPhim;
	private JTextField txtThoiGian;
	private JTextField txtPhong;
	private JTextField txtGhe;
	private JTextField txtTongTien;
	private JLabel lbltenphim;
	private JButton btnXacNhan;
	private JPanel panel2;
	private JLabel lblTenPhim;
	private JLabel lblThoiGian;
	private JLabel lblPhong;
	private JLabel lblTongTien;
	private JLabel lblGhe;
	private JLabel JlblTongTien;
	private String LayMaPhim,MaLichChieu,MaPhong;
	private Phim phimduocchon;
	private Phim_Dao phimDAO;

	public GD_ThongTinHoaDon(Menu_view menu,GD_phim gd_phim,GD_ChonGhe ghe) {
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		phimDAO = new Phim_Dao();
		LayMaPhim = gd_phim.getMaPhimDuocChon();
		phimduocchon = phimDAO.getPhimByMaPhim(LayMaPhim);
		
		MaLichChieu = LichChieuPhim_DAO.getMaLichChieuByMaPhim(LayMaPhim);
		MaPhong = LichChieuPhim_DAO.getMaPhongByMaLichChieu(MaLichChieu);
		Phong phong = Phong_DAO.getPhongByMaPhong(MaPhong);

		KhachHang khachhang = KhachHang_DAO.getKhachHangByMaKH(ghe.returnMaKH());

		//pane 1
		JPanel panel1 = new JPanel();
		panel1.setBounds(400, 0, 440, 280);
		panel1.setBackground(new Color(180, 155, 160));
		add(panel1);
		panel1.setLayout(null);
		
		JLabel lblHoaDon = new JLabel("Thông Tin Vé");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblHoaDon.setBounds(150, 30, 130, 30);
		panel1.add(lblHoaDon);
		
		JLabel lblMaVe = new JLabel("Mã Hóa Đơn:");
		lblMaVe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblMaVe.setBounds(45, 60, 120, 25);
		panel1.add(lblMaVe);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTenKH.setBounds(45, 105, 120, 25);
		panel1.add(lblTenKH);
		
		JLabel lblNgayMua = new JLabel("Ngày mua:");
		lblNgayMua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNgayMua.setBounds(45, 150, 120, 25);
		panel1.add(lblNgayMua);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblSDT.setBounds(45, 195, 120, 25);
		panel1.add(lblSDT);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGioiTinh.setBounds(45, 240, 120, 25);
		panel1.add(lblGioiTinh);
		
		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtMaHD.setEditable(false);
		txtMaHD.setBorder(null);
		txtMaHD.setBackground(new Color(180, 155, 160));
		txtMaHD.setBounds(180, 60, 200, 25);
		panel1.add(txtMaHD);
		txtMaHD.setText(CreateHD());
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenKH.setEditable(false);
		txtTenKH.setBorder(null);
		txtTenKH.setBackground(new Color(180, 155, 160));
		txtTenKH.setBounds(180, 105, 200, 25);
		panel1.add(txtTenKH);
		txtTenKH.setText(khachhang.getHoTenKH());
		
		txtNgayMua = new JTextField();
		txtNgayMua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtNgayMua.setEditable(false);
		txtNgayMua.setBorder(null);
		txtNgayMua.setBackground(new Color(180, 155, 160));
		txtNgayMua.setBounds(180, 150, 200, 25);
		panel1.add(txtNgayMua);
		// Lấy ngày hiện tại
        LocalDate today = LocalDate.now();
        // Chuyển LocalDate thành String
        String todayString = today.toString(); // Chuyển thành định dạng "yyyy-MM-dd"
        // Giả sử txtNgayMua là một JTextField
        txtNgayMua.setText(todayString); // Đặt ngày hiện tại vào JTextField
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSDT.setEditable(false);
		txtSDT.setBorder(null);
		txtSDT.setBackground(new Color(180, 155, 160));
		txtSDT.setBounds(180, 195, 200, 25);
		panel1.add(txtSDT);
		txtSDT.setText(khachhang.getMaKH());
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setBorder(null);
		txtGioiTinh.setBackground(new Color(180, 155, 160));
		txtGioiTinh.setBounds(180, 240, 200, 25);
		txtGioiTinh.setText(khachhang.isGioiTinh() ? "Nam" : "Nữ");
		panel1.add(txtGioiTinh);
		
		
		//panel 2
		panel2 = new JPanel();
		panel2.setBounds(400, 280, 440, 320);
		panel2.setBorder(new MatteBorder(2, 0, 0, 0, Color.black));
		panel2.setBackground(new Color(180, 155, 160));
		add(panel2);
		panel2.setLayout(null);
		
		lblTenPhim = new JLabel("Tên Phim:");
		lblTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTenPhim.setBounds(20, 30, 80, 25);
		panel2.add(lblTenPhim);
		
		lblThoiGian = new JLabel("Thời Gian:");
		lblThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblThoiGian.setBounds(20, 85, 80, 25);
		panel2.add(lblThoiGian);
		
		lblPhong = new JLabel("Phòng:");
		lblPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblPhong.setBounds(20, 140, 80, 25);
		panel2.add(lblPhong);
		
		lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTongTien.setBounds(20, 195, 80, 25);
		panel2.add(lblTongTien);
		
		lblGhe = new JLabel("Ghế:");
		lblGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGhe.setBounds(230, 140, 60, 25);
		panel2.add(lblGhe);
		
		btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnXacNhan.setBackground(new Color(53, 220, 20));
		btnXacNhan.setBounds(160, 270, 120, 40);
		panel2.add(btnXacNhan);
		
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.chaneToGD_phim();
			}
		});
		
		txtTenPhim = new JTextField();
		txtTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenPhim.setEditable(false);
		txtTenPhim.setBorder(null);
		txtTenPhim.setBackground(new Color(180, 155, 160));
		txtTenPhim.setBounds(110, 30, 200, 25);
		panel2.add(txtTenPhim);
		txtTenPhim.setText(phimduocchon.getTenPhim());
		
		txtThoiGian = new JTextField();
		txtThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtThoiGian.setEditable(false);
		txtThoiGian.setBorder(null);
		txtThoiGian.setBackground(new Color(180, 155, 160));
		txtThoiGian.setBounds(110, 85, 200, 25);
		panel2.add(txtThoiGian);
		txtThoiGian.setText(Integer.toString(phimduocchon.getThoiLuong())+" phút");
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtPhong.setEditable(false);
		txtPhong.setBorder(null);
		txtPhong.setBackground(new Color(180, 155, 160));
		txtPhong.setBounds(90, 140, 100, 25);
		panel2.add(txtPhong);
		txtPhong.setText(phong.getTenPhong());
		
		txtGhe = new JTextField();
		txtGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGhe.setEditable(false);
		txtGhe.setBorder(null);
		txtGhe.setBackground(new Color(180, 155, 160));
		txtGhe.setBounds(270, 140, 140, 25);
		panel2.add(txtGhe);
		txtGhe.setText(ghe.returnGhe());
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTongTien.setEditable(false);
		txtTongTien.setBorder(null);
		txtTongTien.setBackground(new Color(180, 155, 160));
		txtTongTien.setBounds(110, 195, 200, 25);
		panel2.add(txtTongTien);
		txtTongTien.setText(Double.toString(ghe.returnPrice()));
	}
	 public static String CreateHD() {
	        Random random = new Random();
	        // Tạo một mã hóa đơn bắt đầu bằng "HD" và sau đó là 6 chữ số ngẫu nhiên
	        String prefix = "HD";
	        int number = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
	        return prefix + number;
	    }

}
