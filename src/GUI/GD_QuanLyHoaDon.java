package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class GD_QuanLyHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtTheoMa;
	private JTextField txtTheoTen;

	/**
	 * Create the panel.
	 */
	public GD_QuanLyHoaDon() {
		setBounds(new Rectangle(0, 0, 1240, 600));
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
//		Table
		String [] header = "Mã hóa đơn;Tên khách hàng; Ngày lập; Tổng tiền".split(";");
		DefaultTableModel model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		table.setBounds(0, 134, 1240, 466);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 135, 1240, 465);
		add(scrollPane);
		
		JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 12)); // Thiết lập kiểu chữ và kích cỡ
        tableHeader.setForeground(Color.BLACK); // Thiết lập màu chữ
        tableHeader.setBackground(new Color(200, 200, 200)); //Màu nền tiêu đề
		
        loadDataFromDatabase();
//		Tìm hóa đơn
		JLabel lblNewLabel = new JLabel("Tìm hóa đơn");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(127, 11, 137, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Theo mã hóa đơn:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(43, 60, 130, 25);
		add(lblNewLabel_1);
		
		txtTheoMa = new JTextField();
		txtTheoMa.setBounds(183, 63, 185, 20);
		add(txtTheoMa);
		txtTheoMa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Theo tên khách hàng:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(43, 96, 130, 25);
		add(lblNewLabel_2);
		
		txtTheoTen = new JTextField();
		txtTheoTen.setBounds(183, 99, 185, 20);
		add(txtTheoTen);
		txtTheoTen.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(255, 255, 128));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maHoaDon = txtTheoMa.getText().trim();
			    String tenKhachHang = txtTheoTen.getText().trim();
			        
		        // Câu truy vấn cơ bản
		        String query = "SELECT hd.MaHD, kh.TenKH, hd.NgayTao, hd.TongTien " +
		                       "FROM HoaDon hd " +
		                       "JOIN KhachHang kh ON hd.MaKH = kh.MaKH WHERE 1=1";

		        // Thêm điều kiện tìm kiếm nếu có dữ liệu nhập
		        if (!maHoaDon.isEmpty()) {
		            query += " AND hd.MaHD LIKE ?";
		        }
		        if (!tenKhachHang.isEmpty()) {
		            query += " AND kh.TenKH LIKE ?";
		        }

		        try (Connection conn = ConnectDB.getConnection();
		             PreparedStatement ps = conn.prepareStatement(query)) {

		            int paramIndex = 1;

		            // Gán tham số vào câu truy vấn
		            if (!maHoaDon.isEmpty()) {
		                ps.setString(paramIndex++, "%" + maHoaDon + "%");
		            }
		            if (!tenKhachHang.isEmpty()) {
		                ps.setString(paramIndex++, "%" + tenKhachHang + "%");
		            }

		            // Thực thi truy vấn
		            try (ResultSet rs = ps.executeQuery()) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

		                // Duyệt qua kết quả trả về và thêm vào bảng
		                while (rs.next()) {
		                    String maHD = rs.getString("MaHD");
		                    String tenKH = rs.getString("TenKH");
		                    String ngayLap = rs.getString("NgayTao");
		                    double tongTien = rs.getDouble("TongTien");

		                    model.addRow(new Object[]{maHD, tenKH, ngayLap, tongTien});
		                }
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnTim.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnTim.setBounds(396, 93, 60, 30);
		add(btnTim);

        // Radio Buttons
        JRadioButton rbtnTang = new JRadioButton("Sắp xếp tăng dần theo mã hóa đơn");
        rbtnTang.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        rbtnTang.setBackground(new Color(225, 214, 196));
        rbtnTang.setBounds(940, 50, 250, 50);
        add(rbtnTang);
        
        rbtnTang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadDataSorted(true); // Gọi hàm để sắp xếp tăng dần
            }
        });
        
        JRadioButton rbtnGiam = new JRadioButton("Sắp xếp giảm dần theo mã hóa đơn");
        rbtnGiam.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        rbtnGiam.setBackground(new Color(225, 214, 196));
        rbtnGiam.setBounds(940, 85, 250, 50);
        add(rbtnGiam);
        
        rbtnGiam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadDataSorted(false); // Gọi hàm để sắp xếp giảm dần
            }
        });
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnTang);
        group.add(rbtnGiam);


	}
	
	 private void loadDataFromDatabase() {
	        String query = "SELECT hd.MaHD, kh.TenKH, hd.NgayTao, hd.TongTien "
	        				+ "FROM HoaDon hd "
	        				+ "JOIN KhachHang kh ON hd.MaKH = kh.MaKH";

	        try (Connection conn = ConnectDB.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {

	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0);

	            while (rs.next()) {
	                String maHoaDon = rs.getString("MaHD");
	                String tenKhachHang = rs.getString("TenKH");
	                String ngayLap = rs.getString("NgayTao");
	                double tongTien = rs.getDouble("TongTien");

	                model.addRow(new Object[]{maHoaDon, tenKhachHang, ngayLap, tongTien});
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	 private void loadDataSorted(boolean ascending) {
		    // Câu truy vấn với điều kiện ORDER BY
		    String query = "SELECT hd.MaHD, kh.TenKH, hd.NgayTao, hd.TongTien " +
		                   "FROM HoaDon hd " +
		                   "JOIN KhachHang kh ON hd.MaKH = kh.MaKH " +
		                   "ORDER BY hd.MaHD " + (ascending ? "ASC" : "DESC");

		    try (Connection conn = ConnectDB.getConnection();
		         PreparedStatement ps = conn.prepareStatement(query);
		         ResultSet rs = ps.executeQuery()) {

		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

		        while (rs.next()) {
		            String maHoaDon = rs.getString("MaHD");
		            String tenKhachHang = rs.getString("TenKH");
		            String ngayLap = rs.getString("NgayTao");
		            double tongTien = rs.getDouble("TongTien");

		            model.addRow(new Object[]{maHoaDon, tenKhachHang, ngayLap, tongTien});
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
	 
	public static void main(String[] args) {
        JFrame frame = new JFrame("GD_phim with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  GD_QuanLyHoaDon());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
