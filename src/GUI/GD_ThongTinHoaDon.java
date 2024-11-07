package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
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
	private JTextField txtSuatChieu;
	private JTextField txtThoiGian;
	private JTextField txtPhong;
	private JTextField txtGhe;
	private JTextField txtTongTien;

	public GD_ThongTinHoaDon(Menu_view menu) {
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		//pane 1
		JPanel panel1 = new JPanel();
		panel1.setBounds(400, 0, 440, 280);
		panel1.setBackground(new Color(180, 155, 160));
		add(panel1);
		panel1.setLayout(null);
		
		JLabel lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
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
		txtMaHD.setBounds(165, 60, 200, 25);
		panel1.add(txtMaHD);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTenKH.setEditable(false);
		txtTenKH.setBorder(null);
		txtTenKH.setBackground(new Color(180, 155, 160));
		txtTenKH.setBounds(165, 105, 200, 25);
		panel1.add(txtTenKH);
		
		txtNgayMua = new JTextField();
		txtNgayMua.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtNgayMua.setEditable(false);
		txtNgayMua.setBorder(null);
		txtNgayMua.setBackground(new Color(180, 155, 160));
		txtNgayMua.setBounds(165, 150, 200, 25);
		panel1.add(txtNgayMua);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSDT.setEditable(false);
		txtSDT.setBorder(null);
		txtSDT.setBackground(new Color(180, 155, 160));
		txtSDT.setBounds(165, 195, 200, 25);
		panel1.add(txtSDT);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setBorder(null);
		txtGioiTinh.setBackground(new Color(180, 155, 160));
		txtGioiTinh.setBounds(165, 240, 200, 25);
		panel1.add(txtGioiTinh);
		
		
		//panel 2
		JPanel panel2 = new JPanel();
		panel2.setBounds(400, 280, 440, 320);
		panel2.setBorder(new MatteBorder(2, 0, 0, 0, Color.black));
		panel2.setBackground(new Color(180, 155, 160));
		add(panel2);
		panel2.setLayout(null);
		
		JLabel lblTenPhim = new JLabel("Tên Phim:");
		lblTenPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTenPhim.setBounds(20, 25, 80, 25);
		panel2.add(lblTenPhim);
		
		JLabel lblXuatChieu = new JLabel("Suất Chiếu:");
		lblXuatChieu.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblXuatChieu.setBounds(20, 75, 80, 25);
		panel2.add(lblXuatChieu);
		
		JLabel lblThoiGian = new JLabel("Thời Gian:");
		lblThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblThoiGian.setBounds(20, 125, 80, 25);
		panel2.add(lblThoiGian);
		
		JLabel lblPhong = new JLabel("Phòng:");
		lblPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblPhong.setBounds(20, 175, 80, 25);
		panel2.add(lblPhong);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTongTien.setBounds(20, 225, 80, 25);
		panel2.add(lblTongTien);
		
		JLabel lblGhe = new JLabel("Ghế:");
		lblGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblGhe.setBounds(230, 175, 60, 25);
		panel2.add(lblGhe);
		
		JButton btnXacNhan = new JButton("Xác Nhận");
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
		txtTenPhim.setBounds(100, 25, 200, 25);
		panel2.add(txtTenPhim);
		
		txtSuatChieu = new JTextField();
		txtSuatChieu.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtSuatChieu.setEditable(false);
		txtSuatChieu.setBorder(null);
		txtSuatChieu.setBackground(new Color(180, 155, 160));
		txtSuatChieu.setBounds(100, 80, 200, 25);
		panel2.add(txtSuatChieu);
		
		txtThoiGian = new JTextField();
		txtThoiGian.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtThoiGian.setEditable(false);
		txtThoiGian.setBorder(null);
		txtThoiGian.setBackground(new Color(180, 155, 160));
		txtThoiGian.setBounds(110, 125, 200, 25);
		panel2.add(txtThoiGian);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtPhong.setEditable(false);
		txtPhong.setBorder(null);
		txtPhong.setBackground(new Color(180, 155, 160));
		txtPhong.setBounds(100, 175, 100, 25);
		panel2.add(txtPhong);
		
		txtGhe = new JTextField();
		txtGhe.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtGhe.setEditable(false);
		txtGhe.setBorder(null);
		txtGhe.setBackground(new Color(180, 155, 160));
		txtGhe.setBounds(290, 175, 140, 25);
		panel2.add(txtGhe);
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		txtTongTien.setEditable(false);
		txtTongTien.setBorder(null);
		txtTongTien.setBackground(new Color(180, 155, 160));
		txtTongTien.setBounds(100, 225, 200, 25);
		panel2.add(txtTongTien);
	}
}
