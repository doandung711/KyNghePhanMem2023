package bo;

import java.util.ArrayList;

import bean.NhanVien;
import dao.NhanVienDao;

public class NhanVienBo {
	NhanVienDao nvdao = new NhanVienDao();
	ArrayList<NhanVien> dsnv= new  ArrayList<NhanVien>();
	
	public ArrayList<NhanVien> getnv(){
		dsnv = nvdao.getnv();
		return dsnv;
	}
	
	public int Them(int MaNhanVien, String HoTen, int Tuoi, String SoDienThoai, String DiaChi, boolean  GioiTinh) {
		for(NhanVien nv : dsnv) {
			if(nv.getMaNhanVien()==MaNhanVien) 
				return 0;
			else
				dsnv.add(new NhanVien(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh));
			return nvdao.Them(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh);
		}
		
	}
}

