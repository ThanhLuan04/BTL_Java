package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_QuanLyHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_QuanLyHoaDon frame = new GD_QuanLyHoaDon();
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
	public GD_QuanLyHoaDon() {
		setTitle("Quản lý hóa đơn");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 214, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(225, 214, 196));
		panel.setBounds(0, 0, 1224, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String [] header = "Mã hóa đơn; Tên khách hàng; Ngày lập; Tổng tiền".split(";");
		DefaultTableModel model = new DefaultTableModel(header, 0);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", " T\u00EAn kh\u00E1ch h\u00E0ng", " Ng\u00E0y l\u1EADp", " T\u1ED5ng ti\u1EC1n"
			}
		));
		table.setBounds(0, 148, 1224, 413);
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 131, 1225, 430);
		panel.add(scrollpane);
		
		JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 12)); // Thiết lập kiểu chữ và kích cỡ
        tableHeader.setForeground(Color.BLACK); // Thiết lập màu chữ
        tableHeader.setBackground(new Color(200, 200, 200)); //Màu nền tiêu đề
		
		JLabel lblNewLabel = new JLabel("Theo mã hóa đơn:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 57, 117, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Theo tên khách hàng:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 95, 150, 25);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(176, 60, 185, 20);
		panel.add(textField);
		textField.setColumns(20);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 98, 185, 20);
		panel.add(textField_1);
		textField_1.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm hóa đơn");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(140, 21, 150, 25);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(375, 75, 78, 31);
		panel.add(btnNewButton);
	}
}
