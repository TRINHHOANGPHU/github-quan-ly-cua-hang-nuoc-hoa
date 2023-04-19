package GUI_NhapHang;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import BLL_NhapHang.NhapHang_BLL;
import BLL_NhapHang.PhieuNhap_BLL;
import DAL_NhapHang.PhieuNhap_DAL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;

// Thiếu validate input !!!!

public class NhapHang_CONTROLLER implements MouseListener{
	
	private NhapHang_VIEW context;
	private ArrayList<ChiTietPhieuNhapDTO> list;
	private PhieuNhapDTO phieuNhapNew;
	private ChiTietPhieuNhapDTO actionNhapHang;
	private static int autoPhieuNhapID;
	private int currentRow = 0;
	private double totalPrice = 0;
	
	NhapHang_CONTROLLER(NhapHang_VIEW c){
		this.context = c;
		list = new ArrayList<ChiTietPhieuNhapDTO>();
		// Gán ID cuối trên cơ sở dữ liệu để tiếp tục tự động tạo ID
		autoPhieuNhapID = PhieuNhap_DAL.getInstance().getLastID();

	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		// Xử lý khởi tạo phiếu nhập để thực hiện nhập hàng
		if (e.getSource().equals(context.NhapHang_btn)) {
			context.activeNhapHang();
			phieuNhapNew = new PhieuNhapDTO();
			phieuNhapNew.setMaPN(++autoPhieuNhapID);
			phieuNhapNew.setMaNCC(1);
			phieuNhapNew.setMaNV(1);
			
			totalPrice = 0;
		}
		
		// Xử lý thêm 1 dòng vào phiếu nhập
		
		
		
		
		if (e.getSource().equals(context.Them_btn)) {
			try {
				int maPN = phieuNhapNew.getMaPN();
				int maSP = Integer.valueOf(context.maSPtext.getText());
				int SoLuong = Integer.valueOf(context.SoLuongtext.getText());
				Double DonGia = Double.valueOf(context.donGiatext.getText());
				
				actionNhapHang = new ChiTietPhieuNhapDTO(phieuNhapNew.getMaPN(),maSP,SoLuong,DonGia);
				// Validate xem id sản phẩm có tồn tại hay không
				
				if(NhapHang_BLL.isSpExist(maSP)) {	
					list.add(actionNhapHang);
					updateTotalPrice(actionNhapHang.getTongGia());
					context.updateTable(list, totalPrice);
					context.clearTextField();
				}
				else return;
				
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				context.activateWarning("Vui lòng không nhập sai định dạng hoạc bỏ trống!!!");
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
				
				updateTotalPrice(-actionNhapHang.getTongGia());
				
				actionNhapHang.setMaSP(maSP);
				actionNhapHang.setSoLuong(SoLuong);
				actionNhapHang.setDonGia(DonGia);
				
				list.set(currentRow, actionNhapHang);
				
				updateTotalPrice(actionNhapHang.getTongGia());
				context.updateTable(list, totalPrice);
				
			}else {
				// Không có thay đổi => thông báo lỗi
				context.activateWarning("Bạn không thay đổi gì!!!");
			}
			
			}
		// Xử lý xóa hàng item nhập đã chọn
		
		if (e.getSource().equals(context.Xoa_btn)) {
			list.remove(currentRow);
			updateTotalPrice(-actionNhapHang.getTongGia());
			context.updateTable(list, totalPrice);
		}

		// Xử lý dừng nhập hàng vào lưu phiếu nhập hàng vào database
		if (e.getSource().equals(context.Dung_btn)) {
			
			if (list.size() < 1) {
				context.activateWarning("Phiếu nhập không được bỏ trống!");
				return;
			}
			
			// Thêm phiếu nhập trước để không bị lỗi ràng buộc khóa phụ
			PhieuNhap_BLL.getCurrentDate(phieuNhapNew);
			phieuNhapNew.setTongTien(totalPrice);
			PhieuNhap_BLL.them(phieuNhapNew);
			// Thêm từng dòng phiếu nhập 	
			NhapHang_BLL.them(list);
			list.clear();
			context.updateTable(new ArrayList<ChiTietPhieuNhapDTO>(),totalPrice);
			context.disActiveNhapHang();
		}
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		
		if (e.getSource().equals(context.jTable)) {
			context.Sua_btn.setEnabled(false);
			context.Xoa_btn.setEnabled(false);
		}
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void updateTotalPrice(double tongTien) {
		this.totalPrice += tongTien;
	}
}
