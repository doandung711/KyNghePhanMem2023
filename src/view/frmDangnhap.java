package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class frmDangnhap extends JFrame {

	private JPanel contentPane;
	TextField txtus = new TextField();
	TextField txtpass = new TextField();
	public static String un="";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangnhap frame = new frmDangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public frmDangnhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 306);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txtus.setBounds(107, 62, 263, 21);
		contentPane.add(txtus);
		
		txtpass.setEchoChar('*');
		txtpass.setBounds(107, 125, 263, 21);
		contentPane.add(txtpass);
		
		Button button = new Button("DANG NHAP");
		button.setFont(new Font("Arial Black", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				un=txtus.getText();
				frmmenu f=new frmmenu();
				f.setVisible(true);
			}
		});
		button.setBounds(176, 181, 89, 23);
		contentPane.add(button);
		
		Label label = new Label("Ten Dang Nhap: ");
		label.setBounds(10, 62, 91, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Mat Khau: ");
		label_1.setBounds(10, 125, 91, 21);
		contentPane.add(label_1);
		
	}
}
