package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Diem;
import bean.LopHoc;
import bean.SinhVien;
import bo.Diembo;
import bo.SinhVienbo;
import dao.CoSo;
import dao.Diemdao;
import dao.Sinhviendao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmThongKe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Sinhviendao svdao= new Sinhviendao();
	Diemdao ddao= new Diemdao();
	SinhVienbo svbo= new SinhVienbo();
	Diembo dbo= new Diembo();
	ArrayList<Diem> dsd;
	ArrayList<SinhVien> dssv;
	private JTable table_1;
	void NapBang1(ArrayList<Diem> dsd) {
		DefaultTableModel mh= new DefaultTableModel();
		String[] td= {"Mã sinh viên", "Điểm môn 1", "Điểm môn 2", "Điểm trung bình"};
		mh.setColumnIdentifiers(td);
		for(Diem d: dsd) {
			Object[] t= new Object[4];
			t[0]=d.getMasv();
			t[1]=d.getDiemmon1();
			t[2]=d.getDiemmon2();
			t[3]=(double) Math.round(((d.getDiemmon1()+d.getDiemmon2())/2) * 10) / 10;
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	void NapBang2() {
		DefaultTableModel Tmodel = new DefaultTableModel(0,4);
			Object[] t= new Object[4];
			 t[0]="Số sinh viên lên lớp";
			 t[1]="Số sinh viên ở lại";
			 t[2]="Tỷ lệ lên lớp(%)";
			 t[3]="Tỷ lệ ở lại(%)";
			Tmodel.addRow(t);
			int n= dsd.size();
			int diemll=0;
			int diemol=0;
			DecimalFormat df= new DecimalFormat("#.#");
			for(int i=0;i<n;i++) {
				Diem d= (Diem) dsd.get(i);
				float diemtb=(d.getDiemmon1()+d.getDiemmon2())/2;
				if(diemtb>=5) {
					diemll++;
				}else {
					diemol++;
				}
				t[0]=diemll;t[1]=diemol ;t[2]= df.format(((double)diemll/n)*100); t[3]=df.format(((double)diemol/n)*100);
			}
			
			Tmodel.addRow(t) ;
		table_1.setModel(Tmodel);
}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThongKe frame = new FrmThongKe();
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
	public FrmThongKe() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					new CoSo().KetNoi();
					dsd=dbo.getDiem();
					NapBang1(dsd);
					NapBang2();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 853, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 68, 387, 418);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Điểm trung bình của các sinh viên", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Label label = new Label("TH\u00D4NG K\u00CA SINH VI\u00CAN");
		label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label.setBackground(new Color(255, 255, 255));
		label.setAlignment(Label.CENTER);
		label.setBounds(284, 10, 222, 31);
		contentPane.add(label);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(419, 68, 410, 418);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("Thống kê chung", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
