package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.NhanVien;
import dao.NhanVienDao;

public class NhanVienBo {
	NhanVienDao nvdao = new NhanVienDao();
	ArrayList<NhanVien> dsnv= new  ArrayList<NhanVien>();
	
	public ArrayList<NhanVien> getnv() throws SQLException{
		dsnv = nvdao.getnv();
		return dsnv;
	}
	
	public int Them(int MaNhanVien, String HoTen, int Tuoi, String SoDienThoai, String DiaChi, boolean  GioiTinh)throws Exception {
		for(NhanVien nv : dsnv) {
			if(nv.getMaNhanVien()==MaNhanVien) 
				return 0;
			else
				dsnv.add(new NhanVien(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh));
		}
		return nvdao.Them(MaNhanVien,HoTen,Tuoi,SoDienThoai,DiaChi,GioiTinh);
	}
	public int Sua(int MaNhanVien, String HoTen, int Tuoi, String SoDienThoai, String DiaChi, boolean  GioiTinh)throws Exception {
		for(NhanVien nv: dsnv) {
			if(nv.getMaNhanVien()==MaNhanVien) {
				nv.setHoTen(HoTen);
				nv.setTuoi(Tuoi);
				nv.setSoDienThoai(SoDienThoai);
				nv.setDiaChi(DiaChi);
				nv.setGioiTinh(GioiTinh);
				nvdao.Sua(MaNhanVien, HoTen, Tuoi, SoDienThoai, DiaChi, GioiTinh);
			}
		}
		return 0;
	}
	public int Xoa(int MaNhanVien)throws Exception{
		for(NhanVien nv:dsnv) {
			if(nv.getMaNhanVien()==MaNhanVien)
				dsnv.remove(nv);
				return nvdao.Xoa(MaNhanVien);
		}
		return 0;
	}
	public ArrayList<NhanVien> Tim(int key) throws Exception{
   	 ArrayList<NhanVien> tam= new ArrayList<NhanVien>();
   	 for(NhanVien nv: dsnv)
   		 if(nv.getMaNhanVien()==(key))
   			 tam.add(nv);
   	 return tam;
   }
	 
}
