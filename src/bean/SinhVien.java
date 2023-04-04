package bean;

public class SinhVien extends Nguoi {
	private String masv;
	private String malop;
	public SinhVien(String masv, String hoten ,String diachi, Boolean gioitinh,int tuoi ,String malop) {
		super( hoten, tuoi, diachi, gioitinh);//truyen 3 tham so len cho lop nguoi 
		this.masv = masv;
		this.malop = malop;
	}
	
	public SinhVien(String hoten, int tuoi, String diachi, boolean gioitinh) {
		super(hoten, tuoi, diachi, gioitinh);
		// TODO Auto-generated constructor stub
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	
}
