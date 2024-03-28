package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginDA extends JFrame {
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDA frame = new LoginDA();
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
	public LoginDA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN    THƯƠNG OANH");
		setBounds(100, 100, 491, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN TO THE SYSTEM");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 22));
		lblNewLabel.setBounds(66, 10, 360, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER:");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(21, 82, 103, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD:");
		lblNewLabel_2.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(21, 140, 101, 39);
		contentPane.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtUser.setBounds(153, 80, 243, 39);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUser.getText();
				String password = txtPass.getText();
				
				String chucVu = checkLogin(username,password);
				
				if(chucVu.equals("admin")) {
					JOptionPane.showMessageDialog(null, "Dang nhap voi tu cach admin");
					MenuDA frame = new MenuDA();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					txtUser.setText("");
					txtPass.setText("");
				}
				
			    if(chucVu.equals("cudan")) {
				    CuDan frame = new CuDan(username);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
			    	txtUser.setText("");
					txtPass.setText("");
				}
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\Login.png"));
		btnLogin.setForeground(new Color(60, 179, 113));
		btnLogin.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		btnLogin.setBounds(160, 251, 170, 40);
		contentPane.add(btnLogin);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtPass.setEchoChar('*');
		txtPass.setBounds(153, 138, 243, 34);
		contentPane.add(txtPass);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.setFont(new Font("Serif", Font.ITALIC, 10));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					txtPass.setEchoChar((char)0);
				} else {
					txtPass.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(140, 194, 140, 21);
		contentPane.add(chckbxNewCheckBox);
	}
	
	private String checkLogin(String username, String password) {
		String chucVu = "";
		
		try {
			Connection conn = Data.getConnection();
			String sql = "SELECT MATKHAU, CHUCVU from DANGNHAP where TENDANGNHAP = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				if(password.equals(rs.getString("MATKHAU"))) {
					chucVu = rs.getString("CHUCVU");
				} else {
					JOptionPane.showMessageDialog(null, "pasword error");
				}
			} else {
				JOptionPane.showMessageDialog(null, "no exits this account");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "test 2 ");
		}
		return chucVu;
	}
}
