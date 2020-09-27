package lalala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect
{	dangnhap dn = new dangnhap();
	Connection conn = null;
		public void Ketnoi()
		{
			
			String url = "jdbc:mysql://localhost:3306/quanly?verifyServerCertificate=false&useSSL=true";
			String username = "root";
			String password = "duysydeptrai";
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,username,password);
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("load driver khong thanh cong");	
			}
			catch (SQLException e) 
			{
				System.out.println("Loi: "+e.getMessage());
				
			}
		}
		public ResultSet showthongtin(String table) {
			ResultSet rs = null;
			String sql = "select * from " + table;
			Statement st;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println("loi \n" + e.toString());
			}
			return rs;
			
		}
		public void xoathongtin(String id,String tenid,String table){
			String sql = "delete from "+table+" where "+tenid+"="+id;
			
			Statement st;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
				dn.ThongBao("Bạn đã xóa thành công");
			} catch (SQLException e) {
				System.out.println("loi \n" + e.toString());
				dn.ThongBao(e.toString());
			}
			
			
		}
		
		public void capnhat(String sql) {
			Statement st;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				dn.ThongBao(e.toString());
				System.out.println("loi \n" + e.toString());
			}
		}
		public void themthongtinsanpham(String id,String tenThietBi,String phong,String tinhTrang,String hangSanXuat,String idql,String table) {
			String sql="insert into "+table+ " value( '"+id+"','"+tenThietBi+"','"+phong+"','"+tinhTrang+"','"+hangSanXuat+"','"+idql+"')";
			Statement st=null;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				dn.ThongBao(e.toString());
			}
		}
		
		public void themtaikhoan(String idql,String user,String passwork,String hoten,String sdt,String table) {
			String sql="insert into "+table+" value('"+idql+"','"+user+"','"+passwork+"','"+hoten+"','"+sdt+"')";
			Statement st=null;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
				dn.ThongBao("Tạo tài khoản thành công");
			} catch (SQLException e) {
				dn.ThongBao(e.toString());
			}
			
		}
		public boolean kiemtradangnhap(String user,String passwork,String table) {
			boolean check=false;
			Statement st;
			ResultSet rs = null;
			String sql="select * from "+table+" where user ="+"'"+user+"'"+" and passwork= "+"'"+passwork+"'";
			try {
				st=conn.createStatement();
				rs=st.executeQuery(sql);
			
				while(rs.next()) {
					if(rs.getString("user").equals(user) && rs.getString("passwork").equals(passwork)) {
						check = true;
					}
					else {
						check= false;
					}
				}
			} catch (SQLException e) {
				dn.ThongBao(e.toString());
			}
			return check;
		}
		
		
}

