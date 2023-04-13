package GUI_NhaCungCap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import BLL_NhaCungCap.NhaCungCap_BLL;
import DTO.NhaCungCapDTO;
import GUI.Content_VIEW;

public class NhaCungCap_CONTROLLER implements MouseListener {
	private NhaCungCap_VIEW nhaCungCap_VIEW;
	private NhaCungCap_BLL nhaCungCap_BLL = new NhaCungCap_BLL();

	public NhaCungCap_CONTROLLER() {

	}

	public NhaCungCap_CONTROLLER(NhaCungCap_VIEW nhaCungCap_VIEW) {
		this.nhaCungCap_VIEW = nhaCungCap_VIEW;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String tenNCC = this.nhaCungCap_VIEW.jTextField_TenNhaCungCap.getText();
		String soDienThoai = this.nhaCungCap_VIEW.jTextField_SoDienThoai.getText();
		String diaChi = this.nhaCungCap_VIEW.jTextField_DiaChi.getText();

		if (e.getSource().equals(this.nhaCungCap_VIEW.jLabel_Them)) {
			if (tenNCC.length() == 0 || soDienThoai.length() == 0 || diaChi.length() == 0) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Không được bỏ trống bất kì trường nào",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else if (!soDienThoai.matches("\\d+")) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chỉ được nhập số vào trường số điện thoại",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else if (soDienThoai.length() < 10) {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Số điện thoại phải từ 10 số trở lên",
						"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				int maNCC = this.nhaCungCap_BLL.layGiaTriLonNhat_ColumnMaNCC() + 1;
				if (Integer.valueOf(this.nhaCungCap_VIEW.jTextField_MaNhaCungCap.getText()) > this.nhaCungCap_BLL
						.layGiaTriLonNhat_ColumnMaNCC()) {
					NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(maNCC, tenNCC, soDienThoai, diaChi);
					this.nhaCungCap_BLL.them(nhaCungCapDTO);
				}
				this.auto_Input_Null();
				this.nhaCungCap_VIEW.auto_Set_maNCC();
				this.nhaCungCap_VIEW.showTable(this.nhaCungCap_BLL.getList_NhaCungCap());
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Thêm thành công", "Thông báo",
						JOptionPane.CLOSED_OPTION, JOptionPane.DEFAULT_OPTION);
			}
		} else if (e.getSource().equals(this.nhaCungCap_VIEW.jLabel_Sua)) {
			if (this.nhaCungCap_VIEW.jTable.getSelectedRow() != -1) {
				if (tenNCC.length() == 0 || soDienThoai.length() == 0 || diaChi.length() == 0) {
					JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Không được bỏ trống bất kì trường nào",
							"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				} else if (!soDienThoai.matches("\\d+")) {
					JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
							"Chỉ được nhập số vào trường số điện thoại", "Thông báo", JOptionPane.CLOSED_OPTION,
							JOptionPane.WARNING_MESSAGE);
				} else if (soDienThoai.length() < 10) {
					JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Số điện thoại phải từ 10 số trở lên",
							"Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					int luaChon = JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
							"Bạn có chắc muốn sửa dòng này chứ", "Thông báo sửa", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					int maNCC = Integer.parseInt(this.nhaCungCap_VIEW.jTextField_MaNhaCungCap.getText());
					if (luaChon == JOptionPane.YES_OPTION) {
						if (maNCC <= this.nhaCungCap_BLL.layGiaTriLonNhat_ColumnMaNCC()) {
							NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(maNCC, tenNCC, soDienThoai, diaChi);
							this.nhaCungCap_BLL.suaMotDongDuaVaoMaNCC(nhaCungCapDTO);
						}
					}
					this.auto_Input_Null();
					this.nhaCungCap_VIEW.auto_Set_maNCC();
					this.nhaCungCap_VIEW.showTable(this.nhaCungCap_BLL.getList_NhaCungCap());
				}
			} else {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chưa chọn dòng mà đòi sửa???",
						"Thông báo chọn dòng sửa", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(this.nhaCungCap_VIEW.jLabel_Xoa)) {
			if (this.nhaCungCap_VIEW.jTable.getSelectedRow() != -1) {
				int luaChon = JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content,
						"Bạn có chắc muốn xóa dòng này chứ", "Thông báo xóa", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				int maNCC = Integer.parseInt(this.nhaCungCap_VIEW.jTextField_MaNhaCungCap.getText());
				if (luaChon == JOptionPane.YES_OPTION) {
					if (maNCC <= this.nhaCungCap_BLL.layGiaTriLonNhat_ColumnMaNCC()) {
						NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(maNCC, tenNCC, soDienThoai, diaChi);
						this.nhaCungCap_BLL.xoaMotDongDuaVaoMaNCC(nhaCungCapDTO);
					}
				}
				this.auto_Input_Null();
				this.nhaCungCap_VIEW.auto_Set_maNCC();
				this.nhaCungCap_VIEW.showTable(this.nhaCungCap_BLL.getList_NhaCungCap());
			} else {
				JOptionPane.showConfirmDialog(Content_VIEW.jPanel_Content, "Chưa chọn dòng mà đòi xóa???",
						"Thông báo chọn dòng xóa", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(this.nhaCungCap_VIEW.jLabel_TimKiem)) {
			int i = 0;
			this.nhaCungCap_VIEW.defaultTableModel.setRowCount(0);
			for (NhaCungCapDTO nhaCungCapDTO : this.nhaCungCap_BLL.getList_NhaCungCap()) {
				if (nhaCungCapDTO.getTenNCC().toLowerCase().contains(this.nhaCungCap_VIEW.jTextField_TimKiem.getText())
						|| nhaCungCapDTO.getSoDienThoai().toLowerCase()
								.contains(this.nhaCungCap_VIEW.jTextField_TimKiem.getText())) {
					Object[] objects = new Object[4];
					objects[0] = nhaCungCapDTO.getMaNCC();
					objects[1] = nhaCungCapDTO.getTenNCC();
					objects[2] = nhaCungCapDTO.getSoDienThoai();
					objects[3] = nhaCungCapDTO.getDiaChi();
					this.nhaCungCap_VIEW.defaultTableModel.addRow(objects);
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
		this.nhaCungCap_VIEW.jTextField_MaNhaCungCap.setText("");
		this.nhaCungCap_VIEW.jTextField_TenNhaCungCap.setText("");
		this.nhaCungCap_VIEW.jTextField_SoDienThoai.setText("");
		this.nhaCungCap_VIEW.jTextField_DiaChi.setText("");
	}
}
