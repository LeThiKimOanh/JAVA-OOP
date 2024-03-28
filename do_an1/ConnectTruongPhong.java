package do_an1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectTruongPhong {
	
	private PreparedStatement pst = null;
	private PreparedStatement pst1 = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
//---------------------SHOW TRUONG PHONG-----------------------
		public ResultSet ShowTrgphong() {
			try {
				Connection conn = Data.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM TRUONGPHONG ORDER BY MACUDAN");
				return rs;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		
//----------------------THEM TRUONG PHONG-----------------------------------
		public void themTrgphong( String macd, String tencd,String gt, String ngsinh,String cccd, String sdt, String ndk,String macanho ) {
			try {
				Connection conn = Data.getConnection();
				pst = conn.prepareStatement ("INSERT INTO TRUONGPHONG VALUES(?,?,?,?,?,?,?,?)");
				
				pst.setString(1, macd);
				pst.setString(2, tencd);
				pst.setString(3, gt);
				pst.setString(4, ngsinh);
				pst.setString(5, cccd);
				pst.setString(6, sdt);
				pst.setString(7, ndk);
				pst.setString(8, macanho);
				
				pst.executeUpdate();
				
				pst1 = conn.prepareStatement ("insert into DANGNHAP values (?,?,?)");
				pst1.setString(1, macd );
				pst1.setString(2, macd);
				pst1.setString(3, "cudan");
				
				pst1.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	
		}
		
//----------------------------TIM TRUONG PHONG------------------------------------------
		public ResultSet timTrgphong(String maCD) {
			try {
				Connection conn = Data.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT TRUONGPHONG.MACUDAN, TENCUDAN, GIOITINH,NGAYSINH, CCCD, SDT, NGAYDK, MACANHO FROM TRUONGPHONG WHERE TRUONGPHONG.MACUDAN ='" + maCD + "'" );
				return rs;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
//----------------------------XOA TRUONG PHONG---------------------------------------------
		public void xoaCuDan(String maCD) {
			try {
				Connection conn = Data.getConnection();
				String sql = "delete TRUONGPHONG where MACUDAN = ?";
				pst = conn.prepareStatement(sql);
				
				String sql1 = "delete DANGNHAP where TENDANGNHAP = ?";
				pst1 = conn.prepareStatement(sql1);
				
				pst.setString(1, maCD);
				pst.executeUpdate();
				
				pst1.setString(1, maCD);
				pst1.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//--------------------------SUA TRUONG PHONG--------------------------------------
		
		public boolean suaCuDan(String maCD,String tenCD, String gioitinh, String ngaysinh, String cccd, String sdt,String ndk, String maCanHo) {
			try {
				Connection conn = Data.getConnection();
				String sql = "UPDATE TRUONGPHONG set TENCUDAN = ?, GIOITINH = ?,NGAYSINH = ?, CCCD = ?, SDT = ?, NGAYDK = ?,MACANHO = ? where MACUDAN = ?";
				pst = conn.prepareStatement(sql);
				//stmt.setString()
				pst.setString(8,maCD);
				pst.setString(1, tenCD);
				pst.setString(2, gioitinh);
				pst.setString(3, ngaysinh);
				pst.setString(4, cccd);
				pst.setString(5, sdt);
				pst.setString(6, ndk);
				pst.setString(7, maCanHo);
				
				pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}
		
		
}
