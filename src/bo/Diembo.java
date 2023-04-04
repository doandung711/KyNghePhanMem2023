package bo;

import java.util.ArrayList;

import bean.Diem;
import dao.Diemdao;

public class Diembo {
	Diemdao ddao= new Diemdao();
	ArrayList<Diem> ds;
	public ArrayList<Diem> getDiem() throws Exception{
		ds=ddao.getDiem();
		return ds;
	}
	public int them(String masv, float diemmon1, float diemmon2,String mahocphan) throws Exception{
		//Kiem tra trung ma
    	for(Diem d: ds)
    		if(d.getMasv().equals(masv))
    			return 0;
    	//Them vao bo nho
    	ds.add(new Diem(masv,diemmon1,diemmon2, mahocphan));
    	//Them vao csdl
    	
    	return ddao.them(masv,diemmon1,diemmon2, mahocphan);
	}
	public int sua(String masv, float diemmon1, float diemmon2, String mahocphan) throws Exception{
		//Kiem tra trung ma
    	for(Diem d: ds) {
    		if(d.getMasv().equals(masv)) 
    		    d.setDiemmon1(diemmon1);
    			d.setDiemmon2(diemmon2);
    			d.setMahocphan(mahocphan);
    			return ddao.sua(masv,diemmon1,diemmon2, mahocphan);	
    	}
    	return 0;
			
	}
	 public int xoa(String masv) throws Exception{
	    	for(Diem d: ds)
	    		if(d.getMasv().equals(masv)) {
	    			ds.remove(d);//Xoa trong bo nho
	    			return ddao.xoa(masv);//Xoa trong csdl
	    		}
	    	return 0;
	    }
	 public ArrayList<Diem> tim(String key) throws Exception {
			ArrayList<Diem> r = new ArrayList<Diem>();
			for(Diem d : ds)
				if(d.getMasv().equalsIgnoreCase(key))
					r.add(d);
			return r;
		}
	 
}
