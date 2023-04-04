package bean;

import java.awt.Component;

public class LopHoc {
	private String malop;
	private String tenlop;
	
	public LopHoc(String malop, String tenlop) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	
}
