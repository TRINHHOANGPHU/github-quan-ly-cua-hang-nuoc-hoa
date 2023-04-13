package DAL_NhaCungCap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.NhaCungCapDTO;
import connectDatabase.JDBCUtil;

public class NhaCungCap_DAL {

	public NhaCungCap_DAL() {
		
	}

	public int them(NhaCungCapDTO nhaCungCapDTO) {
		try {
			// bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();

			// bước 2 tạo ra đối tượng preparedStatement
			String sql = "INSERT INTO nhacungcap(maNCC, tenNCC, soDienThoai, diaChi)\r\n" + "VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, nhaCungCapDTO.getMaNCC());
			ps.setString(2, nhaCungCapDTO.getTenNCC());
			ps.setString(3, nhaCungCapDTO.getSoDienThoai());
			ps.setString(4, nhaCungCapDTO.getDiaChi());

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
	public ArrayList<NhaCungCapDTO> getList_NhaCungCap() {
		ArrayList<NhaCungCapDTO> arrayList_NhaCungCap = new ArrayList<NhaCungCapDTO>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM nhacungcap ORDER BY maNCC ASC";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maNCC = rs.getInt("maNCC");
				String tenNCC = rs.getString("tenNCC");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				
				NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(maNCC, tenNCC, soDienThoai, diaChi);
				arrayList_NhaCungCap.add(nhaCungCapDTO);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList_NhaCungCap;
	}
	
	public int layGiaTriLonNhat_ColumnMaNCC() {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT MAX(maNCC) FROM nhacungcap";
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
	
	public void xoaMotDongDuaVaoMaNCC(NhaCungCapDTO nhaCungCapDTO) {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "DELETE FROM nhacungcap WHERE maNCC = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, nhaCungCapDTO.getMaNCC());
			int rs = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suaMotDongDuaVaoMaNCC(NhaCungCapDTO nhaCungCapDTO) {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE nhacungcap\r\n"
					+ "SET tenNCC = ? \r\n"
					+ ",soDienThoai = ? \r\n"
					+ ",diaChi = ? \r\n"
					+ "WHERE maNCC = ? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(4, nhaCungCapDTO.getMaNCC());
			ps.setString(1, nhaCungCapDTO.getTenNCC());
			ps.setString(2, nhaCungCapDTO.getSoDienThoai());
			ps.setString(3, nhaCungCapDTO.getDiaChi());
			int rs = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
