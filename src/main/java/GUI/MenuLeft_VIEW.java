package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import generalRules.fontChuDe;
import generalRules.mauChuDe;
import generalRules.xuLyAnh;

public class MenuLeft_VIEW {
	public JPanel jPanel_MenuLeft;
	public JPanel jPanel_MenuLeft_Parent;
	
	public String[] string_Items = {
			"Khách hàng"
			,"Bán hàng"
			,"Hóa đơn"
			,"Quản lý sản phẩm"
			,"Khuyến mãi"
			,"Nhập hàng"
			,"Phiếu nhập"
			,"Nhà cung cấp"
			,"Thống kê"
			,"Nhân viên"
			,"Phân quyền"
			,"Tài Khoản"
	};
	public String[] strings_Icons = {
			"icon11.png"
			,"icon4.png"
			,"icon7.png"
			,"icon17.png"
			,"icon9.png"
			,"icon5.png"
			,"icon8.png"
			,"icon12.png"
			,"icon15.png"
			,"icon10.png"
			,"icon14.png"
			,"icon13.png"
	};
	public String string_Image_Purfome = "image_purfome.png";
	
	public JLabel[] jLabels_Items = new JLabel[string_Items.length];
	public JLabel jLabel_Image;
	
	public ImageIcon[] imageIcon_Items = new ImageIcon[strings_Icons.length];
	public ImageIcon imageIcon_Image_Purfome;
	
	public JScrollPane jScrollPane_Items;
	
	public MouseListener mouseListener;
	
	public MenuLeft_VIEW() {
		jPanel_MenuLeft_Parent = new JPanel();
		jPanel_MenuLeft_Parent.setPreferredSize(new Dimension(250, 0));
		jPanel_MenuLeft_Parent.setLayout(new BorderLayout());
		
		imageIcon_Image_Purfome = new ImageIcon(xuLyAnh.icon_MenuLeft_Image_Purfome(new ImageIcon(xuLyAnh.getInstance().getResource_Image(string_Image_Purfome)).getImage()));
		jLabel_Image = new JLabel(imageIcon_Image_Purfome);
		jLabel_Image.setPreferredSize(new Dimension(250, 170));
		jLabel_Image.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_IMAGE.getMaMau()));
		jLabel_Image.setOpaque(true);
	
		jPanel_MenuLeft = new JPanel();
		jPanel_MenuLeft.setPreferredSize(new Dimension(250, 780));
		jPanel_MenuLeft.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_MENU_LEFT.getMaMau()));
		jPanel_MenuLeft.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		mouseListener = new MenuLeft_CONTROLLER(this);
		
		for (int i = 0; i < string_Items.length; i++) {
			imageIcon_Items[i] = new ImageIcon(xuLyAnh.icon_MenuLeft(new ImageIcon(xuLyAnh.getInstance().getResource_Image(strings_Icons[i])).getImage()));
			jLabels_Items[i] = new JLabel(string_Items[i], imageIcon_Items[i], JLabel.LEFT);
			jLabels_Items[i].setPreferredSize(new Dimension(250, 65));
			jLabels_Items[i].setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			jLabels_Items[i].setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
			jLabels_Items[i].setBorder(new EmptyBorder(0, 30, 0, 0));
			jLabels_Items[i].addMouseListener(mouseListener);
			jPanel_MenuLeft.add(jLabels_Items[i]);
		}
		
		jScrollPane_Items = new JScrollPane(jPanel_MenuLeft ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane_Items.setBorder(new CompoundBorder());
		
		jPanel_MenuLeft_Parent.add(jLabel_Image, BorderLayout.NORTH);
		jPanel_MenuLeft_Parent.add(jScrollPane_Items, BorderLayout.CENTER);
		
		GiaoDienChinh.jFrame.add(jPanel_MenuLeft_Parent, BorderLayout.LINE_START);//.getContentPane()
		
	}
}
