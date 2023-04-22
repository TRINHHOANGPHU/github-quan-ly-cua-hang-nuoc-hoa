package GUI_NhapHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL_NhapHang.NhapHang_BLL;
import BLL_NhapHang.PhieuNhap_BLL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class ChiTietPhieuNhap_VIEW extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String[][] datas = {};
	public String[] columns = {"Sản phẩm", "Số lượng", "Đơn giá", "Tổng giá" };
	public DefaultTableModel model;
	private JLabel tongTien;
	private JLabel thoiGian;
	private JLabel nhanVien;

	public ChiTietPhieuNhap_VIEW(ArrayList<ChiTietPhieuNhapDTO> list, PhieuNhapDTO phieuNhap) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_thongTin = new JPanel();
		contentPane.add(panel_thongTin, BorderLayout.NORTH);
		panel_thongTin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Phiếu nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(270, 14));
		panel_thongTin.add(lblNewLabel);
		
		JPanel panel_item = new JPanel();
		contentPane.add(panel_item, BorderLayout.CENTER);
		panel_item.setLayout(new BorderLayout(0, 0));
		
		
		model = new DefaultTableModel(datas, columns);
		table = new JTable();
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_item.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_thongTin_2 = new JPanel();
		panel_thongTin_2.setPreferredSize(new Dimension(10, 60));
		contentPane.add(panel_thongTin_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng tiền:");
		lblNewLabel_1.setPreferredSize(new Dimension(300, 14));
		panel_thongTin_2.add(lblNewLabel_1);
		
		tongTien = new JLabel("");
		tongTien.setHorizontalAlignment(SwingConstants.TRAILING);
		tongTien.setPreferredSize(new Dimension(300, 14));
		panel_thongTin_2.add(tongTien);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Thời gian tạo:");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(300, 14));
		panel_thongTin_2.add(lblNewLabel_1_1_1);
		
		thoiGian = new JLabel("");
		thoiGian.setHorizontalAlignment(SwingConstants.TRAILING);
		thoiGian.setPreferredSize(new Dimension(300, 14));
		panel_thongTin_2.add(thoiGian);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nhân viên tạo");
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(300, 14));
		panel_thongTin_2.add(lblNewLabel_1_1_1_1);
		
		nhanVien = new JLabel("");
		nhanVien.setPreferredSize(new Dimension(300, 14));
		nhanVien.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_thongTin_2.add(nhanVien);
		
		
		loadPhieuNhap(list,phieuNhap);
		setVisible(true);
	}
	
	public void loadPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> list, PhieuNhapDTO phieuNhap) {
		model = new DefaultTableModel(datas, columns);
		String nameSP;
		for (ChiTietPhieuNhapDTO item : list) {
			nameSP =NhapHang_BLL.getSPinfo(item.getMaSP()).getTenSP();
			model.addRow(new Object[] {nameSP, item.getSoLuong(),
					item.getDonGia(), (int)item.getTongGia()+"đ"});
		}
		table.setModel(model);
		tongTien.setText((int) phieuNhap.getTongTien()+"đ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		thoiGian.setText(phieuNhap.getThoiGianNhap().toString()+" - "+sdf.format(phieuNhap.getNgayNhap()).toString());
		nhanVien.setText("null");
	}

}
