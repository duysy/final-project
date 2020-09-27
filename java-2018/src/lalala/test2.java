package lalala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {

	public static void main(String[] args) {
		Connection conn = null;
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
		Statement st;
		String sql="update taikhoan set user='fsf',passwork='fdsf',hoten='fsdf',sdt='fdsf' where idql='1'";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			
			System.out.println("loi \n" + e.toString());
		}
	}
	

}
