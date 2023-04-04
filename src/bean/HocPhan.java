package bean;

public class HocPhan {
	private String mahocphan;
	private String tenhocphan;
	private int sotinchi;
	public String getMahocphan() {
		return mahocphan;
	}
	public void setMahocphan(String mahocphan) {
		this.mahocphan = mahocphan;
	}
	public String getTenhocphan() {
		return tenhocphan;
	}
	public void setTenhocphan(String tenhocphan) {
		this.tenhocphan = tenhocphan;
	}
	public int getSotinchi() {
		return sotinchi;
	}
	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}
	public HocPhan(String mahocphan, String tenhocphan, int sotinchi) {
		super();
		this.mahocphan = mahocphan;
		this.tenhocphan = tenhocphan;
		this.sotinchi = sotinchi;
	}
	
}
