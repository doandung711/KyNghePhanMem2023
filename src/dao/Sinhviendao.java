package dao;

import java.io.BufferedReader;
import bean.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import bean.*;

public class Sinhviendao {

	public int them(String masv, String hoten, String diachi, Boolean gioitinh, int tuoi,
			String malop) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="INSERT sinhvien (masv, hoten, diachi,gioitinh, tuoi, malop) VALUES (?,?,?,?,?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, masv);
		 cmd.setString(2, hoten);
		 cmd.setString(3, diachi);
		 cmd.setBoolean(4, gioitinh);
		 //Doi ngay util sang ngay sql
//		 cmd.setDate(5,new java.sql.Date( ngaysinh.getTime()));
		 cmd.setInt(5, tuoi);
		 cmd.setString(6, malop);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int sua(String masv, String hoten, String diachi, Boolean gioitinh, int tuoi,
			String malop) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="update lophoc set hoten=?, diachi=?,  gioitinh=?, tuoi=?,  malop=?  where masv=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, hoten);
		 cmd.setString(2, diachi);
		 cmd.setBoolean(3, gioitinh);
		 cmd.setInt(4, tuoi);
		 cmd.setString(5, malop);
		 cmd.setString(6, masv);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int xoa(String masv) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="delete from sinhvien where masv=? ";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, masv);
		//b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public ArrayList<SinhVien> getSv() throws Exception{
		//Khai bao 1 mang chua all lop hoc
		 ArrayList<SinhVien> ds= new ArrayList<SinhVien>();
		 //b1: Tao cau lenh sql
		 String sql="select * from sinhvien";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 //b3. Thuc hien cau lenh sql
		 ResultSet rs= cmd.executeQuery();
		//b4: duyet qua rs
            while(rs.next()) {
			String masv=rs.getString("masv");
			String hoten=rs.getString("hoten");
			String diachi=rs.getString("diachi");
			Boolean gioitinh=rs.getBoolean("gioitinh");
			int tuoi=rs.getInt("tuoi");
			String malop=rs.getString("malop");
			SinhVien sv= new SinhVien(masv, hoten, diachi, gioitinh, tuoi, malop);
			ds.add(sv);//Luu vao mang: ds
		}
		rs.close();
		return ds;
	}
	public static void main(String[]args) {
		try {
			Sinhviendao svd=new Sinhviendao();
			for(SinhVien a:svd.getSv()) {
				System.out.println(a.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
