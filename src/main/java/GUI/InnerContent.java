package GUI;

import java.awt.Color;

import GUI_ChiTietPhieuNhap.ChiTietPhieuNhap_VIEW;
import GUI_NhaCungCap.NhaCungCap_VIEW;

public class InnerContent {

	public InnerContent() {
		if (MenuLeft_CONTROLLER.flag == 1) {
			Content_VIEW.jPanel_Content.setBackground(Color.BLACK);
		} else if (MenuLeft_CONTROLLER.flag == 2) {
			Content_VIEW.jPanel_Content.setBackground(Color.GREEN);
		} else if (MenuLeft_CONTROLLER.flag == 3) {
			Content_VIEW.jPanel_Content.setBackground(Color.BLUE);
		} else if (MenuLeft_CONTROLLER.flag == 4) {
			Content_VIEW.jPanel_Content.setBackground(Color.PINK);
		} else if (MenuLeft_CONTROLLER.flag == 5) {
			
		} else if (MenuLeft_CONTROLLER.flag == 6) {
			new ChiTietPhieuNhap_VIEW();
		} else if (MenuLeft_CONTROLLER.flag == 7) {
			
		} else if (MenuLeft_CONTROLLER.flag == 8) {
			new NhaCungCap_VIEW();
		} else if (MenuLeft_CONTROLLER.flag == 9) {
			
		} else if (MenuLeft_CONTROLLER.flag == 10) {
			
		} else if (MenuLeft_CONTROLLER.flag == 11) {
			
		} else if (MenuLeft_CONTROLLER.flag == 12) {
			
		} else if (MenuLeft_CONTROLLER.flag == 13) {
			
		} else if (MenuLeft_CONTROLLER.flag == 14) {
			
		}
	}
	
}
