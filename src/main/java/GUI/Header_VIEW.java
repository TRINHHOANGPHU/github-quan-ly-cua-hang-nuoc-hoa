package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import generalRules.fontChuDe;
import generalRules.mauChuDe;
import generalRules.xuLyAnh;

public class Header_VIEW {
	public JPanel jPanel_Header;
	public JPanel jPanel_Header1;
	public JPanel jPanel_Header2;
	public JPanel jPanel_Header3;
	public String[] strings_Icon = {"icon2.png", "icon1.png"};
	public String string_Icon_Title = "icon3.png";
	public ImageIcon[] imageIcons = new ImageIcon[strings_Icon.length];
	public JLabel[] jLabels_Icon = new JLabel[strings_Icon.length];
	public JLabel jLabel_Title;
	public static JLabel jLabel_Title_Selected_MenuLeft;
	public MouseListener mouseListener;
	
	public Header_VIEW() {
		jPanel_Header = new JPanel();
		jPanel_Header.setPreferredSize(new Dimension(0, 50));
		jPanel_Header.setLayout(new GridLayout(1, 3));
		
		jPanel_Header1 = new JPanel();
		jPanel_Header1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jPanel_Header1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		jLabel_Title = new JLabel("Perfume Store Manager", new ImageIcon(xuLyAnh.icon_Header(new ImageIcon(xuLyAnh.getInstance().getResource_Image(string_Icon_Title)).getImage())), 0);
		jLabel_Title.setForeground(Color.decode(mauChuDe.COLOR_TITLE.getMaMau()));
		jLabel_Title.setFont(fontChuDe.FONT_TITLE.getFont());
		jPanel_Header1.add(jLabel_Title);
		
		jPanel_Header2 = new JPanel();
		jPanel_Header2.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		jPanel_Header2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		
		jPanel_Header3 = new JPanel();
		jPanel_Header3.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jPanel_Header3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		jLabel_Title_Selected_MenuLeft = new JLabel();
		jLabel_Title_Selected_MenuLeft.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Title_Selected_MenuLeft.setFont(fontChuDe.FONT_TITLE_SELECTED_MENU_LEFT.getFont());
		jPanel_Header3.add(jLabel_Title_Selected_MenuLeft);
		
		mouseListener = new Header_CONTROLLER(this);
		
		for (int i = 0; i < strings_Icon.length; i++) {
			imageIcons[i] = new ImageIcon(xuLyAnh.icon_Header(new ImageIcon(xuLyAnh.getInstance().getResource_Image(strings_Icon[i])).getImage()));
			jLabels_Icon[i] = new JLabel(imageIcons[i]);
			jLabels_Icon[i].addMouseListener(mouseListener);
			jPanel_Header2.add(jLabels_Icon[i]);
		}
		
		jPanel_Header.add(jPanel_Header1);
		jPanel_Header.add(jPanel_Header3);
		jPanel_Header.add(jPanel_Header2);
		
		GiaoDienChinh.jFrame.add(jPanel_Header, BorderLayout.PAGE_START);
	}
}
