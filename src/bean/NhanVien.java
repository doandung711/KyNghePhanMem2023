package bean;



public class NhanVien {
	private int MaNhanVien;
	private String HoTen;
	private int Tuoi;
	private String SoDienThoai;
	private String DiaChi;
	private boolean GioiTinh;
	public NhanVien(int maNhanVien, String hoTen, int tuoi, String soDienThoai, String diaChi, boolean  gioiTinh) {
		super();
		MaNhanVien = maNhanVien;
		HoTen = hoTen;
		Tuoi = tuoi;
		SoDienThoai = soDienThoai;
		DiaChi = diaChi;
		GioiTinh = gioiTinh;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public int getTuoi() {
		return Tuoi;
	}
	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean GioiTinh) {
		this.GioiTinh = GioiTinh;
	}
		
}
