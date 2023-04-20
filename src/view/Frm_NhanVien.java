package Frame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import bean.NhanVien;
import bo.NhanVienBo;
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

public class Frm_NhanVien extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtTuoiNV;
	private JTextField txtSDT;
	private JTextField txtDiaChi;

	NhanVienBo nvbo = new NhanVienBo();	
	static ArrayList<NhanVien> dsnv;
	private JLabel lblGioiTinh;
	private JTextField txtGioiTinh;
	private JTable table;
	private JScrollPane scrollPane;


	private JTextField txtsize;
	Void NapBang(ArrayList<NhanVien> dsnv) throws SQLException {
		new CoSo().KetNoi();
		dsnv=nvbo.getnv();
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"STT", "Ma Nhan Vien","Ho Ten", "Tuoi", "So Dien Thoai", "Dia Chi", "Gioi Tinh"};
		mh.setColumnIdentifiers(td);
		int stt= 1;
		int size = dsnv.size();
		txtsize.setText(String.valueOf(size));
		for(NhanVien nv: dsnv) {
			Object[] t = new Object[7];
			t[0]= stt;
			t[1]= nv.getMaNhanVien();
			t[2]= nv.getHoTen();
			t[3]= nv.getTuoi();
			t[4]= nv.getSoDienThoai();
			t[5]= nv.getDiaChi();
			//xu ly gioi tinh
			t[6]= nv.getGioiTinh()==true?"Nam":"Nu";
			stt++;		
			mh.addRow(t);
		}
		table.setModel(mh);
		
		return null;
	}
	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_NhanVien frame = new Frm_NhanVien();
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
	public Frm_NhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					dsnv=nvbo.getnv();
					NapBang(dsnv);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setTitle("Quan Ly Nhan Vien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtx = new JLabel("Ma Nhan Vien");
		txtx.setBounds(10, 14, 110, 14);
		contentPane.add(txtx);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(130, 14, 171, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTenNhanVien = new JLabel("Ten Nhan Vien");
		lblTenNhanVien.setBounds(339, 14, 87, 14);
		contentPane.add(lblTenNhanVien);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(436, 14, 172, 20);
		contentPane.add(txtTenNV);
		
		JLabel lblTuoi = new JLabel("Tuoi");
		lblTuoi.setBounds(10, 53, 73, 14);
		contentPane.add(lblTuoi);
		
		txtTuoiNV = new JTextField();
		txtTuoiNV.setColumns(10);
		txtTuoiNV.setBounds(130, 50, 171, 20);
		contentPane.add(txtTuoiNV);
		
		final JLabel null2 = new JLabel("So Dien Thoai");
		null2.setBounds(339, 53, 77, 14);
		contentPane.add(null2);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(436, 50, 174, 20);
		contentPane.add(txtSDT);
		
		JLabel null1 = new JLabel("Dia Chi");
		null1.setBounds(10, 87, 61, 14);
		contentPane.add(null1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(130, 81, 171, 20);
		contentPane.add(txtDiaChi);
		
		lblGioiTinh = new JLabel("Gioi Tinh");
		lblGioiTinh.setBounds(339, 87, 80, 14);
		contentPane.add(lblGioiTinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(436, 84, 174, 20);
		contentPane.add(txtGioiTinh);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 189, 585, 244);
		contentPane.add(tabbedPane);
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach Nhan Vien", null, scrollPane, null);
		
		table = new JTable();
//		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		/////////////////////////////////////////
		
	
		
		JButton btnNewButton = new JButton("Them");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//kiem tra xem ma da ton tai chua?
					int kt = nvbo.Them(Integer.parseInt(txtMaNV.getText()),txtTenNV.getText(), Integer.parseInt(txtTuoiNV.getText()),txtSDT.getText(),txtDiaChi.getText(),Boolean.parseBoolean(txtGioiTinh.getText()));
					if(kt==0) {//truong hop kt = false thi trung ma nhan vien
						JOptionPane.showMessageDialog(null, "Trung ma!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Da Them Nhan Vien!");
						
						NapBang(dsnv);
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
				int kt = nvbo.Sua(Integer.parseInt(txtMaNV.getText()),txtTenNV.getText(), Integer.parseInt(txtTuoiNV.getText()),txtSDT.getText(),txtDiaChi.getText(),Boolean.parseBoolean(txtGioiTinh.getText()));
				if(kt==0) {
					JOptionPane.showMessageDialog(null, "Loi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Da Sua!");
					NapBang(dsnv);
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
					int kt=nvbo.Xoa(Integer.parseInt(key));
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Khong xoa duoc!");
				else
					JOptionPane.showMessageDialog(null, "Da xoa");
					NapBang(dsnv);
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
					NapBang(dsnv);
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
