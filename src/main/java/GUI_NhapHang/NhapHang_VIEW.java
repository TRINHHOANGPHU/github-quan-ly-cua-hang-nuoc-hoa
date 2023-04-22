package GUI_NhapHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL_NhapHang.NhapHang_BLL;
import DTO.ChiTietPhieuNhapDTO;
import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NhapHang_VIEW extends JPanel {
	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;
	public JScrollPane jScrollPane_Table;
	public JTable jTable;
	public DefaultTableModel model;
	public JTextField donGiatext;
	public JTextField maSPtext;
	public JTextField SoLuongtext;
	public JLabel NhapHang_btn;
	public JLabel Dung_btn;
	public JLabel Them_btn;
	public JLabel Xoa_btn;
	public JLabel total_label;
	public String[][] datas = {};
	public String[] columns = {"Sản phẩm", "Số lượng", "Đơn giá", "Tổng giá" };
	public JLabel Sua_btn;
	public JLabel Clear_btn;
	public JLabel Huy_btn;
	public NhapHang_CONTROLLER control;

	public NhapHang_VIEW() {
		control = new NhapHang_CONTROLLER(this);
		setLayout(new BorderLayout(0, 0));
		
		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);


		jPanel_Input = new JPanel();
		jPanel_Input.setPreferredSize(new Dimension(350, 10));
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 25));
		
		NhapHang_btn = new JLabel("NHẬP HÀNG", SwingConstants.CENTER);
		NhapHang_btn.setPreferredSize(new Dimension(300, 50));
		NhapHang_btn.setOpaque(true);
		NhapHang_btn.setForeground(Color.WHITE);
		NhapHang_btn.setFont(new Font("Arial", Font.BOLD, 18));
		NhapHang_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(NhapHang_btn);
		NhapHang_btn.addMouseListener(control);
		
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
		donGiatext.setEditable(false);
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
		Them_btn.addMouseListener(control);
		
		Sua_btn = new JLabel("SỬA", SwingConstants.CENTER);
		Sua_btn.setPreferredSize(new Dimension(300, 50));
		Sua_btn.setOpaque(true);
		Sua_btn.setForeground(Color.WHITE);
		Sua_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Sua_btn.setEnabled(false);
		Sua_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Sua_btn);
		Sua_btn.addMouseListener(control);
		
		Huy_btn = new JLabel("HỦY", SwingConstants.CENTER);
		Huy_btn.setPreferredSize(new Dimension(100, 50));
		Huy_btn.setOpaque(true);
		Huy_btn.setForeground(Color.WHITE);
		Huy_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Huy_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Huy_btn);
		Huy_btn.addMouseListener(control);
		
		Clear_btn = new JLabel("CLEAR", SwingConstants.CENTER);
		Clear_btn.setPreferredSize(new Dimension(175, 50));
		Clear_btn.setOpaque(true);
		Clear_btn.setForeground(Color.WHITE);
		Clear_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Clear_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Clear_btn);
		Clear_btn.addMouseListener(control);
		
		Xoa_btn = new JLabel("XÓA", SwingConstants.CENTER);
		Xoa_btn.setEnabled(false);
		Xoa_btn.setPreferredSize(new Dimension(100, 50));
		Xoa_btn.setOpaque(true);
		Xoa_btn.setForeground(Color.WHITE);
		Xoa_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Xoa_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Xoa_btn);
		Xoa_btn.addMouseListener(control);
		
		Dung_btn = new JLabel("DỪNG VÀ LƯU", SwingConstants.CENTER);
		Dung_btn.setEnabled(false);
		Dung_btn.setPreferredSize(new Dimension(175, 50));
		Dung_btn.setOpaque(true);
		Dung_btn.setForeground(Color.WHITE);
		Dung_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Dung_btn.setBackground(new Color(47, 62, 70));
		jPanel_Input.add(Dung_btn);
		Dung_btn.addMouseListener(control);
		
		
		model = new DefaultTableModel(datas, columns);
		
		jTable = new JTable();
		jTable.setModel(model);
		jTable.setRowHeight(40);
		jTable.setGridColor(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jTable.setAutoCreateRowSorter(true);
		jTable.getTableHeader().setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jTable.getTableHeader().setForeground(Color.white);
		jTable.getTableHeader().setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTable.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jTable, matte, false, false, 0, 0).setPreferredSize(new Dimension(0, 40));
		jTable.addMouseListener(control);
		
		jScrollPane_Table = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane_Table.setOpaque(true);
		
		jPanel_scrollpane_table = new JPanel();
		jPanel_scrollpane_table.setLayout(new BorderLayout(0,0));
		jPanel_scrollpane_table.setBackground(Color.black);
		jPanel_scrollpane_table.add(jScrollPane_Table, BorderLayout.CENTER);
		
		total_label = new JLabel("Tổng tiền: ");
		total_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		total_label.setForeground(new Color(255, 255, 255));
		total_label.setHorizontalAlignment(SwingConstants.TRAILING);
		jPanel_scrollpane_table.add(total_label, BorderLayout.SOUTH);
		
		this.add(jPanel_scrollpane_table, BorderLayout.CENTER);
		this.add(jPanel_Input, BorderLayout.WEST);
		
		Content_VIEW.jPanel_Content.add(this);
		maSPtext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				control.loadSP();
			}
		});
	}
	public void clearTextField() {
		this.maSPtext.setText("");
		this.SoLuongtext.setText("");
		this.donGiatext.setText("");
	}
	
	public void activeNhapHang() {
		maSPtext.setEnabled(true);
		SoLuongtext.setEnabled(true);
		donGiatext.setEnabled(true);
		Them_btn.setEnabled(true);
		Dung_btn.setEnabled(true);
	}
	
	public void disActiveNhapHang() {
		maSPtext.setEnabled(false);
		SoLuongtext.setEnabled(false);
		donGiatext.setEnabled(false);
		Them_btn.setEnabled(false);
		Dung_btn.setEnabled(false);
		Xoa_btn.setEnabled(false);
		Sua_btn.setEnabled(false);
	}
	
	public void updateTable(ArrayList<ChiTietPhieuNhapDTO> list, double total) {
		model = new DefaultTableModel(datas, columns);
		String nameSP;
		for (ChiTietPhieuNhapDTO item : list) {
			nameSP =NhapHang_BLL.getSPinfo(item.getMaSP()).getTenSP();
			model.addRow(new Object[] {nameSP, item.getSoLuong(),
					item.getDonGia(), (int)item.getTongGia()});
		}
		jTable.setModel(model);
		total_label.setText("Tổng tiền: "+(int)total);
	}
	
	public void setText(int maSP, int SoLuong, double donGia) {
		this.maSPtext.setText(maSP+"");
		this.SoLuongtext.setText(SoLuong+"");
		this.donGiatext.setText(donGia+"");
	}
	
	public void activateWarning(String message) {
		JOptionPane.showMessageDialog(this, message, "", JOptionPane.WARNING_MESSAGE);
	}
	
}
