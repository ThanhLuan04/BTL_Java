package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.net.*;
import javax.swing.JLabel;
import java.awt.Font;

public class GD_phim extends JPanel {

	private static final long serialVersionUID = 1L;

	public GD_phim() {
		
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		
		// panel 1
		JPanel panel1 = new JPanel();
		panel1.setBounds(120, 20, 160, 270);
		add(panel1);
		panel1.setLayout(null);
		
		JLabel Label1_1 = new JLabel();
		Label1_1.setBackground(new Color(0, 64, 64));
		Label1_1.setBounds(0, 0, 160, 190);
		panel1.add(Label1_1);
		Label1_1.setIcon(new ImageIcon("Image\\phim1.jpg"));
		
		JLabel Label1_2_1 = new JLabel("Tên Phim: Mai");
		Label1_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label1_2_1.setBounds(0, 190, 160, 20);
		panel1.add(Label1_2_1);
		
		JLabel Label1_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label1_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label1_2_2.setBounds(0, 210, 160, 20);
		panel1.add(Label1_2_2);
		
		JLabel Label1_2_3 = new JLabel("Giá vé: 90.000");
		Label1_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label1_2_3.setBounds(0, 230, 160, 20);
		panel1.add(Label1_2_3);
		
		JButton btnMua1 = new JButton("Mua");
		btnMua1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua1.setBounds(45, 250, 70, 20);
		btnMua1.setBackground(new Color(138, 63, 63));
		GD_ve ve = new GD_ve();
//		btnMua1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				CardLayout.show(panel)
//			}
//		});
		
		panel1.add(btnMua1);
		
		//panel 2
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(400, 20, 160, 270);
		add(panel2);
		
		JLabel Label2_1 = new JLabel();
		Label2_1.setBackground(new Color(0, 64, 64));
		Label2_1.setBounds(0, 0, 160, 190);
		panel2.add(Label2_1);
		Label2_1.setIcon(new ImageIcon("Image\\phim2.jpg"));
		
		JLabel Label2_2_1 = new JLabel("Tên Phim: Lật Mặt 7");
		Label2_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label2_2_1.setBounds(0, 190, 160, 20);
		panel2.add(Label2_2_1);
		
		JLabel Label2_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label2_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label2_2_2.setBounds(0, 210, 160, 20);
		panel2.add(Label2_2_2);
		
		JLabel Label2_2_3 = new JLabel("Giá vé: 90.000");
		Label2_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label2_2_3.setBounds(0, 230, 160, 20);
		panel2.add(Label2_2_3);
		
		JButton btnMua2 = new JButton("Mua");
		btnMua2.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua2.setBackground(new Color(138, 63, 63));
		btnMua2.setBounds(45, 250, 70, 20);
		panel2.add(btnMua2);
		
		//panel 3
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(680, 20, 160, 270);
		add(panel3);
		
		JLabel Label3_1 = new JLabel();
		Label3_1.setBackground(new Color(0, 64, 64));
		Label3_1.setBounds(0, 0, 160, 190);
		panel3.add(Label3_1);
		Label3_1.setIcon(new ImageIcon("Image\\phim3.jpg"));
		
		
		JLabel Label3_2_1 = new JLabel("Tên Phim: Hai Muối");
		Label3_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label3_2_1.setBounds(0, 190, 160, 20);
		panel3.add(Label3_2_1);
		
		JLabel Label3_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label3_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label3_2_2.setBounds(0, 210, 160, 20);
		panel3.add(Label3_2_2);
		
		JLabel Label3_2_3 = new JLabel("Giá vé: 90.000");
		Label3_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label3_2_3.setBounds(0, 230, 160, 20);
		panel3.add(Label3_2_3);
		
		JButton btnMua3 = new JButton("Mua");
		btnMua3.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua3.setBackground(new Color(138, 63, 63));
		btnMua3.setBounds(45, 250, 70, 20);
		panel3.add(btnMua3);
		
		//panel 4
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(960, 20, 160, 270);
		add(panel4);
		
		JLabel Label4_1 = new JLabel();
		Label4_1.setBackground(new Color(0, 64, 64));
		Label4_1.setBounds(0, 0, 160, 190);
		panel4.add(Label4_1);
		Label4_1.setIcon(new ImageIcon("Image\\phim4.jpg"));
		
		JLabel Label4_2_1 = new JLabel("Tên Phim: Gặp Lại Chị Bầu");
		Label4_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label4_2_1.setBounds(0, 190, 160, 20);
		panel4.add(Label4_2_1);
		
		JLabel Label4_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label4_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label4_2_2.setBounds(0, 210, 160, 20);
		panel4.add(Label4_2_2);
		
		JLabel Label4_2_3 = new JLabel("Giá vé: 90.000");
		Label4_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label4_2_3.setBounds(0, 230, 160, 20);
		panel4.add(Label4_2_3);
		
		JButton btnMua4 = new JButton("Mua");
		btnMua4.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua4.setBackground(new Color(138, 63, 63));
		btnMua4.setBounds(45, 250, 70, 20);
		panel4.add(btnMua4);
		
		//panel 5
		JPanel panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBounds(120, 320, 160, 270);
		add(panel5);
		
		JLabel Label5_1 = new JLabel();
		Label5_1.setBackground(new Color(0, 64, 64));
		Label5_1.setBounds(0, 0, 160, 190);
		panel5.add(Label5_1);
		Label5_1.setIcon(new ImageIcon("Image\\phim5.png"));
		
		JLabel Label5_2_1 = new JLabel("Tên Phim: Kẻ Ăn Hồn");
		Label5_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label5_2_1.setBounds(0, 190, 160, 20);
		panel5.add(Label5_2_1);
		
		JLabel Label5_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label5_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label5_2_2.setBounds(0, 210, 160, 20);
		panel5.add(Label5_2_2);
		
		JLabel Label5_2_3 = new JLabel("Giá vé: 90.000");
		Label5_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label5_2_3.setBounds(0, 230, 160, 20);
		panel5.add(Label5_2_3);
		
		JButton btnMua5 = new JButton("Mua");
		btnMua5.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua5.setBackground(new Color(138, 63, 63));
		btnMua5.setBounds(45, 250, 70, 20);
		panel5.add(btnMua5);
		
		//panel 6
		JPanel panel6 = new JPanel();
		panel6.setLayout(null);
		panel6.setBounds(400, 320, 160, 270);
		add(panel6);
		
		JLabel Label6_1 = new JLabel();
		Label6_1.setBackground(new Color(0, 64, 64));
		Label6_1.setBounds(0, 0, 160, 190);
		panel6.add(Label6_1);
		Label6_1.setIcon(new ImageIcon("Image\\phim6.png"));
		
		JLabel Label6_2_1 = new JLabel("Tên Phim: Vonka");
		Label6_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label6_2_1.setBounds(0, 190, 160, 20);
		panel6.add(Label6_2_1);
		
		JLabel Label6_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label6_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label6_2_2.setBounds(0, 210, 160, 20);
		panel6.add(Label6_2_2);
		
		JLabel Label6_2_3 = new JLabel("Giá vé: 90.000");
		Label6_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label6_2_3.setBounds(0, 230, 160, 20);
		panel6.add(Label6_2_3);
		
		JButton btnMua6 = new JButton("Mua");
		btnMua6.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua6.setBackground(new Color(138, 63, 63));
		btnMua6.setBounds(45, 250, 70, 20);
		panel6.add(btnMua6);
		
		//panel 7
		JPanel panel7 = new JPanel();
		panel7.setLayout(null);
		panel7.setBounds(680, 320, 160, 270);
		add(panel7);
		
		JLabel Label7_1 = new JLabel();
		Label7_1.setBackground(new Color(0, 64, 64));
		Label7_1.setBounds(0, 0, 160, 190);
		panel7.add(Label7_1);
		Label7_1.setIcon(new ImageIcon("Image\\phim7.jpg"));
		
		JLabel Label7_2_1 = new JLabel("Tên Phim: Mai");
		Label7_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label7_2_1.setBounds(0, 190, 160, 20);
		panel7.add(Label7_2_1);
		
		JLabel Label7_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label7_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label7_2_2.setBounds(0, 210, 160, 20);
		panel7.add(Label7_2_2);
		
		JLabel Label7_2_3 = new JLabel("Giá vé: 90.000");
		Label7_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label7_2_3.setBounds(0, 230, 160, 20);
		panel7.add(Label7_2_3);
		
		JButton btnMua7 = new JButton("Mua");
		btnMua7.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua7.setBackground(new Color(138, 63, 63));
		btnMua7.setBounds(45, 250, 70, 20);
		panel7.add(btnMua7);
		
		//panel 8
		JPanel panel8 = new JPanel();
		panel8.setLayout(null);
		panel8.setBounds(960, 320, 160, 270);
		add(panel8);
		
		JLabel Label8_1 = new JLabel();
		Label8_1.setBackground(new Color(0, 64, 64));
		Label8_1.setBounds(0, 0, 160, 190);
		panel8.add(Label8_1);
		Label8_1.setIcon(new ImageIcon("Image\\phim8.jpg"));
		
		JLabel Label8_2_1 = new JLabel("Tên Phim: Liên Minh Thú Cưng");
		Label8_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label8_2_1.setBounds(0, 190, 160, 20);
		panel8.add(Label8_2_1);
		
		JLabel Label8_2_2 = new JLabel("Thời Lượng: 90 phút");
		Label8_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label8_2_2.setBounds(0, 210, 160, 20);
		panel8.add(Label8_2_2);
		
		JLabel Label8_2_3 = new JLabel("Giá vé: 90.000");
		Label8_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		Label8_2_3.setBounds(0, 230, 160, 20);
		panel8.add(Label8_2_3);
		
		JButton btnMua8 = new JButton("Mua");
		btnMua8.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnMua8.setBackground(new Color(138, 63, 63));
		btnMua8.setBounds(45, 250, 70, 20);
		panel8.add(btnMua8);
	}
	public static void main(String[] args) {
        JFrame frame = new JFrame("GD_phim with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GD_phim());
        frame.setSize(1240, 650);
        frame.setVisible(true);
    }
}
