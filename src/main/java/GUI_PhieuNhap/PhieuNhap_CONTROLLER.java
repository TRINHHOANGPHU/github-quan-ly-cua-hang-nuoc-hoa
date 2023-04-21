package GUI_PhieuNhap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import BLL_NhapHang.PhieuNhap_BLL;
import DAL_NhapHang.PhieuNhap_DAL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import GUI_NhapHang.ChiTietPhieuNhap_VIEW;

public class PhieuNhap_CONTROLLER implements MouseListener{
	
	PhieuNhap_VIEW context;
	ArrayList<PhieuNhapDTO> list;
	ArrayList<PhieuNhapDTO> Findlist;
	
	public PhieuNhap_CONTROLLER(PhieuNhap_VIEW context) {
		this.context = context;
		list = PhieuNhap_DAL.getInstance().getAll();
	}

	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource().equals(context.Tim_btn)) {
			
			if (context.getFindDate() == null) return;
			
			Findlist = new ArrayList<PhieuNhapDTO>();
			for (PhieuNhapDTO row : list) {
				if (row.getNgayNhap().equals(context.getFindDate())) {
					Findlist.add(row);
				}
			}
			context.updateTable(Findlist);
		}
		
		
		if (e.getSource().equals(context.Huy_btn)) {
			
			context.updateTable(list);
			
		}
		
		if (e.getSource().equals(context.Detail_btn)) {
						
			int currRow = context.jTable.getSelectedRow();
			if (currRow == -1) {
				context.activateWarning("Vui lòng chọn phiếu nhập để xem chi tiết!");
				return;
			};
			
			int detailMaPN = (Integer) context.jTable.getValueAt(currRow,0);
			
			ArrayList<ChiTietPhieuNhapDTO> detailList = PhieuNhap_BLL.getChiTietByMaPN(detailMaPN);
			PhieuNhapDTO phieuNhap = PhieuNhap_BLL.getByID(detailMaPN);
			
			ChiTietPhieuNhap_VIEW ctpn = new ChiTietPhieuNhap_VIEW(detailList, phieuNhap);

		}
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
		context.updateTable(list);
	}
}
