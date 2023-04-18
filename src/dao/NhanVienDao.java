package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.NhanVien;

public class NhanVienDao {
	ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
	
	
	public ArrayList<NhanVien> getnv(){
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		
		String sql="select * from NhanVien";
		
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		
		ResultSet rs= cmd.executeQuery();
			while(rs.next()) {
				int MaNhanVien = rs.getInt("MaNhanVien");
				String HoTen = rs.getString("TenNhanVien");
				int Tuoi = rs.getInt("Tuoi");
				String SoDienThoai = rs.getString("SoDienThoai");
				String DiaChi = rs.getString("DiaChi");
				Boolean GioiTinh = rs.getBoolean("GioiTinh");
				
				NhanVien nhanVien = new NhanVien(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh);
				dsnv.add(nhanVien);
			}
		
		rs.close();
		return dsnv;
	}

	public int Them(int MaNhanVien, String HoTen,int Tuoi,String SoDienThoai,String DiaChi,Boolean GioiTinh))throws Exception{
		String sql="";
		PreparedStatement cmd= CoSo.cn.prepareStatement(sql);
		cmd.setInt(1, MaNhanVien);
		cmd.setString(2, HoTen);
		cmd.setInt(3,Tuoi);
		cmd.setString(4,SoDienThoai);
		cmd.setString(5,DiaChi);
		cmd.setBoolean(6,GioiTinh);
		return cmd.executeUpdate();
	}
}

