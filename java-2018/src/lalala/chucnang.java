package lalala;

public class chucnang {
	public boolean dangnhap() {
		boolean check = false;
		dangnhap dn = new dangnhap();
		connect conn = new connect();
		conn.Ketnoi();
		while(!check) {
			dn.setVisible(true);
			if(dn.getUser() != null && dn.getPasswork() != null) {
				check=conn.kiemtradangnhap(dn.getUser(),dn.getPasswork(), "taikhoan");
				if(conn.kiemtradangnhap(dn.getUser(),dn.getPasswork(), "taikhoan") == false) {
					dn.ThongBao("hay nhap lai");
					dn.setUser(null);
					dn.setPasswork(null);
				}
				System.out.println(check);
				}
			}
		if(check = true) {
			dn.ThongBao("Ban da dang nhap thanh cong");
			dn.setVisible(false);
		
		}
		return check;
	}
	public boolean admin(String admin) {
		boolean check = false;
		connect conn = new connect();
		dangnhap dn = new dangnhap();
		conn.Ketnoi();
		if(admin != null) {
			check=conn.kiemtradangnhap("admin",admin, "taikhoan");
			if(conn.kiemtradangnhap("admin",admin, "taikhoan") == true) {
				check = true;
			}
			else {
				dn.ThongBao("Hay thu lai");
			}
			System.out.println(check);
			}
		
			
		
		return check;
	}
	

}
