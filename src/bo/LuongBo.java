package bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import bean.Giay;
import bean.Luong;
import dao.LuongDao;

public class LuongBo {
	LuongDao ldao = new LuongDao();
	ArrayList<Luong> dsl = new ArrayList<Luong>();
	public ArrayList<Luong> getLuong() throws SQLException{
			dsl=ldao.getLuong();
			return dsl;
	}
public int Them(int MaNhanVien, Float Luong)throws Exception {
		
//		System.out.print(dsnv.get(MaNhanVien));
		for(Luong l : dsl) {
			if(l.getMaNhanVien()==MaNhanVien) 
				return 0;
		}
		dsl.add(new Luong(MaNhanVien, Luong));
		return ldao.Them(MaNhanVien, Luong);
	}
	public int Sua(int MaNhanVien,Float Luong)throws Exception {
		for(Luong l: dsl) {
			if(l.getMaNhanVien()==MaNhanVien) {
				l.setLuong(Luong);
				return ldao.Sua(MaNhanVien, Luong);
			}
		}
		return 0;
	}
	public int Xoa(int MaNhanVien)throws Exception{
		for(Luong l:dsl) {
			if(l.getMaNhanVien()==MaNhanVien)
				dsl.remove(l);
				return ldao.Xoa(MaNhanVien);
		}
		return 0;
	}
	public ArrayList<Luong> Tim(String key) throws Exception{
   	 ArrayList<Luong> tam= new ArrayList<Luong>();
   	 
   	 for(Luong l: dsl) {
   		 if(l.getMaNhanVien()==Integer.parseInt(key))
   			 tam.add(l);
   	 }
   	 return tam;
   }
}
