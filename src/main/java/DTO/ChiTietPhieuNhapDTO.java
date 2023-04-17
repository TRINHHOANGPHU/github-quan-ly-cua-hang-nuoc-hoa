package DTO;

public class ChiTietPhieuNhapDTO {
	private int maPN;
	private int maSP;
	private int soLuong;
	private double donGia;

	public ChiTietPhieuNhapDTO() {
	}

	public ChiTietPhieuNhapDTO(int maPN, int maSP, int soLuong, double donGia) {
		this.maPN = maPN;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public int getMaPN() {
		return maPN;
	}

	public void setMaPN(int maPN) {
		this.maPN = maPN;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String toString() {
		return maPN+" "+maSP+" "+soLuong+" "+donGia ;
	}
}
