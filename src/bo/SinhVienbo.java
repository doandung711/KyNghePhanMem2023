package bo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.LopHoc;
import bean.SinhVien;
import dao.Sinhviendao;

public class SinhVienbo {
	Sinhviendao svdao= new Sinhviendao();
	ArrayList<SinhVien> dssv; 
	 public int them(String masv, String hoten, String diachi, Boolean gioitinh, int tuoi,String malop) throws Exception{
		   for(SinhVien sv: dssv)
			   if(sv.getMasv().equals(masv))
				   return 0;
		   //Them vao bo nho
		   dssv.add(new SinhVien(masv,hoten, diachi, gioitinh, tuoi, malop));
		return  svdao.them(masv, hoten, diachi, gioitinh,tuoi, malop);
	   }
	public ArrayList<SinhVien> getsv() throws Exception{
		dssv=svdao.getSv();
		return dssv;
	}
	public int sua(String masv, String hoten, String diachi, Boolean gioitinh, int tuoi,String malop) throws Exception{
		//Kiem tra trung ma
    	for(SinhVien sv: dssv) {
    		if(sv.getMasv().equals(masv))
    		sv.setHoTen(hoten);
    		sv.setDiachi(diachi);
    		sv.setGioitinh(gioitinh);
    		sv.setTuoi(tuoi);
    		sv.setMalop(malop);
    		return svdao.sua(masv, hoten, diachi, gioitinh,tuoi, malop);
    		
    	}
    	return 0;
	}
	public int xoa(String masv) throws Exception{
    	for(SinhVien sv: dssv)
    		if(sv.getMasv().equals(masv)) {
    			dssv.remove(sv);//Xoa trong bo nho
    			return svdao.xoa(masv);//Xoa trong csdl
    		}
    	return 0;
    }
	 public ArrayList<SinhVien> tim(String key) throws Exception {
			ArrayList<SinhVien> r = new ArrayList<SinhVien>();
			for(SinhVien sv : dssv)
				if(sv.getMasv().equalsIgnoreCase(key) || sv.getHoTen().toLowerCase().contains(key.toLowerCase()))
					r.add(sv);
			return r;
		}
}
