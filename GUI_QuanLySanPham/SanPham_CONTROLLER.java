package GUI_QuanLySanPham;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import BLL_QuanLySanPham.QuanLySanPham_BLL;
import DTO.SanPhamDTO;
import GUI.Content_VIEW;

public class SanPham_CONTROLLER implements MouseListener {
	private QuanLySanPham_VIEW quanLySanPham_VIEW;
	private QuanLySanPham_BLL quanLySanPham_BLL = new QuanLySanPham_BLL();

	public SanPham_CONTROLLER() {

	}

	public SanPham_CONTROLLER(QuanLySanPham_VIEW quanLySanPham_VIEW) {
		this.quanLySanPham_VIEW = quanLySanPham_VIEW;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String tenSP = this.quanLySanPham_VIEW.jTextField_TenSanPham.getText();
		String giaNhap = this.quanLySanPham_VIEW.jTextField_GiaNhap.getText();
		double giaNhap1 = Double.parseDouble(giaNhap);
		String giaBan = this.quanLySanPham_VIEW.jTextField_GiaBan.getText();
		double giaBan1 = Double.parseDouble(giaBan);
		String soLuong = this.quanLySanPham_VIEW.jTextField_SoLuong.getText();
		int soLuong1 = Integer.parseInt(soLuong);
		String maLoaiSP = this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_1.getText();
		int maLoaiSP1 = Integer.parseInt(maLoaiSP);
		String trangThai = this.quanLySanPham_VIEW.jTextField_TrangThai.getText();
		int trangThai1 = Integer.parseInt(giaNhap);
		String hinh = this.quanLySanPham_VIEW.jTextField_Hinh.getText();

		if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_Them_1)) {
			if (tenSP.length() == 0 || giaNhap.length() == 0 || giaBan.length() == 0 || maLoaiSP.length() == 0 || soLuong.length() == 0 || trangThai.length() == 0) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Không được bỏ trống bất kì trường nào",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else if (!giaBan.matches("\\d+")) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chỉ được nhập số vào trường giá bán ",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else if (!giaNhap.matches("\\d+")) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chỉ được nhập số vào trường giá nhập ",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}else if (!soLuong.matches("\\d+")) {
					JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chỉ được nhập số vào trường số lượng ",
							"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}else if (!maLoaiSP.matches("\\d+")) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chỉ được nhập số vào trường mã loại sản phẩm ",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				int maSP = this.quanLySanPham_BLL.layGiaTriLonNhat_ColumnMaSP() + 1;
				if (Integer.valueOf(this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_1.getText()) > this.quanLySanPham_BLL
						.layGiaTriLonNhat_ColumnMaSP()) {
					SanPhamDTO sanPhamDTO = new SanPhamDTO (maSP, maLoaiSP1, tenSP, giaNhap1, giaBan1, soLuong1, hinh ,trangThai1);
					this.quanLySanPham_BLL.them(sanPhamDTO);
				}
				this.auto_Input_Null();
				this.quanLySanPham_VIEW.auto_Set_maSP();
				this.quanLySanPham_VIEW.showTable1(this.quanLySanPham_BLL.getList_SanPham());
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Thêm thành công", "Thông báo",
						JOptionPane.CLOSED_OPTION, JOptionPane.DEFAULT_OPTION);
			}
		} else if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_Sua_1)) {
			if (this.quanLySanPham_VIEW.jTable_1.getSelectedRow() != -1) {
				if (tenSP.length() == 0 || giaNhap.length() == 0 || giaBan.length() == 0 || maLoaiSP.length() == 0 || soLuong.length() == 0 || trangThai.length() == 0) {
					JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Không được bỏ trống bất kì trường nào",
							"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					int luaChon = JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
							"Bạn có chắc muốn sửa dòng này chứ?", "Thông báo sửa", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					int maSP = Integer.parseInt(this.quanLySanPham_VIEW.jTextField_MaSanPham.getText());
					if (luaChon == JOptionPane.YES_OPTION) {
						if (maSP <= this.quanLySanPham_BLL.layGiaTriLonNhat_ColumnMaSP()) {
							SanPhamDTO sanPhamDTO = new SanPhamDTO(maSP, maLoaiSP1, tenSP, giaNhap1, giaBan1, soLuong1, hinh ,trangThai1);
							this.quanLySanPham_BLL.suaMotDongDuaVaoMaSP(sanPhamDTO);
						}
					}
					this.auto_Input_Null();
					this.quanLySanPham_VIEW.auto_Set_maSP();
					this.quanLySanPham_VIEW.showTable1(this.quanLySanPham_BLL.getList_SanPham());
				}
			} else {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Bạn chưa chọn dòng cần sửa!",
						"Thông báo chọn dòng cần sửa", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_Xoa_1)) {
			if (this.quanLySanPham_VIEW.jTable_1.getSelectedRow() != -1) {
				int luaChon = JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
						"Bạn có chắc muốn xóa dòng này chứ", "Thông báo xóa", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				int maSP= Integer.parseInt(this.quanLySanPham_VIEW.jTextField_MaSanPham.getText());
				if (luaChon == JOptionPane.YES_OPTION) {
					if (maSP <= this.quanLySanPham_BLL.layGiaTriLonNhat_ColumnMaSP()) {
						SanPhamDTO sanPhamDTO = new SanPhamDTO(maSP, maLoaiSP1, tenSP, giaNhap1, giaBan1, soLuong1, hinh ,trangThai1);
						this.quanLySanPham_BLL.xoaMotDongDuaVaoMaSP(sanPhamDTO);
					}
				}
				this.auto_Input_Null();
				this.quanLySanPham_VIEW.auto_Set_maSP();
				this.quanLySanPham_VIEW.showTable1(this.quanLySanPham_BLL.getList_SanPham());
			} else {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Bạn chưa chọn dòng cần xoá!",
						"Thông báo chọn dòng cần xóa", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_TimKiem_1)) {
			int i = 0;
			this.quanLySanPham_VIEW.defaultTableModel_1.setRowCount(0);
			for (SanPhamDTO sanPhamDTO : this.quanLySanPham_BLL.getList_SanPham()) {
				if (SanPhamDTO.getTenSP().toLowerCase().contains(this.quanLySanPham_VIEW.jTextField_TimKiem_1.getText())) {
					Object[] objects = new Object[3];
					objects[0] = sanPhamDTO.getMaSP();
					objects[1] = sanPhamDTO.getMaLoaiSP();
					objects[2] = sanPhamDTO.getTenSP();
					objects[3] = sanPhamDTO.getGiaNhap();
					objects[4] = sanPhamDTO.getGiaBan();
					objects[5] = sanPhamDTO.getSoLuong();
					objects[6] = sanPhamDTO.getHinh();
					objects[7] = sanPhamDTO.getTrangThai();
					this.quanLySanPham_VIEW.defaultTableModel_1.addRow(objects);
					i++;
				}
			}

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

	public void auto_Input_Null() {
		this.quanLySanPham_VIEW.jTextField_MaSanPham.setText("");
		this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_1.setText("");
		this.quanLySanPham_VIEW.jTextField_TenSanPham.setText("");
		this.quanLySanPham_VIEW.jTextField_GiaNhap.setText("");
		this.quanLySanPham_VIEW.jTextField_GiaBan.setText("");
		this.quanLySanPham_VIEW.jTextField_SoLuong.setText("");
		this.quanLySanPham_VIEW.jTextField_TrangThai.setText("");
		this.quanLySanPham_VIEW.jTextField_Hinh.setText("");		
	}
}

