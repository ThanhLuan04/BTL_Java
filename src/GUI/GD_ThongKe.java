package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;

public class GD_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtTongDon;
	private JTextField txtTongTien;

	/**
	 * Create the panel.
	 */
	public GD_ThongKe() {
		setBackground(new Color(225, 214, 196));
		setBounds(new Rectangle(0, 0, 1240, 600));
		setLayout(null);
		
		String [] header = "Mã hóa đơn;Tên khách hàng; Ngày lập; Tổng tiền".split(";");
		DefaultTableModel model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		table.setBounds(0, 81, 1240, 437);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 83, 1240, 455);
		add(scrollPane);
		
		JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 12)); // Thiết lập kiểu chữ và kích cỡ
        tableHeader.setForeground(Color.BLACK); // Thiết lập màu chữ
        tableHeader.setBackground(new Color(200, 200, 200)); //Màu nền tiêu đề
        
        loadDataFromDatabase();
		
		JLabel lblNewLabel = new JLabel("Thống kê doanh thu");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(496, 22, 316, 40);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Tổng đơn hàng:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(694, 563, 105, 25);
		add(lblNewLabel_1);
		
		txtTongDon = new JTextField();
		txtTongDon.setEditable(false);
		txtTongDon.setBounds(809, 564, 100, 25);
		add(txtTongDon);
		txtTongDon.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng tiền:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(943, 563, 75, 25);
		add(lblNewLabel_2);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(1015, 564, 147, 25);
		add(txtTongTien);
		txtTongTien.setColumns(10);

		// Radio Buttons
        JRadioButton rbtnTang = new JRadioButton("Sắp xếp tăng dần theo mã hóa đơn");
        rbtnTang.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        rbtnTang.setBackground(new Color(225, 214, 196));
        rbtnTang.setBounds(940, 10, 250, 30);
        add(rbtnTang);
        
        rbtnTang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadDataSorted(true); // Gọi hàm để sắp xếp tăng dần
            }
        });
        
        JRadioButton rbtnGiam = new JRadioButton("Sắp xếp giảm dần theo mã hóa đơn");
        rbtnGiam.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        rbtnGiam.setBackground(new Color(225, 214, 196));
        rbtnGiam.setBounds(940, 45, 250, 30);
        add(rbtnGiam);
        
        rbtnGiam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadDataSorted(false); // Gọi hàm để sắp xếp giảm dần
            }
        });
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnTang);
        group.add(rbtnGiam);
        
        loadDataFromDatabase();
        updateSummary();
        
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
         // Cập nhật tổng đơn hàng và tổng tiền
            updateSummary();
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
	        
	     // Cập nhật tổng đơn hàng và tổng tiền
	        updateSummary();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	private void updateSummary() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    int totalOrders = model.getRowCount(); // Tổng số dòng trong bảng
	    double totalAmount = 0;

	    // Tính tổng tiền từ cột "Tổng tiền"
	    for (int i = 0; i < totalOrders; i++) {
	        double tongTien = (double) model.getValueAt(i, 3); // Cột thứ 3 (Tổng tiền)
	        totalAmount += tongTien;
	    }

	    // Cập nhật vào các trường
	    txtTongDon.setText(String.valueOf(totalOrders)); // Hiển thị tổng đơn hàng
	    txtTongTien.setText(String.format("%.2f", totalAmount)); // Hiển thị tổng tiền với 2 chữ số thập phân
	}
	public void refreshData() {
	    // Xóa lựa chọn radio button
	    ButtonGroup group = new ButtonGroup();
	    group.clearSelection();

	    // Tải lại dữ liệu từ cơ sở dữ liệu
	    loadDataFromDatabase();

	    // Làm mới giao diện
	    this.revalidate();
	    this.repaint();
	}
	
	
//	public static void main(String[] args) {
//        JFrame frame = new JFrame("GD_phim with Images");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new  GD_ThongKe());
//        frame.setSize(1240, 650);
//        frame.setVisible(true);
//    }
}
