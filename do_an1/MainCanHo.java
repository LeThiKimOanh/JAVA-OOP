package do_an1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

public class MainCanHo extends JFrame {
    
	ConnectCanHo conn = new ConnectCanHo();
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtPhong;
	private JTextField txtTen;
	private JTextField txtNuoc;
	private JTextField txtDien;
	private JTextField txtNguoiO;
    JComboBox jcbTT, jcbDay, jcbDT ;
    
	String day[] = {" ","1","2","3","4","5"};
	String dt[] = {" ","120","200"};
	String tt[] = {" ","Có", "Không"};
	
private void loadBang() {
		
		ResultSet rs = conn.ShowCanHo();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		
		try {
			while(rs.next()) {
              Vector<Object> vec = new Vector<Object>();
              vec.add(rs.getString("MACANHO"));
              vec.add(rs.getString("SODAY"));
              vec.add(rs.getString("TENCHUHO"));
              vec.add(rs.getString("TRANGTHAI"));
              vec.add(rs.getString("DIENTICH"));
              vec.add(rs.getString("SONGUOI"));
              vec.add(rs.getString("SODIEN"));
              vec.add(rs.getString("SONUOC"));
              
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
					MainCanHo frame = new MainCanHo();
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
	public MainCanHo() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" CĂN HỘ ");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(310, 0, 199, 42);
		contentPane.add(lblNewLabel);
		
		jcbTT = new JComboBox(tt);
		jcbTT.setBounds(106, 339, 159, 23);
		contentPane.add(jcbTT);
		
		jcbDay = new JComboBox(day);
		jcbDay.setBounds(106, 230, 159, 23);
		contentPane.add(jcbDay);
		
	    jcbDT = new JComboBox(dt);
		jcbDT.setBounds(538, 230, 159, 23);
		contentPane.add(jcbDT);
		
		
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				if(row>=0) {
					txtPhong.setText(table.getValueAt(row,0).toString());
					jcbDay.setSelectedItem(table.getValueAt(row,1).toString());
					txtTen.setText(table.getValueAt(row,2).toString());
					jcbTT.setSelectedItem(table.getValueAt(row,3).toString());
					jcbDT.setSelectedItem(table.getValueAt(row,4).toString());
					txtNguoiO.setText(table.getValueAt(row,5).toString());
					txtDien.setText(table.getValueAt(row,6).toString());
					txtNuoc.setText(table.getValueAt(row,7).toString());
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Ph\u00F2ng", "D\u00E3y", "H\u1ECD T\u00EAn", "Tr\u1EA1ng Th\u00E1i", "Di\u1EC7n T\u00EDch(m2)", "S\u1ED1 Ng\u01B0\u1EDDi", "S\u1ED1 \u0110i\u1EC7n", "S\u1ED1 N\u01B0\u1EDBc"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setPreferredWidth(47);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.getColumnModel().getColumn(7).setPreferredWidth(70);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 42, 739, 144);
		contentPane.add(scrollPane);
		
		loadBang();
		
		JButton btSua = new JButton("Sửa");
		btSua.setForeground(new Color(0, 100, 0));
		btSua.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\edit.png"));
		btSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn sửa thông tin căn hộ?") == JOptionPane.YES_OPTION) {
				try {
					String day = jcbDay.getSelectedItem().toString() ;
					String ma = txtPhong.getText();
					String ten = txtTen.getText();
					String trangthai = jcbTT.getSelectedItem().toString() ;
					String dt = jcbDT.getSelectedItem().toString() ;
					int songuoi = Integer.parseInt(txtNguoiO.getText());
					int sodien = Integer.parseInt(txtDien.getText());
					int sonuoc = Integer.parseInt(txtNuoc.getText());
					
					conn.suaCanHo(ma,day,ten,trangthai,dt,songuoi,sodien,sonuoc);
					loadBang();
					JOptionPane.showMessageDialog(null, "Sửa thành công!");
		
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				}
			}
		});
		btSua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btSua.setBounds(326, 425, 129, 39);
		contentPane.add(btSua);
		
		JButton btXoa = new JButton("Xóa");
		btXoa.setForeground(new Color(0, 100, 0));
		btXoa.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\delete.png"));
		btXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin căn hộ?") == JOptionPane.YES_OPTION) {
				try {
					String ma = txtPhong.getText();
					conn.xoaCanHo(ma);
					
					loadBang();
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}}
		});
		btXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btXoa.setBounds(533, 425, 122, 39);
		contentPane.add(btXoa);
		
		JButton btThem = new JButton("Thêm");
		btThem.setForeground(new Color(0, 100, 0));
		btThem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\add.png"));
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm căn hộ mới?") == JOptionPane.YES_OPTION) {
				String day = jcbDay.getSelectedItem().toString() ;
				String ma = txtPhong.getText();
				String ten = txtTen.getText();
				String trangthai = jcbTT.getSelectedItem().toString() ;
				String dt = jcbDT.getSelectedItem().toString() ;
				int songuoi = Integer.parseInt(txtNguoiO.getText());
				int sodien = Integer.parseInt(txtDien.getText());
				int sonuoc = Integer.parseInt(txtNuoc.getText());
				conn.themCanHo(ma, day, ten, trangthai,dt,songuoi,sodien, sonuoc);
		
				loadBang();
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				}
				
			
			}
		});
		btThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btThem.setBounds(98, 421, 148, 43);
		contentPane.add(btThem);
		
		JLabel lblNewLabel_2 = new JLabel("Chung cư Thương Oanh");
		lblNewLabel_2.setForeground(Color.MAGENTA);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(296, 477, 159, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btTim = new JButton("Tìm Kiếm");
		btTim.setForeground(new Color(0, 100, 0));
		btTim.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\find.png"));
		btTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					    String ma = txtPhong.getText();
						ResultSet rs = conn.timCanHo(ma);
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						dtm.setRowCount(0);	
							try {
							 while(rs.next()) {
				                 Vector<Object> vec = new Vector<Object>();
				                 vec.add(rs.getString("MACANHO"));
				                 vec.add(rs.getString("SODAY"));
				                 vec.add(rs.getString("TENCHUHO"));
				                 vec.add(rs.getString("TRANGTHAI"));
				                 vec.add(rs.getString("DIENTICH"));
				                 vec.add(rs.getString("SONGUOI"));
				                 vec.add(rs.getString("SODIEN"));
				                 vec.add(rs.getString("SONUOC"));
				                 dtm.addRow(vec);
							    }
							} catch (SQLException e1) { 
									e1.printStackTrace();
							}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Không tìm được!");
					}
	       }
			
		});
		btTim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btTim.setBounds(100, 372, 146, 39);
		contentPane.add(btTim);
		
		JButton btTroLai = new JButton("Trở lại");
		btTroLai.setForeground(new Color(0, 100, 0));
		btTroLai.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\Reset.png"));
		btTroLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBang();
			}
		});
		btTroLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btTroLai.setBounds(326, 372, 129, 39);
		contentPane.add(btTroLai);
		
		
		JButton btClean = new JButton("Clean");
		btClean.setForeground(new Color(0, 100, 0));
		btClean.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\clean.png"));
		btClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPhong.setText("");
				txtTen.setText("");
				txtNguoiO.setText("");
				txtDien.setText("");
				txtNuoc.setText("");
			}
		});
		btClean.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btClean.setBounds(533, 372, 122, 39);
		contentPane.add(btClean);
		
		
		JLabel lblNewLabel_3 = new JLabel("THÔNG TIN PHÒNG");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(10, 196, 225, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dãy");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(20, 226, 50, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phòng: ");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(20, 265, 62, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtPhong = new JTextField();
		txtPhong.setColumns(10);
		txtPhong.setBounds(106, 267, 159, 26);
		contentPane.add(txtPhong);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(106, 303, 159, 26);
		contentPane.add(txtTen);
		
		txtNuoc = new JTextField();
		txtNuoc.setColumns(10);
		txtNuoc.setBounds(538, 338, 159, 26);
		contentPane.add(txtNuoc);
		
		txtDien = new JTextField();
		txtDien.setColumns(10);
		txtDien.setBounds(538, 303, 159, 26);
		contentPane.add(txtDien);
		
		txtNguoiO = new JTextField();
		txtNguoiO.setColumns(10);
		txtNguoiO.setBounds(538, 263, 159, 26);
		contentPane.add(txtNguoiO);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Số điện(kWh):");
		lblNewLabel_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1_3.setBounds(423, 301, 105, 26);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Số nước(m3):");
		lblNewLabel_1_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1_4.setBounds(423, 336, 105, 26);
		contentPane.add(lblNewLabel_1_1_1_4);
		
		JLabel lblNewLabel_1_1_1_5 = new JLabel("Họ tên:");
		lblNewLabel_1_1_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1_5.setBounds(20, 301, 62, 26);
		contentPane.add(lblNewLabel_1_1_1_5);
		
		JLabel tf5 = new JLabel("Diện tích(m2):");
		tf5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tf5.setBounds(423, 227, 104, 26);
		contentPane.add(tf5);
		
		JLabel tf4 = new JLabel("Trạng Thái");
		tf4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tf4.setBounds(20, 337, 75, 26);
		contentPane.add(tf4);
		
		
		JLabel lblNewLabel_1_1_1_5_1_1 = new JLabel("Số người ở:");
		lblNewLabel_1_1_1_5_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1_5_1_1.setBounds(423, 265, 86, 26);
		contentPane.add(lblNewLabel_1_1_1_5_1_1);
		
	
	}
}
