package bo;

import java.util.ArrayList;

import bean.HocPhan;
import bean.LopHoc;
import dao.HocPhandao;
import dao.LopHocdao;

public class HocPhanbo {
	HocPhandao hpdao= new HocPhandao();
	ArrayList<HocPhan> ds;
	public ArrayList<HocPhan> getHocphan() throws Exception{
		ds=hpdao.getHocPhan();
		return ds;
	}
	public int them(String mahocphan, String tenhocphan, int sotinchi) throws Exception{
		//Kiem tra trung ma
    	for(HocPhan hp: ds)
    		if(hp.getMahocphan().equals(mahocphan))
    			return 0;
    	//Them vao bo nho
    	ds.add(new HocPhan(mahocphan,tenhocphan, sotinchi));
    	//Them vao csdl
    	
    	return hpdao.them(mahocphan,tenhocphan, sotinchi);
	}
	public int sua(String mahocphan, String tenhocphan, int sotinchi) throws Exception{
		//Kiem tra trung ma
    	for(HocPhan hp: ds) {
    		if(hp.getMahocphan().equals(mahocphan)) 
    		    hp.setTenhocphan(tenhocphan);
    			hp.setSotinchi(sotinchi);
//    			ds.add(new LopHoc(malop, tenlop));
    			return hpdao.sua(mahocphan,tenhocphan, sotinchi);	
    	}
    	return 0;
			
	}
	 public int xoa(String mahocphan) throws Exception{
	    	for(HocPhan hp: ds)
	    		if(hp.getMahocphan().equals(mahocphan)) {
	    			ds.remove(hp);//Xoa trong bo nho
	    			return hpdao.xoa(mahocphan);//Xoa trong csdl
	    		}
	    	return 0;
	    }
	 public ArrayList<HocPhan> tim(String key) throws Exception {
			ArrayList<HocPhan> r = new ArrayList<HocPhan>();
			for(HocPhan hp : ds)
				if(hp.getMahocphan().equalsIgnoreCase(key) || hp.getTenhocphan().toLowerCase().contains(key.toLowerCase()))
					r.add(hp);
			return r;
		}
}
