package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI_NhaCungCap.NhaCungCap_VIEW;
import generalRules.mauChuDe;

public class Content_VIEW {
	public static JPanel jPanel_Content;
	
	public Content_VIEW() {
		jPanel_Content = new JPanel();
		jPanel_Content.setLayout(null);
		GiaoDienChinh.jFrame.add(jPanel_Content, BorderLayout.CENTER);	
	}
}
