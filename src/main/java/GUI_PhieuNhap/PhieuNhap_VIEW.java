package GUI_PhieuNhap;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


import DTO.PhieuNhapDTO;
import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class PhieuNhap_VIEW extends JPanel {

	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;

	public JScrollPane jScrollPane_Table;

	public JTable jTable;

	public DefaultTableModel model;

	public String[][] datas = {};

	public String[] columns = { "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Thời gian", "Tổng tiền" };
	
	public PhieuNhap_CONTROLLER control;
	private JDateChooser dateChooser;
	public JLabel Detail_btn;
	public JLabel Tim_btn;
	public JLabel Huy_btn;
	
	public PhieuNhap_VIEW() {
		control = new PhieuNhap_CONTROLLER(this);
		Content_VIEW.jPanel_Content.setLayout(new BorderLayout());

		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);

		jPanel_Input = new JPanel();
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));

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
		jPanel_scrollpane_table.setLayout(new BorderLayout());
		jPanel_scrollpane_table.setBackground(Color.black);
		jPanel_scrollpane_table.add(jScrollPane_Table, BorderLayout.CENTER);
		setLayout(new BorderLayout(0, 0));

		this.add(jPanel_Input, BorderLayout.NORTH);
		jPanel_Input.setLayout(new BorderLayout(0, 0));
		
		JPanel btn_panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btn_panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(50);
		btn_panel.setOpaque(false);
		jPanel_Input.add(btn_panel, BorderLayout.EAST);
		
		Tim_btn = new JLabel("Tìm kiếm", SwingConstants.CENTER);
		Tim_btn.setPreferredSize(new Dimension(150, 50));
		Tim_btn.setOpaque(true);
		Tim_btn.setForeground(Color.WHITE);
		Tim_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Tim_btn.setBackground(new Color(47, 62, 70));
		btn_panel.add(Tim_btn);
		Tim_btn.addMouseListener(control);
		
		Huy_btn = new JLabel("Hủy tìm kiếm", SwingConstants.CENTER);
		Huy_btn.setPreferredSize(new Dimension(150, 50));
		Huy_btn.setOpaque(true);
		Huy_btn.setForeground(Color.WHITE);
		Huy_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Huy_btn.setBackground(new Color(47, 62, 70));
		btn_panel.add(Huy_btn);
		Huy_btn.addMouseListener(control);
		
		JPanel filter_panel = new JPanel();
		filter_panel.setOpaque(false);
		FlowLayout fl_filter_panel = (FlowLayout) filter_panel.getLayout();
		fl_filter_panel.setVgap(15);
		fl_filter_panel.setHgap(75);
		jPanel_Input.add(filter_panel);
		
		Detail_btn = new JLabel("Xem chi tiết", SwingConstants.CENTER);
		Detail_btn.setPreferredSize(new Dimension(150, 50));
		Detail_btn.setOpaque(true);
		Detail_btn.setForeground(Color.WHITE);
		Detail_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Detail_btn.setBackground(new Color(47, 62, 70));
		filter_panel.add(Detail_btn);
		Detail_btn.addMouseListener(control);
		
		dateChooser = new JDateChooser();
		dateChooser.setFocusCycleRoot(true);
		dateChooser.getCalendarButton().setPreferredSize(new Dimension(25, 17));
		dateChooser.setPreferredSize(new Dimension(165, 50));
		filter_panel.add(dateChooser);
		this.add(jPanel_scrollpane_table);
		
		control.loadData();
		
		Content_VIEW.jPanel_Content.add(this);
	}
	public void updateTable(ArrayList<PhieuNhapDTO> list) {
		DecimalFormat fmt = new DecimalFormat("#,###,###");
		model = new DefaultTableModel(datas, columns);
		for (PhieuNhapDTO item : list) {
			model.addRow(new Object[] {item.getMaPN(), item.getMaNCC(),
					item.getMaNV(), item.getNgayNhap(), item.getThoiGianNhap(),fmt.format((int) item.getTongTien())+"đ"});
		}
		jTable.setModel(model);
	}
	public java.sql.Date getFindDate() {
		if (this.dateChooser.getDate() != null) {
			java.util.Date date = this.dateChooser.getDate();
			return new java.sql.Date(date.getTime());
		}
		return null;
	}
	public void activateWarning(String message) {
		JOptionPane.showMessageDialog(this, message, "", JOptionPane.WARNING_MESSAGE);
	}
}

