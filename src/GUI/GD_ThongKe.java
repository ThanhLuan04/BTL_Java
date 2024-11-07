package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GD_ThongKe extends JFrame {

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
					GD_ThongKe frame = new GD_ThongKe();
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
	public GD_ThongKe() {
		
		setTitle("Thống kê doanh thu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(225, 214, 196));
		panel.setBounds(0, 0, 1224, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống kê doanh thu");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(473, 0, 390, 45);
		panel.add(lblNewLabel);
		
		String [] header = "Mã hóa đơn; Tên khách hàng; Ngày lập; Tổng tiền".split(";");
		DefaultTableModel model = new DefaultTableModel(header, 0);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", " T\u00EAn kh\u00E1ch h\u00E0ng", " Ng\u00E0y l\u1EADp", " T\u1ED5ng ti\u1EC1n"
			}
		));
		table.setBounds(0, 173, 1224, 307);
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 56, 1225, 445);
		panel.add(scrollpane);
		
		JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 12)); // Thiết lập kiểu chữ và kích cỡ
        tableHeader.setForeground(Color.BLACK); // Thiết lập màu chữ
        tableHeader.setBackground(new Color(200, 200, 200)); //Màu nền tiêu đề
		
		JLabel lblNewLabel_1 = new JLabel("Tổng đơn hàng:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(598, 512, 113, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng tiền:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(873, 512, 72, 25);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(721, 513, 100, 25);
		panel.add(textField);
		textField.setColumns(20);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(955, 513, 169, 25);
		panel.add(textField_1);
		textField_1.setColumns(20);
	}

}
