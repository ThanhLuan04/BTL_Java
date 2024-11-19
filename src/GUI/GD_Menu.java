package GUI;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import GUI.GD_QuanLyHoaDon;
import GUI.GD_QuanLyKhachHang;
import GUI.GD_ThongKe;
import GUI.GD_ThongTinHoaDon;
import GUI.GD_phim;
import connectDB.ConnectDB;
import dao.Phim_Dao;
import entity.Phim;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JTextField;

public class GD_Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private CardLayout CardLayout;
	private JPanel Show;
	private GD_ThongTinHoaDon TT_Hoadon;
	private GD_ChonGhe ghe;
	private GD_phim GDphim;
	private GD_QuanLyKhachHang KhachHang;
	private GD_ThongKe ThongKe;
	private GD_QLyPhim QLyPhim;
	private GD_QuanLyHoaDon HoaDon;
	private JTextField test;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_Menu frame = new GD_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	
	// Thêm phương thức addHoverEffect
	private void addHoverEffect(JButton button, Color hoverBackgroundColor, Font hoverFont, Color defaultBackgroundColor, Font defaultFont) {
	    button.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            button.setBackground(hoverBackgroundColor); // Đổi màu nền khi hover
	            button.setFont(hoverFont); // Phóng to chữ khi hover
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            button.setBackground(defaultBackgroundColor); // Khôi phục màu nền
	            button.setFont(defaultFont); // Khôi phục font chữ ban đầu
	        }
	    });
	}
	
	
	
	
	private void scaleIcon(JButton button, double scale) {
	        ImageIcon originalIcon = (ImageIcon) button.getIcon();
	        Image image = originalIcon.getImage();
	        int newWidth = (int) (image.getWidth(null) * scale);
	        int newHeight = (int) (image.getHeight(null) * scale);
	        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	        button.setIcon(new ImageIcon(scaledImage));
	    }
	
	public GD_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1455, 740 );
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1440, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_menu.setBackground(new Color(255, 255, 255));
		panel_menu.setBounds(0, 100, 200, 600);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
//		test = new JTextField();
//		test.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(149, 62, 62));
		panel_1.setBounds(0, 0, 200, 120);
		panel_menu.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnKhachHang.setHideActionText(true);
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.setBackground(new Color(149, 62, 62));
		btnKhachHang.setBounds(0, 0, 200, 120);
		panel_1.add(btnKhachHang);
		// Áp dụng hiệu ứng hover cho btnKhchHng
	    addHoverEffect(btnKhachHang, new Color(200, 100, 100), new Font("Segoe UI Black", Font.BOLD, 23), new Color(149, 62, 62), new Font("Segoe UI Black", Font.BOLD, 20));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(149, 62, 62));
		panel_1_1.setBounds(0, 120, 200, 120);
		panel_menu.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnQuanLyPhim = new JButton("Quản Lý Phim");
		btnQuanLyPhim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyPhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuanLyPhim.setHideActionText(true);
		btnQuanLyPhim.setForeground(Color.BLACK);
		btnQuanLyPhim.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnQuanLyPhim.setFocusPainted(false);
		btnQuanLyPhim.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyPhim.setBackground(new Color(149, 62, 62));
		btnQuanLyPhim.setBounds(0, 0, 200, 120);
		panel_1_1.add(btnQuanLyPhim);
		// Áp dụng hiệu ứng hover cho btnQuanLyPhim
	    addHoverEffect(btnQuanLyPhim, new Color(200, 100, 100), new Font("Segoe UI Black", Font.BOLD, 23), new Color(149, 62, 62), new Font("Segoe UI Black", Font.BOLD, 20));
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(149, 62, 62));
		panel_1_1_1.setBounds(0, 240, 200, 120);
		panel_menu.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JButton btnDanhSachPhim = new JButton("Danh Sách Phim");
		btnDanhSachPhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDanhSachPhim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDanhSachPhim.setHideActionText(true);
		btnDanhSachPhim.setForeground(Color.BLACK);
		btnDanhSachPhim.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnDanhSachPhim.setFocusPainted(false);
		btnDanhSachPhim.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDanhSachPhim.setBackground(new Color(149, 62, 62));
		btnDanhSachPhim.setBounds(0, 0, 200, 120);
		panel_1_1_1.add(btnDanhSachPhim);
		// Áp dụng hiệu ứng hover cho btnDanhSachPhim
	    addHoverEffect(btnDanhSachPhim, new Color(200, 100, 100), new Font("Segoe UI Black", Font.BOLD, 23), new Color(149, 62, 62), new Font("Segoe UI Black", Font.BOLD, 20));
		
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1.setBackground(new Color(149, 62, 62));
		panel_1_1_1_1.setBounds(0, 360, 200, 120);
		panel_menu.add(panel_1_1_1_1);
		panel_1_1_1_1.setLayout(null);
		
		JButton btnHoaDon = new JButton("Hóa Đơn");
		btnHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHoaDon.setHideActionText(true);
		btnHoaDon.setForeground(Color.BLACK);
		btnHoaDon.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHoaDon.setBackground(new Color(149, 62, 62));
		btnHoaDon.setBounds(0, 0, 200, 120);
		panel_1_1_1_1.add(btnHoaDon);
		// Áp dụng hiệu ứng hover cho btnHoaDon
	    addHoverEffect(btnHoaDon, new Color(200, 100, 100), new Font("Segoe UI Black", Font.BOLD, 23), new Color(149, 62, 62), new Font("Segoe UI Black", Font.BOLD, 20));
		
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_1.setBackground(new Color(149, 62, 62));
		panel_1_1_1_1_1.setBounds(0, 480, 200, 120);
		panel_menu.add(panel_1_1_1_1_1);
		panel_1_1_1_1_1.setLayout(null);
		
		JButton btnThongKe = new JButton("Thống Kê");
		btnThongKe.setFocusPainted(false);
		btnThongKe.setHideActionText(true);
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnThongKe.setForeground(new Color(0, 0, 0));
		btnThongKe.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setBackground(new Color(149, 62, 62));
		btnThongKe.setBounds(0, 0, 200, 120);
		panel_1_1_1_1_1.add(btnThongKe);
		// Áp dụng hiệu ứng hover cho ThongKe
	    addHoverEffect(btnThongKe, new Color(200, 100, 100), new Font("Segoe UI Black", Font.BOLD, 23), new Color(149, 62, 62), new Font("Segoe UI Black", Font.BOLD, 20));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(149, 62, 62));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(0, 0, 1440, 100);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTitleMenu = new JLabel("GOPINGU CINEMA");
		lblTitleMenu.setForeground(new Color(0, 0, 0));
		lblTitleMenu.setFont(new Font("Jokerman", Font.BOLD, 48));
		lblTitleMenu.setBounds(237, 23, 496, 60);
		panel_2.add(lblTitleMenu);
		
		textField = new JTextField();
		textField.setBounds(1000, 35, 250, 40);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnTim = new JButton();
		btnTim.setOpaque(false);
		btnTim.setFocusPainted(false);
		btnTim.setIcon(new ImageIcon(GD_Menu.class.getResource("/view/image/IconMagnifyingGlass.png")));
		btnTim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTim.setBorder(null);
		addHoverEffect(btnTim, new Color(200, 100, 100), new Font("Segoe UI Black", Font.BOLD, 23), new Color(149, 62, 62), new Font("Segoe UI Black", Font.BOLD, 20));
		btnTim.setBorder(null);
		btnTim.setBackground(new Color(149, 62, 62));
		btnTim.setBounds(1271, 33, 45, 45);
		panel_2.add(btnTim);
		
		JLabel lblLogo = new JLabel();
		ImageIcon icon = new ImageIcon(GD_Menu.class.getResource("/view/image/logo_penguin.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblLogo .setIcon(new ImageIcon(scaledImage));
		lblLogo .setBounds(60, 10, 80, 80);
		panel_2.add(lblLogo);
		
		Show = new JPanel();
		Show.setForeground(new Color(0, 0, 0));
		Show.setFont(new Font("Jokerman", Font.BOLD, 48));
		Show.setBorder(new LineBorder(new Color(0, 0, 0)));
		Show.setBounds(200, 100, 1240, 600);
		contentPane.add(Show);
		
		// Show các trang
		
		Show.setLayout(new CardLayout());
		
		CardLayout = (CardLayout)Show.getLayout();
		HoaDon = new GD_QuanLyHoaDon();
		QLyPhim = new GD_QLyPhim();
		KhachHang = new GD_QuanLyKhachHang();
		ThongKe = new GD_ThongKe();
		GDphim = new GD_phim(this);
		
		Show.add(QLyPhim,"QLyPhim");
		Show.add(HoaDon,"HoaDon");
		Show.add(GDphim,"GDPhim");
		Show.add(KhachHang,"KhachHang");
		Show.add(ThongKe,"ThongKe");
//		Show.add(TT_Hoadon,"TT_Hoadon");
		
		btnQuanLyPhim.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout.show(Show,"QLyPhim");
			}
			
		});
		btnThongKe.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
		        ThongKe.refreshData(); 
				CardLayout.show(Show,"ThongKe");
			}
			
		});
		btnKhachHang.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout.show(Show,"KhachHang");
			}
			
		});
		btnHoaDon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				HoaDon.refreshData();
				CardLayout.show(Show,"HoaDon");
			}
			
		});
		
		btnDanhSachPhim.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				GDphim.loadData();
				CardLayout.show(Show,"GDPhim");
				
			}
			
		});
		
		
	}
	public void chaneToGD_ChonGhe() {

		ghe = new GD_ChonGhe(this,GDphim);
//		System.out.println("Mã phim từ GD_phim: " + GDphim.getMaPhimDuocChon());
		Show.add(ghe,"ghe");
		CardLayout.show(Show,"ghe");
		
	}
	
	public void changeToGD_TTHD() {
		TT_Hoadon = new GD_ThongTinHoaDon(this,GDphim,ghe);
		Show.add(TT_Hoadon,"TT_Hoadon");
		CardLayout.show(Show,"TT_Hoadon");
	}
	public void chaneToGD_phim() {
		CardLayout.show(Show, "GDPhim");
	}
}