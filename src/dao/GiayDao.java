package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Giay;


public class GiayDao {
	ArrayList<Giay> dsg = new ArrayList<Giay>();
	public static ArrayList<Giay> getgiay() throws SQLException{
		ArrayList<Giay> arrayList = new ArrayList<Giay>();

		String sql="select * from Giay";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
			while(rs.next()) {
				int MaGiay = rs.getInt(1);
				String TenGiay = rs.getString(2);
				int Size = rs.getInt(3);
				Float Gia = rs.getFloat(4);
				int MaLoaiGiay = rs.getInt(5);
				int MaNhanVien = rs.getInt(6);
				Giay giay = new Giay(MaGiay,TenGiay,Size,Gia,MaLoaiGiay,MaNhanVien);
				arrayList.add(giay);
			}
		rs.close();
		return arrayList;
	}
	public int Them(int maGiay, String TenGiay,int Size,Float Gia,int MaLoaiGiay,int MaNhanVien)throws Exception{
		String sql = "INSERT INTO Giay(MaGiay,TenGiay,Size,Gia,MaLoaiGiay,MaNhanVien) Values(?,?,?,?,?,?)";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
			cmd.setInt(1, maGiay);
			cmd.setString(2, TenGiay);
			cmd.setInt(3,Size);
			cmd.setFloat(4,Gia);
			cmd.setInt(5,MaLoaiGiay);
			cmd.setInt(6,MaNhanVien);
			int kt = cmd.executeUpdate();
			cmd.close();
			return kt;
	}
	public int Sua (int maGiay, String TenGiay,int Size,Float Gia,int MaLoaiGiay,int MaNhanVien)throws Exception{
		String sql = "Update Giay Set MaGiay=?, TenGiay=?, Size=?, Gia=?,MaLoaiGiay=?,MaNhanVien=? Where MaGiay=?";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1, maGiay);
		cmd.setString(2, TenGiay);
		cmd.setInt(3,Size);
		cmd.setFloat(4,Gia);
		cmd.setInt(5,MaLoaiGiay);
		cmd.setInt(6,MaNhanVien);
		cmd.setInt(7,maGiay);
		return cmd.executeUpdate();
	}
	public int Xoa (int maGiay) throws Exception{
		String sql = "delete from Giay where MaGiay =?";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1,maGiay);
		return cmd.executeUpdate();
	}

}
