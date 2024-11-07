package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.TaiKhoan_Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;

public class LogIn_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JTextField password;
	private TaiKhoan_Dao dstk; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn_view frame = new LogIn_view();
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
	public LogIn_view() {
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connect!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(149, 62, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("Đăng nhập");
		lblDangNhap.setBounds(0, 0, 361, 361);
		
		

		
		JLabel lblNewLabel = new JLabel();
//		ImageIcon icon = new ImageIcon(Menu_view.class.getResource("/view/image/logo_penguin.png"));
//		Image image = icon.getImage();
//		Image scaledImage = image.getScaledInstance(361, 361, Image.SCALE_SMOOTH);
//		lblNewLabel.setIcon(new ImageIcon(scaledImage));
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/view/image/logo_penguin_login.png")));
		lblNewLabel.setBounds(0, 0, 361, 361);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 40));
		lblNewLabel_1.setBounds(451, 34, 213, 48);
		contentPane.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setBounds(481, 118, 220, 40);
		contentPane.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setBounds(481, 193, 220, 40);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnLogin = new JButton("Nhập");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Consolas", Font.BOLD, 14));
		btnLogin.setBounds(442, 290, 100, 30);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setFont(new Font("Consolas", Font.BOLD, 14));
		btnExit.setBounds(595, 290, 100, 30);
		contentPane.add(btnExit);
		
		JLabel lblIconLogin = new JLabel();
		lblIconLogin.setIcon(new ImageIcon(getClass().getResource("/view/image/iconAcount.png")));
		lblIconLogin.setBounds(425, 118, 50, 40);
		contentPane.add(lblIconLogin);
		
		JLabel lblIconPass = new JLabel();
		lblIconPass.setIcon(new ImageIcon(getClass().getResource("/view/image/iconKey.png")));
		lblIconPass.setBounds(423, 193, 50, 40);
		contentPane.add(lblIconPass);
		
	}
	public void dangNhap() {
		String tenDN = account.getText().toString().trim();
		String mk = password.getText().toString().trim();
		entity.TaiKhoan tk = dstk.getTaiKhoanTheoTen(tenDN);

		if (tk == null) {
			JOptionPane.showMessageDialog(this, "Tài khoản không đúng!\nVui lòng kiểm tra lại.");
			account.requestFocus();
		} else if (!tk.getMatKhau().equalsIgnoreCase(mk)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không đúng!\nVui lòng kiểm tra lại.");
			password.requestFocus();
		} else {
//			ArrayList<entity.NhanVien> nv = dsNV.getNVTheoMaNV(maTK);
			Menu_view menu_view = new Menu_view();
			menu_view.setVisible(true);
			this.setVisible(false);
		}

	}
}
