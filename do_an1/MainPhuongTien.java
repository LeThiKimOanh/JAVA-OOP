package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

public class MainPhuongTien extends JFrame {

	ConnectPhuongTien conn = new ConnectPhuongTien();
	
	private JPanel contentPane;
	private JTable tablePT;
	private JTextField txtMaPT, txtPhi;
	
	
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	public JComboBox jcbmachu, jcbLoaiPT; 
	String Loai[]= {"Ô tô", "Xe máy", "Xe đạp", "Không có"};
 
	

	
//-----------hiển thị thông tiin lên bảng--------
private void loadBang() {
		
		ResultSet rs = conn.ShowPT();
		DefaultTableModel dtm = (DefaultTableModel) tablePT.getModel();
		dtm.setRowCount(0);

		
		try {
			while(rs.next()) {
              Vector<Object> vec = new Vector<Object>();
              vec.add(rs.getString("MAPT"));
              vec.add(rs.getString("MACUDAN"));
              vec.add(rs.getString("LOAIPT"));
              vec.add(rs.getString("PHIGUI"));
             
              dtm.addRow(vec);
							}
		} catch (SQLException e) {
			  e.printStackTrace();
		}
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public MainPhuongTien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblNewLabel = new JLabel("PHƯƠNG TIỆN ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(292, 0, 255, 44);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 85, 548, 185);
		contentPane.add(scrollPane);
		
		tablePT = new JTable();
		tablePT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tablePT.getSelectedRow();
				if(row>=0) {
					txtMaPT.setText(tablePT.getValueAt(row,0).toString());
					jcbmachu.setSelectedItem(tablePT.getValueAt(row,1).toString());
					jcbLoaiPT.setSelectedItem(tablePT.getValueAt(row,2).toString());
					txtPhi.setText(tablePT.getValueAt(row,3).toString());
					
				}
			}
		});
		tablePT.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Mã PT", "Mã chủ PT", "Loại PT", "Phí gửi"
			}
		));
		tablePT.getColumnModel().getColumn(2).setPreferredWidth(104);
		scrollPane.setViewportView(tablePT);
		
	    loadBang();
	    
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 54, 298, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÍ PHƯƠNG TIỆN");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(24, 10, 218, 31);
		panel.add(lblNewLabel_1);
		
		
		JLabel jlb1 = new JLabel("Mã phương tiện:");
		jlb1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlb1.setBounds(10, 46, 124, 31);
		panel.add(jlb1);
		
		JLabel jlb2 = new JLabel("Mã chủ:");
		jlb2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlb2.setBounds(10, 87, 124, 31);
		panel.add(jlb2);
		
		JLabel jlb3 = new JLabel("Loại PT:");
		jlb3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlb3.setBounds(10, 131, 124, 31);
		panel.add(jlb3);
		
		JLabel jlb4 = new JLabel("Phí gửi:");
		jlb4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlb4.setBounds(10, 172, 124, 31);
		panel.add(jlb4);
		
		txtMaPT = new JTextField();
		txtMaPT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaPT.setBounds(131, 47, 157, 31);
		panel.add(txtMaPT);
		txtMaPT.setColumns(10);
		
		txtPhi = new JTextField();
		txtPhi.setBounds(131, 176, 157, 25);
		panel.add(txtPhi);
		txtPhi.setColumns(10);
		
		jcbmachu = new JComboBox();
		jcbmachu.setBounds(131, 87, 157, 31);
		panel.add(jcbmachu);
		
		combobox();
		
		jcbLoaiPT = new JComboBox(Loai);
		jcbLoaiPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Data.getConnection();					
					Statement stm = conn.createStatement();
					
					String sql = "select * from chitietPT where LOAIPT = ?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, (String)jcbLoaiPT.getSelectedItem());
					rs = pst.executeQuery();
					
					while (rs.next()) {
						txtPhi.setText(rs.getString("PHIGUI"));
					}
					pst.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		jcbLoaiPT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jcbLoaiPT.setBounds(131, 128, 157, 31);
		panel.add(jcbLoaiPT);
		
/*---------------- NÚT CHỨC NĂNG ----------------------------	
-------------------------------------------------------------*/
		
		JButton btTim = new JButton("Tìm Kiếm");
		btTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
					
				    String maPT = txtMaPT.getText();
					ResultSet rs = conn.timPT(maPT);
					DefaultTableModel dtm = (DefaultTableModel) tablePT.getModel();
					dtm.setRowCount(0);	
						try {
							
						 while(rs.next()) {
			                 Vector<Object> vec = new Vector<Object>();
			                 
			                 vec.add(rs.getString("MAPT"));
			                 vec.add(rs.getString("MACUDAN"));
			                 vec.add(rs.getString("LOAIPT"));
			                 vec.add(rs.getString("PHIGUI"));
			              
			                 dtm.addRow(vec);
						    }
						} catch (SQLException e1) { 
								e1.printStackTrace();
						}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Không tìm được!");
				}
			}
		});
		btTim.setBackground(Color.LIGHT_GRAY);
		btTim.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\find.png"));
		btTim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btTim.setBounds(96, 296, 151, 50);
		contentPane.add(btTim);
	

		JButton btThem = new JButton("Thêm");
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm phương tiện mới?") == JOptionPane.YES_OPTION) {
					String maPT = txtMaPT.getText() ;
					String machu = jcbmachu.getSelectedItem().toString() ;
					String loaiPT = jcbLoaiPT.getSelectedItem().toString() ;
					String phi = txtPhi.getText();
					
					conn.themPT( maPT, machu, loaiPT,phi);
					
					loadBang();
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				}	
			}
		});
		btThem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\add.png"));
		btThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btThem.setBackground(Color.LIGHT_GRAY);
		btThem.setBounds(96, 360, 151, 50);
		contentPane.add(btThem);
		
		JButton btTroLai = new JButton("Trở Lại");
		btTroLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBang();
			}
		});
		btTroLai.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\TROLAI.png"));
		btTroLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btTroLai.setBackground(Color.LIGHT_GRAY);
		btTroLai.setBounds(355, 296, 151, 50);
		contentPane.add(btTroLai);
		
		JButton btSua = new JButton("Sửa");
		btSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn sửa thông tin phương tiện?") == JOptionPane.YES_OPTION) {
					try {
						String maPT = txtMaPT.getText();
						String machu = jcbmachu.getSelectedItem().toString() ;
						String loaiPT = jcbLoaiPT.getSelectedItem().toString() ;
						String phi = txtPhi.getText();
						
						
						conn.suaPT(maPT,machu,loaiPT,phi);
						loadBang();
						JOptionPane.showMessageDialog(null, "Sửa thành công!");
			
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					}
			}
		});
		btSua.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\edit.png"));
		btSua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btSua.setBackground(Color.LIGHT_GRAY);
		btSua.setBounds(355, 360, 151, 50);
		contentPane.add(btSua);
		
		JButton btClean = new JButton("Clean");
		btClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaPT.setText("");
//				jcbmachu.setToolTipText("");
//				jcbLoaiPT.setToolTipText("");
				txtPhi.setText("");
			}
		});
		btClean.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\clean.png"));
		btClean.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btClean.setBackground(Color.LIGHT_GRAY);
		btClean.setBounds(610, 296, 151, 50);
		contentPane.add(btClean);
		
		JButton btXoa = new JButton("Xóa");
		btXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin phương tiện?") == JOptionPane.YES_OPTION) {
					try {
						String maPT = txtMaPT.getText();
						conn.xoaPT(maPT);
						
						loadBang();
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		});
		btXoa.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\delete.png"));
		btXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btXoa.setBackground(Color.LIGHT_GRAY);
		btXoa.setBounds(610, 360, 151, 50);
		contentPane.add(btXoa);
	}

	
/*---PHƯƠNG THỨC ĐỔ DỮ LIỆU TỪ CSDL CHO COMBOBOX-------------
-------------------------------------------------------------*/	
	public void combobox() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) jcbmachu.getModel();
		model.removeAllElements();
		try {
			Connection conn = Data.getConnection();
			
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select TRUONGPHONG.MACUDAN from TRUONGPHONG");
			while (rs.next()) {
				String machu = rs.getString("MACUDAN");
				jcbmachu.addItem(machu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
