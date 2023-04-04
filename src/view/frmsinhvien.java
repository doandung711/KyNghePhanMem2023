package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.LopHoc;
import bean.SinhVien;
import bo.LopHocbo;
import bo.SinhVienbo;
import dao.CoSo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class frmsinhvien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmsv;
	private JTextField txtht;
	private JTextField txtdc;
	private JTextField txtgt;
	private JTextField txtt;
	private JTextField txtml;

	SinhVienbo svbo= new SinhVienbo();
	ArrayList<SinhVien> dssv;
	void NapBang(ArrayList<SinhVien> dssv) {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"MaSV","Ho Ten", "Dia Chi", "Gioi Tinh", "Tuoi", "Ma Lop"};
		mh.setColumnIdentifiers(td);
		for(SinhVien sv: dssv) {
			Object[] t= new Object[7];
			t[0]=sv.getMasv();t[1]=sv.getHoTen();
			t[2]=sv.getDiachi();t[3]=sv.isGioitinh();
			t[4]=sv.getTuoi();t[5]=sv.getMalop();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmsinhvien frame = new frmsinhvien();
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
	public frmsinhvien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					dssv=svbo.getsv();
					NapBang(dssv);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 912, 668);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(186, 85, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 256, 878, 365);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach sinh vien", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				txtmsv.setText(table.getValueAt(d, 0).toString());
				txtht.setText(table.getValueAt(d, 1).toString());
				txtdc.setText(table.getValueAt(d, 2).toString());
				txtgt.setText(table.getValueAt(d, 3).toString());
				txtt.setText(table.getValueAt(d, 4).toString());
				txtml.setText(table.getValueAt(d, 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		Label label = new Label("Ma SV: ");
		label.setBounds(10, 84, 91, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Ho Ten: ");
		label_1.setBounds(10, 111, 91, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Dia Chi: ");
		label_2.setBounds(10, 138, 91, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Gioi Tinh: ");
		label_3.setBounds(10, 165, 91, 21);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Tuoi: ");
		label_4.setBounds(10, 192, 91, 21);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Ma Lop: ");
		label_5.setBounds(10, 219, 91, 21);
		contentPane.add(label_5);
		
		txtmsv = new JTextField();
		txtmsv.setBounds(107, 86, 360, 19);
		contentPane.add(txtmsv);
		txtmsv.setColumns(10);
		
		txtht = new JTextField();
		txtht.setColumns(10);
		txtht.setBounds(107, 113, 360, 19);
		contentPane.add(txtht);
		
		txtdc = new JTextField();
		txtdc.setColumns(10);
		txtdc.setBounds(107, 140, 360, 19);
		contentPane.add(txtdc);
		
		txtgt = new JTextField();
		txtgt.setColumns(10);
		txtgt.setBounds(107, 167, 360, 19);
		contentPane.add(txtgt);
		
		txtt = new JTextField();
		txtt.setColumns(10);
		txtt.setBounds(107, 192, 360, 19);
		contentPane.add(txtt);
		
		txtml = new JTextField();
		txtml.setColumns(10);
		txtml.setBounds(107, 221, 360, 19);
		contentPane.add(txtml);
		
		Button button = new Button("THEM");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt= svbo.them(txtmsv.getText(), txtht.getText(),txtdc.getText(), Boolean.parseBoolean(txtgt.getText()),Integer.parseInt(txtt.getText()) , txtml.getText());
					if(kt==0) {
						JOptionPane.showMessageDialog(null, "Trung ma!");
					}else {
						JOptionPane.showMessageDialog(null, "Da them");
						NapBang(dssv);
					}
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		button.setBounds(565, 84, 98, 45);
		contentPane.add(button);
		
		Button button_1 = new Button("SUA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt=svbo.sua(txtmsv.getText(), txtht.getText(),txtdc.getText(), Boolean.parseBoolean(txtgt.getText()),Integer.parseInt(txtt.getText()) , txtml.getText());
				if(kt==0) {
					JOptionPane.showMessageDialog(null, "Khong sua duoc!");
				}	
				else {
					
					JOptionPane.showMessageDialog(null, "Da sua");
					NapBang(dssv);
				}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_1.setBounds(565, 165, 98, 45);
		contentPane.add(button_1);
		
		Button button_2 = new Button("XOA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap masv muon xoa: ");
				try {
					int kt=svbo.xoa(key);
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Khong xoa duoc!");
				else
					JOptionPane.showMessageDialog(null, "Da xoa");
					NapBang(dssv);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_2.setBounds(713, 84, 98, 45);
		contentPane.add(button_2);
		
		Button button_3 = new Button("TIM KIEM");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String key = JOptionPane.showInputDialog("Nhap ma sv hoac ten can tim");
					if(svbo.tim(key).size() == 0)
						JOptionPane.showMessageDialog(null, "Khong tim thay");
					NapBang(svbo.tim(key));
					txtmsv.setText("");
					txtht.setText("");
					txtdc.setText("");
					txtgt.setText("");
					txtt.setText("");
					txtml.setText("");
					
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button_3.setBounds(713, 165, 98, 45);
		contentPane.add(button_3);
		
		Label label_6 = new Label("QUAN LY SINH VIEN");
		label_6.setFont(new Font("Arial Black", Font.PLAIN, 27));
		label_6.setBounds(290, 0, 391, 40);
		contentPane.add(label_6);
	}
}
