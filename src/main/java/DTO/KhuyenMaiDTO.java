package DTO;

import java.sql.Date;

public class KhuyenMaiDTO {
	private int maKM;
	private String tenKM;
	private double dieuKienKM;
	private double phanTramKM;
	private Date ngayBD;
	private Date ngayKT;

	public KhuyenMaiDTO() {
	}

	public KhuyenMaiDTO(int maKM, String tenKM, double dieuKienKM, double phanTramKM, Date ngayBD, Date ngayKT) {
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.dieuKienKM = dieuKienKM;
		this.phanTramKM = phanTramKM;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}

	public int getMaKM() {
		return maKM;
	}

	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public double getDieuKienKM() {
		return dieuKienKM;
	}

	public void setDieuKienKM(double dieuKienKM) {
		this.dieuKienKM = dieuKienKM;
	}

	public double getPhanTramKM() {
		return phanTramKM;
	}

	public void setPhanTramKM(double phanTramKM) {
		this.phanTramKM = phanTramKM;
	}

	public Date getNgayBD() {
		return ngayBD;
	}

	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}

	public Date getNgayKT() {
		return ngayKT;
	}

	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}

}
