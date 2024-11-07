package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class QLyPhim_view extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLyPhim_view frame = new QLyPhim_view();
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
	
	public QLyPhim_view() {
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		JLabel lblPoster = new JLabel("");
		lblPoster.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPoster.setBounds(51, 26, 250, 300);
		add(lblPoster);
		
		textField = new JTextField();
		textField.setBounds(126, 393, 175, 25);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 358, 175, 25);
		add(textField_1);
		
		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setSize(new Dimension(5, 1));
		table_1.setDropMode(DropMode.INSERT_ROWS);
		table_1.setRowHeight(20);
		table_1.setBounds(398, 26, 642, 256);
		add(table_1);
		
		JLabel lblNewLabel = new JLabel("Tên phim");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(51, 398, 56, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Phim");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(51, 358, 57, 25);
		add(lblNewLabel_1);
		
		JButton btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon(QLyPhim_view.class.getResource("/view/image/IconAdd.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(539, 345, 50, 50);
		add(btnThem);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(QLyPhim_view.class.getResource("/view/image/IconBin.png")));
		btnXoa.setBounds(888, 345, 50, 50);
		add(btnXoa);
		
		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon(QLyPhim_view.class.getResource("/view/image/IconEdit.png")));
		btnSua.setBounds(712, 345, 50, 50);
		add(btnSua);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 428, 164, 25);
		add(textField_2);
		
		JLabel lblThiLng = new JLabel("Thời lượng");
		lblThiLng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThiLng.setBounds(51, 433, 67, 13);
		add(lblThiLng);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(126, 469, 175, 25);
		add(textField_3);
		
		JLabel lbloDin = new JLabel("Đạo diễn");
		lbloDin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbloDin.setBounds(51, 474, 56, 13);
		add(lbloDin);
	}
}