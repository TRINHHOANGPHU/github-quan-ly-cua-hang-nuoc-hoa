package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import generalRules.fontChuDe;
import generalRules.mauChuDe;
import generalRules.xuLyAnh;

public class MenuLeft_CONTROLLER implements MouseListener {
	public MenuLeft_VIEW menuLeft_VIEW;
	public Header_VIEW header_VIEW;
	public static int flag;
	
	public MenuLeft_CONTROLLER(MenuLeft_VIEW menuLeft_VIEW) {
		this.menuLeft_VIEW = menuLeft_VIEW;
		flag = 0;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < menuLeft_VIEW.string_Items.length; i++) {
			this.menuLeft_VIEW.jLabels_Items[i].setBorder(new EmptyBorder(0, 30, 0, 0));
			this.menuLeft_VIEW.jLabels_Items[i].setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			this.menuLeft_VIEW.jLabels_Items[i].setIcon(new ImageIcon(xuLyAnh.icon_MenuLeft(new ImageIcon(xuLyAnh.getInstance().getResource_Image(this.menuLeft_VIEW.strings_Icons[i])).getImage())));
			this.menuLeft_VIEW.jLabels_Items[i].setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_MENU_LEFT.getMaMau()));
			this.menuLeft_VIEW.jLabels_Items[i].setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
			this.menuLeft_VIEW.jLabels_Items[i].setOpaque(true);
		}
		if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[0])) {
			flag = 1;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[0], this.menuLeft_VIEW.strings_Icons[0]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[1])) {
			flag = 2;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[1], this.menuLeft_VIEW.strings_Icons[1]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[2])) {
			flag = 3;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[2], this.menuLeft_VIEW.strings_Icons[2]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[3])) {
			flag = 4;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[3], this.menuLeft_VIEW.strings_Icons[3]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[4])) {
			flag = 5;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[4], this.menuLeft_VIEW.strings_Icons[4]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[5])) {
			flag = 6;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[5], this.menuLeft_VIEW.strings_Icons[5]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[6])) {
			flag = 7;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[6], this.menuLeft_VIEW.strings_Icons[6]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[7])) {
			flag = 8;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[7], this.menuLeft_VIEW.strings_Icons[7]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[8])) {
			flag = 9;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[8], this.menuLeft_VIEW.strings_Icons[8]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[9])) {
			flag = 10;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[9], this.menuLeft_VIEW.strings_Icons[9]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[10])) {
			flag = 11;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[10], this.menuLeft_VIEW.strings_Icons[10]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[11])) {
			flag = 12;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[11], this.menuLeft_VIEW.strings_Icons[11]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[12])) {
			flag = 13;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[12], this.menuLeft_VIEW.strings_Icons[12]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
		} else if (e.getSource().equals(this.menuLeft_VIEW.jLabels_Items[13])) {
			flag = 14;
			this.selectMenu(this.menuLeft_VIEW.jLabels_Items[13], this.menuLeft_VIEW.strings_Icons[13]);
			Content_VIEW.jPanel_Content.removeAll();
			new InnerContent();
			Content_VIEW.jPanel_Content.repaint();
			Content_VIEW.jPanel_Content.validate();
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
	
	public void selectMenu(JLabel jLabels_item, String icon) {
		jLabels_item.setBorder(new EmptyBorder(0, 4, 20, 0));
		jLabels_item.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabels_item.setIcon(new ImageIcon(xuLyAnh.icon_MenuLeft_2(new ImageIcon(xuLyAnh.getInstance().getResource_Image(icon)).getImage())));
		jLabels_item.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_MENU_LEFT_2.getMaMau()));
		jLabels_item.setForeground(Color.decode(mauChuDe.COLOR_TITLE.getMaMau()));
		jLabels_item.setOpaque(true);
		this.header_VIEW.jLabel_Title_Selected_MenuLeft.setText(jLabels_item.getText());
	}
}
