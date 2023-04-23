package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.Giay;
import bean.NhanVien;
import dao.GiayDao;
import dao.NhanVienDao;

public class GiayBo {
	GiayDao gdao = new GiayDao();
	ArrayList<Giay> dsg= new  ArrayList<Giay>();
		
	public ArrayList<Giay> getgiay() throws SQLException{
		dsg = gdao.getgiay();
		return dsg;
	}
	
	public int Them(int maGiay, String TenGiay, int Size, Float Gia, int maLoaiGiay,int maNhanVien)throws Exception {
		
//		System.out.print(dsnv.get(MaNhanVien));
		for(Giay g : dsg) {
			if(g.getMaNhanVien()==maGiay) 
				return 0;
		}
		dsg.add(new Giay(maGiay,TenGiay,Size,Gia,maLoaiGiay,maNhanVien));
		return gdao.Them(maGiay,TenGiay,Size,Gia,maLoaiGiay,maNhanVien);
	}
	public int Sua(int maGiay, String TenGiay, int Size, Float Gia, int maLoaiGiay,int maNhanVien)throws Exception {
		for(Giay g: dsg) {
			if(g.getMaGiay()==maGiay) {
				g.setTenGiay(TenGiay);
				g.setSize(Size);
				g.setGia(Gia);
				g.setMaLoaiGiay(maLoaiGiay);
				g.setMaNhanVien(maNhanVien);
				return gdao.Sua(maGiay, TenGiay, Size, Gia, maLoaiGiay, maNhanVien);
			}
		}
		return 0;
	}
	public int Xoa(int MaGiay)throws Exception{
		for(Giay g:dsg) {
			if(g.getMaGiay()==MaGiay)
				dsg.remove(g);
				return gdao.Xoa(MaGiay);
		}
		return 0;
	}
	public ArrayList<Giay> Tim(String key) throws Exception{
   	 ArrayList<Giay> tam= new ArrayList<Giay>();
   	 
   	 for(Giay giay: dsg) {
   		 if(giay.getMaGiay()==Integer.parseInt(key))
   			 tam.add(giay);
   	 }
   	 return tam;
   }
	 	
	
	 
}
