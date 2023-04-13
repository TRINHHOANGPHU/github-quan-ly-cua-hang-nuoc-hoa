package GUI_NhaCungCap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import BLL_NhaCungCap.NhaCungCap_BLL;
import DAL_NhaCungCap.NhaCungCap_DAL;
import DTO.NhaCungCapDTO;
import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;

public class NhaCungCap_VIEW {
	public JTextField jTextField_MaNhaCungCap;
	public JTextField jTextField_TenNhaCungCap;
	public JTextField jTextField_SoDienThoai;
	public JTextField jTextField_DiaChi;
	public JTextField jTextField_TimKiem;

	public JLabel jLabel_Them;
	public JLabel jLabel_Sua;
	public JLabel jLabel_Xoa;
	public JLabel jLabel_TimKiem;

	public JPanel jPanel_Input;
	public JPanel jPanel_Input_Parent_ThongTin_TimKiem;
	public JPanel jPanel_Input_ThongTin;
	public JPanel jPanel_Input_TimKiem;
	public JPanel jPanel_Buttons;
	public JPanel jPanel_scrollpane_table;

	public JScrollPane jScrollPane_Table;

	public JTable jTable;

	public DefaultTableModel defaultTableModel;

	public String[][] datas = {};
	public String[] columns = { "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ" };

	public NhaCungCap_VIEW() {
		MouseListener nhaCungCap_CONTROLLER = new NhaCungCap_CONTROLLER(this);
		MouseAdapter hienThiChiTietMotDong_CONTROLLER = new HienChiTietMotDong_CONTROLLER(this);
		
		
		Content_VIEW.jPanel_Content.setLayout(new BorderLayout());

		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);

		jTextField_MaNhaCungCap = new JTextField();
		jTextField_MaNhaCungCap.setHorizontalAlignment(JTextField.CENTER);
		jTextField_MaNhaCungCap.setEnabled(false);
		jTextField_MaNhaCungCap.setPreferredSize(new Dimension(200, 65));
		jTextField_MaNhaCungCap.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
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
		jTextField_TimKiem = new JTextField();
		jTextField_TimKiem.setPreferredSize(new Dimension(600, 65));
		jTextField_TimKiem.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TimKiem
				.setBorder(new TitledBorder(matte, "Tìm kiếm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		
		
		jLabel_Them = new JLabel("Thêm", JLabel.CENTER);
		jLabel_Them.setPreferredSize(new Dimension(150, 50));
		jLabel_Them.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Them.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Them.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Them.setOpaque(true);
		jLabel_Them.addMouseListener(nhaCungCap_CONTROLLER);
		
		jLabel_Sua = new JLabel("Sửa", JLabel.CENTER);
		jLabel_Sua.setPreferredSize(new Dimension(150, 50));
		jLabel_Sua.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Sua.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Sua.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Sua.setOpaque(true);
		jLabel_Sua.addMouseListener(nhaCungCap_CONTROLLER);
		
		jLabel_Xoa = new JLabel("Xóa", JLabel.CENTER);
		jLabel_Xoa.setPreferredSize(new Dimension(150, 50));
		jLabel_Xoa.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Xoa.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Xoa.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Xoa.setOpaque(true);
		jLabel_Xoa.addMouseListener(nhaCungCap_CONTROLLER);
		
		jLabel_TimKiem = new JLabel("Tìm kiếm", JLabel.CENTER);
		jLabel_TimKiem.setPreferredSize(new Dimension(150, 50));
		jLabel_TimKiem.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_TimKiem.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_TimKiem.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_TimKiem.setOpaque(true);
		jLabel_TimKiem.addMouseListener(nhaCungCap_CONTROLLER);
		
		jPanel_Input_ThongTin = new JPanel();
		jPanel_Input_ThongTin.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		jPanel_Input_ThongTin.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_ThongTin.setPreferredSize(new Dimension(0, 100));
		jPanel_Input_ThongTin.add(jTextField_MaNhaCungCap);
		jPanel_Input_ThongTin.add(jTextField_TenNhaCungCap);
		jPanel_Input_ThongTin.add(jTextField_SoDienThoai);
		jPanel_Input_ThongTin.add(jTextField_DiaChi);
		
		jPanel_Input_TimKiem = new JPanel();
		jPanel_Input_TimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		jPanel_Input_TimKiem.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_TimKiem.setPreferredSize(new Dimension(0, 100));
		jPanel_Input_TimKiem.add(jTextField_TimKiem);
		jPanel_Input_TimKiem.add(jLabel_TimKiem);
		
		jPanel_Input_Parent_ThongTin_TimKiem = new JPanel();
		jPanel_Input_Parent_ThongTin_TimKiem.setLayout(new BorderLayout());
		jPanel_Input_Parent_ThongTin_TimKiem.add(jPanel_Input_TimKiem, BorderLayout.SOUTH);
		jPanel_Input_Parent_ThongTin_TimKiem.add(jPanel_Input_ThongTin, BorderLayout.NORTH);
		
		jPanel_Buttons = new JPanel();
		jPanel_Buttons.setPreferredSize(new Dimension(200, 0));
		jPanel_Buttons.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 13));
		jPanel_Buttons.add(jLabel_Them);
		jPanel_Buttons.add(jLabel_Sua);
		jPanel_Buttons.add(jLabel_Xoa);
		
		jPanel_Input = new JPanel();
		jPanel_Input.setPreferredSize(new Dimension(0, 200));
		jPanel_Input.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input.setLayout(new BorderLayout());
		jPanel_Input.add(jPanel_Input_Parent_ThongTin_TimKiem, BorderLayout.CENTER);
		jPanel_Input.add(jPanel_Buttons, BorderLayout.EAST);

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
		jTable.addMouseListener(hienThiChiTietMotDong_CONTROLLER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // canh giữa nội dung
		jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		jScrollPane_Table = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane_Table.setOpaque(true);
		
		jPanel_scrollpane_table = new JPanel();
		jPanel_scrollpane_table.setLayout(new BorderLayout());
		jPanel_scrollpane_table.setBackground(Color.black);
		jPanel_scrollpane_table.add(jScrollPane_Table, BorderLayout.CENTER);

		Content_VIEW.jPanel_Content.add(jPanel_Input, BorderLayout.PAGE_START);
		Content_VIEW.jPanel_Content.add(jPanel_scrollpane_table, BorderLayout.CENTER);
		this.auto_Set_maNCC();
		this.showTable(new NhaCungCap_BLL().getList_NhaCungCap());
	}
	
	public void auto_Set_maNCC() {
		this.jTextField_MaNhaCungCap.setText((new NhaCungCap_BLL().layGiaTriLonNhat_ColumnMaNCC() + 1) + "");
	}
	
	public void showTable(ArrayList<NhaCungCapDTO> arrayList_NhaCungCapDTOs) {
		this.defaultTableModel.setRowCount(0);
		for (NhaCungCapDTO nhaCungCapDTO : arrayList_NhaCungCapDTOs) {
			Object[] objects = new Object[4];
			objects[0] = nhaCungCapDTO.getMaNCC();
			objects[1] = nhaCungCapDTO.getTenNCC();
			objects[2] = nhaCungCapDTO.getSoDienThoai();
			objects[3] = nhaCungCapDTO.getDiaChi();
			this.defaultTableModel.addRow(objects);
		}
	}

}
