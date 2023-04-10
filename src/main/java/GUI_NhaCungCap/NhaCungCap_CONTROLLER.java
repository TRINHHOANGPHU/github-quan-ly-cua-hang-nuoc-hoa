package GUI_NhaCungCap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import BLL_NhaCungCap.NhaCungCap_BLL;
import DTO.NhaCungCapDTO;

public class NhaCungCap_CONTROLLER implements MouseListener {
	private NhaCungCap_VIEW nhaCungCap_VIEW;
	private NhaCungCap_BLL nhaCungCap_BLL = new NhaCungCap_BLL();
	
	public NhaCungCap_CONTROLLER(NhaCungCap_VIEW nhaCungCap_VIEW) {
		this.nhaCungCap_VIEW = nhaCungCap_VIEW;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int maNCC =  Integer.valueOf(this.nhaCungCap_VIEW.jTextField_MaNhaCungCap.getText());
		String tenNCC = this.nhaCungCap_VIEW.jTextField_TenNhaCungCap.getText();
		String soDienThoai = this.nhaCungCap_VIEW.jTextField_SoDienThoai.getText();
		String diaChi = this.nhaCungCap_VIEW.jTextField_DiaChi.getText();
		NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(maNCC, tenNCC, soDienThoai, diaChi);
		this.nhaCungCap_BLL.them(nhaCungCapDTO);
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
	
}
