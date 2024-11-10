package GUI;

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class LogIn_view extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField account;
    private JTextField password;
    private TaiKhoan_Dao dstk;
    private JButton btnDangNhap;  // Sửa thành JButton
    private JButton btnThoat;     // Sửa thành JButton

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
    	dstk = new TaiKhoan_Dao();
    	getRootPane().setDefaultButton(	btnDangNhap);
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
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/view/image/logo_penguin_login.png")));
        lblNewLabel.setBounds(0, 0, 361, 361);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
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
        // Tai Khoan Mac Dinh
     	account.setText("");
     	password.setText("");
     	// Action
//     	btnDangNhap.addActionListener(this);
//     	btnThoat.addActionListener(this);

        btnDangNhap = new JButton("Nhập");  // Sử dụng biến thành viên
        btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDangNhap.setFont(new Font("Consolas", Font.BOLD, 14));
        btnDangNhap.setBounds(442, 290, 100, 30);
        btnDangNhap.addActionListener(this); // Đăng ký ActionListener
        contentPane.add(btnDangNhap);

        btnThoat = new JButton("Thoát");  // Sử dụng biến thành viên
        btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThoat.setFont(new Font("Consolas", Font.BOLD, 14));
        btnThoat.setBounds(595, 290, 100, 30);
        btnThoat.addActionListener(this); // Đăng ký ActionListener
        contentPane.add(btnThoat);

        JLabel lblIconDangNhap = new JLabel();
        lblIconDangNhap.setIcon(new ImageIcon(getClass().getResource("/view/image/iconAcount.png")));
        lblIconDangNhap.setBounds(425, 118, 50, 40);
        contentPane.add(lblIconDangNhap);

        JLabel lblIconPass = new JLabel();
        lblIconPass.setIcon(new ImageIcon(getClass().getResource("/view/image/iconKey.png")));
        lblIconPass.setBounds(423, 193, 50, 40);
        contentPane.add(lblIconPass);
    }

    public void dangNhap() {
        String tenDN = account.getText().trim();
        String mk = password.getText().trim();
        entity.TaiKhoan tk = dstk.getTaiKhoanTheoTen(tenDN);
        
        if (tk == null) {
            JOptionPane.showMessageDialog(this, "Tài khoản không đúng!\nVui lòng kiểm tra lại.");
            account.requestFocus();
            
        } else if (!tk.getMatKhau().equalsIgnoreCase(mk)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không đúng!\nVui lòng kiểm tra lại.");
            password.requestFocus();
            
        } else {
            Menu_view menu_view = new Menu_view();
            menu_view.setVisible(true);
            this.setVisible(false);
        }
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThoat)) {
            System.exit(0);
        } else if (o.equals(btnDangNhap)) {
            dangNhap();
        }
    }
}
