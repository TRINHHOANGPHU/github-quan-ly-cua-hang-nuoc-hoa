package BLL_QuanLySanPham;

import java.util.ArrayList;


import DAL_QuanLySanPham.QuanLySanPham_DAL;
import DTO.SanPhamDTO;
import DTO.LoaiSanPhamDTO;

public class QuanLySanPham_BLL {
	private QuanLySanPham_DAL quanLySanPham_DAL;

	public QuanLySanPham_BLL() {
		this.quanLySanPham_DAL = new QuanLySanPham_DAL();
	}
	
	//Sản phẩm
	public int them(SanPhamDTO sanPhamDTO) {
		return this.quanLySanPham_DAL.them(sanPhamDTO);
	}
	
	public ArrayList<SanPhamDTO> getList_SanPham(){
		return this.quanLySanPham_DAL.getList_SanPham();
	}
	
	public int layGiaTriLonNhat_ColumnMaSP() {
		return this.quanLySanPham_DAL.layGiaTriLonNhat_ColumnMaSP();
	}
	
	public void xoaMotDongDuaVaoMaSP(SanPhamDTO sanPhamDTO) {
		this.quanLySanPham_DAL.xoaMotDongDuaVaoMaSP(sanPhamDTO);
	}
	
	public void suaMotDongDuaVaoMaSP(SanPhamDTO sanPhamDTO) {
		this.quanLySanPham_DAL.suaMotDongDuaVaoMaSP(sanPhamDTO);
	}
	
	//Loại sản phẩm
	public int them(LoaiSanPhamDTO loaiSanPhamDTO) {
		return this.quanLySanPham_DAL.them(loaiSanPhamDTO);
	}
	
	public ArrayList<LoaiSanPhamDTO> getList_LoaiSanPham(){
		return this.quanLySanPham_DAL.getList_LoaiSanPham();
	}
	
	public int layGiaTriLonNhat_ColumnMaLoaiSP() {
		return this.quanLySanPham_DAL.layGiaTriLonNhat_ColumnMaLoaiSP();
	}
	
	public void xoaMotDongDuaVaoMaLoaiSP(LoaiSanPhamDTO loaiSanPhamDTO) {
		this.quanLySanPham_DAL.xoaMotDongDuaVaoMaLoaiSP(loaiSanPhamDTO);
	}
	
	public void suaMotDongDuaVaoMaLoaiSP(LoaiSanPhamDTO loaiSanPhamDTO) {
		this.quanLySanPham_DAL.suaMotDongDuaVaoMaLoaiSP(loaiSanPhamDTO);
	}
	
}