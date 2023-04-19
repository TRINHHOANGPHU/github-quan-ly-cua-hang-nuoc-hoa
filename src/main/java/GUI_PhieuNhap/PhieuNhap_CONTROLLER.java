package GUI_PhieuNhap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import DAL_NhapHang.PhieuNhap_DAL;
import DTO.PhieuNhapDTO;

public class PhieuNhap_CONTROLLER implements MouseListener{
	
	PhieuNhap_VIEW context;
	ArrayList<PhieuNhapDTO> list;
	
	public PhieuNhap_CONTROLLER(PhieuNhap_VIEW context) {
		this.context = context;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void loadData() {
		list = PhieuNhap_DAL.getInstance().getAll();
		context.updateTable(list);
	}
}
