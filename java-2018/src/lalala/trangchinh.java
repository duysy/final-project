package lalala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

public class trangchinh extends JFrame implements ActionListener,MouseListener, ChangeListener {

	private JPanel contentPane;
	JTabbedPane tabbedPane;
	JMenuBar menuBar;
	JPanel jpbutton = new JPanel();
	DefaultTableModel modelsanpham;
	DefaultTableModel modeltaikhoan;
	private JTable tablesanpham ;
	private JTable tabletaikhoan ;
	JScrollPane scrollPane;
	JScrollPane scrollPane2;
	duleu dl = new duleu();
	public int selectrow =0;
	public int sudungtab=0;
	public String id;
	connect conn = new connect();
	public void load() {
		tabbedPane.removeAll();
		modelsanpham= new DefaultTableModel(dl.sanpham(),dl.tisanpham());
		tablesanpham = new JTable(modelsanpham);
		scrollPane = new JScrollPane(tablesanpham);
		tablesanpham.addMouseListener(this);
		tabbedPane.add("San Pham", scrollPane);
		// bang taikhoan
		modeltaikhoan= new DefaultTableModel(dl.taikhoan(),dl.titaikhoan());
		tabletaikhoan = new JTable(modeltaikhoan);
		scrollPane2 = new JScrollPane(tabletaikhoan);
		tabletaikhoan.addMouseListener(this);
		tabbedPane.add("Tai Khoan", scrollPane2);
		tabbedPane.addChangeListener(this);
	}
	public trangchinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//============================================================
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 223, 21);
		contentPane.add(menuBar,BorderLayout.NORTH);
		//--------------------------
		JMenu mnFile = new JMenu("file");
		mnFile.addActionListener(this);
		menuBar.add(mnFile);
		
		
		JMenu mnThongtin = new JMenu("Thông Tin");
		mnThongtin.addActionListener(this);
		mnFile.add(mnThongtin);
		
		JMenuItem mntmNhaTruong = new JMenuItem("Nhà Trường");
		mntmNhaTruong.addActionListener(this);
		mnThongtin.add(mntmNhaTruong);
		
		JMenuItem mntmHocSinh = new JMenuItem("Học Sinh");
		mntmHocSinh.addActionListener(this);
		mnThongtin.add(mntmHocSinh);
		//-------------------------------------------------
		
		JMenu mnCheDo = new JMenu("Chế Độ");
		mnCheDo.addActionListener(this);
		menuBar.add(mnCheDo);
		
		JMenuItem mntmToi = new JMenuItem("Tối");
		mntmToi.addActionListener(this);
		mnCheDo.add(mntmToi);
		
		JMenuItem mntmSang = new JMenuItem("Sáng");
		mntmSang.addActionListener(this);
		mnCheDo.add(mntmSang);
		
		JMenuItem mntmXanh = new JMenuItem("Xanh");
		mntmXanh.addActionListener(this);
		mnCheDo.add(mntmXanh);
		
		JMenuItem mntmDo = new JMenuItem("Đỏ");
		mntmDo.addActionListener(this);
		mnCheDo.add(mntmDo);
//=================================================================================		
		JButton them = new JButton("Thêm");
		JButton xoa = new JButton("Xóa");
		JButton sua = new JButton("Sửa");
		JButton load = new JButton("load lại");
		them.addActionListener(this);
		xoa.addActionListener(this);
		sua.addActionListener(this);
		load.addActionListener(this);
		jpbutton.add(them);
		jpbutton.add(xoa);
		jpbutton.add(sua);
		jpbutton.add(load);
		
		//================================================================
		
		tabbedPane = new JTabbedPane();
		// bang sanpham
		modelsanpham= new DefaultTableModel(dl.sanpham(),dl.tisanpham());
		tablesanpham = new JTable(modelsanpham);
		scrollPane = new JScrollPane(tablesanpham);
		tablesanpham.addMouseListener(this);
		tabbedPane.add("Thiết bị", scrollPane);
		// bang taikhoan
		modeltaikhoan= new DefaultTableModel(dl.taikhoan(),dl.titaikhoan());
		tabletaikhoan = new JTable(modeltaikhoan);
		scrollPane2 = new JScrollPane(tabletaikhoan);
		tabletaikhoan.addMouseListener(this);
		tabbedPane.add("Tài khoản", scrollPane2);
		tabbedPane.addChangeListener(this);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		contentPane.add(jpbutton,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Tối")) {
			 tabbedPane.setBackground(Color.GRAY);
			 menuBar.setBackground(Color.GRAY);
			 jpbutton.setBackground(Color.GRAY); 
			 tablesanpham.setBackground(Color.GRAY);
			 tabletaikhoan.setBackground(Color.GRAY);
			 scrollPane.setBackground(Color.GRAY);
			 scrollPane2.setBackground(Color.GRAY);
			
		}
		if(e.getActionCommand().equals("Sáng")) {
			tabbedPane.setBackground(Color.white);
			 menuBar.setBackground(Color.white);
			 jpbutton.setBackground(Color.white); 
			 tablesanpham.setBackground(Color.white);
			 tabletaikhoan.setBackground(Color.white);
			 scrollPane.setBackground(Color.white);
			 scrollPane2.setBackground(Color.white);
			
		}
		if(e.getActionCommand().equals("Xanh")) {
			tabbedPane.setBackground(Color.GREEN);
			menuBar.setBackground(Color.GREEN);
			 jpbutton.setBackground(Color.GREEN); 
			 tablesanpham.setBackground(Color.GREEN);
			 tabletaikhoan.setBackground(Color.GREEN);
			 scrollPane.setBackground(Color.GREEN);
			 scrollPane2.setBackground(Color.GREEN);
			 
			
		}
		if(e.getActionCommand().equals("Đỏ")) {
			tabbedPane.setBackground(Color.RED);
			 menuBar.setBackground(Color.RED);
			 jpbutton.setBackground(Color.RED); 
			 tablesanpham.setBackground(Color.RED);
			 tabletaikhoan.setBackground(Color.RED);
			 scrollPane.setBackground(Color.RED);
			 scrollPane2.setBackground(Color.RED);
			
		}
		// -------Tab them-----------------
		if(e.getActionCommand().equals("Thêm")) {
			if(sudungtab==0) {
				Tab tab = new Tab("Them",id);
				tab.setVisible(true);
				}
			else if(sudungtab==1) {
				Tab1 tab1 = new Tab1("Them",id);
				tab1.setVisible(true);	
			}
			
			
		}
		
		//---------Xoa---------------------
		if(e.getActionCommand().equals("Xóa")) {
			chucnang cn = new chucnang();
			if(sudungtab==0) {
				connect conn = new connect();
				conn.Ketnoi();
				conn.xoathongtin(String.valueOf(tablesanpham.getValueAt(selectrow, 0)), "id","sanpham"); // getValueAt(ngang,doc)
			}
			else if(sudungtab==1) {
					if(cn.admin(JOptionPane.showInputDialog("nhap mat khau admin")) == true) {
						connect conn = new connect();
						conn.Ketnoi();
						conn.xoathongtin(String.valueOf(tabletaikhoan.getValueAt(selectrow, 0)), "idql","taikhoan"); // getValueAt(ngang,doc)
					}
				}
		}
		//===========Sua====================
		if(e.getActionCommand().equals("Sửa")) {
			if(sudungtab==0) {
				dangnhap dn = new dangnhap();
				dn.ThongBao("Bạn sửa ô nào thì nhập ô đấy");
				Tab tab = new Tab("Cap Nhat",id);
				
				tab.setVisible(true);
				
				
			}
			else if(sudungtab==1) {
				dangnhap dn = new dangnhap();
				dn.ThongBao("Bạn sửa ô nào thì nhập ô đấy");
				Tab1 tab = new Tab1("Cap Nhat",id);
				tab.setVisible(true);	
			}
			
		}
		if(e.getActionCommand().equals("load lại")) {
			load();
		}
		if(e.getActionCommand().equals("Nhà Trường")) {
			dangnhap dn = new dangnhap();
			dn.ThongBao("Khoa Công Nghệ Thông Tin Va Truyền Thông\n Đại Học Đà Nẵng");
		}
		if(e.getActionCommand().equals("Học Sinh")) {
			System.out.println("skajfaljfal");
			dangnhap dn = new dangnhap();
			dn.ThongBao("Nguyễn Duy Sy-18it5");
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(sudungtab ==1) {
			selectrow=tabletaikhoan.getSelectedRow();
			id=String.valueOf(tabletaikhoan.getValueAt(selectrow, 0));	
			System.out.println(selectrow);
			System.out.println("Gia tri id table taikhoan  "+id); // getValueAt(ngang,doc)
		}
		if(sudungtab ==0) {
			selectrow=tablesanpham.getSelectedRow();
			id=String.valueOf(tablesanpham.getValueAt(selectrow, 0));
			System.out.println(selectrow);
			System.out.println("Gia tri id table sanpham  "+id); 
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		sudungtab=tabbedPane.getSelectedIndex();
		System.out.println("Su dung Tab "+ sudungtab);
		}

	protected String getId() {
		return id;
	}
	
	
	}
		


