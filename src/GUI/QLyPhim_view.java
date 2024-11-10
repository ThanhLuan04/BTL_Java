package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

public class QLyPhim_view extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtTenPhim;
    private JTextField txtMaPhim;
    private JTable table_1;
    private JTextField txtThoiLuong;
    private JTextField txtGiaTien;
    private String imagePath = null;

    public QLyPhim_view() {
        setSize(1240, 600);
        setBackground(new Color(225, 214, 196));
        setLayout(null);

        JLabel lblPoster = new JLabel("");
        lblPoster.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblPoster.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblPoster.setBounds(51, 26, 250, 300);
        add(lblPoster);

        lblPoster.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn hình ảnh");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "gif"));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    imagePath = selectedFile.getAbsolutePath();

                    try {
                        BufferedImage img = ImageIO.read(selectedFile);
                        Image scaledImage = img.getScaledInstance(lblPoster.getWidth(), lblPoster.getHeight(), Image.SCALE_SMOOTH);
                        lblPoster.setIcon(new ImageIcon(scaledImage));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        txtTenPhim = new JTextField();
        txtTenPhim.setBounds(126, 393, 175, 25);
        add(txtTenPhim);

        txtMaPhim = new JTextField();
        txtMaPhim.setBounds(126, 358, 175, 25);
        add(txtMaPhim);

        table_1 = new JTable();
        table_1.setRowHeight(20);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Phim", "Tên Phim", "Thời Lượng", "Giá Tiền", "Ảnh poster"}, 0);
        table_1.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(398, 26, 694, 256);
        add(scrollPane);

        JLabel lblTenPhim = new JLabel("Tên phim");
        lblTenPhim.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTenPhim.setBounds(51, 398, 56, 13);
        add(lblTenPhim);

        JLabel lblMaPhim = new JLabel("Mã Phim");
        lblMaPhim.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMaPhim.setBounds(51, 358, 57, 25);
        add(lblMaPhim);

        JButton btnThem = new JButton("");
        btnThem.setIcon(new ImageIcon(QLyPhim_view.class.getResource("/view/image/IconAdd.png")));
        btnThem.setBounds(539, 345, 50, 50);
        add(btnThem);

        JButton btnXoa = new JButton("");
        btnXoa.setIcon(new ImageIcon(QLyPhim_view.class.getResource("/view/image/IconBin.png")));
        btnXoa.setBounds(888, 345, 50, 50);
        add(btnXoa);

        JButton btnSua = new JButton("");
        btnSua.setIcon(new ImageIcon(QLyPhim_view.class.getResource("/view/image/IconEdit.png")));
        btnSua.setBounds(712, 345, 50, 50);
        add(btnSua);

        txtThoiLuong = new JTextField();
        txtThoiLuong.setBounds(137, 428, 164, 25);
        add(txtThoiLuong);

        JLabel lblThoiLuong = new JLabel("Thời lượng");
        lblThoiLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblThoiLuong.setBounds(51, 433, 67, 13);
        add(lblThoiLuong);

        txtGiaTien = new JTextField();
        txtGiaTien.setBounds(126, 469, 175, 25);
        add(txtGiaTien);

        JLabel lblGiaTien = new JLabel("Giá Tiền");
        lblGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblGiaTien.setBounds(51, 474, 56, 13);
        add(lblGiaTien);
        //Them----------------------------------------
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Kiểm tra các trường dữ liệu
                if (txtMaPhim.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã phim!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (txtTenPhim.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên phim!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (txtThoiLuong.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập thời lượng phim!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (txtGiaTien.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá tiền!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Kiểm tra xem người dùng đã chọn ảnh poster chưa
                if (imagePath == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ảnh poster!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                
                String maPhim = txtMaPhim.getText();
                String tenPhim = txtTenPhim.getText();
                String thoiLuong = txtThoiLuong.getText();
                // Đổi kiểu của giaTien từ String sang BigDecimal
                BigDecimal giaTien = new BigDecimal(txtGiaTien.getText());

                model.addRow(new Object[]{maPhim, tenPhim, thoiLuong, giaTien, imagePath});

                try (Connection conn = ConnectDB.getConnection()) {
                    String query = "INSERT INTO Phim (MaPhim, Tenphim, ThoiLuong, GiaTien, AnhPoster) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, maPhim);
                    stmt.setString(2, tenPhim);
                    stmt.setString(3, thoiLuong);
                    stmt.setBigDecimal(4, giaTien); // Chuyển đổi sang BigDecimal
                    stmt.setString(5, imagePath);
                    stmt.executeUpdate();

                    System.out.println("Thêm dữ liệu thành công!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
             // Xóa nội dung các trường nhập liệu sau khi thêm dữ liệu
                txtMaPhim.setText("");
                txtTenPhim.setText("");
                txtThoiLuong.setText("");
                txtGiaTien.setText("");
                lblPoster.setIcon(null); // Xóa ảnh trên lblPoster
                imagePath = null; 
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();

                // Kiểm tra xem người dùng đã chọn hàng nào chưa
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một phim để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Lấy mã phim từ hàng được chọn
                String maPhim = table_1.getValueAt(selectedRow, 0).toString();

                // Xác nhận từ người dùng
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phim này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }

                // Xóa phim khỏi cơ sở dữ liệu
                try (Connection conn = ConnectDB.getConnection()) {
                    String query = "DELETE FROM Phim WHERE MaPhim = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, maPhim);
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        // Xóa hàng khỏi JTable nếu xóa thành công trong cơ sở dữ liệu
                        ((DefaultTableModel) table_1.getModel()).removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Xóa phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy phim để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi xóa phim!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loadTableData(); // Tải dữ liệu từ database lên bảng
    }
    
    
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        try (Connection conn = ConnectDB.getConnection()) {
            String query = "SELECT MaPhim, Tenphim, ThoiLuong, GiaTien, AnhPoster FROM Phim";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maPhim = rs.getString("MaPhim");
                String tenPhim = rs.getString("Tenphim");
                String thoiLuong = rs.getString("ThoiLuong");
                BigDecimal giaTien = rs.getBigDecimal("GiaTien");
                String anhPoster = rs.getString("AnhPoster");

                // Thêm hàng vào JTable
                model.addRow(new Object[]{maPhim, tenPhim, thoiLuong, giaTien, anhPoster});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản Lý Phim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new QLyPhim_view());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
