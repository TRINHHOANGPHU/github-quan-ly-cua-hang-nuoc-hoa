package GUI_QuanLySanPham;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BLL_QuanLySanPham.QuanLySanPham_BLL;
import DTO.SanPhamDTO;
import DTO.LoaiSanPhamDTO;
import GUI.Content_VIEW;
import GUI_QuanLySanPham.HienChiTietMotDong_CONTROLLER;
import GUI_QuanLySanPham.SanPham_CONTROLLER;
import GUI_QuanLySanPham.LoaiSanPham_CONTROLLER;
import generalRules.fontChuDe;
import generalRules.mauChuDe;

public class QuanLySanPham_VIEW extends JFrame {


//SanPham
	public JTextField jTextField_MaSanPham;
	public JTextField jTextField_TenSanPham;
	public JTextField jTextField_MaLoaiSanPham_1;
	public JTextField jTextField_GiaNhap;
	public JTextField jTextField_GiaBan;
	public JTextField jTextField_SoLuong;
	public JTextField jTextField_TrangThai;
	public JTextField jTextField_Hinh;	
	public JTextField jTextField_TimKiem_1;

	public JLabel jLabel_Them_1;
	public JLabel jLabel_Sua_1;
	public JLabel jLabel_Xoa_1;
	public JLabel jLabel_TimKiem_1;

	public JPanel jPanel_Input_1;
	public JPanel jPanel_Input_Parent_ThongTin_TimKiem_1;
	public JPanel jPanel_Input_ThongTin_1;
	public JPanel jPanel_Input_TimKiem_1;
	public JPanel jPanel_Buttons_1;
	public JPanel jPanel_scrollpane_table_1;

	public JScrollPane jScrollPane_Table_1;

	public JTable jTable_1;

	public DefaultTableModel defaultTableModel_1;

	public String[][] datas_1 = {};
	public String[] columns_1 = { "Mã sản phẩm", "Mã loại sản phẩm", "Tên sản phẩm", "Giá nhập", "Giá bán", "Số lượng", "Hình", "Trạng thái" };
	
//LoaiSanPham
	public JTextField jTextField_MaLoaiSanPham_2;
	public JTextField jTextField_TenLoaiSanPham;
	public JTextField jTextField_MoTa;
	public JTextField jTextField_TimKiem_2;

	public JLabel jLabel_Them_2;
	public JLabel jLabel_Sua_2;
	public JLabel jLabel_Xoa_2;
	public JLabel jLabel_TimKiem_2;

	public JPanel jPanel_Input_2;
	public JPanel jPanel_Input_Parent_ThongTin_TimKiem_2;
	public JPanel jPanel_Input_ThongTin_2;
	public JPanel jPanel_Input_TimKiem_2;
	public JPanel jPanel_Buttons_2;
	public JPanel jPanel_scrollpane_table_2;

	public JScrollPane jScrollPane_Table_2;

	public JTable jTable_2;

	public DefaultTableModel defaultTableModel_2;

	public String[][] datas_2 = {};
	public String[] columns_2 = { "Mã loại sản phẩm", "Mã loại sản phẩm", "Mô tả" };


    public QuanLySanPham_VIEW() {
    	MouseListener sanPham_CONTROLLER = new SanPham_CONTROLLER(this);
    	MouseListener loaiSanPham_CONTROLLER = new SanPham_CONTROLLER(this);
		MouseAdapter hienThiChiTietMotDong_CONTROLLER = new HienChiTietMotDong_CONTROLLER(this);

    	// Thiết lập tiêu đề của cửa sổ
        setTitle("Quản lý sản phẩm");

        // Thiết lập kích thước của cửa sổ
        setSize(975, 712);

        // Tạo 2 tab
        JTabbedPane tabbedPane = new JTabbedPane();        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Quản lý sản phẩm", panel1);
        tabbedPane.addTab("Quản lý loại sản phẩm", panel2);


        getContentPane().add(tabbedPane);
		Content_VIEW.jPanel_Content.setLayout(new BorderLayout());

		// Tạo một MatteBorder đen với viền xung quanh
		Border matte = BorderFactory.createMatteBorder(0, 2, 5, 2, Color.BLACK);
		//Tab1
		jTextField_Hinh = new JTextField();
		jTextField_Hinh.setText(null);

		
		jTextField_MaSanPham = new JTextField();
		jTextField_MaSanPham.setHorizontalAlignment(JTextField.CENTER);
		jTextField_MaSanPham.setEnabled(false);
		jTextField_MaSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_MaSanPham.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jTextField_MaSanPham.setBorder(
				new TitledBorder(matte, "Mã loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_MaLoaiSanPham_1 = new JTextField();
		jTextField_MaLoaiSanPham_1.setPreferredSize(new Dimension(200, 65));
		jTextField_MaLoaiSanPham_1.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_MaLoaiSanPham_1.setBorder(
				new TitledBorder(matte, "Mã loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
				
		jTextField_TenSanPham = new JTextField();
		jTextField_TenSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_TenSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TenSanPham
				.setBorder(new TitledBorder(matte, "Tên sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));		
		jTextField_GiaNhap = new JTextField();
		jTextField_GiaNhap.setPreferredSize(new Dimension(200, 65));
		jTextField_GiaNhap.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_GiaNhap
				.setBorder(new TitledBorder(matte, "Giá nhập", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_GiaBan = new JTextField();
		jTextField_GiaBan.setPreferredSize(new Dimension(200, 65));
		jTextField_GiaBan.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_GiaBan
				.setBorder(new TitledBorder(matte, "Giá bán", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_SoLuong = new JTextField();
		jTextField_SoLuong.setPreferredSize(new Dimension(200, 65));
		jTextField_SoLuong.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_SoLuong
				.setBorder(new TitledBorder(matte, "Số lượng", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		jTextField_TrangThai = new JTextField();
		jTextField_TrangThai.setPreferredSize(new Dimension(200, 65));
		jTextField_TrangThai.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TrangThai
				.setBorder(new TitledBorder(matte, "Trạng thái", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		
		jTextField_TimKiem_1 = new JTextField();
		jTextField_TimKiem_1.setPreferredSize(new Dimension(400, 65));
		jTextField_TimKiem_1.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TimKiem_1
				.setBorder(new TitledBorder(matte, "Tìm kiếm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		
		
		jLabel_Them_1 = new JLabel("Thêm", JLabel.CENTER);
		jLabel_Them_1.setPreferredSize(new Dimension(150, 50));
		jLabel_Them_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Them_1.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Them_1.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Them_1.setOpaque(true);
		jLabel_Them_1.addMouseListener(sanPham_CONTROLLER);
		
		jLabel_Sua_1 = new JLabel("Sửa", JLabel.CENTER);
		jLabel_Sua_1.setPreferredSize(new Dimension(150, 50));
		jLabel_Sua_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Sua_1.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Sua_1.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Sua_1.setOpaque(true);
		jLabel_Sua_1.addMouseListener(sanPham_CONTROLLER);
		
		jLabel_Xoa_1 = new JLabel("Xóa", JLabel.CENTER);
		jLabel_Xoa_1.setPreferredSize(new Dimension(150, 50));
		jLabel_Xoa_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Xoa_1.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Xoa_1.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Xoa_1.setOpaque(true);
		jLabel_Xoa_1.addMouseListener(sanPham_CONTROLLER);
		
		jLabel_TimKiem_1 = new JLabel("Tìm kiếm", JLabel.CENTER);
		jLabel_TimKiem_1.setPreferredSize(new Dimension(150, 50));
		jLabel_TimKiem_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_TimKiem_1.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_TimKiem_1.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_TimKiem_1.setOpaque(true);
		jLabel_TimKiem_1.addMouseListener(sanPham_CONTROLLER);
		
		jPanel_Input_ThongTin_1 = new JPanel();
		jPanel_Input_ThongTin_1.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		jPanel_Input_ThongTin_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_ThongTin_1.setPreferredSize(new Dimension(0, 100));
		jPanel_Input_ThongTin_1.add(jTextField_MaSanPham);
		jPanel_Input_ThongTin_1.add(jTextField_MaLoaiSanPham_1);
		jPanel_Input_ThongTin_1.add(jTextField_TenSanPham);
		jPanel_Input_ThongTin_1.add(jTextField_GiaNhap);
		jPanel_Input_ThongTin_1.add(jTextField_GiaBan);
		jPanel_Input_ThongTin_1.add(jTextField_SoLuong);
		jPanel_Input_ThongTin_1.add(jTextField_TrangThai);
		
		
		jPanel_Input_TimKiem_1 = new JPanel();
		jPanel_Input_TimKiem_1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		jPanel_Input_TimKiem_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_TimKiem_1.setPreferredSize(new Dimension(0, 100));
		jPanel_Input_TimKiem_1.add(jTextField_TimKiem_1);
		jPanel_Input_TimKiem_1.add(jLabel_TimKiem_1);
		
		
		jPanel_Input_Parent_ThongTin_TimKiem_1 = new JPanel();
		jPanel_Input_Parent_ThongTin_TimKiem_1.setLayout(new BorderLayout());
		jPanel_Input_Parent_ThongTin_TimKiem_1.add(jPanel_Input_TimKiem_1, BorderLayout.SOUTH);
		jPanel_Input_Parent_ThongTin_TimKiem_1.add(jPanel_Input_ThongTin_1, BorderLayout.NORTH);
		
		jPanel_Buttons_1 = new JPanel();
		jPanel_Buttons_1.setPreferredSize(new Dimension(200, 0));
		jPanel_Buttons_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Buttons_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 13));
		jPanel_Buttons_1.add(jLabel_Them_1);
		jPanel_Buttons_1.add(jLabel_Sua_1);
		jPanel_Buttons_1.add(jLabel_Xoa_1);
		
		jPanel_Input_1 = new JPanel();
		jPanel_Input_1.setBounds(251, 118, 0, 200);
		jPanel_Input_1.setPreferredSize(new Dimension(0, 200));
		jPanel_Input_1.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_1.setLayout(new BorderLayout());
		jPanel_Input_1.add(jPanel_Input_Parent_ThongTin_TimKiem_1, BorderLayout.CENTER);
		jPanel_Input_1.add(jPanel_Buttons_1, BorderLayout.EAST);

		defaultTableModel_1 = new DefaultTableModel(datas_1, columns_1);

		jTable_1 = new JTable();
		jTable_1.setModel(defaultTableModel_1);
		jTable_1.setRowHeight(40);
		jTable_1.setGridColor(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jTable_1.setAutoCreateRowSorter(true);
		jTable_1.getTableHeader().setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jTable_1.getTableHeader().setForeground(Color.white);
		jTable_1.getTableHeader().setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTable_1.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jTable_1, matte, false, false, 0, 0).setPreferredSize(new Dimension(0, 40));
		jTable_1.addMouseListener(hienThiChiTietMotDong_CONTROLLER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // canh giữa nội dung
		jTable_1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		jScrollPane_Table_1 = new JScrollPane(jTable_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane_Table_1.setBounds(0, 0, 452, 427);
		jScrollPane_Table_1.setOpaque(true);
		
		jPanel_scrollpane_table_1 = new JPanel();
		jPanel_scrollpane_table_1.setBounds(251, 100, 452, 427);
		jPanel_scrollpane_table_1.setBackground(Color.black);
		jPanel_scrollpane_table_1.setLayout(new BorderLayout(0, 0));
		jPanel_scrollpane_table_1.add(jScrollPane_Table_1);
		panel1.setLayout(new BorderLayout());
		
		panel1.add(jPanel_Input_1, BorderLayout.PAGE_START);
		panel1.add(jPanel_scrollpane_table_1);

		this.auto_Set_maSP();
		this.showTable1(new QuanLySanPham_BLL().getList_SanPham());
	
	//Tab2
		jTextField_MaLoaiSanPham_2 = new JTextField();
		jTextField_MaLoaiSanPham_2.setHorizontalAlignment(JTextField.CENTER);
		jTextField_MaLoaiSanPham_2.setEnabled(false);
		jTextField_MaLoaiSanPham_2.setPreferredSize(new Dimension(200, 65));
		jTextField_MaLoaiSanPham_2.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jTextField_MaLoaiSanPham_2.setBorder(
				new TitledBorder(matte, "Mã loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
				
		jTextField_TenLoaiSanPham = new JTextField();
		jTextField_TenLoaiSanPham.setPreferredSize(new Dimension(200, 65));
		jTextField_TenLoaiSanPham.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TenLoaiSanPham
				.setBorder(new TitledBorder(matte, "Tên loại sản phẩm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));		
		jTextField_MoTa = new JTextField();
		jTextField_MoTa.setPreferredSize(new Dimension(200, 65));
		jTextField_MoTa.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_MoTa
				.setBorder(new TitledBorder(matte, "Mô tả", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		
		jTextField_TimKiem_2 = new JTextField();
		jTextField_TimKiem_2.setPreferredSize(new Dimension(400, 65));
		jTextField_TimKiem_2.setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTextField_TimKiem_2
				.setBorder(new TitledBorder(matte, "Tìm kiếm", 0, 0, fontChuDe.FONT_TITLE_BORDER.getFont(), null));
		
		
		jLabel_Them_2 = new JLabel("Thêm", JLabel.CENTER);
		jLabel_Them_2.setPreferredSize(new Dimension(150, 50));
		jLabel_Them_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Them_2.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Them_2.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Them_2.setOpaque(true);
		jLabel_Them_2.addMouseListener(loaiSanPham_CONTROLLER);
		
		jLabel_Sua_2 = new JLabel("Sửa", JLabel.CENTER);
		jLabel_Sua_2.setPreferredSize(new Dimension(150, 50));
		jLabel_Sua_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Sua_2.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Sua_2.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Sua_2.setOpaque(true);
		jLabel_Sua_2.addMouseListener(loaiSanPham_CONTROLLER);
		
		jLabel_Xoa_2 = new JLabel("Xóa", JLabel.CENTER);
		jLabel_Xoa_2.setPreferredSize(new Dimension(150, 50));
		jLabel_Xoa_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_Xoa_2.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_Xoa_2.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_Xoa_2.setOpaque(true);
		jLabel_Xoa_2.addMouseListener(loaiSanPham_CONTROLLER);
		
		jLabel_TimKiem_2 = new JLabel("Tìm kiếm", JLabel.CENTER);
		jLabel_TimKiem_2.setPreferredSize(new Dimension(150, 50));
		jLabel_TimKiem_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jLabel_TimKiem_2.setForeground(Color.decode(mauChuDe.COLOR_FONT_MENU_LEFT.getMaMau()));
		jLabel_TimKiem_2.setFont(fontChuDe.FONT_MENU_LEFT_2.getFont());
		jLabel_TimKiem_2.setOpaque(true);
		jLabel_TimKiem_2.addMouseListener(loaiSanPham_CONTROLLER);
		
		jPanel_Input_ThongTin_2 = new JPanel();
		jPanel_Input_ThongTin_2.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		jPanel_Input_ThongTin_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_ThongTin_2.setPreferredSize(new Dimension(0, 100));
		jPanel_Input_ThongTin_2.add(jTextField_MaLoaiSanPham_2);
		jPanel_Input_ThongTin_2.add(jTextField_TenLoaiSanPham);
		jPanel_Input_ThongTin_2.add(jTextField_MoTa);
		
		
		jPanel_Input_TimKiem_2 = new JPanel();
		jPanel_Input_TimKiem_2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		jPanel_Input_TimKiem_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_TimKiem_2.setPreferredSize(new Dimension(0, 100));
		jPanel_Input_TimKiem_2.add(jTextField_TimKiem_2);
		jPanel_Input_TimKiem_2.add(jLabel_TimKiem_2);
		
		
		jPanel_Input_Parent_ThongTin_TimKiem_2 = new JPanel();
		jPanel_Input_Parent_ThongTin_TimKiem_2.setLayout(new BorderLayout());
		jPanel_Input_Parent_ThongTin_TimKiem_2.add(jPanel_Input_TimKiem_2, BorderLayout.SOUTH);
		jPanel_Input_Parent_ThongTin_TimKiem_2.add(jPanel_Input_ThongTin_2, BorderLayout.NORTH);
		
		jPanel_Buttons_2 = new JPanel();
		jPanel_Buttons_2.setPreferredSize(new Dimension(200, 0));
		jPanel_Buttons_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Buttons_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 13));
		jPanel_Buttons_2.add(jLabel_Them_2);
		jPanel_Buttons_2.add(jLabel_Sua_2);
		jPanel_Buttons_2.add(jLabel_Xoa_2);
		
		jPanel_Input_2 = new JPanel();
		jPanel_Input_2.setBounds(251, 118, 0, 200);
		jPanel_Input_2.setPreferredSize(new Dimension(0, 200));
		jPanel_Input_2.setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_INPUT_CONTENT.getMaMau()));
		jPanel_Input_2.setLayout(new BorderLayout());
		jPanel_Input_2.add(jPanel_Input_Parent_ThongTin_TimKiem_2, BorderLayout.CENTER);
		jPanel_Input_2.add(jPanel_Buttons_2, BorderLayout.EAST);

		defaultTableModel_2 = new DefaultTableModel(datas_2, columns_2);

		jTable_2 = new JTable();
		jTable_2.setModel(defaultTableModel_2);
		jTable_2.setRowHeight(40);
		jTable_2.setGridColor(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jTable_2.setAutoCreateRowSorter(true);
		jTable_2.getTableHeader().setBackground(Color.decode(mauChuDe.COLOR_BACKGROUND_TITLE.getMaMau()));
		jTable_2.getTableHeader().setForeground(Color.white);
		jTable_2.getTableHeader().setFont(fontChuDe.FONT_MENU_LEFT.getFont());
		jTable_2.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jTable_2, matte, false, false, 0, 0).setPreferredSize(new Dimension(0, 40));
		jTable_2.addMouseListener(hienThiChiTietMotDong_CONTROLLER);
		DefaultTableCellRenderer centerRenderer_2 = new DefaultTableCellRenderer();
		centerRenderer_2.setHorizontalAlignment(JLabel.CENTER); // canh giữa nội dung
		jTable_2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		jScrollPane_Table_2 = new JScrollPane(jTable_2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane_Table_2.setBounds(0, 0, 452, 427);
		jScrollPane_Table_2.setOpaque(true);
		
		jPanel_scrollpane_table_2 = new JPanel();
		jPanel_scrollpane_table_2.setBounds(251, 100, 452, 427);
		jPanel_scrollpane_table_2.setBackground(Color.black);
		jPanel_scrollpane_table_2.setLayout(new BorderLayout(0, 0));
		jPanel_scrollpane_table_2.add(jScrollPane_Table_2);
		panel2.setLayout(new BorderLayout());
		
		panel2.add(jPanel_Input_2, BorderLayout.PAGE_START);
		panel2.add(jPanel_scrollpane_table_2);
		
		Content_VIEW.jPanel_Content.add(tabbedPane, BorderLayout.CENTER);
		this.auto_Set_maLoaiSP();
		this.showTable2(new QuanLySanPham_BLL().getList_LoaiSanPham());
	}
	
	public void auto_Set_maSP() {
		this.jTextField_MaSanPham.setText((new QuanLySanPham_BLL().layGiaTriLonNhat_ColumnMaSP() + 1) + "");
	}
	
	public void showTable1(ArrayList<SanPhamDTO> arrayList_SanPhamDTOs) {
		this.defaultTableModel_1.setRowCount(0);
		for (SanPhamDTO SanPhamDTO : arrayList_SanPhamDTOs) {
			Object[] objects = new Object[4];
			objects[0] = SanPhamDTO.getMaSP();
			objects[1] = SanPhamDTO.getMaLoaiSP();
			objects[2] = SanPhamDTO.getTenSP();			
			objects[3] = SanPhamDTO.getGiaNhap();
			objects[4] = SanPhamDTO.getGiaBan();
			objects[5] = SanPhamDTO.getSoLuong();
			objects[6] = SanPhamDTO.getHinh();
			objects[7] = SanPhamDTO.getTrangThai();			
			this.defaultTableModel_1.addRow(objects);
		}
	}		

public void auto_Set_maLoaiSP() {
	this.jTextField_MaLoaiSanPham_2.setText((new QuanLySanPham_BLL().layGiaTriLonNhat_ColumnMaLoaiSP() + 1) + "");
}

public void showTable2(ArrayList<LoaiSanPhamDTO> arrayList_LoaiSanPhamDTOs) {
	this.defaultTableModel_2.setRowCount(0);
	for (LoaiSanPhamDTO LoaiSanPhamDTO : arrayList_LoaiSanPhamDTOs) {
		Object[] objects = new Object[4];
		objects[0] = LoaiSanPhamDTO.getMaLoaiSP();
		objects[1] = LoaiSanPhamDTO.getTenLoaiSP();
		objects[2] = LoaiSanPhamDTO.getMoTa();						
		this.defaultTableModel_2.addRow(objects);
	}
}
  
		
}
