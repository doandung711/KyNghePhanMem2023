package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Diem;

public class Diemdao {
	public int them(String masv, float diemmon1, float diemmon2, String mahocphan) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="insert into diem(masv,diemmon1,diemmon2, mahocphan) values(?,?,?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, masv);
		 cmd.setFloat(2, diemmon1);
		 cmd.setFloat(3, diemmon2);
		 cmd.setString(4, mahocphan);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int sua(String masv, float diemmon1, float diemmon2, String mahocphan) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="update diem set diemmon1=?, diemmon2=?,  where masv=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setFloat(1, diemmon1);
		 cmd.setFloat(2, diemmon2);
		 cmd.setString(3, mahocphan);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int xoa(String masv) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="delete from diem where masv=? ";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, masv);
		//b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	
	public ArrayList<Diem> dsd= new ArrayList<Diem>();
		public ArrayList<Diem> getDiem() throws Exception{
			//Khai bao 1 mang chua all lop hoc
			 ArrayList<Diem> ds= new ArrayList<Diem>();
			 //b1: Tao cau lenh sql
			 String sql="select * from diem";
			//b2: Tao ra prepareStatement
			 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
			 //b3. Thuc hien cau lenh sql
			 ResultSet rs= cmd.executeQuery();
			//b4: duyet qua rs
	while(rs.next()) {
				
				String masv=rs.getString("masv");
				float dm1=rs.getFloat("diemmon1");
				float dm2=rs.getFloat("diemmon2");
				String mhp=rs.getString("mahocphan");
				Diem d= new Diem(masv, dm1, dm2,mhp);
				ds.add(d);//Luu vao mang: ds
			}
			rs.close();
			return ds;

	}
	public static void main(String[]args) {
		try {
			CoSo cs= new CoSo();
			cs.KetNoi();
			Diemdao dd=new Diemdao();
			for(Diem a:dd.getDiem()) {
				System.out.println(a.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
