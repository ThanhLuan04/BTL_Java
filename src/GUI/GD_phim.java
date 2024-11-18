package GUI;

//import DuLieuTam.ThongTinVe_Tam;
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
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
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
	private String MaPhimDC;
//	GD_Menu menu = new GD_Menu();
//	private ThongTinVe_Tam tam = new ThongTinVe_Tam();

	public GD_phim(GD_Menu menu) {
		
		setSize(1240,600);
		setBackground(new Color(225, 214, 196));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(this);
		scrollPane.setBounds(0, 0, 1240, 600);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Tăng tốc độ cuộn
		menu.add(scrollPane);

		// panel 1
		panel1 = new JPanel();
		panel1.setBounds(120, 20, 160, 270);
		add(panel1);
		panel1.setLayout(null);
		//panel 2
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(400, 20, 160, 270);
		add(panel2);
		//panel 3
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(680, 20, 160, 270);
		add(panel3);
		//panel 4
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(960, 20, 160, 270);
		add(panel4);
		//panel 5
		panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBounds(120, 320, 160, 270);
		add(panel5);
		//panel 6
		panel6 = new JPanel();
		panel6.setLayout(null);
		panel6.setBounds(400, 320, 160, 270);
		add(panel6);
		//panel 7
		panel7 = new JPanel();
		panel7.setLayout(null);
		panel7.setBounds(680, 320, 160, 270);
		add(panel7);
		//panel 8
		panel8 = new JPanel();
		panel8.setLayout(null);
		panel8.setBounds(960, 320, 160, 270);
		add(panel8);
		
		for(int i=0; i< danhsachphim.size(); i++) {
			phim[i] = danhsachphim.get(i);
			if(i==0 && phim[i]!=null) {
				Label1_1 = new JLabel();
				Label1_1.setBackground(new Color(0, 64, 64));
				Label1_1.setBounds(0, 0, 160, 190);
				panel1.add(Label1_1);
				ImageIcon originalIcon = new ImageIcon(phim[i].getDuongdan().trim());
				Image img = originalIcon.getImage().getScaledInstance(Label1_1.getWidth(), Label1_1.getHeight(), Image.SCALE_SMOOTH);
				Label1_1.setIcon(new ImageIcon(img));
				Label1_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label1_2_1 = new JLabel("Tên Phim:"+phim[i].getTenPhim().trim());
				Label1_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label1_2_1.setBounds(0, 190, 160, 20);
				panel1.add(Label1_2_1);
				
				JLabel Label1_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong() + " phút");
				Label1_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label1_2_2.setBounds(0, 210, 160, 20);
				panel1.add(Label1_2_2);
				
				Label1_2_3 = new JLabel("Giá vé:" + phim[i].getGiave() + " VND");
				Label1_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label1_2_3.setBounds(0, 230, 160, 20);
				panel1.add(Label1_2_3);
				
				btnMua1 = new JButton("Mua");
				btnMua1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua1.setBounds(45, 250, 70, 20);
				btnMua1.setBackground(new Color(138, 63, 63));
				panel1.add(btnMua1);
				btnMua1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[0].getMaPhim();
						menu.chaneToGD_ChonGhe();
					}
				});
			}
			else if(i==1 && phim[i]!=null) {
				Label2_1 = new JLabel();
				Label2_1.setBackground(new Color(0, 64, 64));
				Label2_1.setBounds(0, 0, 160, 190);
				panel2.add(Label2_1);
				Label2_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label2_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label2_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label2_2_1.setBounds(0, 190, 160, 20);
				panel2.add(Label2_2_1);
				
				JLabel Label2_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label2_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label2_2_2.setBounds(0, 210, 160, 20);
				panel2.add(Label2_2_2);
				
				Label2_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label2_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label2_2_3.setBounds(0, 230, 160, 20);
				panel2.add(Label2_2_3);
				
				btnMua2 = new JButton("Mua");
				btnMua2.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua2.setBackground(new Color(138, 63, 63));
				btnMua2.setBounds(45, 250, 70, 20);
				panel2.add(btnMua2);
				btnMua2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[1].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
			}
			else if(i==2 && phim[i]!=null) {
				Label3_1 = new JLabel();
				Label3_1.setBackground(new Color(0, 64, 64));
				Label3_1.setBounds(0, 0, 160, 190);
				panel3.add(Label3_1);
				Label3_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				
				Label3_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label3_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label3_2_1.setBounds(0, 190, 160, 20);
				panel3.add(Label3_2_1);
				
				Label3_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label3_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label3_2_2.setBounds(0, 210, 160, 20);
				panel3.add(Label3_2_2);
				
				Label3_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label3_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label3_2_3.setBounds(0, 230, 160, 20);
				panel3.add(Label3_2_3);
				
				btnMua3 = new JButton("Mua");
				btnMua3.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua3.setBackground(new Color(138, 63, 63));
				btnMua3.setBounds(45, 250, 70, 20);
				panel3.add(btnMua3);
				btnMua3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[2].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
			}
			else if(i==3 && phim[i]!=null) {
				Label4_1 = new JLabel();
				Label4_1.setBackground(new Color(0, 64, 64));
				Label4_1.setBounds(0, 0, 160, 190);
				panel4.add(Label4_1);
				Label4_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label4_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label4_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label4_2_1.setBounds(0, 190, 160, 20);
				panel4.add(Label4_2_1);
				
				Label4_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label4_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label4_2_2.setBounds(0, 210, 160, 20);
				panel4.add(Label4_2_2);
				
				Label4_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label4_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label4_2_3.setBounds(0, 230, 160, 20);
				panel4.add(Label4_2_3);
				
				btnMua4 = new JButton("Mua");
				btnMua4.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua4.setBackground(new Color(138, 63, 63));
				btnMua4.setBounds(45, 250, 70, 20);
				panel4.add(btnMua4);
				btnMua4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[3].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
			}
			else if(i==4 && phim[i]!=null) {
				Label5_1 = new JLabel();
				Label5_1.setBackground(new Color(0, 64, 64));
				Label5_1.setBounds(0, 0, 160, 190);
				panel5.add(Label5_1);
				Label5_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label5_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label5_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label5_2_1.setBounds(0, 190, 160, 20);
				panel5.add(Label5_2_1);
				
				Label5_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label5_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label5_2_2.setBounds(0, 210, 160, 20);
				panel5.add(Label5_2_2);
				
				Label5_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label5_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label5_2_3.setBounds(0, 230, 160, 20);
				panel5.add(Label5_2_3);
			
				btnMua5 = new JButton("Mua");
				btnMua5.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua5.setBackground(new Color(138, 63, 63));
				btnMua5.setBounds(45, 250, 70, 20);
				panel5.add(btnMua5);
				
				btnMua5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[4].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
				
			}
			else if(i==5 && phim[i]!=null) {
				Label6_1 = new JLabel();
				Label6_1.setBackground(new Color(0, 64, 64));
				Label6_1.setBounds(0, 0, 160, 190);
				panel6.add(Label6_1);
				Label6_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label6_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label6_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label6_2_1.setBounds(0, 190, 160, 20);
				panel6.add(Label6_2_1);
				
				Label6_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label6_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label6_2_2.setBounds(0, 210, 160, 20);
				panel6.add(Label6_2_2);
				
				Label6_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label6_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label6_2_3.setBounds(0, 230, 160, 20);
				panel6.add(Label6_2_3);
				
				btnMua6 = new JButton("Mua");
				btnMua6.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua6.setBackground(new Color(138, 63, 63));
				btnMua6.setBounds(45, 250, 70, 20);
				panel6.add(btnMua6);
				
				btnMua6.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[5].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
			}
			else if(i==6 && phim[i]!=null) {
				Label7_1 = new JLabel();
				Label7_1.setBackground(new Color(0, 64, 64));
				Label7_1.setBounds(0, 0, 160, 190);
				panel7.add(Label7_1);
				Label7_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label7_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label7_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label7_2_1.setBounds(0, 190, 160, 20);
				panel7.add(Label7_2_1);
				
				Label7_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label7_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label7_2_2.setBounds(0, 210, 160, 20);
				panel7.add(Label7_2_2);
				
				Label7_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label7_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label7_2_3.setBounds(0, 230, 160, 20);
				panel7.add(Label7_2_3);
				
				btnMua7 = new JButton("Mua");
				btnMua7.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua7.setBackground(new Color(138, 63, 63));
				btnMua7.setBounds(45, 250, 70, 20);
				panel7.add(btnMua7);
				
				btnMua7.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[6].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
			}
			else if(i==7 && phim[i]!=null) {
				Label8_1 = new JLabel();
				Label8_1.setBackground(new Color(0, 64, 64));
				Label8_1.setBounds(0, 0, 160, 190);
				panel8.add(Label8_1);
				Label8_1.setIcon(new ImageIcon(phim[i].getDuongdan().trim()));
				
				Label8_2_1 = new JLabel("Tên Phim:" + phim[i].getTenPhim().trim());
				Label8_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label8_2_1.setBounds(0, 190, 160, 20);
				panel8.add(Label8_2_1);
				
				Label8_2_2 = new JLabel("Thời Lượng:" + phim[i].getThoiLuong()+" phút");
				Label8_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label8_2_2.setBounds(0, 210, 160, 20);
				panel8.add(Label8_2_2);
				
				Label8_2_3 = new JLabel("Giá vé:" + phim[i].getGiave()+" VND");
				Label8_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
				Label8_2_3.setBounds(0, 230, 160, 20);
				panel8.add(Label8_2_3);
				
				btnMua8 = new JButton("Mua");
				btnMua8.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
				btnMua8.setBackground(new Color(138, 63, 63));
				btnMua8.setBounds(45, 250, 70, 20);
				panel8.add(btnMua8);
				
				btnMua8.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MaPhimDC = phim[7].getMaPhim();
						menu.chaneToGD_ChonGhe();
						
					}
				});
				
			}
			
		}
//		loadData();
			
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------
	public void loadData() {
	    // Lấy lại danh sách phim từ cơ sở dữ liệu
	    List<Phim> newDanhsachphim = phimDao.getPhimList();

	    // Cập nhật lại danh sách phim
	    phim = new Phim[newDanhsachphim.size()];
	    for (int i = 0; i < newDanhsachphim.size(); i++) {
	        phim[i] = newDanhsachphim.get(i);
	    }
//	}
	    // Xóa các thành phần cũ trong các panel
	    panel1.removeAll();
	    panel2.removeAll();
	    panel3.removeAll();
	    panel4.removeAll();
	    panel5.removeAll();
	    panel6.removeAll();
	    panel7.removeAll();
	    panel8.removeAll();

	    // Thêm lại các thành phần mới vào các panel
	    for (int i = 0; i < phim.length; i++) {
	        if (i == 0 && phim[i] != null) {
	            // Thêm thông tin phim vào panel1
	            addFilmToPanel(panel1, phim[i], 0);
	        } else if (i == 1 && phim[i] != null) {
	            // Thêm thông tin phim vào panel2
	            addFilmToPanel(panel2, phim[i], 1);
	        } else if (i == 2 && phim[i] != null) {
	            // Thêm thông tin phim vào panel3
	            addFilmToPanel(panel3, phim[i], 2);
	        } else if (i == 3 && phim[i] != null) {
	            // Thêm thông tin phim vào panel4
	            addFilmToPanel(panel4, phim[i], 3);
	        } else if (i == 4 && phim[i] != null) {
	            // Thêm thông tin phim vào panel5
	            addFilmToPanel(panel5, phim[i], 4);
	        } else if (i == 5 && phim[i] != null) {
	            // Thêm thông tin phim vào panel6
	            addFilmToPanel(panel6, phim[i], 5);
	        } else if (i == 6 && phim[i] != null) {
	            // Thêm thông tin phim vào panel7
	            addFilmToPanel(panel7, phim[i], 6);
	        } else if (i == 7 && phim[i] != null) {
	            // Thêm thông tin phim vào panel8
	            addFilmToPanel(panel8, phim[i], 7);
	        }
	    }
   
	    
	    // Cập nhật lại giao diện
	    revalidate();
	    repaint();
	}

	private void addFilmToPanel(JPanel panel, Phim phim, int index) {
	    JLabel labelImage = new JLabel();
	    labelImage.setBackground(new Color(0, 64, 64));
	    labelImage.setBounds(0, 0, 160, 190);
	    panel.add(labelImage);
	    ImageIcon originalIcon = new ImageIcon(phim.getDuongdan().trim());
	    Image img = originalIcon.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
	    labelImage.setIcon(new ImageIcon(img));

	    JLabel labelName = new JLabel("Tên Phim:" + phim.getTenPhim().trim());
	    labelName.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
	    labelName.setBounds(0, 190, 160, 20);
	    panel.add(labelName);

	    JLabel labelDuration = new JLabel("Thời Lượng:" + phim.getThoiLuong() + " phút");
	    labelDuration.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
	    labelDuration.setBounds(0, 210, 160, 20);
	    panel.add(labelDuration);

	    JLabel labelPrice = new JLabel("Giá vé:" + phim.getGiave() + " VND");
	    labelPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
	    labelPrice.setBounds(0, 230, 160, 20);
	    panel.add(labelPrice);

	    JButton buyButton = new JButton("Mua");
	    buyButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
	    buyButton.setBackground(new Color(138, 63, 63));
	    buyButton.setBounds(45, 250, 70, 20);
	    panel.add(buyButton);
	    
	    buyButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Các hành động liên quan đến button "Mua
	            MaPhimDC = phim.getMaPhim();
	            System.out.println("Mã phim đã được chọn: " + MaPhimDC);
	            // Chuyển sang giao diện chọn ghế
	            GD_Menu Menu = new GD_Menu();
	            Menu.chaneToGD_ChonGhe();
	        }
	    });

	}

	public String getMaPhimDuocChon() {
		return MaPhimDC;
	}
	
	
}

