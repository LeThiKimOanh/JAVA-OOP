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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DienNuoc extends JFrame {

	ConnectThanhToan conn = new ConnectThanhToan();
	
	private JPanel contentPane;
	private JTable tableDN;
	private JTextField txtdien;
	private JTextField txtnuoc;
	private JTextField txtphong;
	JComboBox jcbthang;
	
	String thang[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	
	//-----------hiển thị thông tiin lên bảng--------
		private void loadBang() {
				
				ResultSet rs = conn.HienThiDN();
				DefaultTableModel dtm = (DefaultTableModel) tableDN.getModel();
				dtm.setRowCount(0);

				
				try {
					while(rs.next()) {
		              Vector<Object> vec = new Vector<Object>();
		              vec.add(rs.getString("THANG"));
		              vec.add(rs.getString("TONGDIEN"));
		              vec.add(rs.getString("TONGNUOC"));
		              vec.add(rs.getString("SOPHONGSUDUNG"));
		             
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
					DienNuoc frame = new DienNuoc();
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
	public DienNuoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("THỐNG KÊ ĐIỆN NƯỚC");
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(191, 10, 184, 33);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 53, 597, 109);
		contentPane.add(scrollPane);
		
		tableDN = new JTable();
		tableDN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tableDN.getSelectedRow();
				if(row>=0) {
					
					jcbthang.setSelectedItem(tableDN.getValueAt(row,0).toString());
					txtdien.setText(tableDN.getValueAt(row,1).toString());
					txtnuoc.setText(tableDN.getValueAt(row,2).toString());
					txtphong.setText(tableDN.getValueAt(row,3).toString());
				}
			}
		});
		tableDN.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Tháng", "Tổng điện", "Tổng nước", "Số phòng sử dụng"
			}
		));
		tableDN.getColumnModel().getColumn(0).setPreferredWidth(55);
		scrollPane.setViewportView(tableDN);
		
		loadBang();
		
		JLabel lblNewLabel_1 = new JLabel("Tháng:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 191, 67, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng điện:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(186, 191, 81, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng nước:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(186, 227, 81, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số phòng đang sử dụng:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(186, 263, 170, 26);
		contentPane.add(lblNewLabel_1_3);
		
		txtdien = new JTextField();
		txtdien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtdien.setBounds(377, 191, 143, 25);
		contentPane.add(txtdien);
		txtdien.setColumns(10);
		
		txtnuoc = new JTextField();
		txtnuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtnuoc.setColumns(10);
		txtnuoc.setBounds(377, 227, 143, 25);
		contentPane.add(txtnuoc);
		
		txtphong = new JTextField();
		txtphong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtphong.setColumns(10);
		txtphong.setBounds(377, 263, 143, 25);
		contentPane.add(txtphong);
		
		jcbthang = new JComboBox(thang);
		jcbthang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jcbthang.setBounds(73, 195, 67, 22);
		contentPane.add(jcbthang);
	
//------------------------THÊM DỮ LIỆU LÊN BẢNG--------------------------
		
		JButton btThem = new JButton("CẬP NHẬT");
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật?") == JOptionPane.YES_OPTION) {
						String thang = jcbthang.getSelectedItem().toString() ;
						String dien = txtdien.getText();
						String nuoc = txtnuoc.getText();
						String phong = txtphong.getText();
						
						
						conn.themDN(thang,dien,nuoc,phong);
						loadBang();
						JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
					}
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
				}
			}
		});
		btThem.setForeground(new Color(60, 179, 113));
		btThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btThem.setBounds(534, 261, 121, 33);
		contentPane.add(btThem);
		
/*-----------ĐỔ DỮ LIỆU LÊN TEXTFIELD---------------------------------
-----------------------------------------------------------------------*/	
			try {
				Connection conn = Data.getConnection();
						
				Statement stm = conn.createStatement();
				String sql = "use doanjava\r\n"
						+ "select sum(SODIEN) as 'TONGDIEN',\r\n"
						+ "       sum(SONUOC) AS 'TONGNUOC',\r\n"
						+ " count(*) AS 'SOPHONGDUNG' \r\n"
						+ " FROM dbo.CanHo\r\n"
						+ " where TRANGTHAI = 'Có'\r\n"
						+ " ";
				PreparedStatement pre = conn.prepareStatement(sql);
				ResultSet rs = pre.executeQuery();
				
				if(rs.next()) {
				    txtdien.setText(rs.getString("TONGDIEN"));
					txtnuoc.setText(rs.getString("TONGNUOC"));
					txtphong.setText(rs.getString("SOPHONGDUNG"));
				}	
						
			} catch (Exception e1) {
				e1.printStackTrace();
			}  
	}
}
