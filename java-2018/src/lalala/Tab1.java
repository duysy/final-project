package lalala;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tab1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel pn = new JPanel();
	private JPanel pn1 = new JPanel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	public String id;
	
	public Tab1(String Tabl,String id) {
		this.id=id;
		setBounds(100, 100, 424, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		pn1.setLayout(new GridLayout(5,2));
		
		
		JLabel lblNewLabel_4 = new JLabel("Id Quản lý");
		pn1.add(lblNewLabel_4);
		
		textField = new JTextField();
		pn1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("User");
		pn1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		pn1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Passwork");
		pn1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		pn1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên");
		pn1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		pn1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số điện thoại");
		pn1.add(lblNewLabel);
		
		textField_4 = new JTextField();
		pn1.add(textField_4);
		textField_4.setColumns(10);
		//-----------button----------------
		btnNewButton = new JButton("làm lại");
		pn.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_2 = new JButton("Thoát");
		pn.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		if(Tabl.equals("Them")) {
			btnNewButton_1 = new JButton("Thêm");
			pn.add(btnNewButton_1);
			btnNewButton_1.addActionListener(this);
			this.setTitle("Thêm tài khoản");
		}
		else if(Tabl.equals("Cap Nhat")){
			btnNewButton_1 = new JButton("Cập Nhật");
			pn.add(btnNewButton_1);
			btnNewButton_1.addActionListener(this);
			this.setTitle("Cập nhật tài khoản");
		}
		
		
		
		contentPane.add(pn1);
		contentPane.add(pn);
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Làm Lại")) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
		}
		if(e.getActionCommand().equals("Thêm")) {
			connect conn = new connect();
			dangnhap dn = new dangnhap();
			conn.Ketnoi();
			conn.themtaikhoan(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(),"taikhoan");
			this.setVisible(false);
		}
		if(e.getActionCommand().equals("Cập Nhật")) {
			textField.setEditable(false);
			connect conn = new connect();
			conn.Ketnoi();
			dangnhap dn = new dangnhap();
			dn.ThongBao("CHi co admin moi sua duoc ok");
			chucnang cn = new chucnang();
			if(cn.admin(JOptionPane.showInputDialog("nhap mat khau admin")) == true) {
				Vector<String> thaydoinhap = new Vector<String>();
				Vector<String> thaydoitit = new Vector<String>();
				String set="update taikhoan set ";
				if(!textField.getText().equals("")) {   thaydoinhap.add(textField.getText());thaydoitit.add("idql");}
				if(!textField_1.getText().equals("")) {   thaydoinhap.add(textField_1.getText());thaydoitit.add("user");}
				if(!textField_2.getText().equals("")) {   thaydoinhap.add(textField_2.getText());thaydoitit.add("passwork");}
				if(!textField_3.getText().equals("")) {   thaydoinhap.add(textField_3.getText());thaydoitit.add("hoten");}
				if(!textField_4.getText().equals("")) {   thaydoinhap.add(textField_4.getText());thaydoitit.add("sdt");}
				System.out.println(!textField_1.getText().equals(""));
				for(int i=0;i<thaydoitit.size()-1;i++) {
					set=set+thaydoitit.get(i)+"='"+thaydoinhap.get(i)+"',";
				}
				set=set+thaydoitit.get(thaydoitit.size()-1)+"='"+thaydoinhap.get(thaydoinhap.size()-1)+"' where idql='"+id+"'";
				System.out.println(set);
				conn.capnhat(set);
				this.setVisible(false);
			}
		}
		else {
			dangnhap dn = new dangnhap();
			dn.ThongBao("tam biet ban khong phai admin");
			this.setVisible(false);
		}
					
		
		if(e.getActionCommand().equals("Thoát")) {
			this.setVisible(false);
		}
		
	}

}
