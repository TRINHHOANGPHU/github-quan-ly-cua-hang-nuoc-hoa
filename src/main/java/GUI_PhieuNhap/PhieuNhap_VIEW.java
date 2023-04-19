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

import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;

public class PhieuNhap_VIEW extends JPanel {

	public JPanel jPanel_Input;
	public JPanel jPanel_scrollpane_table;

	public JScrollPane jScrollPane_Table;

	public JTable jTable;

	public DefaultTableModel model;

	public String[][] datas = {};

	public String[] columns = { "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Thời gian", "Tổng tiền" };
	private JTextField textField_1;
	private JTextField textField_2;
	
	public PhieuNhap_CONTROLLER control;
	
	public PhieuNhap_VIEW() {
		
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
		flowLayout.setHgap(50);
		flowLayout.setAlignment(FlowLayout.LEADING);
		btn_panel.setOpaque(false);
		jPanel_Input.add(btn_panel, BorderLayout.EAST);
		
		JLabel Xoa_btn = new JLabel("Xóa", SwingConstants.CENTER);
		Xoa_btn.setPreferredSize(new Dimension(150, 65));
		Xoa_btn.setOpaque(true);
		Xoa_btn.setForeground(Color.WHITE);
		Xoa_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Xoa_btn.setBackground(new Color(47, 62, 70));
		btn_panel.add(Xoa_btn);
		
		JLabel Tim_btn = new JLabel("Tìm kiếm", SwingConstants.CENTER);
		Tim_btn.setPreferredSize(new Dimension(150, 65));
		Tim_btn.setOpaque(true);
		Tim_btn.setForeground(Color.WHITE);
		Tim_btn.setFont(new Font("Arial", Font.BOLD, 18));
		Tim_btn.setBackground(new Color(47, 62, 70));
		btn_panel.add(Tim_btn);
		
		JPanel text_panel = new JPanel();
		text_panel.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) text_panel.getLayout();
		flowLayout_1.setHgap(50);
		jPanel_Input.add(text_panel);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(200, 65));
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		text_panel.add(textField_1);
		
		
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(200, 65));
		textField_2.setFont(new Font("Arial", Font.PLAIN, 15));
		text_panel.add(textField_2);
		this.add(jPanel_scrollpane_table);
		
		control = new PhieuNhap_CONTROLLER(this);
		control.loadData();
		
		Content_VIEW.jPanel_Content.add(this);
	}
	public void updateTable(ArrayList<PhieuNhapDTO> list) {
		model = new DefaultTableModel(datas, columns);
		for (PhieuNhapDTO item : list) {
			model.addRow(new Object[] {item.getMaPN(), item.getMaNCC(),
					item.getMaNV(), item.getNgayNhap(), item.getThoiGianNhap(), item.getTongTien()});
		}
		jTable.setModel(model);
	}
}
