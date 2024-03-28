package do_an1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ThongTin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTin frame = new ThongTin();
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
	public ThongTin() {
		setTitle("Thông tin căn hộ");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\Da12.jpg"));
		lblNewLabel.setBounds(315, 83, 318, 315);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vị trí nằm bên cạnh đường bờ biển, thuận tiện du lịch");
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\\\Users\\\\Thuong's Laptop\\\\Pictures\\\\Saved Pictures\\\\icons8-double-tick.gif"));
		lblNewLabel_1.setBounds(10, 11, 485, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phòng rộng, thoáng mát, sạch sẽ,...");
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\icons8-double-tick.gif"));
		lblNewLabel_2.setBounds(10, 111, 373, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đảm bảo an ninh, an toàn trong khu chung cư");
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\icons8-double-tick.gif"));
		lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 43, 412, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Có hầm để xe, thang máy tiện nghi");
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Thuong's Laptop\\Pictures\\Saved Pictures\\icons8-double-tick.gif"));
		lblNewLabel_4.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 72, 366, 39);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(-5, 152, 330, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Giá Điện: 3000/số");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_5.setBackground(new Color(245, 255, 250));
		lblNewLabel_5.setForeground(new Color(139, 0, 0));
		lblNewLabel_5.setBounds(10, 21, 100, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Giá Nước: 7000/m3");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_6.setForeground(new Color(139, 0, 0));
		lblNewLabel_6.setBackground(new Color(139, 0, 0));
		lblNewLabel_6.setBounds(10, 46, 136, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Diện Tích 120m2 : 3.500.000/tháng");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_7.setForeground(new Color(139, 0, 0));
		lblNewLabel_7.setBounds(10, 71, 190, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Diện Tích 200m2 : 4.000.000/tháng");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_8.setForeground(new Color(139, 0, 0));
		lblNewLabel_8.setBounds(10, 92, 220, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Phí gửi phù hợp với từng loại phương tiện");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_9.setForeground(new Color(139, 0, 0));
		lblNewLabel_9.setBounds(10, 117, 233, 14);
		panel.add(lblNewLabel_9);
	}

}
