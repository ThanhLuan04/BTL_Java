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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_QuanLyKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public GD_QuanLyKhachHang() {
		setBackground(new Color(225, 214, 196));
		setBounds(new Rectangle(0, 0, 1240, 600));
		setLayout(null);
		
//		Table
		String [] header = "Mã khách hàng;Tên khách hàng; Giới tính; Số điện thoại".split(";");
		DefaultTableModel model = new DefaultTableModel(header, 0);
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
        
//        Thông tin khách hàng
		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(36, 49, 98, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(36, 85, 98, 25);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(144, 52, 150, 20);
		add(textField);
		textField.setColumns(20);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 87, 150, 22);
		add(textField_1);
		textField_1.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(333, 49, 86, 25);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(333, 85, 69, 25);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(401, 52, 150, 20);
		add(textField_2);
		textField_2.setColumns(20);
		
//		Tìm khách hàng
		JLabel lblNewLabel_4 = new JLabel("Theo tên:");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(899, 49, 73, 25);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Theo mã:");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(899, 85, 73, 25);
		add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(982, 52, 150, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(982, 88, 150, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(401, 86, 150, 22);
		add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Thông tin khách hàng");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setBounds(176, 11, 215, 25);
		add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(1142, 82, 60, 30);
		add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Tìm khách hàng");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(952, 11, 215, 25);
		add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Thêm khách hàng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton_1.setBounds(343, 556, 150, 30);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sửa khách hàng");
		btnNewButton_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton_2.setBounds(524, 556, 150, 30);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Xóa khách hàng");
		btnNewButton_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(702, 556, 150, 30);
		add(btnNewButton_3);

	}
	public static void main(String[] args) {
        JFrame frame = new JFrame("GD_phim with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  GD_QuanLyKhachHang());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
