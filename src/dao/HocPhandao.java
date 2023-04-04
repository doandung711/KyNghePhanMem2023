package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.HocPhan;



public class HocPhandao {
	public int them(String mahocphan, String tenhocphan, int sotinchi) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="insert into hocphan(mahocphan, tenhocphan, sotinchi) values(?,?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, mahocphan);
		 cmd.setString(2, tenhocphan);
		 cmd.setInt(3, sotinchi);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int sua(String mahocphan, String tenhocphan, int sotinchi) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="update hocphan set tenhocphan=?, sotinchi=?, where mahocphan=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, tenhocphan);
		 cmd.setInt(2, sotinchi);
		 cmd.setString(3, mahocphan);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int xoa(String mahocphan) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="delete from hocphan where mahocphan=? ";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		 cmd.setString(1, mahocphan);
		//b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	
	public ArrayList<HocPhan> ds= new ArrayList<HocPhan>();
		public ArrayList<HocPhan> getHocPhan() throws Exception{
			//Khai bao 1 mang chua all lop hoc
			 ArrayList<HocPhan> ds= new ArrayList<HocPhan>();
			 //b1: Tao cau lenh sql
			 String sql="select * from hocphan";
			//b2: Tao ra prepareStatement
			 PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
			 //b3. Thuc hien cau lenh sql
			 ResultSet rs= cmd.executeQuery();
			//b4: duyet qua rs
	while(rs.next()) {
				
				String mahp=rs.getString("mahocphan");
				String tenhp=rs.getString("tenhocphan");
				int stc=rs.getInt("sotinchi");
				HocPhan hp= new HocPhan(mahp, tenhp, stc);
				ds.add(hp);//Luu vao mang: ds
			}
			rs.close();
			return ds;

	}
	public static void main(String[]args) {
		try {
			CoSo cs= new CoSo();
			cs.KetNoi();
			HocPhandao hpd=new HocPhandao();
			for(HocPhan a:hpd.getHocPhan()) {
				System.out.println(a.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
