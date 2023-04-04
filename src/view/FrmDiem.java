package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Diem;
import bo.Diembo;

import dao.CoSo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FrmDiem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmasv;
	private JTextField txtdm1;
	private JTextField txtdm2;

	Diembo dbo= new Diembo();
	ArrayList<Diem> ds;
	private JTextField txtmahp;
	void NapBang(ArrayList<Diem> ds) {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"Ma sinh vien","Ma hoc phan","Diem mon 1", "Diem mon 2"};
		mh.setColumnIdentifiers(td);
		for(Diem d: ds) {
			Object[] t= new Object[4];
			t[0]=d.getMasv();
			t[2]=d.getDiemmon1();
			t[3]=d.getDiemmon2();
			t[1]=d.getMahocphan();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDiem frame = new FrmDiem();
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
	public FrmDiem() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					ds=dbo.getDiem();
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 665);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 224, 812, 394);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach diem", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				txtmasv.setText(table.getValueAt(d, 0).toString());
				txtdm1.setText(table.getValueAt(d, 2).toString());
				txtdm2.setText(table.getValueAt(d, 3).toString());
				txtmahp.setText(table.getValueAt(d, 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		Button button = new Button("THEM");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt= dbo.them(txtmasv.getText(), Float.parseFloat(txtdm1.getText()),Float.parseFloat(txtdm2.getText()), txtmahp.getText());
					if(kt==0) {
						JOptionPane.showMessageDialog(null, "Trung ma!");
					}else {
						JOptionPane.showMessageDialog(null, "Da them");
						NapBang(ds);
					}
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		button.setBounds(588, 79, 87, 30);
		contentPane.add(button);
		
		Button button_1 = new Button("SUA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt=dbo.sua(txtmasv.getText(),Float.parseFloat(txtdm1.getText()),Float.parseFloat(txtdm2.getText()), txtmahp.getText());
					
				if(kt==0) {
					JOptionPane.showMessageDialog(null, "Khong sua duoc!");
				}else {
					NapBang(ds);
					JOptionPane.showMessageDialog(null, "Da sua");
					
				}
	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_1.setBounds(588, 166, 87, 30);
		contentPane.add(button_1);
		
		Button button_2 = new Button("XOA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap ma sv muon xoa: ");
				try {
					int kt=dbo.xoa(key);
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Khong xoa duoc!");
				else
					JOptionPane.showMessageDialog(null, "Da xoa");
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_2.setBounds(755, 79, 87, 30);
		contentPane.add(button_2);
		
		Button button_3 = new Button("TIM KIEM");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String key = JOptionPane.showInputDialog("Nhap ma sv  can tim");
					if(dbo.tim(key).size() == 0)
						JOptionPane.showMessageDialog(null, "Khong tim thay");
					NapBang(dbo.tim(key));
					txtmasv.setText("");
					txtdm1.setText("");
					txtdm2.setText("");
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button_3.setBounds(755, 166, 87, 30);
		contentPane.add(button_3);
		
		Label label = new Label("Ma sinh vien: ");
		label.setBounds(30, 92, 92, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Diem mon 1: ");
		label_1.setBounds(30, 119, 97, 21);
		contentPane.add(label_1);
		
		Label label_1_1 = new Label("Diem mon 2: ");
		label_1_1.setBounds(30, 146, 97, 21);
		contentPane.add(label_1_1);
		
		txtmasv = new JTextField();
		txtmasv.setBounds(133, 90, 191, 19);
		contentPane.add(txtmasv);
		txtmasv.setColumns(10);
		
		txtdm1 = new JTextField();
		txtdm1.setColumns(10);
		txtdm1.setBounds(133, 119, 191, 19);
		contentPane.add(txtdm1);
		
		txtdm2 = new JTextField();
		txtdm2.setColumns(10);
		txtdm2.setBounds(133, 148, 191, 19);
		contentPane.add(txtdm2);
		
		txtmahp = new JTextField();
		txtmahp.setBounds(133, 177, 191, 19);
		contentPane.add(txtmahp);
		txtmahp.setColumns(10);
		
		Label label_2 = new Label("Ma hoc phan");
		label_2.setBounds(30, 175, 87, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("QUAN LY DIEM");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 29));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(283, 10, 318, 42);
		contentPane.add(label_3);
	}
}
