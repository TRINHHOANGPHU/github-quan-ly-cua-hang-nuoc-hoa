package GUI_NhapHang;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		
		// Ngăn việc MouseListener vẫn bắt sự kiện của nút đã bị setEnable(false) 
		
		if (e.getSource().equals(context.jTable)) {
			// do nothing
		}
		else {
			JLabel btn = (JLabel) e.getSource();
			if (!btn.isEnabled()) {
				return;
			}
		}
		
		// Xử lý khởi tạo phiếu nhập để thực hiện nhập hàng
		
		if (e.getSource().equals(context.NhapHang_btn)) {
			context.activeNhapHang();
			phieuNhapNew = new PhieuNhapDTO();
			phieuNhapNew.setMaPN(++autoPhieuNhapID);
			phieuNhapNew.setMaNCC(1);
			phieuNhapNew.setMaNV(1);
			
			totalPrice = 0;
			context.NhapHang_btn.setEnabled(false);
		}
		
		// Xử lý thêm 1 dòng vào phiếu nhập
		
		if (e.getSource().equals(context.Them_btn)) {
			try {

				int maSP = Integer.valueOf(context.maSPtext.getText());
				int SoLuong = Integer.valueOf(context.SoLuongtext.getText());
				Double DonGia = Double.valueOf(context.donGiatext.getText());
				
				if (SoLuong < 1) {
					context.activateWarning("Số lượng phải lớn hơn hoặc bằng 1!");
					return;
				}
				
				actionNhapHang = new ChiTietPhieuNhapDTO(phieuNhapNew.getMaPN(),maSP,SoLuong,DonGia);
		
			
				// Validate xem id sản phẩm có tồn tại hay không				
				if(NhapHang_BLL.isSpExist(maSP)) {
					
					int dupIndex = isDuplicate(maSP);
					
					if(dupIndex == -1 || DonGia != list.get(dupIndex).getDonGia()) {
						// Sản phẩm không trùng trong list
						list.add(actionNhapHang);
					}
					else {
						ChiTietPhieuNhapDTO DupRow = list.get(dupIndex);	
						DupRow.setSoLuong(DupRow.getSoLuong() + SoLuong);
						list.set(dupIndex, DupRow);
					}
					
					updateTotalPrice(actionNhapHang.getTongGia());
					context.updateTable(list, totalPrice);
					context.clearTextField();
					
				}
				else {
					context.activateWarning("Sản phẩm bạn nhập không tồn tại");
					return;
				} 
				
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
				context.clearTextField();
				
			}else {
				// Không có thay đổi => thông báo lỗi
				context.activateWarning("Bạn không thay đổi gì!!!");
			}
			
			}
		// Xử lý xóa hàng item nhập đã chọn
		
		if (e.getSource().equals(context.Xoa_btn)) {
			list.remove(currentRow);
			updateTotalPrice(-actionNhapHang.getTongGia());
			context.clearTextField();
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
			// Lưu vào database
			NhapHang_BLL.them(list);
			list.clear();
			context.updateTable(list,0);
			context.disActiveNhapHang();
			context.NhapHang_btn.setEnabled(true);
		}
		// Xử lý clear textField
		if (e.getSource().equals(context.Clear_btn)) {
			context.clearTextField();
		}
		// Xử lý hủy thao tác
		if (e.getSource().equals(context.Huy_btn)) {
			if (JOptionPane.showConfirmDialog(context, "Bạn có chắc chắn muốn hủy nhập hàng?", "Cảnh báo",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				list.clear();
				context.updateTable(list,0);
				context.disActiveNhapHang();
				context.NhapHang_btn.setEnabled(true);
				return;
			} else {
			    return;
			}
		}
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		
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
	
	public int isDuplicate(int maSP) {
		for ( ChiTietPhieuNhapDTO row : list) {
			if (row.getMaSP() == maSP) {
				return list.indexOf(row);
			}
		}
		return -1;
	}
}
