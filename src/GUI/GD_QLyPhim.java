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

public class GD_QLyPhim extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenPhim;
	private JTextField txtMaPhim;
	private JTable table_1;
	private JTextField txtThoiLuong;
	private JTextField txtGiaTien;
	private JTextField txtGioChieu;
	private String imagePath ;

	public GD_QLyPhim() {
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
						Image scaledImage = img.getScaledInstance(lblPoster.getWidth(), lblPoster.getHeight(),
								Image.SCALE_SMOOTH);
						lblPoster.setIcon(new ImageIcon(scaledImage));
						// Lưu đường dẫn ảnh vào tooltip hoặc biến khác nếu cần
		                lblPoster.setToolTipText(imagePath);
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

		DefaultTableModel model = new DefaultTableModel(
			    new String[] { "Mã Phim", "Tên Phim", "Thời Lượng", "Giá Tiền", "Ảnh poster", "Giờ Chiếu" }, 0);
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
		btnThem.setIcon(new ImageIcon(GD_QLyPhim.class.getResource("/view/image/IconAdd.png")));
		btnThem.setBounds(539, 345, 50, 50);
		add(btnThem);

		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(GD_QLyPhim.class.getResource("/view/image/IconBin.png")));
		btnXoa.setBounds(888, 345, 50, 50);
		add(btnXoa);

		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon(GD_QLyPhim.class.getResource("/view/image/IconEdit.png")));
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

		
		txtGioChieu = new JTextField();
		txtGioChieu.setBounds(126, 510, 175, 25); // Điều chỉnh vị trí và kích thước
		add(txtGioChieu);

		JLabel lblGioChieu = new JLabel("Giờ Chiếu");
		lblGioChieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGioChieu.setBounds(51, 515, 56, 13); // Điều chỉnh vị trí
		add(lblGioChieu);

//-----------------------------------------------------------------------------------------------------------------------------
		table_1.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        int selectedRow = table_1.getSelectedRow();
		        table_1.setSelectionBackground(new Color(184, 217, 29));
		        table_1.setSelectionForeground(Color.BLACK);

		        if (selectedRow != -1) {
		            // Lấy dữ liệu từ dòng đã chọn
		            String maPhim = table_1.getValueAt(selectedRow, 0).toString();
		            String tenPhim = table_1.getValueAt(selectedRow, 1).toString();
		            String thoiLuong = table_1.getValueAt(selectedRow, 2).toString();
		            String giaTien = table_1.getValueAt(selectedRow, 3).toString();
		            String anhPoster = table_1.getValueAt(selectedRow, 4).toString();
		            String gioChieu = table_1.getValueAt(selectedRow, 5).toString();

		            txtMaPhim.setText(maPhim);
		            txtTenPhim.setText(tenPhim);
		            txtThoiLuong.setText(thoiLuong);
		            txtGiaTien.setText(giaTien);
		            txtGioChieu.setText(gioChieu);

		            // Khi chọn dòng, kiểm tra nếu có ảnh tồn tại trong dữ liệu
		            if (anhPoster != null && !anhPoster.isEmpty()) {
		                try {
		                    java.io.File imageFile = new java.io.File(anhPoster);
		                    if (imageFile.exists()) {
		                        BufferedImage img = ImageIO.read(imageFile);
		                        Image scaledImage = img.getScaledInstance(lblPoster.getWidth(), lblPoster.getHeight(), Image.SCALE_SMOOTH);
		                        lblPoster.setIcon(new ImageIcon(scaledImage));
		                        // Lưu đường dẫn ảnh vào tooltip hoặc một biến tạm nếu cần
		                        lblPoster.setToolTipText(anhPoster); // Lưu đường dẫn vào tooltip
		                    } else {
		                        System.out.println("Ảnh không tồn tại: " + anhPoster);
		                    }
		                } catch (IOException ex) {
		                    System.out.println("Lỗi khi tải hình ảnh từ đường dẫn: " + anhPoster);
		                    ex.printStackTrace();
		                }
		            }
		        }
		    }
		});

		btnThem.setToolTipText("Thêm phim mới");
		btnXoa.setToolTipText("Xóa phim đã chọn");
		btnSua.setToolTipText("Sửa thông tin phim");

// --------------------------------------------------------------Them-----------------------------------------------------------
		btnThem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Kiểm tra các trường dữ liệu
		        String maPhim = txtMaPhim.getText().trim();
		        String tenPhim = txtTenPhim.getText().trim();
		        String thoiLuongStr = txtThoiLuong.getText().trim();
		        String giaTienStr = txtGiaTien.getText().trim();
		        String gioChieu = txtGioChieu.getText().trim();
		        
		        if (gioChieu.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập giờ chiếu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        if (maPhim.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã phim!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        if (!maPhim.matches("[A-Za-z0-9]+")) {  // Kiểm tra mã phim chỉ chứa chữ và số
		            JOptionPane.showMessageDialog(null, "Mã phim chỉ được chứa chữ và số!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        if (tenPhim.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên phim!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        int thoiLuong = 0;
		        try {
		            thoiLuong = Integer.parseInt(thoiLuongStr);
		            if (thoiLuong <= 0) {
		                JOptionPane.showMessageDialog(null, "Thời lượng phim phải là một số nguyên dương!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                return;
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Thời lượng phim phải là một số nguyên hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        BigDecimal giaTien = null;
		        try {
		            giaTien = new BigDecimal(giaTienStr);
		            if (giaTien.compareTo(BigDecimal.ZERO) <= 0) {
		                JOptionPane.showMessageDialog(null, "Giá tiền phải là một số lớn hơn 0!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                return;
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Giá tiền phải là một số hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        if (imagePath == null || imagePath.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn ảnh poster!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        // Ktra mã phim có tồn tại trong cơ sở dữ liệu k
		        try (Connection conn = ConnectDB.getConnection()) {
		            String checkQuery = "SELECT COUNT(*) FROM Phim WHERE MaPhim = ?";
		            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
		            checkStmt.setString(1, maPhim);
		            ResultSet rs = checkStmt.executeQuery();
		            if (rs.next() && rs.getInt(1) > 0) {
		                JOptionPane.showMessageDialog(null, "Mã phim đã tồn tại trong cơ sở dữ liệu. Vui lòng nhập mã phim khác!", "Thông báo", JOptionPane.ERROR_MESSAGE);
		                return; // Dừng lại nếu mã phim đã tồn tại
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra mã phim!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Thêm dữ liệu vào JTable
		        model.addRow(new Object[] { maPhim, tenPhim, thoiLuong, giaTien, imagePath, gioChieu });
		        
		     // Thêm vào cơ sở dữ liệu
		        try (Connection conn = ConnectDB.getConnection()) {
		            String query = "INSERT INTO Phim (MaPhim, Tenphim, ThoiLuong, GiaTien, AnhPoster, GioChieu) VALUES (?, ?, ?, ?, ?, ?)";
		            PreparedStatement stmt = conn.prepareStatement(query);
		            stmt.setString(1, maPhim);
		            stmt.setString(2, tenPhim);
		            stmt.setInt(3, thoiLuong);
		            stmt.setBigDecimal(4, giaTien);
		            stmt.setString(5, imagePath);
		            stmt.setString(6, gioChieu);
		            stmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Lỗi khi thêm dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }

		        // Xóa trắng các trường sau khi thêm
		        txtMaPhim.setText("");
		        txtTenPhim.setText("");
		        txtThoiLuong.setText("");
		        txtGiaTien.setText("");
		        txtGioChieu.setText("");
		        lblPoster.setIcon(null);
		        imagePath = null;
		    }
		});


//--------------------------------------------------------Xoa-----------------------------------------------------------------------
		btnXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table_1.getSelectedRow();

		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một phim để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        String maPhim = table_1.getValueAt(selectedRow, 0).toString();

		        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phim này và tất cả dữ liệu liên quan?", "Xác nhận", JOptionPane.YES_NO_OPTION);
		        if (confirm != JOptionPane.YES_OPTION) {
		            return;
		        }

		        try (Connection conn = ConnectDB.getConnection()) {
		            String deletePhim = "DELETE FROM Phim WHERE MaPhim = ?";
		            PreparedStatement stmt = conn.prepareStatement(deletePhim);
		            stmt.setString(1, maPhim);
		            stmt.executeUpdate();

		            // Xóa dòng khỏi bảng JTable
		            ((DefaultTableModel) table_1.getModel()).removeRow(selectedRow);
		            JOptionPane.showMessageDialog(null, "Xóa phim và dữ liệu liên quan thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi xóa phim!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

//-------------------------------------------------------------------Sua----------------------------------------------
		btnSua.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Lấy dòng được chọn trong JTable
		        int selectedRow = table_1.getSelectedRow();

		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một phim để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        // Lấy mã phim hiện tại (MaPhim cũ) từ dòng được chọn
		        String maPhimCu = table_1.getValueAt(selectedRow, 0).toString();

		        // Lấy thông tin từ các JTextField
		        String maPhim = txtMaPhim.getText().trim();
		        String tenPhim = txtTenPhim.getText().trim();
		        String thoiLuongStr = txtThoiLuong.getText().trim();
		        String giaTienStr = txtGiaTien.getText().trim();
		        String gioChieu = txtGioChieu.getText().trim();
		        
		       

		        // Kiểm tra các trường nhập liệu
		        if (maPhim.isEmpty() || tenPhim.isEmpty() || thoiLuongStr.isEmpty() || giaTienStr.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        if (gioChieu.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập giờ chiếu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        // Kiểm tra thời lượng
		        int thoiLuong = 0;
		        try {
		            thoiLuong = Integer.parseInt(thoiLuongStr);
		            if (thoiLuong <= 0) {
		                JOptionPane.showMessageDialog(null, "Thời lượng phim phải là một số nguyên dương!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                return;
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Thời lượng phim phải là một số nguyên hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        // Kiểm tra giá tiền
		        BigDecimal giaTien = null;
		        try {
		            giaTien = new BigDecimal(giaTienStr);
		            if (giaTien.compareTo(BigDecimal.ZERO) <= 0) {
		                JOptionPane.showMessageDialog(null, "Giá tiền phải là một số lớn hơn 0!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		                return;
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Giá tiền phải là một số hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        // Lấy đường dẫn ảnh từ tooltip (nếu có chọn ảnh mới)
		        String imagePath = lblPoster.getToolTipText();

		        // Nếu không có ảnh mới được chọn, lấy ảnh cũ từ bảng
		        if (imagePath == null || imagePath.isEmpty()) {
		            imagePath = table_1.getValueAt(selectedRow, 5).toString();
		        }

		        // Kiểm tra xem mã phim mới có trùng với mã phim đã tồn tại không
		        try (Connection conn = ConnectDB.getConnection()) {
		            String checkQuery = "SELECT COUNT(*) FROM Phim WHERE Maphim = ? AND Maphim != ?";
		            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
		            checkStmt.setString(1, maPhim);
		            checkStmt.setString(2, maPhimCu);
		            ResultSet rs = checkStmt.executeQuery();

		            if (rs.next() && rs.getInt(1) > 0) {
		                JOptionPane.showMessageDialog(null, "Mã phim đã tồn tại, vui lòng nhập mã phim khác!", "Thông báo", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Nếu không bị trùng, tiếp tục cập nhật thông tin
		            String updateQuery = "UPDATE Phim SET Maphim = ?, Tenphim = ?, ThoiLuong = ?, GiaTien = ?, AnhPoster = ?, GioChieu = ? WHERE MaPhim = ?";
		            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
		            updateStmt.setString(1, maPhim);
		            updateStmt.setString(2, tenPhim);
		            updateStmt.setInt(3, thoiLuong); // Chuyển đổi thành số nguyên
		            updateStmt.setBigDecimal(4, giaTien); // Chuyển đổi BigDecimal
		            updateStmt.setString(5, imagePath);
		            updateStmt.setString(6, gioChieu);
		            updateStmt.setString(7, maPhimCu);

		            int rowsUpdated = updateStmt.executeUpdate();
		            if (rowsUpdated > 0) {
		                // Cập nhật lại thông tin trên JTable
		                table_1.setValueAt(maPhim, selectedRow, 0); // Cột mã phim
		                table_1.setValueAt(tenPhim, selectedRow, 1); // Cột tên phim
		                table_1.setValueAt(thoiLuong, selectedRow, 2); // Cột thời lượng
		                table_1.setValueAt(giaTien, selectedRow, 3); // Cột giá tiền
		                table_1.setValueAt(imagePath, selectedRow, 4); // Cột ảnh poster
		                table_1.setValueAt(gioChieu, selectedRow, 5); // Cột Giờ Chiếu
		                

		                JOptionPane.showMessageDialog(null, "Cập nhật thông tin phim thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "Không tìm thấy mã phim cần cập nhật!", "Thông báo", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});


		
		loadTableData(); // Tải dữ liệu từ database lên bảng
	}

	private void loadTableData() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0); // Xóa dữ liệu cũ

		try (Connection conn = ConnectDB.getConnection()) {
			String query = "SELECT MaPhim, Tenphim, ThoiLuong, GiaTien, AnhPoster, GioChieu FROM Phim";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] {
				        rs.getString("MaPhim"),
				        rs.getString("Tenphim"),
				        rs.getInt("ThoiLuong"),
				        rs.getBigDecimal("GiaTien"),
				        rs.getString("AnhPoster"),
				        rs.getString("GioChieu")
				    });
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame("Quản Lý Phim");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add(new GD_QLyPhim());
//		frame.setSize(1240, 650);
//		frame.setVisible(true);
//		
//	}
}
