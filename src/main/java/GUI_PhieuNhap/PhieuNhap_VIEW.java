package GUI_PhieuNhap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
import javax.swing.SwingConstants;
import java.awt.Font;

public class PhieuNhap_VIEW extends JPanel {

	public JTextField MaPhieuNhap_text;
	public JTextField MaNCC_text;
	public JTextField MaNV_text;
	public JTextField NgayNhap_text;

	public JLabel Sua_btn;

	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;

	public JScrollPane jScrollPane_Table;

	public JTable jTable;

	public DefaultTableModel defaultTableModel;

	public String[][] datas = {};

	public String[] columns = { "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Tổng tiền" };
	private JLabel Xoa_btn;
	private JTextField findText;
	private JLabel Tim_btn;

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

		Sua_btn = new JLabel("Sửa", JLabel.CENTER);
		Sua_btn.setPreferredSize(new Dimension(150, 65));
		Sua_btn.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		Sua_btn.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		Sua_btn.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		Sua_btn.setOpaque(true);

		jPanel_Input = new JPanel();
		jPanel_Input.setPreferredSize(new Dimension(0, 200));
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 15));
		jPanel_Input.add(MaPhieuNhap_text);
		jPanel_Input.add(MaNCC_text);
		jPanel_Input.add(MaNV_text);
		jPanel_Input.add(NgayNhap_text);
		jPanel_Input.add(Sua_btn);

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
		setLayout(new BorderLayout(0, 0));

		this.add(jPanel_Input, BorderLayout.NORTH);
		
		Xoa_btn = new JLabel("Xóa", SwingConstants.CENTER);
		Xoa_btn.setPreferredSize(new Dimension(150, 65));
		Xoa_btn.setOpaque(true);
		Xoa_btn.setForeground(Color.WHITE);
		Xoa_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Xoa_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Xoa_btn);
		
		findText = new JTextField();
		findText.setForeground(new Color(192, 192, 192));
		findText.setText("Nhập vào để tìm kiếm...");
		findText.setPreferredSize(new Dimension(400, 65));
		findText.setFont(new Font("Arial", Font.PLAIN, 15));
		findText
		.setBorder(new TitledBorder(matte, "", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jPanel_Input.add(findText);
		
		Tim_btn = new JLabel("Tìm kiếm", SwingConstants.CENTER);
		Tim_btn.setPreferredSize(new Dimension(120, 65));
		Tim_btn.setOpaque(true);
		Tim_btn.setForeground(Color.WHITE);
		Tim_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Tim_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Tim_btn);
		this.add(jPanel_scrollpane_table);
		
		Content_VIEW.jPanel_Content.add(this);
	}
}
