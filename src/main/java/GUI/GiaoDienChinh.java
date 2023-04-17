package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GiaoDienChinh {
	public static JFrame jFrame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GiaoDienChinh() {
		jFrame = new JFrame();
//		jFrame.setUndecorated(true);
		init();
		jFrame.setVisible(true);
	}
	public void init() {
		jFrame.setResizable(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setUndecorated(false);
		jFrame.setSize(1404, 800);
		jFrame.setLocationRelativeTo(null);
		jFrame.setLayout(new BorderLayout(0, 0));
		
		new Header_VIEW();
		new MenuLeft_VIEW();
		new Content_VIEW();
	}
}
