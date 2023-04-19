package BLL_NhapHang;

import java.sql.Date;
import java.sql.Time;

import DAL_NhapHang.PhieuNhap_DAL;
import DTO.PhieuNhapDTO;

public class PhieuNhap_BLL {
	
	public PhieuNhap_BLL() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean them(PhieuNhapDTO pn) {	
		return PhieuNhap_DAL.getInstance().insert(pn);	
	}
	
	public static void getCurrentDate(PhieuNhapDTO phieunhap) {
		long millis = System.currentTimeMillis();
		Date curDate = new java.sql.Date(millis);
		Time curTime = new java.sql.Time(millis);
		
		phieunhap.setNgayNhap(curDate);
		phieunhap.setThoiGianNhap(curTime);
	}

}
