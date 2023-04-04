package bo;

import java.util.ArrayList;

import bean.Diem;
import bean.LopHoc;
import dao.LopHocdao;

public class LopHocbo {
	LopHocdao lhdao= new LopHocdao();
	ArrayList<LopHoc> ds;
	public ArrayList<LopHoc> getLop() throws Exception{
		ds=lhdao.getLop();
		return ds;
	}
	public int them(String malop, String tenlop) throws Exception{
		//Kiem tra trung ma
    	for(LopHoc lh: ds)
    		if(lh.getMalop().equals(malop))
    			return 0;
    	//Them vao bo nho
    	ds.add(new LopHoc(malop, tenlop));
    	//Them vao csdl
    	
    	return lhdao.them(malop, tenlop);
	}
	public int sua(String malop, String tenlop) throws Exception{
		//Kiem tra trung ma
    	for(LopHoc lh: ds) {
    		if(lh.getMalop().equals(malop)) 
    		    lh.setTenlop(tenlop);
//    			ds.add(new LopHoc(malop, tenlop));
    		//sua trong csdl
    			return lhdao.sua(malop, tenlop);	
    	}
    	return 0;
			
	}
	 public int xoa(String malop) throws Exception{
	    	for(LopHoc lh: ds)
	    		if(lh.getMalop().equals(malop)) {
	    			ds.remove(lh);//Xoa trong bo nho
	    			return lhdao.xoa(malop);//Xoa trong csdl
	    		}
	    	return 0;
	    }
	 public ArrayList<LopHoc> tim(String key) throws Exception {
			ArrayList<LopHoc> r = new ArrayList<LopHoc>();
			for(LopHoc lh : ds)
				if(lh.getMalop().equalsIgnoreCase(key) || lh.getTenlop().toLowerCase().contains(key.toLowerCase()))
					r.add(lh);
			return r;
		}
}
