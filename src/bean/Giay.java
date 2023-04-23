package bean;

public class Giay {
	private int MaGiay;
	private String TenGiay;
	private	int Size;
	private	float Gia;
	private	int MaLoaiGiay;
	private int MaNhanVien;
	public Giay(int maGiay, String tenGiay, int size, float gia, int maLoaiGiay, int maNhanVien) {
		super();
		MaGiay = maGiay;
		TenGiay = tenGiay;
		Size = size;
		Gia = gia;
		MaLoaiGiay = maLoaiGiay;
		MaNhanVien = maNhanVien;
	}
	public Giay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaGiay() {
		return MaGiay;
	}
	public void setMaGiay(int maGiay) {
		MaGiay = maGiay;
	}
	public String getTenGiay() {
		return TenGiay;
	}
	public void setTenGiay(String tenGiay) {
		TenGiay = tenGiay;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		Gia = gia;
	}
	public int getMaLoaiGiay() {
		return MaLoaiGiay;
	}
	public void setMaLoaiGiay(int maLoaiGiay) {
		MaLoaiGiay = maLoaiGiay;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	
}
