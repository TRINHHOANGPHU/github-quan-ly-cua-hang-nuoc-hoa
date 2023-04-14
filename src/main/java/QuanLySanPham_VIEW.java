package GUI_QuanLySanPham;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GUI.Content_VIEW;
import generalRules.fontChuDe;
import generalRules.mauChuDe;

public class QuanLySanPham_VIEW extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JTextField jTextField_MaSanPham;
	public JTextField jTextField_TenSanPham;
	public JTextField jTextField_LoaiSanPham;
	public JTextField jTextField_DonGia;
	public JTextField jTextField_ChuThich;
	
	
	public JTextField jTextField_MaLoaiSanPham;
	public JTextField jTextField_TenLoaiSanPham;
	public JTextField jTextField_TimKiem;
	public JLabel jLabel_Them;
	public JLabel jLabel_Sua;
	public JLabel jLabel_Xoa;
	public JLabel jLabel_TimKiem;
	
	
	public JPanel jPanel_scrollpane_table;
	public JScrollPane jScrollPane_Table;
	public JTable jTable;
	public DefaultTableModel defaultTableModel;
	public String[] columns = {"STT", "Mã loại sản phẩm", "Tên loại sản phẩm"};		
	public Object[][] datas = {};
	private JTable Bang_Tab1;
	private JPanel panel;
	private JScrollPane scrollPane_Tab2;
	private JTable Bang_Tab2;
	
    public QuanLySanPham_VIEW() {
    	
    	// Tạo một MatteBorder đen với viền xung quanh
    			Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);
    	// Thiết lập tiêu đề của cửa sổ
        setTitle("Quản lý sản phẩm");

        // Thiết lập kích thước của cửa sổ
        setSize(975, 712);

        // Tạo 2 tab
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tab_QuanLySP = new JPanel();
        JPanel tab_QuanLyLoaiSP = new JPanel();
        tabbedPane.addTab("Quản lý sản phẩm", tab_QuanLySP);
        tabbedPane.addTab("Quản lý loại sản phẩm", tab_QuanLyLoaiSP);
        

        getContentPane().add(tabbedPane);
     // Thêm vào tab 1
        jTextField_TenSanPham = new JTextField();
        jTextField_TenSanPham.setBounds(365, 405, 537, 69);
		jTextField_TenSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_TenSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TenSanPham.setBorder(
				new TitledBorder(matte, "Tên sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_MaLoaiSanPham = new JTextField();
		jTextField_MaLoaiSanPham.setBounds(653, 485, 249, 69);
		jTextField_MaLoaiSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_MaLoaiSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_MaLoaiSanPham.setBorder(
				new TitledBorder(matte, "Mã loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_MaSanPham = new JTextField();
		jTextField_MaSanPham.setBounds(365, 485, 269, 69);
		jTextField_MaSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_MaSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_MaSanPham.setBorder(
				new TitledBorder(matte, "Mã sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_DonGia = new JTextField();
		jTextField_DonGia.setBounds(365, 565, 269, 69);
		jTextField_DonGia.setPreferredSize(new Dimension(200, 65));
		jTextField_DonGia.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_DonGia.setBorder(
				new TitledBorder(matte, "Đơn giá", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_ChuThich = new JTextField();
		jTextField_ChuThich.setBounds(653, 565, 249, 69);
		jTextField_ChuThich.setPreferredSize(new Dimension(200, 65));
		jTextField_ChuThich.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_ChuThich.setBorder(
				new TitledBorder(matte, "Chú thích", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
        
        jTextField_TimKiem = new JTextField();
		jTextField_TimKiem.setBounds(10, 11, 675, 65);
		jTextField_TimKiem.setPreferredSize(new Dimension(200, 65));
		jTextField_TimKiem.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TimKiem.setBorder(
				new TitledBorder(matte, "Tìm kiếm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jLabel_TimKiem = new JLabel("Tìm kiếm", SwingConstants.CENTER);
		jLabel_TimKiem.setPreferredSize(new Dimension(200, 65));
		jLabel_TimKiem.setOpaque(true);
		jLabel_TimKiem.setForeground(Color.WHITE);
		jLabel_TimKiem.setFont(new Font("Arial", Font.BOLD, 18));
		jLabel_TimKiem.setBackground(new Color(47, 62, 70));
		jLabel_TimKiem.setBounds(705, 11, 197, 65);		
	
		
		tab_QuanLySP.setPreferredSize(new Dimension(0, 100));
		tab_QuanLySP.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		tab_QuanLySP.setLayout(null);
		tab_QuanLySP.add(jTextField_TenSanPham );
		tab_QuanLySP.add(jTextField_MaLoaiSanPham);
		tab_QuanLySP.add(jTextField_MaSanPham);
		tab_QuanLySP.add(jTextField_DonGia);
		tab_QuanLySP.add(jTextField_ChuThich);
		tab_QuanLySP.add(jTextField_TimKiem);
		tab_QuanLySP.add(jLabel_TimKiem);
		
		
		JPanel Panel_Bang_Tab1 = new JPanel();
		Panel_Bang_Tab1.setBounds(10, 87, 934, 294);
		tab_QuanLySP.add(Panel_Bang_Tab1);
		Panel_Bang_Tab1.setLayout(null);
		
		JScrollPane scrollPane_Tab1 = new JScrollPane();
		scrollPane_Tab1.setBounds(0, 0, 934, 294);
		Panel_Bang_Tab1.add(scrollPane_Tab1);
		
		Bang_Tab1 = new JTable();
		Bang_Tab1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Mã loại sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
			}
		));
		scrollPane_Tab1.setViewportView(Bang_Tab1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 392, 321, 242);
		tab_QuanLySP.add(panel_1);
       
        // Thêm vào tab 2
        jTextField_MaLoaiSanPham = new JTextField();
        jTextField_MaLoaiSanPham.setBounds(10, 108, 377, 65);
		jTextField_MaLoaiSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_MaLoaiSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_MaLoaiSanPham.setBorder(
				new TitledBorder(matte, "Mã loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_TenLoaiSanPham = new JTextField();
		jTextField_TenLoaiSanPham.setBounds(397, 108, 365, 65);
		jTextField_TenLoaiSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_TenLoaiSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TenLoaiSanPham.setBorder(
				new TitledBorder(matte, "Tên loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_TimKiem = new JTextField();
		jTextField_TimKiem.setBounds(10, 11, 501, 65);
		jTextField_TimKiem.setPreferredSize(new Dimension(200, 65));
		jTextField_TimKiem.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TimKiem.setBorder(
				new TitledBorder(matte, "Tìm kiếm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		
		jLabel_Them = new JLabel("Thêm", JLabel.CENTER);
		jLabel_Them.setBounds(793, 11, 151, 45);
		jLabel_Them.setPreferredSize(new Dimension(200, 65));
		jLabel_Them.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Them.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Them.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Them.setOpaque(true);		
		
		jLabel_Xoa = new JLabel("Xoá", SwingConstants.CENTER);
		jLabel_Xoa.setPreferredSize(new Dimension(200, 65));
		jLabel_Xoa.setOpaque(true);
		jLabel_Xoa.setForeground(Color.WHITE);
		jLabel_Xoa.setFont(new Font("Arial", Font.BOLD, 18));
		jLabel_Xoa.setBackground(new Color(47, 62, 70));
		jLabel_Xoa.setBounds(793, 67, 151, 45);		
		
		jLabel_Sua = new JLabel("Sửa", SwingConstants.CENTER);
		jLabel_Sua.setPreferredSize(new Dimension(200, 65));
		jLabel_Sua.setOpaque(true);
		jLabel_Sua.setForeground(Color.WHITE);
		jLabel_Sua.setFont(new Font("Arial", Font.BOLD, 18));
		jLabel_Sua.setBackground(new Color(47, 62, 70));
		jLabel_Sua.setBounds(793, 123, 151, 45);
		
		jLabel_TimKiem = new JLabel("Tìm kiếm", SwingConstants.CENTER);
		jLabel_TimKiem.setPreferredSize(new Dimension(200, 65));
		jLabel_TimKiem.setOpaque(true);
		jLabel_TimKiem.setForeground(Color.WHITE);
		jLabel_TimKiem.setFont(new Font("Arial", Font.BOLD, 18));
		jLabel_TimKiem.setBackground(new Color(47, 62, 70));
		jLabel_TimKiem.setBounds(565, 11, 197, 65);		
	
		
		tab_QuanLyLoaiSP.setPreferredSize(new Dimension(0, 100));
		tab_QuanLyLoaiSP.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		tab_QuanLyLoaiSP.setLayout(null);
		tab_QuanLyLoaiSP.add(jTextField_MaLoaiSanPham);
		tab_QuanLyLoaiSP.add(jTextField_TenLoaiSanPham);
		tab_QuanLyLoaiSP.add(jTextField_TimKiem);
		tab_QuanLyLoaiSP.add(jLabel_Them);
		tab_QuanLyLoaiSP.add(jLabel_TimKiem);
		tab_QuanLyLoaiSP.add(jLabel_Sua);
		tab_QuanLyLoaiSP.add(jLabel_Xoa);
		
		panel = new JPanel();
		panel.setBounds(10, 184, 934, 450);
		tab_QuanLyLoaiSP.add(panel);
		panel.setLayout(null);
		
		scrollPane_Tab2 = new JScrollPane();
		scrollPane_Tab2.setBounds(0, 0, 934, 450);
		panel.add(scrollPane_Tab2);
		
		Bang_Tab2 = new JTable();
		Bang_Tab2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã loại sản phẩm", "Tên loại sản phẩm"
			}
		));
		scrollPane_Tab2.setViewportView(Bang_Tab2);
		
		
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
		
		jPanel_scrollpane_table = new JPanel(new BorderLayout());
		jPanel_scrollpane_table.setLayout(new BorderLayout());
		jPanel_scrollpane_table.setBackground(Color.black);
		jPanel_scrollpane_table.add(jScrollPane_Table, BorderLayout.CENTER);



    }
}
