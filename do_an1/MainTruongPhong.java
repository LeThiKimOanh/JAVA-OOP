package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;

public class MainTruongPhong extends JFrame {

	ConnectTruongPhong conn = new ConnectTruongPhong();
	
	private JPanel contentPane;
	private JTable tableTrgphong;
	private JLabel lblNewLabel_1;
	private JTextField txtMacd;
	private JTextField txtTencd;
	private JTextField txtCCCD;
	private JTextField txtSDT;
	JComboBox<String> jcbGT, jcbPhong;
    String gt[] = {" ", "Nam", "Nữ"};

    private PreparedStatement pst = null;
	private ResultSet rs = null;
    
private void loadBang() {
		
		ResultSet rs = conn.ShowTrgphong();
		DefaultTableModel dtm = (DefaultTableModel) tableTrgphong.getModel();
		dtm.setRowCount(0);

		
		try {
			while(rs.next()) {
              Vector<Object> vec = new Vector<Object>();
              vec.add(rs.getString("MACANHO"));
              vec.add(rs.getString("MACUDAN"));
              vec.add(rs.getString("TENCUDAN"));
              vec.add(rs.getString("GIOITINH"));
              vec.add(rs.getString("NGAYSINH"));
              vec.add(rs.getString("CCCD"));
              vec.add(rs.getString("SDT"));
              vec.add(rs.getString("NGAYDK"));
             
              
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
					MainTruongPhong frame = new MainTruongPhong();
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
	public MainTruongPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("TRƯỞNG PHÒNG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(304, 10, 246, 46);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 890, 145);
		contentPane.add(scrollPane);
		
//------LICH--------------------------------------------------------
		JDateChooser dateSinh = new JDateChooser();
		JDateChooser dateDK = new JDateChooser();
//------------------------------------------------------------------	
		
		tableTrgphong = new JTable();
		tableTrgphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tableTrgphong.getSelectedRow();
				if(row>=0) {
					txtMacd.setText(tableTrgphong.getValueAt(row,1).toString());
					txtTencd.setText(tableTrgphong.getValueAt(row,2).toString());
					jcbGT.setSelectedItem(tableTrgphong.getValueAt(row,3).toString());
					try {
						java.util.Date d=new SimpleDateFormat("yyyy-MM-dd").parse((String)tableTrgphong.getValueAt(row,4).toString());
							dateSinh.setDate(d);
						
						} catch (Exception e2) {
							// TODO: handle exception
						}
					txtCCCD.setText(tableTrgphong.getValueAt(row,5).toString());
					txtSDT.setText(tableTrgphong.getValueAt(row,6).toString());
					try {
						java.util.Date d=new SimpleDateFormat("yyyy-MM-dd").parse((String)tableTrgphong.getValueAt(row,7).toString());
							dateDK.setDate(d);
						
						} catch (Exception e2) {
							// TODO: handle exception
						}
					jcbPhong.setSelectedItem(tableTrgphong.getValueAt(row,0).toString());
				}
			}
		});
		tableTrgphong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Phòng","Mã cư dân", "Tên cư dân", "Giới tính", "Ngày sinh", "CCCD", "SDT", "Ngày ĐK"
			}
		));
		scrollPane.setViewportView(tableTrgphong);
		
		loadBang();
		
		lblNewLabel_1 = new JLabel("THÔNG TIN TRƯỞNG PHÒNG");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(20, 223, 267, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phòng:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(183, 270, 78, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã cư dân:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(183, 307, 111, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên cư dân:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(182, 344, 92, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Giới tính:");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(183, 381, 78, 27);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ngày sinh:");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(499, 270, 78, 27);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("CCCD:");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(499, 307, 78, 27);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("SDT:");
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_6.setBounds(499, 344, 78, 27);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Ngày ĐK:");
		lblNewLabel_2_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_7.setBounds(499, 381, 78, 27);
		contentPane.add(lblNewLabel_2_7);
		
		jcbPhong = new JComboBox();
		jcbPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Data.getConnection();
					
					String sql = "select * from CanHo where MACANHO = ?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, (String)jcbPhong.getSelectedItem());
					rs = pst.executeQuery();
					
					while (rs.next()) {
						txtTencd.setText(rs.getString("TENCHUHO"));
					}
					pst.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		jcbPhong.setBounds(271, 272, 144, 25);
		contentPane.add(jcbPhong);
		
		txtMacd = new JTextField();
		txtMacd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMacd.setBounds(271, 306, 144, 27);
		contentPane.add(txtMacd);
		txtMacd.setColumns(10);
		
		txtTencd = new JTextField();
		txtTencd.setEditable(false);
		txtTencd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTencd.setColumns(10);
		txtTencd.setBounds(271, 344, 144, 27);
		contentPane.add(txtTencd);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(587, 306, 144, 27);
		contentPane.add(txtCCCD);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(587, 343, 144, 27);
		contentPane.add(txtSDT);
		
	    jcbGT = new JComboBox(gt);
		jcbGT.setBounds(271, 381, 144, 25);
		contentPane.add(jcbGT);

/*---------------------------------------------------------------------------------
 *                                           CHUC NANG		
----------------------------------------------------------------------------------- */
		
		JButton btTimkiem = new JButton("Tìm kiếm");
		btTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				try {
				    String maCD = txtMacd.getText();
					ResultSet rs = conn.timTrgphong(maCD);
					DefaultTableModel dtm = (DefaultTableModel) tableTrgphong.getModel();
					dtm.setRowCount(0);	
						try {
							
						 while(rs.next()) {
			                 Vector<Object> vec = new Vector<Object>();
			                 
			                 vec.add(rs.getString("MACUDAN"));
			                 vec.add(rs.getString("TENCUDAN"));
			                 vec.add(rs.getString("GIOITINH"));
			                 vec.add(rs.getString("NGAYSINH"));
			                 vec.add(rs.getString("CCCD"));
			                 vec.add(rs.getString("SDT"));
			                 vec.add(rs.getString("NGAYDK"));
			                 vec.add(rs.getString("MACANHO"));
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
		btTimkiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btTimkiem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\find.png"));
		btTimkiem.setBounds(10, 274, 137, 37);
		contentPane.add(btTimkiem);
		
		JButton btTrove = new JButton("Trở về");
		btTrove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBang();
			}
		});
		btTrove.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\TROLAI.png"));
		btTrove.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btTrove.setBounds(10, 334, 137, 37);
		contentPane.add(btTrove);
		
		JButton btClean = new JButton("Clean");
		btClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMacd.setText("");
				jcbPhong.setToolTipText("");
				txtTencd.setText("");
				txtCCCD.setText("");
				txtSDT.setText("");
				jcbGT.setToolTipText(gt[0]);
				dateSinh.setToolTipText("");
				dateDK.setToolTipText("");
			}
		});
		btClean.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\clean.png"));
		btClean.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btClean.setBounds(10, 391, 137, 37);
		contentPane.add(btClean);
		
		JButton btThem = new JButton("Thêm");
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm căn hộ mới?") == JOptionPane.YES_OPTION) {
					String macanho = jcbPhong.getSelectedItem().toString() ;
					String ma = txtMacd.getText();
					String ten = txtTencd.getText();
					String gioitinh = jcbGT.getSelectedItem().toString() ;
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	
					String ngsinh = f.format(dateSinh.getDate());
					String cccd = txtCCCD.getText();
					String sdt = txtSDT.getText();	
					String ndk = f.format(dateDK.getDate());
					
					conn.themTrgphong( ma, ten, gioitinh,ngsinh,cccd,sdt,ndk,macanho);
					
					loadBang();
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				}
			}
		});
		btThem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\add.png"));
		btThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btThem.setBounds(773, 270, 137, 37);
		contentPane.add(btThem);
		
		JButton btSua = new JButton("Sửa");
		btSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn sửa thông tin căn hộ?") == JOptionPane.YES_OPTION) {
					try {
						String maCD = txtMacd.getText();
						String maCanHo = jcbPhong.getSelectedItem().toString() ;
						String ten = txtTencd.getText();
						String gioitinh = jcbGT.getSelectedItem().toString() ;
						SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	
						String ngsinh = f.format(dateSinh.getDate());
						String cccd = txtCCCD.getText();
						String sdt = txtSDT.getText();
						String ndk = f.format(dateDK.getDate());
						
						conn.suaCuDan(maCD,ten,gioitinh,ngsinh,cccd,sdt,ndk,maCanHo);
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
		btSua.setBounds(773, 334, 137, 37);
		contentPane.add(btSua);
		
		JButton btXoa = new JButton("Xóa");
		btXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin căn hộ?") == JOptionPane.YES_OPTION) {
					try {
						String maCD = txtMacd.getText();
						conn.xoaCuDan(maCD);
						
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
		btXoa.setBounds(773, 391, 137, 37);
		contentPane.add(btXoa);
		
//		JDateChooser dateSinh = new JDateChooser();
		dateSinh.setBounds(587, 270, 151, 25);
		contentPane.add(dateSinh);
		
//		JDateChooser dateDK = new JDateChooser();
		dateDK.setBounds(587, 381, 151, 25);
		contentPane.add(dateDK);
		
		
		combobox();
		
	}
	
//------------ĐỔ DỮ LIỆU LÊN COMBOBOX---------------------------
	
	public void combobox() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) jcbPhong.getModel();
		model.removeAllElements();
		try {
			Connection conn = Data.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select MACANHO from CanHo");
			while (rs.next()) {
				String maphong = rs.getString("MACANHO");
				jcbPhong.addItem(maphong);
			}
		} catch (Exception e) {
			System.out.println("2. Connected error");
		}
	}
}
