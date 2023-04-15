package GUI_NhapHang;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;


public class NhapHang_CONTROLLER implements MouseListener{
	
	private NhapHang_VIEW context;
	private ArrayList<ChiTietPhieuNhapDTO> list;
	private PhieuNhapDTO phieuNhapNew;
	private static int autoPhieuNhapID = 0;
	
	NhapHang_CONTROLLER(NhapHang_VIEW c){
		this.context = c;
		list = new ArrayList<ChiTietPhieuNhapDTO>();
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if (e.getSource().equals(context.NhapHang_btn)) {
			context.activeNhapHang();
			phieuNhapNew = new PhieuNhapDTO();
			phieuNhapNew.setMaPN(++autoPhieuNhapID);
		}
		
		if (e.getSource().equals(context.Them_btn)) {
			try {
				int maPN = phieuNhapNew.getMaPN();
				int maSP = Integer.valueOf(context.maSPtext.getText());
				int SoLuong = Integer.valueOf(context.SoLuongtext.getText());
				Double DonGia = Double.valueOf(context.donGiatext.getText());
				
				list.add(new ChiTietPhieuNhapDTO(maPN,maSP,SoLuong,DonGia));
				context.updateTable(list);
				context.clearTextField();
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
				
			}
		}
	}

	

	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
