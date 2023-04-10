package DTO;

import java.sql.Date;
import java.sql.Time;

public class HoaDonDTO {
	private int maHD;
	private int maNV;
	private int maKH;
	private int maKM;
	private Date ngayLapHD;
	private Time thoiGianLapHD;
	private double tongTien;

	public HoaDonDTO() {
	}

	public HoaDonDTO(int maHD, int maNV, int maKH, int maKM, Date ngayLapHD, Time thoiGianLapHD, double tongTien) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maKM = maKM;
		this.ngayLapHD = ngayLapHD;
		this.thoiGianLapHD = thoiGianLapHD;
		this.tongTien = tongTien;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public int getMaKM() {
		return maKM;
	}

	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}

	public Date getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public Time getThoiGianLapHD() {
		return thoiGianLapHD;
	}

	public void setThoiGianLapHD(Time thoiGianLapHD) {
		this.thoiGianLapHD = thoiGianLapHD;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}
