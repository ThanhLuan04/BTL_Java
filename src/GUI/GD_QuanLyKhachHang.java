package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GD_QuanLyKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtMa;
	private JTextField txtSDT;
	private JTextField txtTen;
	private JTextField txtTheoTen;
	private JTextField txtTheoMa;
	private DefaultTableModel model;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public GD_QuanLyKhachHang() {
		setBackground(new Color(225, 214, 196));
		setBounds(new Rectangle(0, 0, 1240, 600));
		setLayout(null);
		
//		Table
		String [] header = "Mã khách hàng;Tên khách hàng; Giới tính; Số điện thoại".split(";");
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		table.setBounds(0, 155, 1240, 385);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 135, 1240, 405);
		add(scrollPane);
		
		JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 12)); // Thiết lập kiểu chữ và kích cỡ
        tableHeader.setForeground(Color.BLACK); // Thiết lập màu chữ
        tableHeader.setBackground(new Color(200, 200, 200)); //Màu nền tiêu đề
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Get data from the selected row
                    String maKH = (String) table.getValueAt(selectedRow, 0);
                    String tenKH = (String) table.getValueAt(selectedRow, 1);
                    String soDienThoai = (String) table.getValueAt(selectedRow, 3);

                    // Display data in text fields
                    txtMa.setText(maKH);
                    txtTen.setText(tenKH);
                    txtSDT.setText(soDienThoai);
                    
                }
            }
        });
        
     // Tải dữ liệu từ database
     	loadDataFromDatabase();
     		
//        Thông tin khách hàng
		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(36, 49, 98, 25);
		add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setBounds(144, 52, 150, 20);
		add(txtMa);
		txtMa.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(36, 85, 98, 25);
		add(lblNewLabel_1);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(144, 87, 150, 22);
		add(txtSDT);
		txtSDT.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(333, 49, 86, 25);
		add(lblNewLabel_2);
		
		txtTen = new JTextField();
		txtTen.setBounds(401, 52, 150, 20);
		add(txtTen);
		txtTen.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(333, 85, 69, 25);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(401, 86, 150, 22);
		add(comboBox);
		
//		Tìm khách hàng
		JLabel lblNewLabel_4 = new JLabel("Theo tên:");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(899, 49, 73, 25);
		add(lblNewLabel_4);
		
		txtTheoTen = new JTextField();
		txtTheoTen.setBounds(982, 52, 150, 20);
		add(txtTheoTen);
		txtTheoTen.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Theo mã:");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(899, 85, 73, 25);
		add(lblNewLabel_5);
		
		txtTheoMa = new JTextField();
		txtTheoMa.setBounds(982, 88, 150, 20);
		add(txtTheoMa);
		txtTheoMa.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Thông tin khách hàng");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setBounds(176, 11, 215, 25);
		add(lblNewLabel_6);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String searchName = txtTheoTen.getText().trim();
	            String searchID = txtTheoMa.getText().trim();

	            try {
	                Connection conn = ConnectDB.getConnection();
	                String query = "SELECT * FROM KhachHang WHERE (TenKH LIKE ? OR ? = '') AND (MaKH LIKE ? OR ? = '')";
	                PreparedStatement pstmt = conn.prepareStatement(query);
	                pstmt.setString(1, "%" + searchName + "%");
	                pstmt.setString(2, searchName);
	                pstmt.setString(3, "%" + searchID + "%");
	                pstmt.setString(4, searchID);
	                
	                ResultSet rs = pstmt.executeQuery();

	                // Xóa dữ liệu hiện tại
	                model.setRowCount(0);

	                boolean found = false;
	                // Chỉ hiện dòng kết quả
	                if (rs.next()) {
	                    found = true;
	                    String maKH = rs.getString("MaKH");
	                    String tenKH = rs.getString("TenKH");
	                    String gioiTinh = rs.getString("GioiTinh").equals("0") ? "Nam" : "Nữ";
	                    String soDienThoai = rs.getString("MaKH");
	                    model.addRow(new Object[]{maKH, tenKH, gioiTinh, soDienThoai});
	                }

	                if (!found) {
	                    System.out.println("Không tìm thấy khách hàng.");
	                }

	                rs.close();
	                pstmt.close();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                System.out.println("Lỗi khi tìm kiếm khách hàng.");
	            }
	        }
	    });
		btnTim.setBackground(new Color(255, 255, 128));
		btnTim.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnTim.setBounds(1142, 82, 60, 30);
		add(btnTim);
		
		JLabel lblNewLabel_7 = new JLabel("Tìm khách hàng");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(952, 11, 215, 25);
		add(lblNewLabel_7);
		
		JButton btnThem = new JButton("Thêm khách hàng");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maKH = txtMa.getText();
		        String tenKH = txtTen.getText();
		        String gioiTinh = comboBox.getSelectedItem().equals("Nam") ? "0" : "1";
		        String soDienThoai = txtSDT.getText();

		        if (!maKH.isEmpty() && !tenKH.isEmpty() && !soDienThoai.isEmpty()) {
		            try {
		                Connection conn = ConnectDB.getConnection();
		                String query = "INSERT INTO KhachHang (MaKH, TenKH, GioiTinh) VALUES (?, ?, ?)";
		                PreparedStatement pstmt = conn.prepareStatement(query);
		                pstmt.setString(1, maKH);
		                pstmt.setString(2, tenKH);
		                pstmt.setString(3, gioiTinh);

		                int rowsInserted = pstmt.executeUpdate();
		                if (rowsInserted > 0) {
		                    model.addRow(new Object[] {maKH, tenKH, gioiTinh.equals("0") ? "Nam" : "Nữ", soDienThoai});
		                    System.out.println("Thêm khách hàng thành công.");
		                }

		                // Làm trắng
		                txtMa.setText("");
		                txtTen.setText("");
		                comboBox.setSelectedIndex(0);
		                txtSDT.setText("");

		                pstmt.close();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		                System.out.println("Không thể thêm khách hàng.");
		            }
		        } else {
		            System.out.println("Vui lòng điền đủ thông tin khách hàng.");
		        }
			}
		});
		btnThem.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnThem.setBounds(343, 556, 150, 30);
		add(btnThem);
		
		JButton btnSua = new JButton("Sửa khách hàng");
		btnSua.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                String maKH = txtMa.getText();
	                String tenKH = txtTen.getText();
	                String gioiTinh = comboBox.getSelectedItem().equals("Nam") ? "0" : "1";

	                try {
	                    Connection conn = ConnectDB.getConnection();
	                    String query = "UPDATE KhachHang SET TenKH = ?, GioiTinh = ? WHERE MaKH = ?";
	                    PreparedStatement pstmt = conn.prepareStatement(query);
	                    pstmt.setString(1, tenKH);
	                    pstmt.setString(2, gioiTinh);
	                    pstmt.setString(3, maKH);

	                    int rowsUpdated = pstmt.executeUpdate();
	                    if (rowsUpdated > 0) {
	                        model.setValueAt(maKH, selectedRow, 0);
	                        model.setValueAt(tenKH, selectedRow, 1);
	                        model.setValueAt(gioiTinh.equals("0") ? "Nam" : "Nữ", selectedRow, 2);
	                        System.out.println("Cập nhật khách hàng thành công.");
	                    }

	                    // Làm trắng
	                    txtMa.setText("");
	                    txtTen.setText("");
	                    comboBox.setSelectedIndex(0);
	                    txtSDT.setText("");

	                    pstmt.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    System.out.println("Không thể cập nhật khách hàng.");
	                }
	            } else {
	                System.out.println("Vui lòng chọn khách hàng để sửa.");
	            }
	        }
	    });
		btnSua.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSua.setBounds(524, 556, 150, 30);
		add(btnSua);
		
		JButton btnXoa = new JButton("Xóa khách hàng");
		btnXoa.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            String maKH = (String) model.getValueAt(selectedRow, 0);

		            try {
		                Connection conn = ConnectDB.getConnection();
		                String query = "DELETE FROM KhachHang WHERE MaKH = ?";
		                PreparedStatement pstmt = conn.prepareStatement(query);
		                pstmt.setString(1, maKH);

		                int rowsDeleted = pstmt.executeUpdate();
		                if (rowsDeleted > 0) {
		                    model.removeRow(selectedRow);
		                    System.out.println("Xóa khách hàng thành công.");
		                }

		                // Làm trắng
		                txtMa.setText("");
		                txtTen.setText("");
		                comboBox.setSelectedIndex(0);
		                txtSDT.setText("");

		                pstmt.close();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		                System.out.println("Không thể xóa khách hàng.");
		            }
		        } else {
		            System.out.println("Vui lòng chọn khách hàng để xóa.");
		        }
			}
		});
		btnXoa.setBounds(702, 556, 150, 30);
		add(btnXoa);

	}
	private void loadDataFromDatabase() {
		try {
			Connection conn = ConnectDB.getConnection();
			String query = "SELECT * FROM KhachHang";  // Chọn dữ liệu từ bảng KhachHang
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Xóa dữ liệu cũ trong bảng
			model.setRowCount(0);

			// Duyệt qua từng hàng dữ liệu và thêm vào model của bảng
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String tenKH = rs.getString("TenKH");
				String gioiTinh = rs.getString("GioiTinh").equals("0") ? "Nam" : "Nữ";
				String soDienThoai = rs.getString("MaKH");
				model.addRow(new Object[] { maKH, tenKH, gioiTinh, soDienThoai });
			}

			// Đóng các tài nguyên sau khi hoàn thành
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Không thể tải dữ liệu từ cơ sở dữ liệu.");
		}
	}
	public static void main(String[] args) {
        JFrame frame = new JFrame("GD_phim with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  GD_QuanLyKhachHang());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
