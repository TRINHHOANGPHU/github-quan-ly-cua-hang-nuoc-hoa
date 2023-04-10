package DAL_NhaCungCap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.NhaCungCapDTO;
import connectDatabase.JDBCUtil;

public class NhaCungCap_DAL {

	public NhaCungCap_DAL() {
		
	}

	public int them(NhaCungCapDTO nhaCungCapDTO) {
		try {
			// bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();

			// bước 2 tạo ra đối tượng statement
			String sql = "INSERT INTO nhacungcap(maNCC, tenNCC, soDienThoai, diaChi)\r\n" + "VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, nhaCungCapDTO.getMaNCC());
			ps.setString(2, nhaCungCapDTO.getTenNCC());
			ps.setString(3, nhaCungCapDTO.getSoDienThoai());
			ps.setString(4, nhaCungCapDTO.getDiaChi());

			// bước 3 thực thi một câu lệnh sql

			int check = ps.executeUpdate();

			// bước 4 xử lý kết quả
			System.out.println("số dòng thay đổi" + check);
			if (check > 0) {
				System.out.println("thêm dữ liệu thành công");
			} else {
				System.out.println("thêm dữ liệu thất bại");
			}
			// bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
