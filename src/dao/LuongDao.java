package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Luong;

public class LuongDao {
	public static ArrayList<Luong> getLuong() throws SQLException{
		ArrayList<Luong> dsLuong = new ArrayList<Luong>();
		String sql= "Select * from Luong";
		PreparedStatement cmd = CoSo.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			int MaNhanVien = rs.getInt(1);
			Float luong = rs.getFloat(2);
			Luong l = new Luong(MaNhanVien,luong);
			dsLuong.add(l);
		}
		rs.close();
		return dsLuong;
	}
	public int Them (int MaNhanVien,Float luong) throws SQLException{
		String sql = "Insert into Luong(MaNhanVien,Luong) values(?,?)";
		PreparedStatement cmd = CoSo.cn.prepareStatement(sql);
		cmd.setInt(1,MaNhanVien);
		cmd.setFloat(2, luong);
		return cmd.executeUpdate();
	}
	public int Sua (int MaNhanVien,Float luong)throws Exception{
		String sql = "Update Luong Set Luong=? Where MaNhanVien=?";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setFloat(1, luong);
		cmd.setInt(2,MaNhanVien);
		return cmd.executeUpdate();
	}
	public int Xoa(int MaNhanVien) throws Exception{
		String sql = "Delete from Luong where MaNhanVien = ?";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1, MaNhanVien);
		return cmd.executeUpdate();
	}
}

