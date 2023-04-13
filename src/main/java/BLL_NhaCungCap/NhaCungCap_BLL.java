package BLL_NhaCungCap;

import java.util.ArrayList;

import DAL_NhaCungCap.NhaCungCap_DAL;
import DTO.NhaCungCapDTO;

public class NhaCungCap_BLL {
	private NhaCungCap_DAL nhaCungCap_DAL;

	public NhaCungCap_BLL() {
		this.nhaCungCap_DAL = new NhaCungCap_DAL();
	}
	
	public int them(NhaCungCapDTO nhaCungCapDTO) {
		return this.nhaCungCap_DAL.them(nhaCungCapDTO);
	}
	
	public ArrayList<NhaCungCapDTO> getList_NhaCungCap(){
		return this.nhaCungCap_DAL.getList_NhaCungCap();
	}
	
	public int layGiaTriLonNhat_ColumnMaNCC() {
		return this.nhaCungCap_DAL.layGiaTriLonNhat_ColumnMaNCC();
	}
	
	public void xoaMotDongDuaVaoMaNCC(NhaCungCapDTO nhaCungCapDTO) {
		this.nhaCungCap_DAL.xoaMotDongDuaVaoMaNCC(nhaCungCapDTO);
	}
	
	public void suaMotDongDuaVaoMaNCC(NhaCungCapDTO nhaCungCapDTO) {
		this.nhaCungCap_DAL.suaMotDongDuaVaoMaNCC(nhaCungCapDTO);
	}
}
