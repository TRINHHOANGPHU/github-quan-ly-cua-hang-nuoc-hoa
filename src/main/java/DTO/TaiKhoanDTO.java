package DTO;

public class TaiKhoanDTO {
	private String tenTaiKhoan;
	private String matKhau;
	private int maNV;
	private int maQuyen;

	public TaiKhoanDTO() {
	}

	public TaiKhoanDTO(String tenTaiKhoan, String matKhau, int maNV, int maQuyen) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.maNV = maNV;
		this.maQuyen = maQuyen;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

}
