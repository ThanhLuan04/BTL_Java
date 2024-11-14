package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_QuanLyHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblNewLabel_2 = new JLabel("Theo tên khách hàng:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(43, 96, 130, 25);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(183, 63, 185, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 99, 185, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(396, 93, 60, 30);
		add(btnNewButton);

	}
	public static void main(String[] args) {
        JFrame frame = new JFrame("GD_phim with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  GD_QuanLyHoaDon());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
