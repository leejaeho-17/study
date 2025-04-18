package climb.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import shop2.data.ShopRepleDto;

public class ClimbRepleDao {
	MysqlConnect db = new MysqlConnect();
	
	public void insertRelpe(ClimbRepleDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into climbreple values (null,?,?,?,now())";
		
		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			pstmt.setInt(2, dto.getStar());
			pstmt.setString(3, dto.getMessage());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteReple(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from climbreple where idx = ?";
		
		conn = db.getNaverConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 5개
			pstmt.setInt(1, idx);
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public List<ClimbRepleDto> getRepleByNum(int num) {
		
		List<ClimbRepleDto> list = new Vector<ClimbRepleDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from climbreple where num = ? order by idx desc";
		
		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClimbRepleDto dto = new ClimbRepleDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setStar(rs.getInt("star"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
}
