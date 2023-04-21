package DAL_NhapHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import connectDatabase.JDBCUtil;

public class NhapHang_DAL implements DALinterface<ChiTietPhieuNhapDTO>{

	public static NhapHang_DAL getInstance() {	
		return new NhapHang_DAL();
	}
	
	public boolean insert(ChiTietPhieuNhapDTO t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql ="INSERT INTO `chitietphieunhap`(`maPN`, `maSP`, `soLuong`, `donGia`)"+
									"VALUES (?, ?, ?, ?)";
			PreparedStatement st =  con.prepareStatement(sql);
			
			st.setInt(1, t.getMaPN());
			st.setInt(2, t.getMaSP());
			st.setInt(3, t.getSoLuong());
			st.setDouble(4, t.getDonGia());
			
			st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(ChiTietPhieuNhapDTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(ChiTietPhieuNhapDTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChiTietPhieuNhapDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ChiTietPhieuNhapDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<ChiTietPhieuNhapDTO> getByMaPN(int maPN) {
		ArrayList<ChiTietPhieuNhapDTO> ketQua = new ArrayList<ChiTietPhieuNhapDTO>();
		Connection con = JDBCUtil.getConnection();
		
		try {
			String sql = "SELECT * FROM `chitietphieunhap` WHERE maPN = "+maPN;
			PreparedStatement st =  con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ChiTietPhieuNhapDTO chitiet = new ChiTietPhieuNhapDTO(rs.getInt("maPN")
						, rs.getInt("maSP"), rs.getInt("soLuong"), rs.getDouble("donGia"));
				ketQua.add(chitiet);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBCUtil.closeConnection(con);
		
		return ketQua;	
	}
	

}
