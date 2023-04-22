package BLL_NhapHang;

import java.util.ArrayList;

import DAL_NhapHang.NhapHang_DAL;
import DAL_NhapHang.PhieuNhap_DAL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.SanPhamDTO;

public class NhapHang_BLL {
	
	public static void them(ArrayList<ChiTietPhieuNhapDTO> list) {
		
		for (ChiTietPhieuNhapDTO item : list) {		
			NhapHang_DAL.getInstance().insert(item);
		}
		
	}

	public static boolean isSpExist(int maSP) {
		SanPhamDTO sp = NhapHang_DAL.getInstance().getSPinfobyId(maSP);
			if (sp != null) {
			return true;
		}
			else {
			return false;
		}		
	}
	public static SanPhamDTO getSPinfo(int maSP) {
		return NhapHang_DAL.getInstance().getSPinfobyId(maSP);
	}
	
}
