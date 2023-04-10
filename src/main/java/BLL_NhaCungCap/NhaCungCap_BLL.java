package BLL_NhaCungCap;

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
}
