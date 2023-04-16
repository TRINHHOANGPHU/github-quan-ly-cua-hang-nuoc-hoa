package NhapHang_BLL;

import java.util.ArrayList;

import DAL_NhapHang.NhapHang_DAL;
import DTO.ChiTietPhieuNhapDTO;

public class NhapHang_BLL {
	public static void them(ArrayList<ChiTietPhieuNhapDTO> list) {
		for (ChiTietPhieuNhapDTO item : list) {
			NhapHang_DAL.getInstance().insert(item);
		}
	}
}
