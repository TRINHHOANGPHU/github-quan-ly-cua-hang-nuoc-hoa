package DTO;

public class PhanQuyenDTO {
	private int maQuyen;
	private String tenQuyen;
	private String chiTietQuyen;

	public PhanQuyenDTO() {
	}

	public PhanQuyenDTO(int maQuyen, String tenQuyen, String chiTietQuyen) {
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.chiTietQuyen = chiTietQuyen;
	}

	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public String getChiTietQuyen() {
		return chiTietQuyen;
	}

	public void setChiTietQuyen(String chiTietQuyen) {
		this.chiTietQuyen = chiTietQuyen;
	}

	
}
