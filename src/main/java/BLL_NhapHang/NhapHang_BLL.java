package BLL_NhapHang;

import java.util.ArrayList;

import DAL_NhapHang.NhapHang_DAL;
import DTO.ChiTietPhieuNhapDTO;

public class NhapHang_BLL {
	
	public static void them(ArrayList<ChiTietPhieuNhapDTO> list) {
		boolean isSuccess;
		for (ChiTietPhieuNhapDTO item : list) {
			
			isSuccess = NhapHang_DAL.getInstance().insert(item);
			if (!isSuccess) {
				
			}	
		}
		
	}
	
}
