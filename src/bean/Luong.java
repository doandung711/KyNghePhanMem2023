package bean;

public class Luong {
	public int MaNhanVien;
	public float luong;
	public Luong(int maNhanVien, float luong) {
		super();
		MaNhanVien = maNhanVien;
		this.luong = luong;
	}
	public Luong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
}
