package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GD_QuanLyKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GD_QuanLyKhachHang frame = new GD_QuanLyKhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public GD_QuanLyKhachHang() {
//		setTitle("Quản lý khách hàng");
		
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1240, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

//		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(225, 214, 196));
		panel_1.setBounds(0, 0, 1224, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		String [] header = "Mã khách hàng;Tên khách hàng; Giới tính; Số điện thoại".split(";");
		DefaultTableModel model = new DefaultTableModel(header, 0);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", " Gi\u1EDBi t\u00EDnh", " S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
			}
		));
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		table.setBounds(0, 134, 1420, 500);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 131, 1225, 364);
		panel_1.add(scrollpane);
		
		JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 12)); // Thiết lập kiểu chữ và kích cỡ
        tableHeader.setForeground(Color.BLACK); // Thiết lập màu chữ
        tableHeader.setBackground(new Color(200, 200, 200)); //Màu nền tiêu đề
		
		JButton btnNewButton_6 = new JButton("Thêm khách hàng");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNewButton_6.setBounds(351, 506, 150, 30);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Xóa khách hàng");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNewButton_7.setBounds(671, 506, 150, 30);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Sửa khách hàng");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNewButton_8.setBounds(511, 506, 150, 30);
		panel_1.add(btnNewButton_8);
	
//		Thông tin khách hàng
		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(37, 42, 98, 25);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 45, 150, 20);
		panel_1.add(textField);
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 78, 98, 25);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 81, 150, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(326, 42, 74, 25);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(398, 45, 150, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(20);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		comboBox.setBounds(398, 79, 150, 22);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(326, 78, 80, 25);
		panel_1.add(lblNewLabel_3);
		
//		Tìm kiếm khách hang
		JLabel lblNewLabel_4 = new JLabel("Theo tên:");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(898, 42, 68, 25);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Theo mã:");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(898, 78, 68, 25);
		panel_1.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(976, 45, 150, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(976, 81, 150, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(1136, 75, 60, 30);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Thông tin khách hàng");
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(152, 11, 228, 25);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tìm khách hàng");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(930, 11, 174, 25);
		panel_1.add(lblNewLabel_7);
	}
	public static void main(String[] args) {
        JFrame frame = new JFrame("GD_phim with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GD_QuanLyKhachHang());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
