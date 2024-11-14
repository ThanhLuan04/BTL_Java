package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GD_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblNewLabel = new JLabel("Thống kê doanh thu");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(496, 22, 316, 40);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Tổng đơn hàng:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(694, 563, 105, 25);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(809, 564, 100, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng tiền:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(943, 563, 75, 25);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(1015, 564, 147, 25);
		add(textField_1);
		textField_1.setColumns(10);

	}

}
