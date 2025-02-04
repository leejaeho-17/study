package shop2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class Shop2Dao {
	MysqlConnect db = new MysqlConnect();
	
	public void insertShop(Shop2Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into shop (sangpum,scolor,scnt,sprice,sphoto,ipgoday,writeday) values (?,?,?,?,?,?,now())";
		
		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getScolor());
			pstmt.setInt(3, dto.getScnt());
			pstmt.setInt(4, dto.getSprice());
			pstmt.setString(5, dto.getSphoto());
			pstmt.setString(6, dto.getIpgoday());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//order :1.등록순, 2.높은가격순, 3.낮은가격순, 4.상품명순
	public List<Shop2Dto> getAllSangpums(int order) {
		
		List<Shop2Dto> list = new Vector<Shop2Dto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		if(order == 1)
			sql = "select * from shop order by num";
		else if(order == 2)
			sql = "select * from shop order by sprice desc";
		else if(order == 3)
			sql = "select * from shop order by sprice asc";
		else if(order == 4)
			sql = "select * from shop order by sangpum asc";

		conn = db.getNaverConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Shop2Dto dto = new Shop2Dto();
				
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setScolor(rs.getString("scolor"));
				dto.setScnt(rs.getInt("scnt"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setIpgoday(rs.getString("ipgoday"));
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