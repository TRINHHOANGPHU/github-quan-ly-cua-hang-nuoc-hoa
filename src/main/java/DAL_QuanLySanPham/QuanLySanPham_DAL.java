package DAL_QuanLySanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.LoaiSanPhamDTO;
import DTO.SanPhamDTO;
import connectDatabase.JDBCUtil;

public class QuanLySanPham_DAL {

	public QuanLySanPham_DAL() {
		
	}
	
	//SanPham
	public int them(SanPhamDTO sanPhamDTO) {
		try {
			// bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();

			// bước 2 tạo ra đối tượng preparedStatement
			String sql = "INSERT INTO sanpham(maSP, maLoaiSP, tenSP, giaNhap, giaBan, soLuong, hinh, trangThai)\r\n" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sanPhamDTO.getMaSP());
			ps.setInt(2, sanPhamDTO.getMaLoaiSP());
			ps.setString(3, sanPhamDTO.getTenSP());
			ps.setDouble(4, sanPhamDTO.getGiaNhap());
			ps.setDouble(5, sanPhamDTO.getGiaBan());
			ps.setInt(6, sanPhamDTO.getSoLuong());		
			ps.setString(7, sanPhamDTO.getHinh());
			ps.setInt(8, sanPhamDTO.getTrangThai());

			// bước 3 thực thi một câu lệnh sql
			int check = ps.executeUpdate();

			// bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<SanPhamDTO> getList_SanPham() {
		ArrayList<SanPhamDTO> arrayList_SanPham = new ArrayList<SanPhamDTO>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sanpham ORDER BY maSP ASC";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("maSP");
				int maLoaiSP = rs.getInt("maLoaiSP");
				String tenSP = rs.getString("tenSP");
				String hinh = rs.getString("hinh");
				int soLuong = rs.getInt("soLuong");
				double giaNhap = rs.getDouble("giaNhap");
				double giaBan = rs.getDouble("giaBan");
				int trangThai = rs.getInt("trangThai");
				
				SanPhamDTO sanPhamDTO = new SanPhamDTO(maSP, maLoaiSP, tenSP, giaNhap, giaBan, soLuong, hinh,trangThai);
				arrayList_SanPham.add(sanPhamDTO);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList_SanPham;
	}
	
	public int layGiaTriLonNhat_ColumnMaSP() {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT MAX(maSP) FROM sanpham";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int maxValue = 0;
			while (rs.next()) {
				maxValue = rs.getInt(1);
				return maxValue;
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void xoaMotDongDuaVaoMaSP(SanPhamDTO sanPhamDTO) {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "DELETE FROM sanpham WHERE maSP = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sanPhamDTO.getMaSP());
			int rs = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suaMotDongDuaVaoMaSP(SanPhamDTO sanPhamDTO) {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE sanpham\r\n"
					+ "SET maLoaiSP = ? \\r\\n"
					+ ",tenSP = ? \\r\\n"
					+ ",giaNhap = ? \\r\\n"
					+ ",giaBan = ? \\r\\n"
					+ ",soLuong = ? \\r\\n"
					+ ",hinh = ? \\r\\n"
					+ ",trangThai = ? \\\\r\\\\n"					
					+ "WHERE maSP = ? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(8, sanPhamDTO.getMaSP());
			ps.setInt(1, sanPhamDTO.getMaLoaiSP());
			ps.setString(2, sanPhamDTO.getTenSP());			
			ps.setDouble(3, sanPhamDTO.getGiaNhap());
			ps.setDouble(4, sanPhamDTO.getGiaBan());
			ps.setInt(5, sanPhamDTO.getSoLuong());
			ps.setString(6, sanPhamDTO.getHinh());
			ps.setInt(7, sanPhamDTO.getTrangThai());
			int rs = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//LoaiSanPham

	public int them(LoaiSanPhamDTO loaiSanPhamDTO) {
		try {
			// bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();

			// bước 2 tạo ra đối tượng preparedStatement
			String sql = "INSERT INTO loaisanpham(maLoaiSP, tenLoaiSP, moTa)\r\n" + "VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, loaiSanPhamDTO.getMaLoaiSP());
			ps.setString(2, loaiSanPhamDTO.getTenLoaiSP());
			ps.setString(3, loaiSanPhamDTO.getMoTa());

			// bước 3 thực thi một câu lệnh sql
			int check = ps.executeUpdate();

			// bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<LoaiSanPhamDTO> getList_LoaiSanPham() {
		ArrayList<LoaiSanPhamDTO> arrayList_LoaiSanPham = new ArrayList<LoaiSanPhamDTO>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM loaisanpham ORDER BY maLoaiSP ASC";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maLoaiSP = rs.getInt("maLoaiSP");
				String tenLoaiSP = rs.getString("tenLoaiSP");
				String moTa = rs.getString("moTa");
				
				LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO(maLoaiSP, tenLoaiSP, moTa);
				arrayList_LoaiSanPham.add(loaiSanPhamDTO);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList_LoaiSanPham;
	}
	
	public int layGiaTriLonNhat_ColumnMaLoaiSP() {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT MAX(maLoaiSP) FROM loaisanpham";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int maxValue = 0;
			while (rs.next()) {
				maxValue = rs.getInt(1);
				return maxValue;
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void xoaMotDongDuaVaoMaLoaiSP(LoaiSanPhamDTO loaiSanPhamDTO) {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "DELETE FROM loaisanpham WHERE maLoaiSP = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, loaiSanPhamDTO.getMaLoaiSP());
			int rs = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suaMotDongDuaVaoMaLoaiSP(LoaiSanPhamDTO loaiSanPhamDTO) {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE loaisanpham\r\n"
					+ "SET tenLoaiSP = ? \r\n"
					+ ",moTa = ? \r\n"
					+ "WHERE maLoaiSP = ? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(3, loaiSanPhamDTO.getMaLoaiSP());
			ps.setString(1, loaiSanPhamDTO.getTenLoaiSP());
			ps.setString(2, loaiSanPhamDTO.getMoTa());
			int rs = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
