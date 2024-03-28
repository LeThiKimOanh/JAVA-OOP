package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class CuDanChiTiet extends JFrame {

	private JPanel contentPane;
	private JTextField txtmacd;
	private JTextField txttencd;
	private JTextField txtphong;
	private JTextField txtcccd;
	private JTextField txtsdt;
	private JTextField txtngaydk;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CuDanChiTiet frame = new CuDanChiTiet();
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
	public CuDanChiTiet(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("THÔNG TIN BẢN THÂN");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(128, 10, 126, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MÃ CƯ DÂN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(6, 30, 116, 33);
		panel.add(lblNewLabel);
		
		JLabel lblTnCDn = new JLabel("TÊN CƯ DÂN");
		lblTnCDn.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnCDn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTnCDn.setBounds(6, 86, 116, 33);
		panel.add(lblTnCDn);
		
		JLabel lblPhng = new JLabel("PHÒNG");
		lblPhng.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhng.setBounds(6, 129, 116, 33);
		panel.add(lblPhng);
		
		JLabel lblCccd = new JLabel("CCCD");
		lblCccd.setHorizontalAlignment(SwingConstants.LEFT);
		lblCccd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCccd.setBounds(6, 172, 116, 33);
		panel.add(lblCccd);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setHorizontalAlignment(SwingConstants.LEFT);
		lblSt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSt.setBounds(6, 215, 105, 33);
		panel.add(lblSt);
		
		JLabel lblNgyngK = new JLabel("NGÀY ĐĂNG KÍ");
		lblNgyngK.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgyngK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNgyngK.setBounds(6, 258, 116, 33);
		panel.add(lblNgyngK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(279, 29, 354, 282);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtmacd = new JTextField();
		txtmacd.setEditable(false);
		txtmacd.setBounds(0, 10, 354, 33);
		panel_1.add(txtmacd);
		txtmacd.setColumns(10);
		
		txttencd = new JTextField();
		txttencd.setEditable(false);
		txttencd.setColumns(10);
		txttencd.setBounds(0, 63, 354, 33);
		panel_1.add(txttencd);
		
		txtphong = new JTextField();
		txtphong.setEditable(false);
		txtphong.setColumns(10);
		txtphong.setBounds(0, 106, 354, 33);
		panel_1.add(txtphong);
		
		txtcccd = new JTextField();
		txtcccd.setEditable(false);
		txtcccd.setColumns(10);
		txtcccd.setBounds(0, 149, 354, 33);
		panel_1.add(txtcccd);
		
		txtsdt = new JTextField();
		txtsdt.setEditable(false);
		txtsdt.setColumns(10);
		txtsdt.setBounds(0, 192, 354, 33);
		panel_1.add(txtsdt);
		
		txtngaydk = new JTextField();
		txtngaydk.setEditable(false);
		txtngaydk.setColumns(10);
		txtngaydk.setBounds(0, 239, 354, 33);
		panel_1.add(txtngaydk);
		
		try {
			Connection conn = Data.getConnection();
		
			String sql = "select * from TRUONGPHONG where MACUDAN =  ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,username );
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()) {
				txtmacd.setText(rs.getString("MACUDAN"));
				txttencd.setText(rs.getString("TENCUDAN"));
				txtphong.setText(rs.getString("MACANHO"));
				txtcccd.setText(rs.getString("CCCD"));
				txtsdt.setText(rs.getString("SDT"));
				txtngaydk.setText(rs.getString("NGAYDK"));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		JButton btchangepass = new JButton("ChangePass");
		btchangepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoiMK frame = new DoiMK(username);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btchangepass.setForeground(Color.RED);
		btchangepass.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btchangepass.setBounds(-4, 268, 126, 41);
		contentPane.add(btchangepass);
		
		JButton bthelp = new JButton("HELP");
		bthelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		bthelp.setForeground(Color.RED);
		bthelp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bthelp.setBounds(566, 321, 96, 32);
		contentPane.add(bthelp);
	}
}
