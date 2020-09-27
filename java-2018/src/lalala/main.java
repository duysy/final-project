package lalala;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check = false;
		chucnang cn = new chucnang();
		while(!check) {
			check = cn.dangnhap();
		}
		System.out.println(check+"  Dang nhap thanh cong");
		trangchinh cc = new trangchinh();
		cc.setVisible(true);
		
	}

}
