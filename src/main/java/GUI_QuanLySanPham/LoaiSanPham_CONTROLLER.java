package GUI_QuanLySanPham;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import BLL_QuanLySanPham.QuanLySanPham_BLL;
import DTO.LoaiSanPhamDTO;
import GUI.Content_VIEW;

public class LoaiSanPham_CONTROLLER implements MouseListener {
	private QuanLySanPham_VIEW quanLySanPham_VIEW;
	private QuanLySanPham_BLL quanLySanPham_BLL = new QuanLySanPham_BLL();

	public LoaiSanPham_CONTROLLER() {

	}

	public LoaiSanPham_CONTROLLER(QuanLySanPham_VIEW quanLySanPham_VIEW) {
		this.quanLySanPham_VIEW = quanLySanPham_VIEW;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String tenLoaiSP = this.quanLySanPham_VIEW.jTextField_TenLoaiSanPham.getText();
		String moTa = this.quanLySanPham_VIEW.jTextField_MoTa.getText();

		if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_Them_2)) {
			if (tenLoaiSP.length() == 0 || moTa.length() == 0) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Không được bỏ trống bất kì trường nào",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				int maLoaiSP = this.quanLySanPham_BLL.layGiaTriLonNhat_ColumnMaLoaiSP() + 1;
				if (Integer.valueOf(this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_2.getText()) > this.quanLySanPham_BLL
						.layGiaTriLonNhat_ColumnMaLoaiSP()) {
					LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO(maLoaiSP, tenLoaiSP, moTa);
					this.quanLySanPham_BLL.them(loaiSanPhamDTO);
				}
				this.auto_Input_Null();
				this.quanLySanPham_VIEW.auto_Set_maLoaiSP();
				this.quanLySanPham_VIEW.showTable2(this.quanLySanPham_BLL.getList_LoaiSanPham());
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Thêm thành công", "Thông báo",
						JOptionPane.CLOSED_OPTION, JOptionPane.DEFAULT_OPTION);
			}
		} else if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_Sua_2)) {
			if (this.quanLySanPham_VIEW.jTable_2.getSelectedRow() != -1) {
				if (tenLoaiSP.length() == 0 || moTa.length() == 0) {
					JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Không được bỏ trống bất kì trường nào",
							"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					int luaChon = JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
							"Bạn có chắc muốn sửa dòng này chứ?", "Thông báo sửa", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					int maLoaiSP = Integer.parseInt(this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_2.getText());
					if (luaChon == JOptionPane.YES_OPTION) {
						if (maLoaiSP <= this.quanLySanPham_BLL.layGiaTriLonNhat_ColumnMaLoaiSP()) {
							LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO(maLoaiSP, tenLoaiSP, moTa);
							this.quanLySanPham_BLL.suaMotDongDuaVaoMaLoaiSP(loaiSanPhamDTO);
						}
					}
					this.auto_Input_Null();
					this.quanLySanPham_VIEW.auto_Set_maLoaiSP();
					this.quanLySanPham_VIEW.showTable2(this.quanLySanPham_BLL.getList_LoaiSanPham());
				}
			} else {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Bạn chưa chọn dòng cần sửa!",
						"Thông báo chọn dòng cần sửa", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_Xoa_2)) {
			if (this.quanLySanPham_VIEW.jTable_2.getSelectedRow() != -1) {
				int luaChon = JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
						"Bạn có chắc muốn xóa dòng này chứ", "Thông báo xóa", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				int maLoaiSP= Integer.parseInt(this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_2.getText());
				if (luaChon == JOptionPane.YES_OPTION) {
					if (maLoaiSP <= this.quanLySanPham_BLL.layGiaTriLonNhat_ColumnMaLoaiSP()) {
						LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO(maLoaiSP, tenLoaiSP, moTa);
						this.quanLySanPham_BLL.xoaMotDongDuaVaoMaLoaiSP(loaiSanPhamDTO);
					}
				}
				this.auto_Input_Null();
				this.quanLySanPham_VIEW.auto_Set_maLoaiSP();
				this.quanLySanPham_VIEW.showTable2(this.quanLySanPham_BLL.getList_LoaiSanPham());
			} else {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Bạn chưa chọn dòng cần xoá!",
						"Thông báo chọn dòng cần xóa", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(this.quanLySanPham_VIEW.jLabel_TimKiem_2)) {
			int i = 0;
			this.quanLySanPham_VIEW.defaultTableModel_2.setRowCount(0);
			for (LoaiSanPhamDTO loaiSanPhamDTO : this.quanLySanPham_BLL.getList_LoaiSanPham()) {
				if (loaiSanPhamDTO.getTenLoaiSP().toLowerCase().contains(this.quanLySanPham_VIEW.jTextField_TimKiem_2.getText())
						|| loaiSanPhamDTO.getMoTa().toLowerCase()
								.contains(this.quanLySanPham_VIEW.jTextField_TimKiem_2.getText())) {
					Object[] objects = new Object[3];
					objects[0] = loaiSanPhamDTO.getMaLoaiSP();
					objects[1] = loaiSanPhamDTO.getTenLoaiSP();
					objects[2] = loaiSanPhamDTO.getMoTa();
					this.quanLySanPham_VIEW.defaultTableModel_2.addRow(objects);
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
		this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham_2.setText("");
		this.quanLySanPham_VIEW.jTextField_TenLoaiSanPham.setText("");
		this.quanLySanPham_VIEW.jTextField_MoTa.setText("");
	}
}
