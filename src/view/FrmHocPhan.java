package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.HocPhan;
import bean.LopHoc;
import bo.HocPhanbo;
import bo.LopHocbo;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FrmHocPhan extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmahp;
	private JTextField txttenhp;
	private JTextField txttxtstc;
	HocPhanbo hpbo= new HocPhanbo();
	ArrayList<HocPhan> ds;
	void NapBang(ArrayList<HocPhan> ds) {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"Ma hoc phan","Ten hoc phan", "So tin chi"};
		mh.setColumnIdentifiers(td);
		for(HocPhan hp: ds) {
			Object[] t= new Object[4];
			t[0]=hp.getMahocphan();
			t[1]=hp.getTenhocphan();
			t[2]=hp.getSotinchi();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHocPhan frame = new FrmHocPhan();
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
	public FrmHocPhan() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					ds=hpbo.getHocphan();
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 173, 765, 356);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				txtmahp.setText(table.getValueAt(d, 0).toString());
				txttenhp.setText(table.getValueAt(d, 1).toString());
				txttxtstc.setText(table.getValueAt(d, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		Label label = new Label("Ma hoc phan: ");
		label.setBounds(38, 75, 80, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Ten hoc phan: ");
		label_1.setBounds(35, 102, 83, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("So tin chi: ");
		label_2.setBounds(38, 129, 80, 21);
		contentPane.add(label_2);
		
		txtmahp = new JTextField();
		txtmahp.setBounds(124, 77, 282, 19);
		contentPane.add(txtmahp);
		txtmahp.setColumns(10);
		
		txttenhp = new JTextField();
		txttenhp.setColumns(10);
		txttenhp.setBounds(124, 104, 282, 19);
		contentPane.add(txttenhp);
		
		txttxtstc = new JTextField();
		txttxtstc.setColumns(10);
		txttxtstc.setBounds(124, 131, 282, 19);
		contentPane.add(txttxtstc);
		
		Button button = new Button("THEM");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt= hpbo.them(txtmahp.getText(), txttenhp.getText(), Integer.parseInt(txttxtstc.getText()));
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
		button.setBounds(566, 61, 80, 35);
		contentPane.add(button);
		
		Button button_1 = new Button("SUA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt=hpbo.sua(txtmahp.getText(), txttenhp.getText(), Integer.parseInt(txttxtstc.getText()));
					
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
		button_1.setBounds(566, 115, 80, 35);
		contentPane.add(button_1);
		
		Button button_2 = new Button("XOA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap ma hoc phan muon xoa: ");
				try {
					int kt=hpbo.xoa(key);
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
		button_2.setBounds(723, 61, 80, 35);
		contentPane.add(button_2);
		
		Button button_3 = new Button("TIM KIEM");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String key = JOptionPane.showInputDialog("Nhap ma hoc phan hoac ten hoc phan can tim");
					if(hpbo.tim(key).size() == 0)
						JOptionPane.showMessageDialog(null, "Khong tim thay");
					NapBang(hpbo.tim(key));
					txtmahp.setText("");
					txttenhp.setText("");
					txtmahp.setText("");
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button_3.setBounds(723, 115, 80, 35);
		contentPane.add(button_3);
		
		Label label_3 = new Label("QUAN LY HOC PHAN");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(348, 10, 229, 31);
		contentPane.add(label_3);
	}

}
