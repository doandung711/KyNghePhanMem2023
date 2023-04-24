package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Luong;
import bo.LuongBo;
import dao.CoSo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class Frm_Luong_NhanVien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtLuong;
	private JTable table;
	private JTextField txtSize;
	LuongBo lbo = new LuongBo();
	static ArrayList<Luong> dsl;
	Void NapBang(ArrayList<Luong> dsl) throws SQLException {
		new CoSo().KetNoi();
		dsl=lbo.getLuong();
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"STT", "Ma Nhan Vien","Luong"};
		mh.setColumnIdentifiers(td);
		int stt= 1;
		int size = dsl.size();
		txtSize.setText(String.valueOf(size));
		for(Luong l: dsl) {
			Object[] t = new Object[7];
			t[0]= stt;
			t[1]= l.getMaNhanVien();
			t[2]= l.getLuong();
			stt++;		
			mh.addRow(t);
		}
		table.setModel(mh);
		
		return null;
	}
	Void BangTimKiem(ArrayList<Luong> dsluong) {
		if(dsluong.get(0)==null) {
			JOptionPane.showMessageDialog(null, "Khong Tim Thay!");
		}
		else {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"STT", "Ma Nhan Vien", "Luong"};
		mh.setColumnIdentifiers(td);
		int stt= 1;
		int size = dsluong.size();
		txtSize.setText(String.valueOf(size));
		for(Luong l: dsluong) {
			Object[] t = new Object[7];
			t[0]= stt;
			t[1]= l.getMaNhanVien();
			t[2]= l.getLuong();
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
					Frm_Luong_NhanVien frame = new Frm_Luong_NhanVien();
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
	public Frm_Luong_NhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					dsl = lbo.getLuong();
					NapBang(dsl);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		setTitle("Quan Ly Luong Nhan Vien");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtx = new JLabel("Ma Nhan Vien");
		txtx.setBounds(10, 24, 110, 23);
		contentPane.add(txtx);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(130, 11, 172, 40);
		contentPane.add(txtMaNV);
		
		JLabel lblLuong = new JLabel("Luong");
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLuong.setBounds(328, 24, 87, 23);
		contentPane.add(lblLuong);
		
		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(436, 11, 172, 40);
		contentPane.add(txtLuong);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 134, 623, 186);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Quan Ly Luong Nhan Vien", null, scrollPane, null);
		
		table = new JTable();
//		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Them");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//kiem tra xem ma da ton tai chua?
					int kt = lbo.Them(Integer.parseInt(txtMaNV.getText()),Float.parseFloat(txtLuong.getText()));
					if(kt==0) {//truong hop kt = false thi trung ma nhan vien
						JOptionPane.showMessageDialog(null, "Trung ma!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Da Them Nhan Vien!");
						NapBang(dsl);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 62, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {			
					int kt = lbo.Sua(Integer.parseInt(txtMaNV.getText()),Float.parseFloat(txtLuong.getText()));
					if(kt==0) {
						JOptionPane.showMessageDialog(null, "Loi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Da Sua!");
						NapBang(dsl);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnSua.setBounds(164, 62, 115, 23);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String key=JOptionPane.showInputDialog("Nhap masv muon xoa: ");
				try {
					int kt=lbo.Xoa(Integer.parseInt(key));
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Khong xoa duoc!");
				else
					JOptionPane.showMessageDialog(null, "Da xoa");
					NapBang(dsl);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(311, 62, 115, 23);
		contentPane.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tim kiem");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap Ma Nhan Vien: ");
				try {	
					BangTimKiem(lbo.Tim(key));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTimKiem.setBounds(481, 62, 127, 23);
		contentPane.add(btnTimKiem);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					NapBang(dsl);
				}catch (Exception e1 ) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(520, 100, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtSize = new JTextField();
		txtSize.setColumns(10);
		txtSize.setBounds(130, 331, 46, 20);
		contentPane.add(txtSize);
		
		JLabel lblNewLabel = new JLabel("So Luong");
		lblNewLabel.setBounds(42, 334, 55, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSapXepTheo = new JButton("Sap xep theo luong tang dan");
		btnSapXepTheo.setBounds(242, 328, 184, 23);
		contentPane.add(btnSapXepTheo);
		
		JButton btnThongKeLuong = new JButton("Thong ke luong");
		btnThongKeLuong.setBounds(437, 328, 184, 23);
		contentPane.add(btnThongKeLuong);
	}
}
