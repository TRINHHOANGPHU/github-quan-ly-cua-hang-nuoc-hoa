package GUI_NhapHang;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import BLL_NhapHang.NhapHang_BLL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;

// Thiếu validate input !!!!
public class NhapHang_CONTROLLER implements MouseListener{
	
	private NhapHang_VIEW context;
	private ArrayList<ChiTietPhieuNhapDTO> list;
	private PhieuNhapDTO phieuNhapNew;
	private ChiTietPhieuNhapDTO actionNhapHang;
	private static int autoPhieuNhapID = 0;
	private int currentRow = 0;
	
	NhapHang_CONTROLLER(NhapHang_VIEW c){
		this.context = c;
		list = new ArrayList<ChiTietPhieuNhapDTO>();
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		// Xử lý khởi tạo phiếu nhập để thực hiện nhập hàng
		if (e.getSource().equals(context.NhapHang_btn)) {
			context.activeNhapHang();
			phieuNhapNew = new PhieuNhapDTO();
			phieuNhapNew.setMaPN(++autoPhieuNhapID);
		}
		
		// Xử lý thêm 1 dòng vào phiếu nhập
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
		
		
		// Xử lý chọn 1 hàng 
		if (e.getSource().equals(context.jTable)) {	
			currentRow = context.jTable.getSelectedRow();
			int maSP 		= (Integer) context.jTable.getValueAt(currentRow, 0);
			int SoLuong 	= (Integer) context.jTable.getValueAt(currentRow, 1);
			Double DonGia 	= (Double) 	context.jTable.getValueAt(currentRow, 2);
			
			context.setText(maSP, SoLuong, DonGia);
			actionNhapHang = new ChiTietPhieuNhapDTO(phieuNhapNew.getMaPN(),maSP,SoLuong,DonGia);
			
			context.Sua_btn.setEnabled(true);
			context.Xoa_btn.setEnabled(true);
		}
		
		// Xử lý sửa hàng item nhập đã chọn
		if (e.getSource().equals(context.Sua_btn)) {
			int maSP = Integer.valueOf(context.maSPtext.getText());
			int SoLuong = Integer.valueOf(context.SoLuongtext.getText());
			Double DonGia = Double.valueOf(context.donGiatext.getText());
			
			if (actionNhapHang.getMaSP() != maSP || 
				actionNhapHang.getSoLuong() != SoLuong ||
				actionNhapHang.getDonGia() != DonGia ) {
				
				actionNhapHang.setMaSP(maSP);
				actionNhapHang.setSoLuong(SoLuong);
				actionNhapHang.setDonGia(DonGia);
				list.set(currentRow, actionNhapHang);
				context.updateTable(list);
				
			}else {
				// Không có thay đổi => thông báo lỗi
				context.activateWarning("Bạn không thay đổi gì!!!");
			}
			
			}
		// Xử lý sửa hàng item nhập đã chọn
		
		if (e.getSource().equals(context.Xoa_btn)) {
			list.remove(currentRow);
			context.updateTable(list);
		}

		// Xử lý dừng nhập hàng vào lưu phiếu nhập hàng vào database
		if (e.getSource().equals(context.Dung_btn)) {
			NhapHang_BLL.them(list);
			context.updateTable(new ArrayList<ChiTietPhieuNhapDTO>());
			context.disActiveNhapHang();
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
