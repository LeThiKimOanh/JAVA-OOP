package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

public class MainCuDan extends JFrame {

	ConnectCuDan conn = new ConnectCuDan();
	
	private JPanel contentPane;
	private JTable tableCD;
	private JTextField txtMaCD;
	private JTextField txtTenCD;
	private JTextField txtCCCD;
	private JTextField txtSDT;
	JComboBox<String> jcbGT, jcbPhong;
    String gt[] = {" ", "Nam", "Nữ"};
	
private void loadBang() {
		
		ResultSet rs = conn.ShowCuDan();
		DefaultTableModel dtm = (DefaultTableModel) tableCD.getModel();
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
					MainCuDan frame = new MainCuDan();
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
	public MainCuDan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CƯ DÂN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(341, 10, 163, 37);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 846, 163);
		contentPane.add(scrollPane);

//-------LỊCH----------------------------------------------------
		final	JDateChooser dateSinh = new JDateChooser();
		final	JDateChooser dateDK = new JDateChooser();
//---------------------------------------------------------------	
		
		tableCD = new JTable();
		tableCD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tableCD.getSelectedRow();
				if(row>=0) {
					txtMaCD.setText(tableCD.getValueAt(row,1).toString());
					txtTenCD.setText(tableCD.getValueAt(row,2).toString());
					jcbGT.setSelectedItem(tableCD.getValueAt(row,3).toString());
					try {
						java.util.Date d=new SimpleDateFormat("yyyy-MM-dd").parse((String)tableCD.getValueAt(row,4).toString());
							dateSinh.setDate(d);
						
						} catch (Exception e2) {
							// TODO: handle exception
						}
					txtCCCD.setText(tableCD.getValueAt(row,5).toString());
					txtSDT.setText(tableCD.getValueAt(row,6).toString());
					try {
						java.util.Date d=new SimpleDateFormat("yyyy-MM-dd").parse((String)tableCD.getValueAt(row,7).toString());
							dateDK.setDate(d);
						
						} catch (Exception e2) {
							// TODO: handle exception
						}
					jcbPhong.setSelectedItem(tableCD.getValueAt(row,0).toString());
				}
			}
		});
		tableCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tableCD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
					 "Ph\u00F2ng","M\u00E3 C\u01B0 D\u00E2n", "T\u00EAn C\u01B0 D\u00E2n", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "CCCD", "SDT", "Ng\u00E0y \u0110K"
			}
		));
		scrollPane.setViewportView(tableCD);
		
	loadBang();
		
		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN CƯ DÂN");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(36, 226, 192, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Cư Dân:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 308, 94, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phòng:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(10, 265, 84, 29);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên Cư Dân:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(10, 353, 100, 29);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Giới Tính:");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(10, 392, 84, 29);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ngày Sinh:");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_4.setBounds(470, 269, 84, 29);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("CCCD:");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_5.setBounds(470, 308, 84, 29);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("SĐT:");
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_6.setBounds(470, 347, 84, 29);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Ngày ĐK:");
		lblNewLabel_2_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_7.setBounds(470, 392, 84, 29);
		contentPane.add(lblNewLabel_2_7);
		
		txtMaCD = new JTextField();
		txtMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaCD.setBounds(125, 308, 171, 29);
		contentPane.add(txtMaCD);
		txtMaCD.setColumns(10);
		
		txtTenCD = new JTextField();
		txtTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtTenCD.setColumns(10);
		txtTenCD.setBounds(125, 353, 171, 29);
		contentPane.add(txtTenCD);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(564, 308, 171, 29);
		contentPane.add(txtCCCD);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(564, 347, 171, 29);
		contentPane.add(txtSDT);
		
		jcbGT = new JComboBox(gt);
		jcbGT.setBounds(125, 393, 73, 29);
		contentPane.add(jcbGT);
		
	    jcbPhong = new JComboBox();
		jcbPhong.setBounds(125, 265, 171, 29);
		contentPane.add(jcbPhong);
		
///	final	JDateChooser dateSinh = new JDateChooser();
		dateSinh.setBounds(564, 265, 171, 29);
		contentPane.add(dateSinh);
		
///	final	JDateChooser dateDK = new JDateChooser();
		dateDK.setBounds(564, 392, 171, 29);
		contentPane.add(dateDK);
		
		JButton btTimKiem = new JButton("Tìm Kiếm");
		btTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				    String maCD = txtMaCD.getText();
					ResultSet rs = conn.timCuDan(maCD);
					DefaultTableModel dtm = (DefaultTableModel) tableCD.getModel();
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
		btTimKiem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\find.png"));
		btTimKiem.setForeground(Color.BLUE);
		btTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btTimKiem.setBounds(109, 449, 146, 41);
		contentPane.add(btTimKiem);
		
		JButton btTroLai = new JButton("Trở Lại");
		btTroLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBang();
			}
		});
		btTroLai.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\Reset.png"));
		btTroLai.setForeground(Color.BLUE);
		btTroLai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btTroLai.setBounds(399, 449, 133, 41);
		contentPane.add(btTroLai);
		
		JButton btThem = new JButton("Thêm");
		btThem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\add.png"));
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm căn hộ mới?") == JOptionPane.YES_OPTION) {
					String macanho = jcbPhong.getSelectedItem().toString() ;
					String ma = txtMaCD.getText();
					String ten = txtTenCD.getText();
					String gioitinh = jcbGT.getSelectedItem().toString() ;
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	
					String ngsinh = f.format(dateSinh.getDate());
					String cccd = txtCCCD.getText();
					String sdt = txtSDT.getText();	
					String ndk = f.format(dateDK.getDate());
					
					conn.themCuDan( ma, ten, gioitinh,ngsinh,cccd,sdt,ndk,macanho);
					
					loadBang();
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				}
			}
		});
		btThem.setForeground(Color.BLUE);
		btThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btThem.setBounds(109, 500, 146, 37);
		contentPane.add(btThem);
		
		JButton btSua = new JButton("Sửa");
		btSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn sửa thông tin căn hộ?") == JOptionPane.YES_OPTION) {
					try {
						String maCD = txtMaCD.getText();
						String maCanHo = jcbPhong.getSelectedItem().toString() ;
						String ten = txtTenCD.getText();
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
		btSua.setForeground(Color.BLUE);
		btSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btSua.setBounds(399, 500, 133, 37);
		contentPane.add(btSua);
		
		JButton btXoa = new JButton("Xóa");
		btXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin căn hộ?") == JOptionPane.YES_OPTION) {
					try {
						String maCD = txtMaCD.getText();
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
		btXoa.setForeground(Color.BLUE);
		btXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btXoa.setBounds(650, 500, 133, 37);
		contentPane.add(btXoa);
		
		JButton btClean = new JButton("Clean");
		btClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaCD.setText("");
				jcbPhong.setToolTipText("");
				txtTenCD.setText("");
				txtCCCD.setText("");
				txtSDT.setText("");
				jcbGT.setToolTipText(gt[0]);
				dateSinh.setToolTipText("");
				dateDK.setToolTipText("");
				
			}
		});
		btClean.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\clean.png"));
		btClean.setForeground(Color.BLUE);
		btClean.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btClean.setBounds(650, 449, 133, 39);
		contentPane.add(btClean);
		
		JLabel lblNewLabel_3 = new JLabel("Chung cư Thương Oanh");
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblNewLabel_3.setBounds(333, 543, 221, 17);
		contentPane.add(lblNewLabel_3);
		
		combobox();
	
	}
	
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
		    e.printStackTrace();
		}
	}
}
