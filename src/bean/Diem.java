package bean;

public class Diem {
	private String masv;
	private float diemmon1;
	private float diemmon2;
	private String mahocphan;
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public float getDiemmon1() {
		return diemmon1;
	}
	public void setDiemmon1(float diemmon1) {
		this.diemmon1 = diemmon1;
	}
	public float getDiemmon2() {
		return diemmon2;
	}
	public void setDiemmon2(float diemmon2) {
		this.diemmon2 = diemmon2;
	}
	public String getMahocphan() {
		return mahocphan;
	}
	public void setMahocphan(String mahocphan) {
		this.mahocphan = mahocphan;
	}
	public Diem(String masv, float diemmon1, float diemmon2, String mahocphan) {
		super();
		this.masv = masv;
		this.diemmon1 = diemmon1;
		this.diemmon2 = diemmon2;
		this.mahocphan = mahocphan;
	}
	
	
}
