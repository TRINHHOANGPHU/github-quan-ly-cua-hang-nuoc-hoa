package DAL_NhapHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhieuNhapDTO;
import connectDatabase.JDBCUtil;
import main.Main;

public class PhieuNhap_DAL implements DALinterface<PhieuNhapDTO>{
	
	public static PhieuNhap_DAL getInstance() {	
		return new PhieuNhap_DAL();
	}

	public boolean insert(PhieuNhapDTO t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO `phieunhap`(`maPN`, `maNCC`, `maNV`, `ngayNhap`, `thoiGianNhap`, `tongTien`) "
						+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(	1,t.getMaPN());
			st.setInt(	2,t.getMaNCC());
			st.setInt(	3,t.getMaNV());
			st.setDate(	4,t.getNgayNhap());
			st.setTime(	5,t.getThoiGianNhap());
			st.setDouble(6, t.getTongTien());
			
			st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(PhieuNhapDTO t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE * FROM `phieunhap` WHERE maPN =?"
						+ "VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(	1,t.getMaPN());		
			st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(PhieuNhapDTO t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE INTO `phieunhap`(`maPN`, `maNCC`, `maNV`, `ngayNhap`, `thoiGianNhap`, `tongTien`) "
						+ "VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(	1,t.getMaPN());
			st.setInt(	2,t.getMaNCC());
			st.setInt(	3,t.getMaNV());
			st.setDate(	4,t.getNgayNhap());
			st.setTime(	5,t.getThoiGianNhap());
			st.setDouble(6, t.getTongTien());
			
			st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public PhieuNhapDTO getById(int id) {
		PhieuNhapDTO ketQua = null;
		Connection con = JDBCUtil.getConnection();
		
		try {
			String sql = "SELECT * FROM phieunhap WHERE MaPN = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				ketQua = new PhieuNhapDTO(rs.getInt("MaPN"),rs.getInt("MaNCC"),rs.getInt("maNV"),
						rs.getDate("ngayNhap"),rs.getTime("thoiGianNhap"),rs.getDouble("tongTien"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(con);
		return ketQua;
	}

	public ArrayList<PhieuNhapDTO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<PhieuNhapDTO> ketQua = new ArrayList<PhieuNhapDTO>();
		Connection con = JDBCUtil.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM phieunhap ORDER BY maPN DESC";					 
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				PhieuNhapDTO pn = new PhieuNhapDTO(rs.getInt("MaPN"),rs.getInt("MaNCC"),rs.getInt("maNV"),
						rs.getDate("ngayNhap"),rs.getTime("thoiGianNhap"),rs.getDouble("tongTien"));
				ketQua.add(pn);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBCUtil.closeConnection(con);
		
		return ketQua;	
	}
	
	public int getLastID() {
		try {
			int result = 0;
			Connection con = JDBCUtil.getConnection();
			
			String sql ="SELECT * FROM `phieunhap` ORDER BY maPN DESC LIMIT 1";
			PreparedStatement st =  con.prepareStatement(sql);		
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) result = rs.getInt("maPN");
			
			JDBCUtil.closeConnection(con);
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

