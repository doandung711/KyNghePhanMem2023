package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.NhanVien;

public class NhanVienDao {
    ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
	
	
	public static ArrayList<NhanVien> getnv() throws SQLException{
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		String sql="select * from NhanVien";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
			while(rs.next()) {
				int MaNhanVien = rs.getInt(1);
				String HoTen = rs.getString(2);
				int Tuoi = rs.getInt(3);
				String SoDienThoai = rs.getString(4);
				String DiaChi = rs.getString(5);
				Boolean GioiTinh = rs.getBoolean(6);
				NhanVien nhanVien = new NhanVien(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh);
				dsnv.add(nhanVien);
			}
		rs.close();
		return dsnv;
	}

	public int Them(int maNhanVien, String hoTen,int tuoi,String soDienThoai,String diaChi,Boolean gioiTinh)throws Exception{
		int gioiTinhbit = gioiTinh ? 1:0;
		String sql = "INSERT INTO NhanVien(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh) Values(?,?,?,?,?,?)";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
			cmd.setInt(1, maNhanVien);
			cmd.setString(2, hoTen);
			cmd.setInt(3,tuoi);
			cmd.setString(4,soDienThoai);
			cmd.setString(5,diaChi);
			cmd.setBoolean(6,gioiTinh);
			int kt = cmd.executeUpdate();
			cmd.close();
			return kt;
	}
	public int Sua (int maNhanVien, String hoTen,int tuoi,String soDienThoai,String diaChi,Boolean gioiTinh)throws Exception{
		String sql = "Update NhanVien Set MaNhanVien=?, HoTen=?, Tuoi=?, SoDienThoai=?,DiaChi=?,GioiTinh=? Where MaNhanVien=?";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1, maNhanVien);
		cmd.setString(2, hoTen);
		cmd.setInt(3,tuoi);
		cmd.setString(4,soDienThoai);
		cmd.setString(5,diaChi);
		cmd.setBoolean(6,gioiTinh);
		cmd.setInt(7,maNhanVien);
		return cmd.executeUpdate();
	}
	public int Xoa (int maNhanVien) throws Exception{
		String sql = "delete from NhanVien where MaNhanVien =?";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1,maNhanVien);
		return cmd.executeUpdate();
	}
	
}

