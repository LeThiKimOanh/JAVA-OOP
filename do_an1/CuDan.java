package do_an1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuDan extends JFrame {
    
	ConnectThanhToan con = new ConnectThanhToan();
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtcsDien;
	private JTextField txtcsNuoc;
	private JTextField txtDientich;
	private JTextField txtGuixe;
	private JTextField txtTienDien;
	private JTextField txtTienNuoc;
	private JTextField txtTienphong;
	private JTextField txtPhiguixe;
	private JTextField txtTong;
	private JTextField txtMaHD;
	private JTextField txtPhong;
	
	String thang[]= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CuDan frame = new CuDan();
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
	public CuDan(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbchucvu = new JLabel("Cư dân");
		lbchucvu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbchucvu.setBounds(10, 10, 83, 31);
		contentPane.add(lbchucvu);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setText("Họ tên cư dân");
		txtName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		txtName.setBounds(130, 10, 222, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);
		 
	    JLabel lblNewLabel_3 = new JLabel("Tháng:");
	    lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblNewLabel_3.setBounds(389, 50, 74, 31);
	    contentPane.add(lblNewLabel_3);
	    
	    JComboBox jcbThang = new JComboBox(thang);
	    jcbThang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    jcbThang.setBounds(485, 51, 50, 31);
	    contentPane.add(jcbThang);
	    
	    JLabel lblNewLabel_4 = new JLabel("Phòng:");
	    lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblNewLabel_4.setBounds(389, 12, 74, 31);
	    contentPane.add(lblNewLabel_4);
		
		txtPhong = new JTextField();
	    txtPhong.setEditable(false);
	    txtPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    txtPhong.setBounds(485, 10, 50, 31);
	    contentPane.add(txtPhong);
	    txtPhong.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EC9 s\u1ED1", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(33, 101, 306, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Điện:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 31, 103, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNc = new JLabel("Nước:");
		lblNc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNc.setBounds(10, 100, 103, 43);
		panel.add(lblNc);
		
		JLabel lblDinTch = new JLabel("Diện tích:");
		lblDinTch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDinTch.setBounds(10, 165, 103, 43);
		panel.add(lblDinTch);
		
		JLabel lblGiXe = new JLabel("Gửi xe:");
		lblGiXe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGiXe.setBounds(10, 235, 103, 43);
		panel.add(lblGiXe);
		
		txtcsDien = new JTextField();
		txtcsDien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtcsDien.setEditable(false);
		txtcsDien.setBounds(119, 31, 177, 43);
		panel.add(txtcsDien);
		txtcsDien.setColumns(10);
		
		txtcsNuoc = new JTextField();
		txtcsNuoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtcsNuoc.setEditable(false);
		txtcsNuoc.setColumns(10);
		txtcsNuoc.setBounds(119, 100, 177, 43);
		panel.add(txtcsNuoc);
		
		txtDientich = new JTextField();
		txtDientich.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDientich.setEditable(false);
		txtDientich.setColumns(10);
		txtDientich.setBounds(119, 165, 177, 43);
		panel.add(txtDientich);
		
		txtGuixe = new JTextField();
		txtGuixe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtGuixe.setEditable(false);
		txtGuixe.setColumns(10);
		txtGuixe.setBounds(119, 235, 177, 43);
		panel.add(txtGuixe);
// đổ tên cư dân lene textfield		
		try {
			Connection conn = Data.getConnection();
			
			String sql = "select * from TRUONGPHONG where MACUDAN = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				txtName.setText(rs.getString("TENCUDAN"));
			    txtPhong.setText(rs.getString("MACANHO"));
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(389, 101, 322, 377);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Điện:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 29, 103, 43);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNc_1 = new JLabel("Nước:");
		lblNc_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNc_1.setBounds(10, 91, 103, 43);
		panel_1.add(lblNc_1);
		
		JLabel lblPhng = new JLabel("Phòng:");
		lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhng.setBounds(10, 161, 103, 43);
		panel_1.add(lblPhng);
		
		JLabel lblPhGiXe = new JLabel("Phí gửi xe:");
		lblPhGiXe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhGiXe.setBounds(10, 230, 103, 43);
		panel_1.add(lblPhGiXe);
		
		JLabel lblTng = new JLabel("Tổng:");
		lblTng.setForeground(Color.RED);
		lblTng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTng.setBounds(10, 297, 103, 43);
		panel_1.add(lblTng);
		
		txtTienDien = new JTextField();
		txtTienDien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTienDien.setEditable(false);
		txtTienDien.setColumns(10);
		txtTienDien.setBounds(123, 29, 189, 43);
		panel_1.add(txtTienDien);
		
		txtTienNuoc = new JTextField();
		txtTienNuoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTienNuoc.setEditable(false);
		txtTienNuoc.setColumns(10);
		txtTienNuoc.setBounds(123, 91, 189, 43);
		panel_1.add(txtTienNuoc);
		
		txtTienphong = new JTextField();
		txtTienphong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTienphong.setEditable(false);
		txtTienphong.setColumns(10);
		txtTienphong.setBounds(123, 161, 189, 43);
		panel_1.add(txtTienphong);
		
		txtPhiguixe = new JTextField();
		txtPhiguixe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPhiguixe.setEditable(false);
		txtPhiguixe.setColumns(10);
		txtPhiguixe.setBounds(123, 230, 189, 43);
		panel_1.add(txtPhiguixe);
		
		txtTong = new JTextField();
		txtTong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTong.setEditable(false);
		txtTong.setColumns(10);
		txtTong.setBounds(123, 297, 189, 43);
		panel_1.add(txtTong);
		
		JButton btThanhtoan = new JButton("THANH TOÁN");
		btThanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh toán?") == JOptionPane.YES_OPTION) {
						String thang = jcbThang.getSelectedItem().toString() ;
						String maHD = txtMaHD.getText();
						String phong = txtPhong.getText();
						String tiendien = txtTienDien.getText();
						String tiennuoc = txtTienNuoc.getText();
						String tienphong = txtTienphong.getText();
						String guixe = txtGuixe.getText();
						String tong = txtTong.getText();
						String trangthai = "ĐÃ THANH TOÁN";
						
						con.themHD(thang,maHD,phong,tiendien,tiennuoc,tienphong,guixe,tong,trangthai);
						
						JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
					}
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Bạn đã thanh toán rồi!");
				}
				
			}
		});
		btThanhtoan.setBackground(Color.GREEN);
		btThanhtoan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btThanhtoan.setBounds(517, 488, 180, 38);
		contentPane.add(btThanhtoan);
		
/*-----------ĐỔ DỮ LIỆU LÊN TEXTFIELD CÁC CHỈ SỐ-----------------------
-----------------------------------------------------------------------*/	
			try {
				Connection conn = Data.getConnection();
				
				String sql = "select * from TRUONGPHONG,CanHo,PhuongTien where TRUONGPHONG.MACANHO = CanHo.MACANHO AND TRUONGPHONG.MACUDAN = ? and PhuongTien.MACUDAN = ? ";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1,username );
				pst.setString(2,username);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					txtcsDien.setText(rs.getString("SODIEN"));
					txtcsNuoc.setText(rs.getString("SONUOC"));
					txtDientich.setText(rs.getString("DIENTICH"));
					txtGuixe.setText(rs.getString("LOAIPT"));
					txtPhiguixe.setText(rs.getString("PHIGUI"));
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			
			
			double a = Double.parseDouble(txtcsDien.getText());
			double b = Double.parseDouble(txtcsNuoc.getText());
			double c = Double.parseDouble(txtDientich.getText());
			double x1 = a*3000;
			double x2 = b*7000;
				txtTienDien.setText(String.valueOf(x1));
				txtTienNuoc.setText(String.valueOf(x2));
			double y1 = 0, y2 = 0;	
			if( c == 120) {
				y1 = 3500000;
				txtTienphong.setText(String.valueOf(y1));
			} else {
				y2 = 4000000;
				txtTienphong.setText(String.valueOf(y2));
			}
			
			double z1 = Double.parseDouble(txtPhiguixe.getText());
			    
		    double tong = x1 + x2+y1+y2+z1;
		    txtTong.setText(String.valueOf(tong));
		    
		    txtMaHD = new JTextField();
		    txtMaHD.setEditable(false);
		    txtMaHD.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		    txtMaHD.setText("MaHD");
		    txtMaHD.setBounds(130, 51, 222, 31);
		    contentPane.add(txtMaHD);
		    txtMaHD.setColumns(10);
//----Random ma HOA DON-----------		    
		    Random rand = new Random();
			int n = rand.nextInt(10000)+1;
			String val = String.valueOf(n);
			txtMaHD.setText(val);
		    
		    JLabel lblNewLabel_2 = new JLabel("Mã hóa đơn:");
		    lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		    lblNewLabel_2.setBounds(10, 51, 110, 31);
		    contentPane.add(lblNewLabel_2);
		    
		    JLabel lbThongtin = new JLabel("Thông tin cư dân");
		    lbThongtin.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		EventQueue.invokeLater(new Runnable() {
		    			public void run() {
		    				try {
		    					CuDanChiTiet frame = new CuDanChiTiet(username);
		    					frame.setVisible(true);
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    			}
		    		});
		    	}
		    });
		    lbThongtin.setForeground(Color.BLUE);
		    lbThongtin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		    lbThongtin.setBounds(601, 61, 147, 21);
		    contentPane.add(lbThongtin);
		    
		    
			
	}
//	// Random mã hoá đơn
//		public void random() {
//			Random rand = new Random();
//			int n = rand.nextInt(10000)+1;
//			String val = String.valueOf(n);
//			txtMaHD.setText(val);	
//		}
		
	
}
