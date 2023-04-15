package GUI_NhapHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;

public class NhapHang_VIEW extends JPanel {
	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;
	public JScrollPane jScrollPane_Table;
	public JTable jTable;
	public DefaultTableModel defaultTableModel;
	public String[][] datas = {};
	private JTextField donGiatext;
	private JLabel NhapHang_btn;
	private JLabel Dung_btn;
	private JTextField maSPtext;
	private JTextField SoLuongtext;
	private JLabel Them_btn;
	private JLabel Xoa_btn;
	public String[] columns = {"Sản phẩm", "Số lượng", "Đơn giá", "Tổng giá" };
	private JLabel total_label;

	public NhapHang_VIEW() {
		
		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);


		jPanel_Input = new JPanel();
		jPanel_Input.setPreferredSize(new Dimension(350, 10));
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));
		
		NhapHang_btn = new JLabel("NHẬP HÀNG", SwingConstants.CENTER);
		NhapHang_btn.setPreferredSize(new Dimension(300, 50));
		NhapHang_btn.setOpaque(true);
		NhapHang_btn.setForeground(Color.WHITE);
		NhapHang_btn.setFont(new Font("Arial", Font.BOLD, 18));
		NhapHang_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(NhapHang_btn);
		
		maSPtext = new JTextField();
		maSPtext.setEnabled(false);
		maSPtext.setPreferredSize(new Dimension(300, 50));
		maSPtext.setFont(new Font("Arial", Font.PLAIN, 15));
		maSPtext.setBorder(
				new TitledBorder(matte, "Mã sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jPanel_Input.add(maSPtext);
		
		SoLuongtext = new JTextField();
		SoLuongtext.setEnabled(false);
		SoLuongtext.setPreferredSize(new Dimension(300, 50));
		SoLuongtext.setFont(new Font("Arial", Font.PLAIN, 15));
		SoLuongtext.setBorder(
				new TitledBorder(matte, "Số lượng", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jPanel_Input.add(SoLuongtext);
		
		donGiatext = new JTextField();
		donGiatext.setEnabled(false);
		donGiatext.setPreferredSize(new Dimension(300, 50));
		donGiatext.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		donGiatext.setBorder(
				new TitledBorder(matte, "Đơn giá", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jPanel_Input.add(donGiatext);
		
		Them_btn = new JLabel("THÊM", SwingConstants.CENTER);
		Them_btn.setEnabled(false);
		Them_btn.setPreferredSize(new Dimension(300, 50));
		Them_btn.setOpaque(true);
		Them_btn.setForeground(Color.WHITE);
		Them_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Them_btn.setBackground(new Color(47, 62, 70));
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
		
		total_label = new JLabel("Tổng tiền: ");
		total_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		total_label.setForeground(new Color(255, 255, 255));
		total_label.setHorizontalAlignment(SwingConstants.TRAILING);
		jPanel_scrollpane_table.add(total_label, BorderLayout.SOUTH);
		jPanel_scrollpane_table.add(jScrollPane_Table, BorderLayout.CENTER);
		setLayout(new BorderLayout(0, 0));

		this.add(jPanel_Input, BorderLayout.WEST);
		
		Xoa_btn = new JLabel("XÓA", SwingConstants.CENTER);
		Xoa_btn.setEnabled(false);
		Xoa_btn.setPreferredSize(new Dimension(100, 50));
		Xoa_btn.setOpaque(true);
		Xoa_btn.setForeground(Color.WHITE);
		Xoa_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Xoa_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Xoa_btn);
		
		Dung_btn = new JLabel("DỪNG VÀ LƯU", SwingConstants.CENTER);
		Dung_btn.setEnabled(false);
		Dung_btn.setPreferredSize(new Dimension(175, 50));
		Dung_btn.setOpaque(true);
		Dung_btn.setForeground(Color.WHITE);
		Dung_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Dung_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Dung_btn);
		this.add(jPanel_scrollpane_table, BorderLayout.CENTER);
		
		Content_VIEW.jPanel_Content.add(this);
	}

}
