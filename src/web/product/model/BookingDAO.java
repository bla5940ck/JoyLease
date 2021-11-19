package web.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class BookingDAO implements BookingDAOImpl {

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add(BookingVO bk) {
		String sql = "INSERT INTO booking(`prod_id`, `status`, `est_start`, `est_end`) VALUES (?, ?, ?, ?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bk.getProdID());
			pstmt.setInt(2,bk.getStatus());
			pstmt.setDate(3, bk.getEstStart());
			pstmt.setDate(4, bk.getEstEnd());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(BookingVO bk) {
		String sql = "update booking set `status`= ? where bk_id =?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bk.getStatus());
			pstmt.setInt(2, bk.getBkID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(Integer bkID) {

	String sql = "DELETE FROM booking WHERE `bk_id` = ?;";
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bkID);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	}

	@Override
	public List<BookingVO>  findDateByProdID(Integer prodID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from booking where prod_id = ? &&( status =1 ||status =0)" ;
		BookingVO bk = null;
		List<BookingVO> list = new ArrayList<BookingVO>();
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prodID);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bk = new BookingVO();
				
				bk.setEstStart(rs.getDate("est_start"));
				bk.setEstEnd(rs.getDate("est_end"));
				
				list.add(bk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public BookingVO findBookingByPK(Integer bkID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from booking where bk_id = ?" ;
		BookingVO bk = null;
		List<BookingVO> list = new ArrayList<BookingVO>();
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bkID);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bk = new BookingVO();
				bk.setProdID(rs.getInt("prod_id"));
				bk.setBkID(rs.getInt("bk_id"));
				bk.setStatus(rs.getInt("status"));
				bk.setEstStart(rs.getDate("est_start"));
				bk.setEstEnd(rs.getDate("est_end"));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return bk;
	}
	
	
	

	@Override
	public List<BookingVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "select * from booking";
		BookingVO bk = null;
		List<BookingVO> list = new ArrayList<BookingVO>();
		
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				bk  = new BookingVO();
				bk.setBkID(rs.getInt("bk_id"));
				bk.setProdID(rs.getInt("prod_id"));
				bk.setStatus(rs.getInt("status"));
				bk.setEstStart(rs.getDate("est_start"));
				bk.setEstEnd(rs.getDate("est_end"));
				list.add(bk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return list;
	}

}
