package Frame;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Giay;
import bo.GiayBo;
//import dao.CoSo;
import dao.CoSo;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frm_Giay extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaGiay;
	private JTextField txtTenGiay;
	private JTextField txtSize;
	private JTextField txtGia;
	private JTextField txtMaLoaiGiay;

	GiayBo gbo = new GiayBo();	
	static ArrayList<Giay> dsg;
	private JLabel lblGioiTinh;
	private JTextField txtMaNV;
	private JTable table;
	private JScrollPane scrollPane;


	private JTextField txtsize;
	Void NapBang(ArrayList<Giay> dsg) throws SQLException {
		new CoSo().KetNoi();
		dsg=gbo.getgiay();
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"STT", "Ma Giay","Ten Giay", "Size", "Gia", "Ma Loai Giay", "Ma Nhan Vien"};
		mh.setColumnIdentifiers(td);
		int stt= 1;
		int size = dsg.size();
		txtsize.setText(String.valueOf(size));
		for(Giay giay: dsg) {
			Object[] t = new Object[7];
			t[0]= stt;
			t[1]= giay.getMaGiay();
			t[2]= giay.getTenGiay();
			t[3]= giay.getSize();
			t[4]= giay.getGia();
			t[5]= giay.getMaLoaiGiay();
			t[6]= giay.getMaNhanVien();
			stt++;		
			mh.addRow(t);
		}
		table.setModel(mh);
		
		return null;
	}
	
	Void BangTimKiem(ArrayList<Giay> dsg) {
		if(dsg.get(0)==null) {
			JOptionPane.showMessageDialog(null, "Khong Tim Thay!");
		}
		else {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"STT", "Ma Nhan Vien","Ho Ten", "Tuoi", "So Dien Thoai", "Dia Chi", "Gioi Tinh"};
		mh.setColumnIdentifiers(td);
		int stt= 1;
		int size = dsg.size();
		txtsize.setText(String.valueOf(size));
		for(Giay giay: dsg) {
			Object[] t = new Object[7];
			t[0]= stt;
			t[1]= giay.getMaGiay();
			t[2]= giay.getTenGiay();
			t[3]= giay.getSize();
			t[4]= giay.getGia();
			t[5]= giay.getMaLoaiGiay();
			t[6]= giay.getMaNhanVien();
			stt++;		
			mh.addRow(t);
		}
		table.setModel(mh);
		}
		return null;
		
	}
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Giay frame = new Frm_Giay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frm_Giay() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					dsg=gbo.getgiay();
					NapBang(dsg);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setTitle("Quan Ly Giay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtx = new JLabel("Ma Giay");
		txtx.setBounds(10, 14, 110, 14);
		contentPane.add(txtx);
		
		txtMaGiay = new JTextField();
		txtMaGiay.setBounds(130, 14, 171, 20);
		contentPane.add(txtMaGiay);
		txtMaGiay.setColumns(10);
		
		JLabel lblTenNhanVien = new JLabel("Ten Giay");
		lblTenNhanVien.setBounds(339, 14, 87, 14);
		contentPane.add(lblTenNhanVien);
		
		txtTenGiay = new JTextField();
		txtTenGiay.setColumns(10);
		txtTenGiay.setBounds(436, 14, 172, 20);
		contentPane.add(txtTenGiay);
		
		JLabel lblTuoi = new JLabel("Size");
		lblTuoi.setBounds(10, 53, 73, 14);
		contentPane.add(lblTuoi);
		
		txtSize = new JTextField();
		txtSize.setColumns(10);
		txtSize.setBounds(130, 50, 171, 20);
		contentPane.add(txtSize);
		
		final JLabel null2 = new JLabel("Gia");
		null2.setBounds(339, 53, 77, 14);
		contentPane.add(null2);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(436, 50, 174, 20);
		contentPane.add(txtGia);
		
		JLabel null1 = new JLabel("Ma Loai Giay");
		null1.setBounds(10, 87, 61, 14);
		contentPane.add(null1);
		
		txtMaLoaiGiay = new JTextField();
		txtMaLoaiGiay.setColumns(10);
		txtMaLoaiGiay.setBounds(130, 81, 171, 20);
		contentPane.add(txtMaLoaiGiay);
		
		lblGioiTinh = new JLabel("Ma Nhan Vien");
		lblGioiTinh.setBounds(339, 87, 80, 14);
		contentPane.add(lblGioiTinh);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(436, 84, 174, 20);
		contentPane.add(txtMaNV);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 189, 585, 244);
		contentPane.add(tabbedPane);
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach Giay", null, scrollPane, null);
		
		table = new JTable();
//		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		/////////////////////////////////////////
		
	
		
		JButton btnNewButton = new JButton("Them");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//kiem tra xem ma da ton tai chua?
					int kt = gbo.Them(Integer.parseInt(txtMaGiay.getText()),txtTenGiay.getText(), Integer.parseInt(txtSize.getText()),Float.parseFloat(txtGia.getText()),Integer.parseInt(txtMaLoaiGiay.getText()),Integer.parseInt(txtMaNV.getText()));
					if(kt==0) {//truong hop kt = false thi trung ma nhan vien
						JOptionPane.showMessageDialog(null, "Trung ma!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Da Them Nhan Vien!");	
						NapBang(dsg);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(22, 137, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {			
				int kt = gbo.Sua(Integer.parseInt(txtMaGiay.getText()),txtTenGiay.getText(), Integer.parseInt(txtSize.getText()),Float.parseFloat(txtGia.getText()),Integer.parseInt(txtMaLoaiGiay.getText()),Integer.parseInt(txtMaNV.getText()));
				if(kt==0) {
					JOptionPane.showMessageDialog(null, "Loi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Da Sua!");
					NapBang(dsg);
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			}
		});
		btnSua.setBounds(160, 137, 115, 23);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap masv muon xoa: ");
				
				try {
					int kt=gbo.Xoa(Integer.parseInt(key));
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Khong xoa duoc!");
				else
					JOptionPane.showMessageDialog(null, "Da xoa");
					NapBang(dsg);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(311, 137, 115, 23);
		contentPane.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tim kiem");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String key=JOptionPane.showInputDialog("Nhap Ma Nhan Vien: ");
				try {	
					BangTimKiem(gbo.Tim(key));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTimKiem.setBounds(480, 137, 127, 23);
		contentPane.add(btnTimKiem);
		
		JButton btnThongKeLuong = new JButton("Thong ke luong");
		btnThongKeLuong.setBounds(403, 455, 184, 23);
		contentPane.add(btnThongKeLuong);
		
		JButton btnSapXepTheo = new JButton("Sap xep theo luong tang dan");
		btnSapXepTheo.setBounds(208, 455, 184, 23);
		contentPane.add(btnSapXepTheo);
		
		txtsize = new JTextField();
		txtsize.setBounds(136, 456, 46, 20);
		contentPane.add(txtsize);
		txtsize.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("So Luong");
		lblNewLabel.setBounds(48, 459, 55, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NapBang(dsg);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(518, 174, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
