package do_an1;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDA extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDA frame = new MenuDA();
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
	public MenuDA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 495);
		setTitle("MENU DA");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(250, 240, 230));
		menuBar.setBounds(0, 0, 858, 36);
		contentPane.add(menuBar);
		
		JMenu mnTT = new JMenu("Thông Tin");
		mnTT.setForeground(new Color(139, 0, 0));
		mnTT.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		menuBar.add(mnTT);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("THÔNG TIN CĂN HỘ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ThongTin frame = new ThongTin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnTT.add(mntmNewMenuItem);
		
		JMenu mnQuanLi = new JMenu("Quản Lí");
		mnQuanLi.setForeground(new Color(139, 0, 0));
		mnQuanLi.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		menuBar.add(mnQuanLi);
		
		JMenuItem mnitemCanHo = new JMenuItem("CĂN HỘ");
		mnitemCanHo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainCanHo frame = new MainCanHo();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitemCanHo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnQuanLi.add(mnitemCanHo);
		
		JMenuItem mnitem = new JMenuItem("CƯ DÂN");
		mnitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainCuDan frame = new MainCuDan();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnQuanLi.add(mnitem);
		
		JMenuItem mnitemPhuongTien = new JMenuItem("PHƯƠNG TIỆN");
		mnitemPhuongTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainPhuongTien frame = new MainPhuongTien();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitemPhuongTien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnQuanLi.add(mnitemPhuongTien);
		
		JMenuItem mnitemTrgPhong = new JMenuItem("TRƯỞNG PHÒNG");
		mnitemTrgPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainTruongPhong frame = new MainTruongPhong();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitemTrgPhong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnQuanLi.add(mnitemTrgPhong);
		
		JMenu mnThongKe = new JMenu("Thống Kê");
		mnThongKe.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		mnThongKe.setForeground(new Color(139, 0, 0));
		menuBar.add(mnThongKe);
		
		JMenuItem mnitemDienNuoc = new JMenuItem("ĐIỆN NƯỚC");
		mnitemDienNuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DienNuoc frame = new DienNuoc();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitemDienNuoc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnThongKe.add(mnitemDienNuoc);
		
		JMenuItem mnitemThanhToan = new JMenuItem("THANH TOÁN");
		mnitemThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainThanhToan frame = new MainThanhToan();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitemThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnThongKe.add(mnitemThanhToan);
		
		JMenu mnHoTro = new JMenu("Hỗ Trợ");
		mnHoTro.setForeground(new Color(139, 0, 0));
		mnHoTro.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		menuBar.add(mnHoTro);
		
		JMenuItem mnitemLH = new JMenuItem("LIÊN HỆ");
		mnitemLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Help frame = new Help();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnitemLH.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnHoTro.add(mnitemLH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\Da12.jpg"));
		lblNewLabel.setBounds(10, 35, 753, 426);
		contentPane.add(lblNewLabel);
	}
}
