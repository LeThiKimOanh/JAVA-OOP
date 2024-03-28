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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MainThanhToan extends JFrame {
    
	ConnectThanhToan conn = new ConnectThanhToan();
	
	private JPanel contentPane;
	private JTable tableHD;
	JComboBox jcbThang; 

	
	
//-----------hiển thị thông tiin lên bảng--------
	private void loadBang() {
			
			ResultSet rs = conn.ShowHD();
			DefaultTableModel dtm = (DefaultTableModel) tableHD.getModel();
			dtm.setRowCount(0);

			
			try {
				while(rs.next()) {
	              Vector<Object> vec = new Vector<Object>();
	              vec.add(rs.getString("THANG"));
	              vec.add(rs.getString("MAHD"));
	              vec.add(rs.getString("MACANHO"));
	              vec.add(rs.getString("TIENDIEN"));
	              vec.add(rs.getString("TIENNUOC"));
	              vec.add(rs.getString("TIENPHONG"));
	              vec.add(rs.getString("GUIXE"));
	              vec.add(rs.getString("TONG"));
	              vec.add(rs.getString("TRANGTHAI"));
	             
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
					MainThanhToan frame = new MainThanhToan();
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
	public MainThanhToan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANH TOÁN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(332, 0, 216, 43);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 806, 186);
		contentPane.add(scrollPane);
		
		tableHD = new JTable();
		tableHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Th\u00E1ng", "M\u00E3 HD", "Ph\u00F2ng", "Ti\u1EC1n \u0111i\u1EC7n", "Ti\u1EC1n n\u01B0\u1EDBc", "Ti\u1EC1n ph\u00F2ng", "G\u1EEDi xe", "T\u1ED5ng", "Tr\u1EA1ng th\u00E1i"
			}
		));
		tableHD.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableHD.getColumnModel().getColumn(1).setPreferredWidth(68);
		tableHD.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableHD.getColumnModel().getColumn(7).setPreferredWidth(82);
		tableHD.getColumnModel().getColumn(8).setPreferredWidth(100);
		scrollPane.setViewportView(tableHD);
		
		loadBang();
		
		JLabel lbtimkiem = new JLabel("Tìm kiếm theo tháng:");
		lbtimkiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                 try {
					
				    String thang = jcbThang.getSelectedItem().toString() ;
					ResultSet rs = conn.timHD(thang);
					DefaultTableModel dtm = (DefaultTableModel) tableHD.getModel();
					dtm.setRowCount(0);	
						try {
							
						 while(rs.next()) {
			                 Vector<Object> vec = new Vector<Object>();
			                 
			                  vec.add(rs.getString("THANG"));
				              vec.add(rs.getString("MAHD"));
				              vec.add(rs.getString("MACANHO"));
				              vec.add(rs.getString("TIENDIEN"));
				              vec.add(rs.getString("TIENNUOC"));
				              vec.add(rs.getString("TIENPHONG"));
				              vec.add(rs.getString("GUIXE"));
				              vec.add(rs.getString("TONG"));
				              vec.add(rs.getString("TRANGTHAI"));
			              
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
		lbtimkiem.setForeground(new Color(0, 0, 255));
		lbtimkiem.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbtimkiem.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\find.png"));
		lbtimkiem.setBounds(40, 279, 210, 37);
		contentPane.add(lbtimkiem);
		
		JLabel lbtrolai = new JLabel("");
		lbtrolai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadBang();
			}
		});
		lbtrolai.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\TROLAI.png"));
		lbtrolai.setBounds(361, 279, 37, 37);
		contentPane.add(lbtrolai);
		
	    jcbThang = new JComboBox();
		jcbThang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jcbThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		jcbThang.setBounds(269, 282, 65, 28);
		contentPane.add(jcbThang);
		
	}
}
