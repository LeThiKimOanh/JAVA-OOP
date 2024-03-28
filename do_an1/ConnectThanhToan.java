package do_an1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectThanhToan {

	    private PreparedStatement pst = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		
		
		//-----THÊM HÓA ĐƠN----
		
		    public void themHD( String thang, String maHD,String phong, String tiendien,String tiennuoc, String tienphong, String guixe, String tong, String trthai ) {
					try {
						Connection conn = Data.getConnection();
						pst = conn.prepareStatement ("INSERT INTO THANHTOAN VALUES(?,?,?,?,?,?,?,?,?)");
						
						pst.setString(1, thang);
						pst.setString(2, maHD);
						pst.setString(3, phong);
						pst.setString(4, tiendien);
						pst.setString(5, tiennuoc);
						pst.setString(6, tienphong);
						pst.setString(7, guixe);
						pst.setString(8, tong);
						pst.setString(9, trthai);
						
						pst.executeUpdate();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
		    

			//----SHOW THANH TOAN----
				public ResultSet ShowHD() {
					try {
						Connection conn = Data.getConnection();
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM THANHTOAN ORDER BY THANG");
						return rs;
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return null;
				}
				
			//------TÌM HÓA ĐƠN------
				public ResultSet timHD(String thang) {
					try {
						Connection conn = Data.getConnection();
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM THANHTOAN WHERE THANG ='" + thang + "'" );
						return rs;
					}catch (Exception e) {
						e.printStackTrace();
					}
					return null;
					
				}
				
				//----SHOW DIEN NUOC----
				public ResultSet HienThiDN() {
					try {
						Connection conn = Data.getConnection();
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM DIENNUOC ORDER BY THANG");
						return rs;
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return null;
				}
				
				//-----THÊM DIEN NUOC----
				
			    public void themDN( String thang, String dien,String nuoc, String phong) {
						try {
							Connection conn = Data.getConnection();
							pst = conn.prepareStatement ("INSERT INTO DIENNUOC VALUES(?,?,?,?)");
							
							pst.setString(1, thang);
							pst.setString(2, dien);
							pst.setString(3, nuoc);
							pst.setString(4, phong);
							
							
							pst.executeUpdate();
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
}
