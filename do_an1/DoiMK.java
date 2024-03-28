package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoiMK extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JPasswordField mkCu;
	private JPasswordField mkMoi;
	private JPasswordField nlmkMoi;
	private String StringOldPass;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoiMK frame = new DoiMK();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DoiMK(final String username) {
		StringOldPass = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("ĐỔI MẬT KHẨU");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÊN ĐĂNG NHẬP");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 76, 148, 40);
		contentPane.add(lblNewLabel);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTen.setEditable(false);
		txtTen.setBounds(203, 76, 180, 40);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		try {
			Connection conn = Data.getConnection();
			
			Statement stm = conn.createStatement();
			String sql = "select * from DANGNHAP where TENDANGNHAP = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()) {
				txtTen.setText(rs.getString("TENDANGNHAP"));
				StringOldPass = rs.getString("MATKHAU");
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		JLabel lblMtKhuC = new JLabel("MẬT KHẨU CŨ:");
		lblMtKhuC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMtKhuC.setBounds(22, 126, 148, 40);
		contentPane.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("MẬT KHẨU MỚI:");
		lblMtKhuMi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMtKhuMi.setBounds(22, 159, 148, 40);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblNhpLiMt = new JLabel("NHẬP LẠI MẬT KHẨU MỚI:");
		lblNhpLiMt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNhpLiMt.setBounds(22, 192, 219, 40);
		contentPane.add(lblNhpLiMt);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					mkCu.setEchoChar((char)0);
					mkMoi.setEchoChar((char)0);
					nlmkMoi.setEchoChar((char)0);
				} else {
					mkCu.setEchoChar('*');
					mkMoi.setEchoChar('*');
					nlmkMoi.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(243, 249, 153, 31);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("CHANGE PASS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringOldPass.equals(mkCu.getText())) {
					if(mkMoi.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "input pass new");
					} else {
						if(mkMoi.getText().equals(nlmkMoi.getText())) {
							if(JOptionPane.showConfirmDialog(null, "Bạn có muốn đổi mật khẩu không? ") == JOptionPane.YES_OPTION) {
								try {
									Connection conn = Data.getConnection();
									
									Statement stm = conn.createStatement();
									String sql = "update DANGNHAP set MATKHAU = ? where TENDANGNHAP = ?";
									PreparedStatement pre = conn.prepareStatement(sql);
									pre.setString(1, mkMoi.getText());
									pre.setString(2, username);
									if(pre.executeUpdate() > 0) {
										JOptionPane.showMessageDialog(null, "ĐỔI MẬT KHẨU THÀNH CÔNG!");
										mkCu.setText("");
										mkMoi.setText("");
										nlmkMoi.setText("");
										setVisible(false);
									}
									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "ok !!!!!");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "pass error !!!!!");
				}
			}
		});
		btnNewButton.setForeground(new Color(60, 179, 113));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\change.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(130, 286, 253, 52);
		contentPane.add(btnNewButton);
		
		mkCu = new JPasswordField();
		mkCu.setFont(new Font("Tahoma", Font.BOLD, 15));
		mkCu.setBounds(243, 126, 164, 31);
		contentPane.add(mkCu);
		
		mkMoi = new JPasswordField();
		mkMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		mkMoi.setBounds(243, 163, 164, 31);
		contentPane.add(mkMoi);
		
		nlmkMoi = new JPasswordField();
		nlmkMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		nlmkMoi.setBounds(243, 204, 164, 31);
		contentPane.add(nlmkMoi);
	}
}
