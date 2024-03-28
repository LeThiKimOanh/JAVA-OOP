package do_an1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectCuDan {
	private PreparedStatement pst = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	//SHow Cư Dân
	public ResultSet ShowCuDan() {
		try {
			Connection conn = Data.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CuDan1 ORDER BY MACUDAN");
			return rs;
			
		} catch (Exception e) {
	        e.printStackTrace();
		}
		return null;
	}
	
	//Thêm Cư Dân
	public void themCuDan( String macd, String tencd,String gt, String ngsinh,String cccd, String sdt, String ndk,String macanho ) {
		try {
			Connection conn = Data.getConnection();
			pst = conn.prepareStatement ("INSERT INTO CuDan1 VALUES(?,?,?,?,?,?,?,?)");
			
			pst.setString(1, macd);
			pst.setString(2, tencd);
			pst.setString(3, gt);
			pst.setString(4, ngsinh);
			pst.setString(5, cccd);
			pst.setString(6, sdt);
			pst.setString(7, ndk);
			pst.setString(8, macanho);
			
			pst.executeUpdate();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//Tìm Cư Dân
	public ResultSet timCuDan(String maCD) {
		try {
			Connection conn = Data.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT CuDan1.MACUDAN, TENCUDAN, GIOITINH,NGAYSINH, CCCD, SDT, NGAYDK, MACANHO FROM CuDan1 WHERE CuDan1.MACUDAN ='" + maCD + "'" );
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//Xóa Cư Dân
	public void xoaCuDan(String maCD) {
		try {
			Connection conn = Data.getConnection();
			String sql = "delete CuDan1 where MACUDAN = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, maCD);
			pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Sửa Cư dân
	public boolean suaCuDan(String maCD,String tenCD, String gioitinh, String ngaysinh, String cccd, String sdt,String ndk, String maCanHo) {
		try {
			Connection conn = Data.getConnection();
			String sql = "UPDATE CuDan1 set TENCUDAN = ?, GIOITINH = ?,NGAYSINH = ?, CCCD = ?, SDT = ?, NGAYDK = ?,MACANHO = ? where MACUDAN = ?";
			pst = conn.prepareStatement(sql);
			
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
