package do_an1;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import do_an1.Data;

public class ConnectCanHo {

		
		private PreparedStatement pst = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		
		
		// show Căn Hộ
		public ResultSet ShowCanHo() {
			try {
				Connection conn = Data.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT CanHo.MACANHO,SODAY, TENCHUHO,TRANGTHAI,DIENTICH,SONGUOI,SODIEN,SONUOC  FROM CanHo ORDER BY CanHo.MACANHO");
				return rs;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// Thêm Căn Hộ
		public void themCanHo(String ma,String  day, String ten, String trangthai, String dt, int songuoi,int sodien, int sonuoc) {
			try {
				Connection conn = Data.getConnection();
					pst = conn.prepareStatement("INSERT INTO CanHo VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
					pst.setString(1, ma);
					pst.setString(2, day);
					pst.setString(3, ten);
					pst.setString(4, trangthai);
					pst.setString(5, dt);
					pst.setInt(6, songuoi);
					pst.setInt(7, sodien);
					pst.setInt(8, sonuoc);
					
					pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Xóa Căn Hộ
		public void xoaCanHo(String ma) {
			try {
				Connection conn = Data.getConnection();
				String sql1 = "DELETE from CanHo where MACANHO = ?;";
				PreparedStatement pst = conn.prepareStatement(sql1);
				pst.setString(1, ma);
				pst.executeUpdate();
			    //con.close();
			    //System.out.println("DELETED OK!");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Sửa Căn Hộ
		public boolean suaCanHo(String ma,String  day, String ten, String trangthai, String dt, int songuoi,int sodien, int sonuoc) {
			try {
				Connection conn = Data.getConnection();
				String sql = "UPDATE CanHo set SODAY = ?, TENCHUHO = ?, TRANGTHAI = ?,DIENTICH = ?, SONGUOI = ?, SODIEN = ?, SONUOC = ? where MACANHO = ?";
				PreparedStatement pst = conn.prepareStatement(sql);
				//stmt.setString()
				pst.setString(8,ma);
				pst.setString(1, day);
				pst.setString(2, ten);
				pst.setString(3, trangthai);
				pst.setString(4, dt);
				pst.setInt(5, songuoi);
				pst.setInt(6, sodien);
				pst.setInt(7, sonuoc);
				
				pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		//Tìm kiếm Căn Hộ
		public  ResultSet timCanHo(String ma) {
			try {
				Connection conn = Data.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT CanHo.MACANHO, SODAY, TENCHUHO, TRANGTHAI, DIENTICH, SONGUOI, SODIEN, SONUOC FROM CanHo WHERE MACANHO ='" + ma + "'" );

			return rs;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		
		

}
