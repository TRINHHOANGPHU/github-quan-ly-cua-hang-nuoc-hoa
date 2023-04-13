package GUI_NhaCungCap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HienChiTietMotDong_CONTROLLER extends MouseAdapter {
	private NhaCungCap_VIEW nhaCungCap_VIEW;
	
	public HienChiTietMotDong_CONTROLLER(NhaCungCap_VIEW nhaCungCap_VIEW) {
		this.nhaCungCap_VIEW = nhaCungCap_VIEW;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int maNCC =(Integer) this.nhaCungCap_VIEW.jTable.getValueAt(this.nhaCungCap_VIEW.jTable.getSelectedRow(), 0);
		String tenNCC = (String) this.nhaCungCap_VIEW.jTable.getValueAt(this.nhaCungCap_VIEW.jTable.getSelectedRow(), 1);
		String soDienThoai = (String) this.nhaCungCap_VIEW.jTable.getValueAt(this.nhaCungCap_VIEW.jTable.getSelectedRow(), 2);
		String diaChi = (String) this.nhaCungCap_VIEW.jTable.getValueAt(this.nhaCungCap_VIEW.jTable.getSelectedRow(), 3);
		this.nhaCungCap_VIEW.jTextField_MaNhaCungCap.setText(maNCC + "");
		this.nhaCungCap_VIEW.jTextField_TenNhaCungCap.setText(tenNCC);
		this.nhaCungCap_VIEW.jTextField_SoDienThoai.setText(soDienThoai);
		this.nhaCungCap_VIEW.jTextField_DiaChi.setText(diaChi);
	}
	
}
