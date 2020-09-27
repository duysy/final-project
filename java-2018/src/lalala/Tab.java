package lalala;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tab extends JFrame implements ActionListener{

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
	private JLabel lblIdQuanLy;
	private JTextField textField_5;
	public String id;
	
	
	public Tab(String Tab,String id) {
		this.id=id;
		setBounds(100, 100, 424, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		pn1.setLayout(new GridLayout(6,2));
		this.setTitle("Them tai khoan");
		
		JLabel lblNewLabel_4 = new JLabel("ID Sản phẩm");
		pn1.add(lblNewLabel_4);
		
		textField = new JTextField();
		pn1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tên thiết bị");
		pn1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		pn1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phòng");
		pn1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		pn1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tình trạng");
		pn1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		pn1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hãng sản xuất");
		pn1.add(lblNewLabel);
		
		textField_4 = new JTextField();
		pn1.add(textField_4);
		textField_4.setColumns(10);
		
		lblIdQuanLy = new JLabel("ID Quản lý");
		pn1.add(lblIdQuanLy);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		pn1.add(textField_5);
		//-----------button----------------
		btnNewButton = new JButton("Làm Lại");
		pn.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_2 = new JButton("Thoát");
		pn.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		if(Tab.equals("Them")) {
			btnNewButton_1 = new JButton("Thêm");
			pn.add(btnNewButton_1);
			btnNewButton_1.addActionListener(this);
			this.setTitle("Thêm Thiết Bị");
		}
		else if(Tab.equals("Cap Nhat")){
			btnNewButton_1 = new JButton("Cập Nhật");
			pn.add(btnNewButton_1);
			btnNewButton_1.addActionListener(this);
			this.setTitle("Cập nhật thiết bị");
		}
		
		contentPane.add(pn1);
		contentPane.add(pn);
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Làm Lại")) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
		}
		//========them==================================				
		if(e.getActionCommand().equals("Thêm")) {
			connect conn = new connect();
			conn.Ketnoi();
			conn.themthongtinsanpham(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(),textField_5.getText(),"sanpham");
			this.setVisible(false);
		}
		if(e.getActionCommand().equals("Cập Nhật")) {
			textField.setEditable(false);
			connect conn = new connect();
			conn.Ketnoi();
			Vector<String> thaydoinhap = new Vector<String>();
			Vector<String> thaydoitit = new Vector<String>();
			String set="update sanpham set ";
			if(!textField.getText().equals("")) {   thaydoinhap.add(textField.getText());thaydoitit.add("id");}
			if(!textField_1.getText().equals("")) {   thaydoinhap.add(textField_1.getText());thaydoitit.add("tenThietBi");}
			if(!textField_2.getText().equals("")) {   thaydoinhap.add(textField_2.getText());thaydoitit.add("phong");}
			if(!textField_3.getText().equals("")) {   thaydoinhap.add(textField_3.getText());thaydoitit.add("tinhTrang");}
			if(!textField_4.getText().equals("")) {   thaydoinhap.add(textField_4.getText());thaydoitit.add("hangSanXuat");}
			if(!textField_5.getText().equals("")) {   thaydoinhap.add(textField_5.getText());thaydoitit.add("idql");}
			for(int i=0;i<thaydoitit.size()-1;i++) {
				set=set+thaydoitit.get(i)+"='"+thaydoinhap.get(i)+"',";
			}
			set=set+thaydoitit.get(thaydoitit.size()-1)+"='"+thaydoinhap.get(thaydoinhap.size()-1)+"' where id='"+id+"'";
			System.out.println(set);
			conn.capnhat(set);
			this.setVisible(false);
		}
		if(e.getActionCommand().equals("Thoát")) {
			this.setVisible(false);
		}
	}
	
}
