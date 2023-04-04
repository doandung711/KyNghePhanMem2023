package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.LopHoc;
import bo.LopHocbo;
import dao.CoSo;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Frmlophoc extends JFrame {

	private JPanel contentPane;
	private JTextField txtmalop;
	private JTextField txttenlop;
	private JTable table;
	LopHocbo lhbo= new LopHocbo();
	ArrayList<LopHoc> ds;
	void NapBang(ArrayList<LopHoc> ds) {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"Malop","TenLop"};
		mh.setColumnIdentifiers(td);
		for(LopHoc sv: ds) {
			Object[] t= new Object[2];
			t[0]=sv.getMalop();
			t[1]=sv.getTenlop();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmlophoc frame = new Frmlophoc();
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
	public Frmlophoc() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					ds=lhbo.getLop();
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtmalop = new JTextField();
		txtmalop.setBounds(223, 67, 308, 19);
		contentPane.add(txtmalop);
		txtmalop.setColumns(10);
		
		txttenlop = new JTextField();
		txttenlop.setBounds(223, 96, 308, 19);
		contentPane.add(txttenlop);
		txttenlop.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(60, 185, 662, 265);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach lop", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				txtmalop.setText(table.getValueAt(d, 0).toString());
				txttenlop.setText(table.getValueAt(d, 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		Button button = new Button("THEM");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt= lhbo.them(txtmalop.getText(), txttenlop.getText());
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
		button.setBounds(152, 142, 79, 21);
		contentPane.add(button);
		
		Button button_1 = new Button("SUA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt=lhbo.sua(txtmalop.getText(),txttenlop.getText());
					
				if(kt==0) {
					JOptionPane.showMessageDialog(null, "Khong sua duoc!");
				}else {
					JOptionPane.showMessageDialog(null, "Da sua");
					NapBang(ds);
				}
	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_1.setBounds(297, 142, 79, 21);
		contentPane.add(button_1);
		
		Button button_2 = new Button("XOA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap ma lop muon xoa: ");
				try {
					int kt=lhbo.xoa(key);
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
		button_2.setBounds(438, 142, 79, 21);
		contentPane.add(button_2);
		
		Label label = new Label("Ma Lop: ");
		label.setBounds(114, 65, 59, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Ten Lop: ");
		label_1.setBounds(114, 94, 59, 21);
		contentPane.add(label_1);
		
		Button button_3 = new Button("TIM KIEM");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String key = JOptionPane.showInputDialog("Nhap ma lop hoac ten can tim");
				if(lhbo.tim(key).size() == 0)
					JOptionPane.showMessageDialog(null, "Khong tim thay");
				NapBang(lhbo.tim(key));
				txtmalop.setText("");
				txttenlop.setText("");
			} catch (Exception err) {
				err.printStackTrace();
			}
			}
		});
		button_3.setBounds(578, 142, 66, 21);
		contentPane.add(button_3);
		
		Label label_2 = new Label("QUAN LY LOP HOC");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_2.setBounds(312, 10, 196, 31);
		contentPane.add(label_2);
	}
}
