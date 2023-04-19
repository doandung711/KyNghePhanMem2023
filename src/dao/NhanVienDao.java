package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.NhanVien;

public class NhanVienDao {
	ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
	
	
	public ArrayList<NhanVien> getnv() throws SQLException{
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

	public int Them(int MaNhanVien, String HoTen,int Tuoi,String SoDienThoai,String DiaChi,Boolean GioiTinh)throws Exception{
		String sql="insert NhanVien(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1, MaNhanVien);
		cmd.setString(2, HoTen);
		cmd.setInt(3,Tuoi);
		cmd.setString(4,SoDienThoai);
		cmd.setString(5,DiaChi);
		cmd.setBoolean(6,GioiTinh);
		return cmd.executeUpdate();
	}
	public int Sua (int maNhanVien, String hoTen,int tuoi,String soDienThoai,String diaChi,Boolean gioiTinh)throws Exception{
		String sql = "Update NhanVien Set MaNhanVien=maNhanVien, HoTen=hoTen, Tuoi=tuoi, SoDienThoai=soDienThoai,DiaChi=diaChi,GioiTinh=gioiTinh";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1, maNhanVien);
		cmd.setString(2, hoTen);
		cmd.setInt(3,tuoi);
		cmd.setString(4,soDienThoai);
		cmd.setString(5,diaChi);
		cmd.setBoolean(6,gioiTinh);
		return cmd.executeUpdate();
	}
	public int Xoa (int maNhanVien) throws Exception{
		String sql = "delete from NhanVien where MaNhanVien = maNhanVien";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1,maNhanVien);
		return cmd.executeUpdate();
	}
}

