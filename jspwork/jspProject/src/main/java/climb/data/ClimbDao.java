package climb.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import shop2.data.Shop2Dto;

public class ClimbDao {
	MysqlConnect db = new MysqlConnect();
	
public void insertClimb(ClimbDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into climb (cname,cprice,cphoto,cday,curl,writeday) values (?,?,?,?,?,now())";
		
		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCname());
			pstmt.setInt(2, dto.getCprice());
			pstmt.setString(3, dto.getCphoto());
			pstmt.setString(4, dto.getCday());
			pstmt.setString(5, dto.getCurl());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public ClimbDto getClimb(int num) {
		ClimbDto dto = new ClimbDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from climb where num = ?";
		
		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setCname(rs.getString("cname"));
				dto.setCprice(rs.getInt("cprice"));
				dto.setCphoto(rs.getString("cphoto"));
				dto.setCday(rs.getString("cday"));
				dto.setCurl(rs.getString("curl"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		return dto;
	}
	
	public void updateClimb(ClimbDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="""
				update climb set cname=?,cprice=?,cphoto=?,cday=?,curl=?
				where num=?	
				""";
		conn=db.getNaverConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getCname());
			pstmt.setInt(2, dto.getCprice());
			pstmt.setString(3, dto.getCphoto());
			pstmt.setString(4, dto.getCday());
			pstmt.setString(5, dto.getCurl());
			pstmt.setInt(6, dto.getNum());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteClimb (int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from climb where num = ?";
		
		conn = db.getNaverConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 5개
			pstmt.setInt(1, num);
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public List<ClimbDto> getAllClimb() {
		List<ClimbDto> list = new Vector<ClimbDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from climb order by num";
		
		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClimbDto dto = new ClimbDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setCname(rs.getString("cname"));
				dto.setCprice(rs.getInt("cprice"));
				dto.setCphoto(rs.getString("cphoto"));
				dto.setCday(rs.getString("cday"));
				dto.setCurl(rs.getString("curl"));
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
