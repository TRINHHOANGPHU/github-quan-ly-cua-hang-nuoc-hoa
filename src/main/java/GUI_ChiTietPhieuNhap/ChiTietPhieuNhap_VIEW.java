package GUI_ChiTietPhieuNhap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
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
import javax.swing.SwingConstants;
import java.awt.Font;

public class ChiTietPhieuNhap_VIEW extends JPanel {
	
	public JTextField MaNV_text;
	public JTextField SoLuong_text;
	public JLabel Them_btn;
	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;
	public JScrollPane jScrollPane_Table;
	public JTable jTable;
	public DefaultTableModel defaultTableModel;
	public String[][] datas = {};
	public String[] columns = { "Mã ID", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá", "Tổng giá" };
	private JTextField DonGia_text;
	private JTextField ID_text;
	private JTextField MaPhieuNhap_text;
	private JLabel Xóa_btn;
	private JLabel Sua_btn;

	public ChiTietPhieuNhap_VIEW() {
		this.setLayout(new BorderLayout());
		
		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);

		ID_text = new JTextField();
		ID_text.setPreferredSize(new Dimension(200, 65));
		ID_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		ID_text.setBorder(
				new TitledBorder(matte, "ID", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		MaPhieuNhap_text = new JTextField();
		MaPhieuNhap_text.setPreferredSize(new Dimension(200, 65));
		MaPhieuNhap_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		MaPhieuNhap_text.setBorder(
				new TitledBorder(matte, "Mã phiếu nhập", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		MaNV_text = new JTextField();
		MaNV_text.setPreferredSize(new Dimension(200, 65));
		MaNV_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		MaNV_text
				.setBorder(new TitledBorder(matte, "Mã sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		SoLuong_text = new JTextField();
		SoLuong_text.setPreferredSize(new Dimension(200, 65));
		SoLuong_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		SoLuong_text
				.setBorder(new TitledBorder(matte, "Số lượng", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		DonGia_text = new JTextField();
		DonGia_text.setPreferredSize(new Dimension(200, 65));
		DonGia_text.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		DonGia_text
				.setBorder(new TitledBorder(matte, "Đơn giá", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));

		Them_btn = new JLabel("Thêm", JLabel.CENTER);
		Them_btn.setPreferredSize(new Dimension(200, 65));
		Them_btn.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		Them_btn.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		Them_btn.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		Them_btn.setOpaque(true);

		jPanel_Input = new JPanel();
		jPanel_Input.setPreferredSize(new Dimension(0, 175));
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
		jPanel_Input.add(ID_text);
		jPanel_Input.add(MaPhieuNhap_text);
		jPanel_Input.add(MaNV_text);
		jPanel_Input.add(SoLuong_text);
		jPanel_Input.add(DonGia_text);
		jPanel_Input.add(Them_btn);

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

		this.add(jPanel_Input, BorderLayout.PAGE_START);
		
		Xóa_btn = new JLabel("Xóa", SwingConstants.CENTER);
		Xóa_btn.setPreferredSize(new Dimension(200, 65));
		Xóa_btn.setOpaque(true);
		Xóa_btn.setForeground(Color.WHITE);
		Xóa_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Xóa_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Xóa_btn);
		
		Sua_btn = new JLabel("Sửa", SwingConstants.CENTER);
		Sua_btn.setPreferredSize(new Dimension(200, 65));
		Sua_btn.setOpaque(true);
		Sua_btn.setForeground(Color.WHITE);
		Sua_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Sua_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Sua_btn);
		this.add(jPanel_scrollpane_table, BorderLayout.CENTER);
		
		Content_VIEW.jPanel_Content.add(this);
	}

}
