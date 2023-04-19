package BLL_NhapHang;

import java.util.ArrayList;

import DAL_NhapHang.NhapHang_DAL;
import DAL_NhapHang.PhieuNhap_DAL;
import DTO.ChiTietPhieuNhapDTO;

public class NhapHang_BLL {
	
	public static void them(ArrayList<ChiTietPhieuNhapDTO> list) {
		
		for (ChiTietPhieuNhapDTO item : list) {		
			NhapHang_DAL.getInstance().insert(item);
		}
		
	}

	public static boolean isSpExist(int maSP) {
		
		// Chờ DAL của sản phẩm xong mới làm
		return true;
	}
	
}
