package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.mysql.cj.xdevapi.Statement;

import dao.Phim_Dao;
import entity.Phim;

import java.net.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;

public class GD_phim extends JPanel {
	Phim_Dao phimDao = new Phim_Dao();
	List<Phim> danhsachphim = phimDao.getPhimList();
	Phim[] phim = new Phim[danhsachphim.size()];
	private static final long serialVersionUID = 1L;
	JButton btnMua1,btnMua2,btnMua3,btnMua4,btnMua5,btnMua6,btnMua7,btnMua8;
	private JLabel Label1_2_1,Label1_2_2,Label1_2_3,Label1_1;
	private JLabel Label2_2_1,Label2_2_2,Label2_2_3,Label2_1;
	private JLabel Label3_2_1,Label3_2_2,Label3_2_3,Label3_1;
	private JLabel Label4_2_1,Label4_2_2,Label4_2_3,Label4_1;
	private JLabel Label5_2_1,Label5_2_2,Label5_2_3,Label5_1;
	private JLabel Label6_2_1,Label6_2_2,Label6_2_3,Label6_1;
	private JLabel Label7_2_1,Label7_2_2,Label7_2_3,Label7_1;
	private JLabel Label8_2_1,Label8_2_2,Label8_2_3,Label8_1;
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8;

	public GD_phim(Menu_view menu) {
		
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		for(int i=0; i< danhsachphim.size(); i++) {
			phim[i] = danhsachphim.get(i);
			if(i==0) {
				// panel 1
				panel1 = new JPanel();
				panel1.setBounds(120, 20, 160, 270);
				add(panel1);
				panel1.setLayout(null);
				
				Label1_1 = new JLabel();
				Label1_1.setBackground(new Color(0, 64, 64));
				Label1_1.setBounds(0, 0, 160, 190);
				panel1.add(Label1_1);
				Label1_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label1_2_1 = new JLabel("Tên Phim:"+phim[i].getTenPhim().trim());
				Label1_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label1_2_1.setBounds(0, 190, 160, 20);
				panel1.add(Label1_2_1);
				
				JLabel Label1_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label1_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label1_2_2.setBounds(0, 210, 160, 20);
				panel1.add(Label1_2_2);
				
				Label1_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label1_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label1_2_3.setBounds(0, 230, 160, 20);
				panel1.add(Label1_2_3);
				
				
			}
			else if(i==1) {
				//panel 2
				panel2 = new JPanel();
				panel2.setLayout(null);
				panel2.setBounds(400, 20, 160, 270);
				add(panel2);
				
				Label2_1 = new JLabel();
				Label2_1.setBackground(new Color(0, 64, 64));
				Label2_1.setBounds(0, 0, 160, 190);
				panel2.add(Label2_1);
				Label2_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label2_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label2_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label2_2_1.setBounds(0, 190, 160, 20);
				panel2.add(Label2_2_1);
				
				JLabel Label2_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label2_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label2_2_2.setBounds(0, 210, 160, 20);
				panel2.add(Label2_2_2);
				
				Label2_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label2_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label2_2_3.setBounds(0, 230, 160, 20);
				panel2.add(Label2_2_3);
				
			
				
			}
			else if(i==2) {
				//panel 3
				panel3 = new JPanel();
				panel3.setLayout(null);
				panel3.setBounds(680, 20, 160, 270);
				add(panel3);
				
				Label3_1 = new JLabel();
				Label3_1.setBackground(new Color(0, 64, 64));
				Label3_1.setBounds(0, 0, 160, 190);
				panel3.add(Label3_1);
				Label3_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				
				Label3_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label3_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label3_2_1.setBounds(0, 190, 160, 20);
				panel3.add(Label3_2_1);
				
				Label3_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label3_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label3_2_2.setBounds(0, 210, 160, 20);
				panel3.add(Label3_2_2);
				
				Label3_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label3_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label3_2_3.setBounds(0, 230, 160, 20);
				panel3.add(Label3_2_3);
				
				
				
			}
			else if(i==3) {
				//panel 4
				panel4 = new JPanel();
				panel4.setLayout(null);
				panel4.setBounds(960, 20, 160, 270);
				add(panel4);
				
				Label4_1 = new JLabel();
				Label4_1.setBackground(new Color(0, 64, 64));
				Label4_1.setBounds(0, 0, 160, 190);
				panel4.add(Label4_1);
				Label4_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label4_2_1 = new JLabel("Tên Phim" + phim[i].getTenPhim().trim());
				Label4_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label4_2_1.setBounds(0, 190, 160, 20);
				panel4.add(Label4_2_1);
				
				Label4_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label4_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label4_2_2.setBounds(0, 210, 160, 20);
				panel4.add(Label4_2_2);
				
				Label4_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label4_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label4_2_3.setBounds(0, 230, 160, 20);
				panel4.add(Label4_2_3);
				
			
			}
			else if(i==4) {
				//panel 5
				panel5 = new JPanel();
				panel5.setLayout(null);
				panel5.setBounds(120, 320, 160, 270);
				add(panel5);
				
				Label5_1 = new JLabel();
				Label5_1.setBackground(new Color(0, 64, 64));
				Label5_1.setBounds(0, 0, 160, 190);
				panel5.add(Label5_1);
				Label5_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label5_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label5_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label5_2_1.setBounds(0, 190, 160, 20);
				panel5.add(Label5_2_1);
				
				Label5_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label5_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label5_2_2.setBounds(0, 210, 160, 20);
				panel5.add(Label5_2_2);
				
				Label5_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label5_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label5_2_3.setBounds(0, 230, 160, 20);
				panel5.add(Label5_2_3);
				
				
				
			}
			else if(i==5) {
				//panel 6
				panel6 = new JPanel();
				panel6.setLayout(null);
				panel6.setBounds(400, 320, 160, 270);
				add(panel6);
				
				Label6_1 = new JLabel();
				Label6_1.setBackground(new Color(0, 64, 64));
				Label6_1.setBounds(0, 0, 160, 190);
				panel6.add(Label6_1);
				Label6_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label6_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label6_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label6_2_1.setBounds(0, 190, 160, 20);
				panel6.add(Label6_2_1);
				
				Label6_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label6_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label6_2_2.setBounds(0, 210, 160, 20);
				panel6.add(Label6_2_2);
				
				Label6_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label6_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label6_2_3.setBounds(0, 230, 160, 20);
				panel6.add(Label6_2_3);
				
				
			}
			else if(i==6) {
				//panel 7
				panel7 = new JPanel();
				panel7.setLayout(null);
				panel7.setBounds(680, 320, 160, 270);
				add(panel7);
				
				Label7_1 = new JLabel();
				Label7_1.setBackground(new Color(0, 64, 64));
				Label7_1.setBounds(0, 0, 160, 190);
				panel7.add(Label7_1);
				Label7_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label7_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label7_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label7_2_1.setBounds(0, 190, 160, 20);
				panel7.add(Label7_2_1);
				
				Label7_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label7_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label7_2_2.setBounds(0, 210, 160, 20);
				panel7.add(Label7_2_2);
				
				Label7_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label7_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label7_2_3.setBounds(0, 230, 160, 20);
				panel7.add(Label7_2_3);
				
				
			}
			else if(i==7) {
				//panel 8
				panel8 = new JPanel();
				panel8.setLayout(null);
				panel8.setBounds(960, 320, 160, 270);
				add(panel8);
				
				Label8_1 = new JLabel();
				Label8_1.setBackground(new Color(0, 64, 64));
				Label8_1.setBounds(0, 0, 160, 190);
				panel8.add(Label8_1);
				Label8_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label8_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label8_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label8_2_1.setBounds(0, 190, 160, 20);
				panel8.add(Label8_2_1);
				
				Label8_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong());
				Label8_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label8_2_2.setBounds(0, 210, 160, 20);
				panel8.add(Label8_2_2);
				
				Label8_2_3 = new JLabel("Giá vé:" + phim[i].getGiave());
				Label8_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label8_2_3.setBounds(0, 230, 160, 20);
				panel8.add(Label8_2_3);
				
			}
		}
			btnMua1 = new JButton("Mua");
			btnMua1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua1.setBounds(45, 250, 70, 20);
			btnMua1.setBackground(new Color(138, 63, 63));
			panel1.add(btnMua1);
			
			btnMua2 = new JButton("Mua");
			btnMua2.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua2.setBackground(new Color(138, 63, 63));
			btnMua2.setBounds(45, 250, 70, 20);
			panel2.add(btnMua2);
			
			btnMua3 = new JButton("Mua");
			btnMua3.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua3.setBackground(new Color(138, 63, 63));
			btnMua3.setBounds(45, 250, 70, 20);
			panel3.add(btnMua3);
			
			btnMua4 = new JButton("Mua");
			btnMua4.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua4.setBackground(new Color(138, 63, 63));
			btnMua4.setBounds(45, 250, 70, 20);
			panel4.add(btnMua4);
			
			btnMua5 = new JButton("Mua");
			btnMua5.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua5.setBackground(new Color(138, 63, 63));
			btnMua5.setBounds(45, 250, 70, 20);
			panel5.add(btnMua5);
			
			btnMua6 = new JButton("Mua");
			btnMua6.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua6.setBackground(new Color(138, 63, 63));
			btnMua6.setBounds(45, 250, 70, 20);
			panel6.add(btnMua6);
			
			btnMua7 = new JButton("Mua");
			btnMua7.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua7.setBackground(new Color(138, 63, 63));
			btnMua7.setBounds(45, 250, 70, 20);
			panel7.add(btnMua7);
			
			btnMua8 = new JButton("Mua");
			btnMua8.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
			btnMua8.setBackground(new Color(138, 63, 63));
			btnMua8.setBounds(45, 250, 70, 20);
			panel8.add(btnMua8);
			
			//khởi tạo chuyển trang cho các nút button
			JButton[] buttons = {btnMua1,btnMua2,btnMua3,btnMua4,btnMua5,btnMua6,btnMua7,btnMua8};
			for(int k = 0; k< buttons.length; k++) {
				buttons[k].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						menu.chaneToGD_ve();
					}
				});
			}

	}

}

