package do_an1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectPhuongTien {
    private PreparedStatement pst = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//----SHOW PHUONG TIEN----
		public ResultSet ShowPT() {
			try {
				Connection conn = Data.getConnection();       //---KET NOI---
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM PhuongTien ORDER BY MACUDAN");
				return rs;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
	//-----THEM PHUONG TIEN----
		
		public void themPT( String maPT, String machu,String loaiPT, String phi ) {
			try {
				Connection conn = Data.getConnection();
				pst = conn.prepareStatement ("INSERT INTO PhuongTien VALUES(?,?,?,?)");
				
				pst.setString(1, maPT);
				pst.setString(2, machu);
				pst.setString(3, loaiPT);
				pst.setString(4, phi);
				
				pst.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	//------TÌM PHƯƠNG TIỆN------
		public ResultSet timPT(String maPT) {
			try {
				Connection conn = Data.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM PhuongTien WHERE MAPT ='" + maPT + "'" );
				return rs;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}
	//-----XÓA PHƯƠNG TIỆN-------
		public void xoaPT(String maPT) {
			try {
				Connection conn = Data.getConnection();
				String sql = "delete PhuongTien where MAPT = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, maPT);
				pst.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	//-----SỬA PHƯƠNG TIỆN---------
		public boolean suaPT(String maPT,String machu, String loaiPT, String phi) {
			try {
				Connection conn = Data.getConnection();
				String sql = "UPDATE PhuongTien set MACUDAN = ?,LOAIPT = ?, PHIGUI = ? where MAPT = ?";
				pst = conn.prepareStatement(sql);
				
				pst.setString(4,maPT);
				pst.setString(1, machu);
				pst.setString(2, loaiPT);
				pst.setString(3, phi);
				
				pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}
		
	
}

