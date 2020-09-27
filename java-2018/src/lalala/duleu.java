package lalala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class duleu {
	public Vector taikhoan() {
		connect con = new connect();
		con.Ketnoi();
		Vector datataikhoan = new Vector();
		ResultSet rs;
		rs=con.showthongtin("taikhoan");
		try {
			rs.next();
			while(rs.next()) {
				Vector row = new Vector(5);
				for(int i=1;i<6;i++) {
					if(i !=3 ) { // ch giau mat khau
						row.add(rs.getString(i));
					}
					else {
						row.add("khongcosan");
					}
				}
				datataikhoan.add(row);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datataikhoan;	
	}
	public Vector sanpham() {
		connect con = new connect();
		con.Ketnoi();
		Vector datasanpham = new Vector();
		ResultSet rs;
		rs=con.showthongtin("sanpham");
		try {
			while(rs.next()) {
				Vector<String> row = new Vector<String>();
				for(int i=1;i<7;i++) {
					row.add(rs.getString(i));
				}
				datasanpham.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return datasanpham;
		
	}
	public Vector titaikhoan() {
		Vector<String> titaikhoan = new Vector<String>();
		titaikhoan.clear();
		titaikhoan.add("idquanly");
		titaikhoan.add("user");
		titaikhoan.add("passwork");
		titaikhoan.add("hoten");
		titaikhoan.add("sdt");
		
		return titaikhoan;
		
	}
	public Vector tisanpham() {
		Vector<String> tisanpham = new Vector<String>();
		tisanpham.clear();
		tisanpham.add("id");
		tisanpham.add("hangsanxuat");
		tisanpham.add("tenthietbi");
		tisanpham.add("phong");
		tisanpham.add("tinhtrang");
		tisanpham.add("idquanly");
		return tisanpham;
		
	}



}
