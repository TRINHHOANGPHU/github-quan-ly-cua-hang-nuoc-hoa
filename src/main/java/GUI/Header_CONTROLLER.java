package GUI;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Header_CONTROLLER implements MouseListener {
	Header_VIEW header_VIEW;
	
	public Header_CONTROLLER(Header_VIEW header_VIEW) {
		this.header_VIEW = header_VIEW;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(this.header_VIEW.jLabels_Icon[0])) {
			GiaoDienChinh.jFrame.setState(JFrame.ICONIFIED);
		} else if(e.getSource().equals(this.header_VIEW.jLabels_Icon[1])) {			
			System.exit(0);
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

}
