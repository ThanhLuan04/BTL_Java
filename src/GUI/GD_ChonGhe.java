package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.PopupMenu;

import javax.swing.SwingConstants;

import DuLieuTam.SharedData;
import DuLieuTam.SharedDataHolder;
import dao.KhachHang_DAO;
import dao.LichChieuPhim_DAO;
import dao.Phim_Dao;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.Phim;
import entity.Phong;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class GD_ChonGhe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhim;
	private JTextField txtTenPhim;
	private JTextField txtThoiGian;
	private JTextField txtPhong;
	private JTextField txtGhe;
	private JTextField txtTongTien1;
	private JTextField txtTongTien2;
	private JTextField txtTienThua;
	private JTextField txtGioChieu;
	private String LayMaPhim,MaLichChieu,MaPhong;
	
	private Phim_Dao phimDAO;
	private JPanel panel3,panel2,panel1;
	private JLabel lblTienKhachDua,lblTienThua,lblTongTien2,lblThanhToan,lblGhe,lblTongTien1,lblPhong,lblTenPhim,lblThongTinVe;
	private JTextField txtTienKhachDua,txtSDT2,txtTenKH,txtSDT1;
	private JButton btnDat,btnHuy,btnTim;
	private JComboBox cboSex;
	private JLabel lblMaPhim,lblManHinhChinh;
	private JButton btnB05,btnB03,btnB02,btnB01,btnB04,btnB07,btnB08,btnB09,btnB10,btnB06;
	private JButton btnA09,btnA08,btnA07,btnA06,btnA03,btnA01,btnA02,btnA04,btnA05,btnA10;
	private JButton btnC01,btnC02,btnC03,btnC04,btnC05,btnC06,btnC07,btnC08,btnC09,btnC10; 
	private JButton btnD01,btnD02,btnD03,btnD04,btnD05,btnD06,btnD07,btnD08,btnD09,btnD10;
	private JButton btnE01,btnE02,btnE03,btnE04,btnE05,btnE06,btnE07,btnE09,btnE08,btnE10;
	private JLabel labelDaChon,labelTrong,labelDangChon,lblDaChon,lblGheTrong,lblDangChon,lblGioChieu;;
	private KhachHang_DAO khachhang_DAO;
	private String makhachhang;
	private Phim phimduocchon;
	SharedData dulieutam;

	public GD_ChonGhe(Menu_view menu, GD_phim gd_phim) {
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		phimDAO = new Phim_Dao();
		LayMaPhim = gd_phim.getMaPhimDuocChon();
		phimduocchon = phimDAO.getPhimByMaPhim(LayMaPhim);
		System.out.println(LayMaPhim);
		
		MaLichChieu = LichChieuPhim_DAO.getMaLichChieuByMaPhim(LayMaPhim);
		MaPhong = LichChieuPhim_DAO.getMaPhongByMaLichChieu(MaLichChieu);
		Phong phong = Phong_DAO.getPhongByMaPhong(MaPhong);
		
		//panel 1
		panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel1.setBackground(new Color(225, 214, 196));
		panel1.setBounds(0, 0, 885, 600);
		add(panel1);
		panel1.setLayout(null);
		
		lblManHinhChinh = new JLabel("Màn Hình Chính");
		lblManHinhChinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblManHinhChinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblManHinhChinh.setBounds(295, 0, 300, 40);
		panel1.add(lblManHinhChinh);
//--------------------------------------------------------------------------------------------------------------------------------------------------------
		//hàng 1
		btnA01 = new JButton("A01");
		btnA01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA01.setBackground(new Color(227, 47 ,47));
		btnA01.setBounds(30, 80, 55, 50);
		panel1.add(btnA01);
		
		btnA02 = new JButton("A02");
		btnA02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA02.setBackground(new Color(227, 47 ,47));
		btnA02.setBounds(115, 80, 55, 50);
		panel1.add(btnA02);
		
		btnA03 = new JButton("A03");
		btnA03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA03.setBackground(new Color(227, 47 ,47));
		btnA03.setBounds(200, 80, 55, 50);
		panel1.add(btnA03);
		
		btnA04 = new JButton("A04");
		btnA04.setBounds(285, 80, 55, 50);
		btnA04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA04.setBackground(new Color(227, 47 ,47));
		panel1.add(btnA04);
		
		btnA05 = new JButton("A05");
		btnA05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA05.setBackground(new Color(227, 47 ,47));
		btnA05.setBounds(370, 80, 55, 50);
		panel1.add(btnA05);
		
		btnA06 = new JButton("A06");
		btnA06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA06.setBackground(new Color(227, 47 ,47));
		btnA06.setBounds(455, 80, 55, 50);
		panel1.add(btnA06);
		
		btnA07 = new JButton("A07");
		btnA07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA07.setBackground(new Color(227, 47 ,47));
		btnA07.setBounds(540, 80, 55, 50);
		panel1.add(btnA07);
		
		btnA08 = new JButton("A08");
		btnA08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA08.setBackground(new Color(227, 47 ,47));
		btnA08.setBounds(625, 80, 55, 50);
		panel1.add(btnA08);
		
		btnA09 = new JButton("A09");
		btnA09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA09.setBackground(new Color(227, 47 ,47));
		btnA09.setBounds(710, 80, 55, 50);
		panel1.add(btnA09);
		
		btnA10 = new JButton("A01");
		btnA10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnA10.setBackground(new Color(227, 47 ,47));
		btnA10.setBounds(795, 80, 55, 50);
		panel1.add(btnA10);
		
		//hàng 2
		btnB01 = new JButton("B01");
		btnB01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB01.setBackground(new Color(227, 47 ,47));
		btnB01.setBounds(30, 160, 55, 50);
		panel1.add(btnB01);
		
		btnB02 = new JButton("B02");
		btnB02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB02.setBackground(new Color(227, 47 ,47));
		btnB02.setBounds(115, 160, 55, 50);
		panel1.add(btnB02);
		
		btnB03 = new JButton("B03");
		btnB03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB03.setBackground(new Color(227, 47 ,47));
		btnB03.setBounds(200, 160, 55, 50);
		panel1.add(btnB03);
		
		btnB04 = new JButton("B04");
		btnB04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB04.setBackground(new Color(227, 47 ,47));
		btnB04.setBounds(285, 160, 55, 50);
		panel1.add(btnB04);
		
		btnB05 = new JButton("B05");
		btnB05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB05.setBackground(new Color(227, 47 ,47));
		btnB05.setBounds(370, 160, 55, 50);
		panel1.add(btnB05);
		
		JButton btnB06 = new JButton("B06");
		btnB06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB06.setBackground(new Color(227, 47 ,47));
		btnB06.setBounds(455, 160, 55, 50);
		panel1.add(btnB06);
		
		btnB07 = new JButton("B07");
		btnB07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB07.setBackground(new Color(227, 47 ,47));
		btnB07.setBounds(540, 160, 55, 50);
		panel1.add(btnB07);
		
		btnB08 = new JButton("B08");
		btnB08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB08.setBackground(new Color(227, 47 ,47));
		btnB08.setBounds(625, 160, 55, 50);
		panel1.add(btnB08);
		
		btnB09 = new JButton("B09");
		btnB09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB09.setBackground(new Color(227, 47 ,47));
		btnB09.setBounds(710, 160, 55, 50);
		panel1.add(btnB09);
		
		btnB10 = new JButton("B10");
		btnB10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnB10.setBackground(new Color(227, 47 ,47));
		btnB10.setBounds(795, 160, 55, 50);
		panel1.add(btnB10);
		
		//hàng 3
		btnC01 = new JButton("C01");
		btnC01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC01.setBackground(new Color(227, 47 ,47));
		btnC01.setBounds(30, 245, 55, 50);
		panel1.add(btnC01);
		
		btnC02 = new JButton("C02");
		btnC02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC02.setBackground(new Color(227, 47 ,47));
		btnC02.setBounds(115, 245, 55, 50);
		panel1.add(btnC02);
		
		btnC03 = new JButton("C03");
		btnC03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC03.setBackground(new Color(227, 47 ,47));
		btnC03.setBounds(200, 245, 55, 50);
		panel1.add(btnC03);
		
		btnC04 = new JButton("C04");
		btnC04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC04.setBackground(new Color(227, 47 ,47));
		btnC04.setBounds(285, 245, 55, 50);
		panel1.add(btnC04);
		
		btnC05 = new JButton("C05");
		btnC05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC05.setBackground(new Color(227, 47 ,47));
		btnC05.setBounds(370, 245, 55, 50);
		panel1.add(btnC05);
		
		btnC06 = new JButton("C06");
		btnC06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC06.setBackground(new Color(227, 47 ,47));
		btnC06.setBounds(455, 245, 55, 50);
		panel1.add(btnC06);
		
		btnC07 = new JButton("C07");
		btnC07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC07.setBackground(new Color(227, 47 ,47));
		btnC07.setBounds(540, 245, 55, 50);
		panel1.add(btnC07);
		
		btnC08 = new JButton("C08");
		btnC08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC08.setBackground(new Color(227, 47 ,47));
		btnC08.setBounds(625, 245, 55, 50);
		panel1.add(btnC08);
		
		btnC09 = new JButton("C09");
		btnC09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC09.setBackground(new Color(227, 47 ,47));
		btnC09.setBounds(710, 245, 55, 50);
		panel1.add(btnC09);
		
		btnC10 = new JButton("A01");
		btnC10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnC10.setBackground(new Color(227, 47 ,47));
		btnC10.setBounds(795, 245, 55, 50);
		panel1.add(btnC10);
		
		//hàng 4
		btnD01 = new JButton("D01");
		btnD01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD01.setBackground(new Color(227, 47 ,47));
		btnD01.setBounds(30, 330, 55, 50);
		panel1.add(btnD01);
		
		btnD02 = new JButton("D02");
		btnD02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD02.setBackground(new Color(227, 47 ,47));
		btnD02.setBounds(115, 330, 55, 50);
		panel1.add(btnD02);
		
		btnD03 = new JButton("D03");
		btnD03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD03.setBackground(new Color(227, 47 ,47));
		btnD03.setBounds(200, 330, 55, 50);
		panel1.add(btnD03);
		
		btnD04 = new JButton("D04");
		btnD04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD04.setBackground(new Color(227, 47 ,47));
		btnD04.setBounds(285, 330, 55, 50);
		panel1.add(btnD04);
		
		btnD05 = new JButton("D05");
		btnD05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD05.setBackground(new Color(227, 47 ,47));
		btnD05.setBounds(370, 330, 55, 50);
		panel1.add(btnD05);
		
		btnD06 = new JButton("D06");
		btnD06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD06.setBackground(new Color(227, 47 ,47));
		btnD06.setBounds(455, 330, 55, 50);
		panel1.add(btnD06);
		
		btnD07 = new JButton("D07");
		btnD07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD07.setBackground(new Color(227, 47 ,47));
		btnD07.setBounds(540, 330, 55, 50);
		panel1.add(btnD07);
		
		btnD08 = new JButton("D08");
		btnD08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD08.setBackground(new Color(227, 47 ,47));
		btnD08.setBounds(625, 330, 55, 50);
		panel1.add(btnD08);
		
		btnD09 = new JButton("D09");
		btnD09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD09.setBackground(new Color(227, 47 ,47));
		btnD09.setBounds(710, 330, 55, 50);
		panel1.add(btnD09);
		
		btnD10 = new JButton("D10");
		btnD10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnD10.setBackground(new Color(227, 47 ,47));
		btnD10.setBounds(795, 330, 55, 50);
		panel1.add(btnD10);
		
		//hàng 5
		btnE01 = new JButton("E01");
		btnE01.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE01.setBackground(new Color(227, 47 ,47));
		btnE01.setBounds(30, 415, 55, 50);
		panel1.add(btnE01);
		
		btnE02 = new JButton("E02");
		btnE02.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE02.setBackground(new Color(227, 47 ,47));
		btnE02.setBounds(115, 415, 55, 50);
		panel1.add(btnE02);
		
		btnE03 = new JButton("E03");
		btnE03.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE03.setBackground(new Color(227, 47 ,47));
		btnE03.setBounds(200, 415, 55, 50);
		panel1.add(btnE03);
		
		btnE04 = new JButton("E04");
		btnE04.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE04.setBackground(new Color(227, 47 ,47));
		btnE04.setBounds(285, 415, 55, 50);
		panel1.add(btnE04);
		
		btnE05 = new JButton("E05");
		btnE05.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE05.setBackground(new Color(227, 47 ,47));
		btnE05.setBounds(370, 415, 55, 50);
		panel1.add(btnE05);
		
		btnE06 = new JButton("E06");
		btnE06.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE06.setBackground(new Color(227, 47 ,47));
		btnE06.setBounds(455, 415, 55, 50);
		panel1.add(btnE06);
		
		btnE07 = new JButton("E07");
		btnE07.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE07.setBackground(new Color(227, 47 ,47));
		btnE07.setBounds(540, 415, 55, 50);
		panel1.add(btnE07);
		
		btnE08 = new JButton("E08");
		btnE08.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE08.setBackground(new Color(227, 47 ,47));
		btnE08.setBounds(625, 415, 55, 50);
		panel1.add(btnE08);
		
		btnE09 = new JButton("E09");
		btnE09.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE09.setBackground(new Color(227, 47 ,47));
		btnE09.setBounds(710, 415, 55, 50);
		panel1.add(btnE09);
		
		btnE10 = new JButton("E10");
		btnE10.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnE10.setBackground(new Color(227, 47 ,47));
		btnE10.setBounds(795, 415, 55, 50);
		panel1.add(btnE10);
//--------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//thông báo ghế 
		labelTrong = new JLabel();
		labelTrong.setOpaque(true);
		labelTrong.setBackground(new Color(227, 47, 47));
		labelTrong.setBounds(20, 520, 55, 50);
		panel1.add(labelTrong);
		
		labelDaChon = new JLabel();
		labelDaChon.setOpaque(true);
		labelDaChon.setBackground(new Color(161, 149, 149));
		labelDaChon.setBounds(220, 520, 55, 50);
		panel1.add(labelDaChon);
		
		labelDangChon = new JLabel();
		labelDangChon.setOpaque(true);
		labelDangChon.setBackground(new Color(226, 194, 112));
		labelDangChon.setBounds(420, 520, 55, 50);
		panel1.add(labelDangChon);
		
		lblGheTrong = new JLabel("Ghế trống");
		lblGheTrong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGheTrong.setBounds(80, 520, 110, 50);
		panel1.add(lblGheTrong );
		
		lblDaChon = new JLabel("Đã chọn");
		lblDaChon.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblDaChon.setBounds(280, 520, 110, 50);
		panel1.add(lblDaChon);
		
		lblDangChon = new JLabel("Đang chọn");
		lblDangChon.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblDangChon.setBounds(480, 520, 110, 50);
		panel1.add(lblDangChon);
		
		lblGioChieu = new JLabel("Giờ Chiếu:");
		lblGioChieu.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblGioChieu.setBounds(670, 530, 70, 30);
		panel1.add(lblGioChieu);
		
		txtGioChieu = new JTextField();
		txtGioChieu.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGioChieu.setVisible(true);
		txtGioChieu.setBackground(new Color(225, 214, 196));
		txtGioChieu.setBorder(null);
		txtGioChieu.setEditable(false);
		txtGioChieu.setBounds(740, 530, 90, 30);
		txtGioChieu.setText(phimduocchon.getGioChieu());
		panel1.add(txtGioChieu);
//---------------------------------------------------------------------------------------------------------------------------------------------------------

		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel2.setBackground(new Color(225, 214, 196));
		panel2.setBounds(885, 0, 355, 330);
		add(panel2);
		panel2.setLayout(null);
		
		lblThongTinVe = new JLabel("Thông Tin Vé");
		lblThongTinVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinVe.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblThongTinVe.setBounds(120, 10, 135, 30);
		panel2.add(lblThongTinVe);
		
		lblMaPhim = new JLabel("Mã Phim:");
		lblMaPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblMaPhim.setBounds(30, 55, 90, 25);
		panel2.add(lblMaPhim);
		
		lblTenPhim = new JLabel("Tên Phim:");
		lblTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTenPhim.setBounds(30, 100, 90, 25);
		panel2.add(lblTenPhim);
		
		JLabel lblThoiGian = new JLabel("Thời Gian:");
		lblThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblThoiGian.setBounds(30, 145, 90, 25);
		panel2.add(lblThoiGian);
		
		lblPhong = new JLabel("Phòng:");
		lblPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblPhong.setBounds(30, 190, 70, 25);
		panel2.add(lblPhong);
		
		lblTongTien1 = new JLabel("Tổng Tiền:");
		lblTongTien1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTongTien1.setBounds(30, 235, 90, 25);
		panel2.add(lblTongTien1);
		
		lblGhe = new JLabel("Ghế:");
		lblGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGhe.setBounds(180, 190, 55, 25);
		panel2.add(lblGhe);
		
		txtMaPhim = new JTextField();
		txtMaPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtMaPhim.setBackground(new Color(225, 214, 196));
		txtMaPhim.setBorder(null);
		txtMaPhim.setEditable(false);
		txtMaPhim.setBounds(120, 55, 200, 25);
		txtMaPhim.setText(phimduocchon.getMaPhim());
		panel2.add(txtMaPhim);
		
		txtTenPhim = new JTextField();
		txtTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenPhim.setVisible(true);
		txtTenPhim.setBackground(new Color(225, 214, 196));
		txtTenPhim.setBorder(null);
		txtTenPhim.setEditable(false);
		txtTenPhim.setBounds(120, 100, 200, 25);
		txtTenPhim.setText(phimduocchon.getTenPhim());
		panel2.add(txtTenPhim);
		
		txtThoiGian = new JTextField();
		txtThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtThoiGian.setVisible(true);
		txtThoiGian.setBackground(new Color(225, 214, 196));
		txtThoiGian.setBorder(null);
		txtThoiGian.setEditable(false);
		txtThoiGian.setBounds(120, 145, 200, 25);
		txtThoiGian.setText(String.valueOf(phimduocchon.getThoiLuong())+" phút");
		panel2.add(txtThoiGian);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtPhong.setVisible(true);
		txtPhong.setEditable(false);
		txtPhong.setBackground(new Color(225, 214, 196));
		txtPhong.setBorder(null);
		txtPhong.setBounds(100, 190, 60, 25);
		txtPhong.setText(phong.getTenPhong());
		panel2.add(txtPhong);
		
		txtGhe = new JTextField();
		txtGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGhe.setVisible(true);
		txtGhe.setEditable(false);
		txtGhe.setBackground(new Color(225, 214, 196));
		txtGhe.setBorder(null);
		txtGhe.setBounds(235, 190, 90, 25);
		panel2.add(txtGhe);
		
		txtTongTien1 = new JTextField();
		txtTongTien1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTongTien1.setVisible(true);
		txtTongTien1.setEditable(false);
		txtTongTien1.setBackground(new Color(225, 214, 196));
		txtTongTien1.setBorder(null);
		txtTongTien1.setBounds(120, 235, 200, 25);
		panel2.add(txtTongTien1);
		
		//panel 3
		panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel3.setBackground(new Color(225, 214, 196));
		panel3.setBounds(885, 330, 355, 270);
		add(panel3);
		panel3.setLayout(null);
		
		//hàng đầu
		txtSDT1 = new JTextField();
		txtSDT1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSDT1.setBounds(15, 40, 150, 25);
		txtSDT1.setBackground(new Color(225, 214, 196));
		panel3.add(txtSDT1);
		setPlaceholder(txtSDT1,"Nhập số điện thoại");
//		String makhachhang = txtSDT1.getText();
//		
//		KhachHang khachhang = KhachHang_DAO.getKhachHangByMaKH(makhachhang);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnTim.setBackground(new Color(79, 143, 66));
		btnTim.setBounds(180, 40, 60, 25);
		panel3.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Lấy mã khách hàng từ JTextField tại thời điểm nhấn nút
		        makhachhang = txtSDT1.getText();  // Lấy giá trị từ JTextField
		        KhachHang khachhang = KhachHang_DAO.getKhachHangByMaKH(makhachhang);  // Gọi hàm lấy thông tin khách hàng
		        
		        // Kiểm tra nếu khách hàng tồn tại thì hiển thị thông tin
		        if (khachhang != null) {
		            txtTenKH.setText(khachhang.getHoTenKH());
		            txtSDT2.setText(khachhang.getMaKH());
		            cboSex.setSelectedItem(khachhang.isGioiTinh() ? "Nam" : "Nữ"); // Hiển thị giới tính
		        } 
		        else {
		        	JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!");
		        	txtTenKH.setText("");
		            txtSDT2.setText("");
		            cboSex.getSelectedItem().equals("Nam");
		        }
		   }
		});

		// hàng 2
		txtTenKH = new JTextField("");
		txtTenKH.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenKH.setBounds(15, 80, 130, 25);
		txtTenKH.setBackground(new Color(225, 214, 196));
		panel3.add(txtTenKH);
		setPlaceholder(txtTenKH,"Tên Khách Hàng");
		
		txtSDT2 = new JTextField("");
		txtSDT2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSDT2.setBackground(new Color(225, 214, 196));
		txtSDT2.setBounds(150, 80, 130, 25);
		panel3.add(txtSDT2);
		setPlaceholder(txtSDT2,"SĐT Khách Hàng");
		
		String[] sex = {"Nam","Nữ"};
		cboSex = new JComboBox(sex);
		cboSex.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		cboSex.setBackground(new Color(225, 214, 196));
		cboSex.setBounds(285, 80, 65, 25);
		panel3.add(cboSex);
		
		// hàng 3
		btnHuy = new JButton("Hủy Bỏ");
		btnHuy.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnHuy.setBackground(new Color(227, 47, 47));
		btnHuy.setBounds(50, 235, 105, 30);
		panel3.add(btnHuy);
		
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.chaneToGD_phim();;
			}
		});
		
		btnDat = new JButton("Đặt Vé");
		btnDat.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnDat.setBackground(new Color(53, 220, 20));
		btnDat.setBounds(205, 235, 105, 30);
		panel3.add(btnDat);
		
		btnDat.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// Lấy số điện thoại
		    	String maKH = txtSDT2.getText().trim(); // Lấy số điện thoại đã nhập, và loại bỏ khoảng trắng thừa
		    	if (maKH.isEmpty() || maKH.equals("Nhập số điện thoại")) {
		    	    JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại hợp lệ.");
		    	    return;  // Dừng nếu không có giá trị hợp lệ
		    	}

		        String tenKH = txtTenKH.getText();  // Lấy tên khách hàng
		        boolean gioiTinh = cboSex.getSelectedItem().equals("Nam");  // true nếu là Nam, false nếu là Nữ

		        KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		        boolean success = khachHangDAO.saveKhachHang(maKH, tenKH, gioiTinh);

		        if (success) {
		            JOptionPane.showMessageDialog(null, "Lưu khách hàng thành công!");
		        }
		        // Lưu thông tin vào SharedData
		        SharedData dulieutam = new SharedData(maKH, tenKH, gioiTinh);
		        SharedDataHolder.setSharedData(dulieutam);  // Lưu vào SharedDataHolder
		        menu.changeToGD_TTHD();
		    }  
		});
		
				
		
		lblThanhToan = new JLabel("Thanh Toán");
		lblThanhToan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhToan.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblThanhToan.setBounds(120, 10, 135, 30);
		panel3.add(lblThanhToan);
		
		lblTongTien2 = new JLabel("Tổng tiền:");
		lblTongTien2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTongTien2.setBounds(15, 120, 100, 25);
		panel3.add(lblTongTien2);
		
		lblTienKhachDua = new JLabel("Tiền Khách Đưa:");
		lblTienKhachDua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTienKhachDua.setBounds(15, 160, 120, 25);
		panel3.add(lblTienKhachDua);
		
		lblTienThua = new JLabel("Tiền Thừa");
		lblTienThua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTienThua.setBounds(15, 200, 100, 25);
		panel3.add(lblTienThua);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTienKhachDua.setBounds(135, 160, 200, 25);
		txtTienKhachDua.setBackground(new Color(225, 214, 196));
		panel3.add(txtTienKhachDua);
		
		txtTongTien2 = new JTextField();
		txtTongTien2.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTongTien2.setBackground(new Color(225, 214 ,196));
		txtTongTien2.setBorder(null);
		txtTongTien2.setEditable(false);
		txtTongTien2.setBounds(135, 120, 200, 25);
		panel3.add(txtTongTien2);
		
		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTienThua.setBackground(new Color(225, 214 ,196));
		txtTienThua.setBorder(null);
		txtTienThua.setEditable(false);
		txtTienThua.setBounds(135, 200, 200, 25);
		txtTienThua.setBorder(null);
		panel3.add(txtTienThua);
	}

	 // Hàm setPlaceholder cho JTextField
    public static void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
    public String returnMaKH() {
    	return makhachhang;
    }
    public Phim returnPhim() {
    	return phimduocchon;
    }
//    public SharedData returnDuLieuTam() {
//    	return dulieutam;
//    }

}
