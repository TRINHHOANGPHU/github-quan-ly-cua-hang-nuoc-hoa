package DTO;

public class SanPhamDTO {
	private int maSP;
	private int maLoaiSP;
	private String tenSP;
	private double giaNhap;
	private double giaBan;
	private int soLuong;
	private String hinh;
	private int trangThai;

	public SanPhamDTO() {
	}

	public SanPhamDTO(int maSP, int maLoaiSP, String tenSP, double giaNhap, double giaBan, int soLuong, String hinh,
			int trangThai) {
		this.maSP = maSP;
		this.maLoaiSP = maLoaiSP;
		this.tenSP = tenSP;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.hinh = hinh;
		this.trangThai = trangThai;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}
