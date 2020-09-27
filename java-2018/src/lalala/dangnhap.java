package lalala;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class dangnhap extends JFrame implements ActionListener{
	JButton btnngNhp;
	JButton mat;
	JButton btnLmLi;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	protected String passwork = null;
	protected String user = null;
	boolean matt = false;
//------------------------------------------------------------------------------

	public dangnhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 252);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Đăng Nhập");
		
		JLabel lblChoMngBn = new JLabel("CHÀO MỪNG BẠN ĐÃ QUAY TRỞ LẠI");
		lblChoMngBn.setForeground(Color.BLUE);
		lblChoMngBn.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		lblChoMngBn.setBounds(60, 11, 289, 25);
		contentPane.add(lblChoMngBn);
		
		JLabel lblTnngNhp = new JLabel("    Tên đăng nhập");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnngNhp.setBounds(41, 47, 111, 25);
		contentPane.add(lblTnngNhp);
		
		JLabel lblMtKhu = new JLabel("      Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(41, 80, 111, 25);
		contentPane.add(lblMtKhu);
		
		textField = new JTextField();
		textField.setBounds(183, 47, 127, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		mat = new JButton("mat");
		mat.setBounds(316, 80, 37, 25);
		contentPane.add(mat);
		mat.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(183, 80, 127, 25);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
		
		btnngNhp = new JButton("Đăng nhập");
		btnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnngNhp.setBounds(211, 135, 95, 23);
		contentPane.add(btnngNhp);
		btnngNhp.addActionListener(this);
		
		btnLmLi = new JButton("Làm Lại");
		btnLmLi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLmLi.setBounds(97, 135, 95, 23);
		contentPane.add(btnLmLi);
		btnLmLi.addActionListener(this);
	}
	
	@Override//------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Đăng nhập")) {
			user=textField.getText();
			passwork = passwordField.getText();

		}
		if(e.getActionCommand().equals("mat") && matt == false) {
			passwordField.setEchoChar((char)0);
			System.out.println("mo");
			matt =true;
		}
		else if(e.getActionCommand().equals("mat") && matt == true) {
			passwordField.setEchoChar('*');
			matt =false;
			System.out.println("dong");
		}
		if(e.getActionCommand().equals("Làm Lại")){
			passwordField.setText(null);
			textField.setText(null);
			
		}	
	}
	public void ThongBao(String str) {
		JOptionPane.showMessageDialog(this, str);
	}

	protected String getPasswork() {
		return passwork;
	}

	protected void setPasswork(String passwork) {
		this.passwork = passwork;
	}

	protected String getUser() {
		return user;
	}

	protected void setUser(String user) {
		this.user = user;
	}
	
	//-------------------------------------------------------------------------------------

	

	
}
