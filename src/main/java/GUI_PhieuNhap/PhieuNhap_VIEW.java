package GUI_PhieuNhap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;

public class PhieuNhap_VIEW {

		public JTextField MaPhieuNhap_text;
		public JTextField MaNCC_text;
		public JTextField MaNV_text;
		public JTextField NgayNhap_text;
	
		public JLabel jLabel_Them;
	
		public JPanel jPanel_Input;
		public JPanel jPanel_scrollpane_table;
	
		public JScrollPane jScrollPane_Table;
	
		public JTable jTable;
	
		public DefaultTableModel defaultTableModel;
	
		public String[][] datas = {};
	
		public String[] columns = { "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Tổng tiền" };
	
		public PhieuNhap_VIEW() {
			
			Content_VIEW.jPanel_Content.setLayout(new BorderLayout());
	
			// Tạo một MatteBorder đen với viền xung quanh
			Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);
	
			MaPhieuNhap_text = new JTextField();
			MaPhieuNhap_text.setPreferredSize(new Dimension(200, 65));
			MaPhieuNhap_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			MaPhieuNhap_text.setBorder(
					new TitledBorder(matte, "Mã phiếu nhập", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
			MaNCC_text = new JTextField();
			MaNCC_text.setPreferredSize(new Dimension(200, 65));
			MaNCC_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			MaNCC_text.setBorder(
					new TitledBorder(matte, "Mã nhà cung cấp", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
			MaNV_text = new JTextField();
			MaNV_text.setPreferredSize(new Dimension(200, 65));
			MaNV_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			MaNV_text
					.setBorder(new TitledBorder(matte, "Mã nhân viên", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
			NgayNhap_text = new JTextField();
			NgayNhap_text.setPreferredSize(new Dimension(200, 65));
			NgayNhap_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			NgayNhap_text
					.setBorder(new TitledBorder(matte, "Ngày nhập", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
	
			jLabel_Them = new JLabel("Thêm", JLabel.CENTER);
			jLabel_Them.setPreferredSize(new Dimension(200, 65));
			jLabel_Them.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
			jLabel_Them.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
			jLabel_Them.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
			jLabel_Them.setOpaque(true);
	
			jPanel_Input = new JPanel();
			jPanel_Input.setPreferredSize(new Dimension(0, 175));
			jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
			jPanel_Input.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
			jPanel_Input.add(MaPhieuNhap_text);
			jPanel_Input.add(MaNCC_text);
			jPanel_Input.add(MaNV_text);
			jPanel_Input.add(NgayNhap_text);
			jPanel_Input.add(jLabel_Them);
	
			defaultTableModel = new DefaultTableModel(datas, columns);
	
			jTable = new JTable();
			jTable.setModel(defaultTableModel);
			jTable.setRowHeight(40);
			jTable.setGridColor(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
			jTable.setAutoCreateRowSorter(true);
			jTable.getTableHeader().setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
			jTable.getTableHeader().setForeground(Color.white);
			jTable.getTableHeader().setFont(fontChuDe.FONT_MENU_LEFT.getFont());
			jTable.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jTable, matte, false, false, 0, 0).setPreferredSize(new Dimension(0, 40));
	
			jScrollPane_Table = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jScrollPane_Table.setOpaque(true);
			
			jPanel_scrollpane_table = new JPanel();
			jPanel_scrollpane_table.setLayout(new BorderLayout());
			jPanel_scrollpane_table.setBackground(Color.black);
			jPanel_scrollpane_table.add(jScrollPane_Table, BorderLayout.CENTER);
	
			Content_VIEW.jPanel_Content.add(jPanel_Input, BorderLayout.PAGE_START);
			Content_VIEW.jPanel_Content.add(jPanel_scrollpane_table, BorderLayout.CENTER);
		}

}
