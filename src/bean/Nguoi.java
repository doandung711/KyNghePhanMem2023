package bean;

import java.util.Date;

public class Nguoi {
	protected String HoTen;
	protected int tuoi;
	protected String diachi;
	protected boolean gioitinh;
	
	public Nguoi(String hoTen, int tuoi, String diachi, boolean gioitinh) {
		super();
		HoTen = hoTen;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	
	
}
