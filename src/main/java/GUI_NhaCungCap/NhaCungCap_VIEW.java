package GUI_NhaCungCap;

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

public class NhaCungCap_VIEW {
	public JTextField jTextField_MaNhaCungCap;
	public JTextField jTextField_TenNhaCungCap;
	public JTextField jTextField_SoDienThoai;
	public JTextField jTextField_DiaChi;

	public JLabel jLabel_Them;

	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;

	public JScrollPane jScrollPane_Table;

	public JTable jTable;

	public DefaultTableModel defaultTableModel;

	public String[][] datas = {};

	public String[] columns = { "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ" };

	public NhaCungCap_VIEW() {
		MouseListener nhaCungCap_CONTROLLER = new NhaCungCap_CONTROLLER(this);
		
		Content_VIEW.jPanel_Content.setLayout(new BorderLayout());

		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);

		jTextField_MaNhaCungCap = new JTextField();
		jTextField_MaNhaCungCap.setPreferredSize(new Dimension(200, 65));
		jTextField_MaNhaCungCap.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_MaNhaCungCap.setBorder(
				new TitledBorder(matte, "Mã nhà cung cấp", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_TenNhaCungCap = new JTextField();
		jTextField_TenNhaCungCap.setPreferredSize(new Dimension(200, 65));
		jTextField_TenNhaCungCap.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TenNhaCungCap.setBorder(
				new TitledBorder(matte, "Tên nhà cung cấp", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_SoDienThoai = new JTextField();
		jTextField_SoDienThoai.setPreferredSize(new Dimension(200, 65));
		jTextField_SoDienThoai.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_SoDienThoai
				.setBorder(new TitledBorder(matte, "Số điện thoại", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_DiaChi = new JTextField();
		jTextField_DiaChi.setPreferredSize(new Dimension(200, 65));
		jTextField_DiaChi.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_DiaChi
				.setBorder(new TitledBorder(matte, "Địa chỉ", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));

		jLabel_Them = new JLabel("Thêm", JLabel.CENTER);
		jLabel_Them.setPreferredSize(new Dimension(200, 65));
		jLabel_Them.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Them.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Them.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Them.setOpaque(true);
		jLabel_Them.addMouseListener(nhaCungCap_CONTROLLER);

		jPanel_Input = new JPanel();
		jPanel_Input.setPreferredSize(new Dimension(0, 100));
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));
		jPanel_Input.add(jTextField_MaNhaCungCap);
		jPanel_Input.add(jTextField_TenNhaCungCap);
		jPanel_Input.add(jTextField_SoDienThoai);
		jPanel_Input.add(jTextField_DiaChi);
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
