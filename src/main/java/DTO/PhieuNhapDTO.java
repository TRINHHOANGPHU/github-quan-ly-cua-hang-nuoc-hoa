package DTO;

import java.sql.Date;
import java.sql.Time;

public class PhieuNhapDTO {
	private int maPN;
	private int maNCC;
	private int maNV;
	private Date ngayNhap;
	private Time thoiGianNhap;
	private double tongTien;

	public PhieuNhapDTO() {
	}

	public PhieuNhapDTO(int maPN, int maNCC, int maNV, Date ngayNhap, Time thoiGianNhap, double tongTien) {
		this.maPN = maPN;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngayNhap = ngayNhap;
		this.thoiGianNhap = thoiGianNhap;
		this.tongTien = tongTien;
	}

	public int getMaPN() {
		return maPN;
	}

	public void setMaPN(int maPN) {
		this.maPN = maPN;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public Time getThoiGianNhap() {
		return thoiGianNhap;
	}

	public void setThoiGianNhap(Time thoiGianNhap) {
		this.thoiGianNhap = thoiGianNhap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return maPN+" "+maNCC+" "+maNV+" "+ngayNhap.toString()+" "+thoiGianNhap.toString()+" "+tongTien;
	}
}
