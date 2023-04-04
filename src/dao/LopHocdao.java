package dao;

import java.io.BufferedReader;
import bean.*;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LopHocdao {
	public int them(String malop, String tenlop) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="insert into lophoc(malop,tenlop) values(?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, malop);
		 cmd.setString(2, tenlop);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int sua(String malop, String tenlop) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="update lophoc set tenlop=? where malop=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, tenlop);
		 cmd.setString(2, malop);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int xoa(String malop) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="delete from lophoc where malop=? ";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, malop);
		//b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	
	public ArrayList<LopHoc> ds= new ArrayList<LopHoc>();
		public ArrayList<LopHoc> getLop() throws Exception{
			//Khai bao 1 mang chua all lop hoc
			 ArrayList<LopHoc> ds= new ArrayList<LopHoc>();
			 //b1: Tao cau lenh sql
			 String sql="select * from lophoc";
			//b2: Tao ra prepareStatement
			 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
			 //b3. Thuc hien cau lenh sql
			 ResultSet rs= cmd.executeQuery();
			//b4: duyet qua rs
	while(rs.next()) {
				
				String malop=rs.getString("malop");
				String tenlop=rs.getString("tenlop");
				LopHoc lh= new LopHoc(malop, tenlop);
				ds.add(lh);//Luu vao mang: ds
			}
			rs.close();
			return ds;

	}
	public static void main(String[]args) {
		try {
			CoSo cs= new CoSo();
			cs.KetNoi();
			LopHocdao lhd=new LopHocdao();
			for(LopHoc a:lhd.getLop()) {
				System.out.println(a.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
