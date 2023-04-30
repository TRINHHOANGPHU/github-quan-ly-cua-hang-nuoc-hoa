package GUI_QuanLySanPham;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HienChiTietMotDong_CONTROLLER extends MouseAdapter {
	private QuanLySanPham_VIEW quanLySanPham_VIEW;
	
	public HienChiTietMotDong_CONTROLLER(QuanLySanPham_VIEW quanLySanPham_VIEW) {
		this.quanLySanPham_VIEW = quanLySanPham_VIEW;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int maSP =(Integer) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 0);
		int maLoaiSP =(Integer) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 1);
		String tenSP = (String) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 2);
		double giaNhap = (Double) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 3);
		double giaBan = (Double) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 4);
		int soLuong = (Integer) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 5);
		String hinh = (String) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 6);
		int trangThai = (Integer) this.quanLySanPham_VIEW.Bang_Tab1.getValueAt(this.quanLySanPham_VIEW.Bang_Tab1.getSelectedRow(), 7);
				
		this.quanLySanPham_VIEW.jTextField_MaSanPham.setText(maSP + "");
		this.quanLySanPham_VIEW.jTextField_TenSanPham.setText(tenSP);
		this.quanLySanPham_VIEW.jTextField_MaLoaiSanPham.setText(maLoaiSP + "");
		this.quanLySanPham_VIEW.jTextField_GiaNhap.setText(giaNhap + "");
		this.quanLySanPham_VIEW.jTextField_GiaBan.setText(giaBan + "");
		this.quanLySanPham_VIEW.jTextField_SoLuong.setText(soLuong + "");
		this.quanLySanPham_VIEW.jTextField_TrangThai.setText(trangThai + "");
	}
	
}

