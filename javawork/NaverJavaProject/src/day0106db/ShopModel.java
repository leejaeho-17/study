package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import oracle.jdbc.proxy.annotation.Pre;

//db 를 처리하기 위한 클래스
public class ShopModel {

	MysqlConnect connect=new MysqlConnect();

	//전체 데이터 반환하는 메소드
	//list 안에 vector 형태로 넣어서 반환
	public List<Vector<String>> getAllDatas()
	{
		List<Vector<String>> list=new Vector<Vector<String>>();
		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from shop order by idx desc";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("sangpum"));
				data.add(rs.getString("su"));
				data.add(rs.getString("danga"));
				data.add(rs.getString("ipgoday"));

				int total=rs.getInt("su")*rs.getInt("danga");
				data.add(String.valueOf(total));
				data.add(rs.getString("ipgoday").substring(0,10));

				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	// insert
	public void insertShop(ShopDto dto)
	{
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into shop (sangpum, su, danga, ipgoday) values (?,?,?,now())";

		try {
			pstmt = conn.prepareStatement(sql);

			// 바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setInt(2, dto.getSu());
			pstmt.setInt(3, dto.getDanga());

			// 실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//delete
	public void deleteShop(int idx) {

		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from shop where idx=?";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}
	}

	//update
	public void updateShop(int idx,String sangpum,int danga)
	{
		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		String sql="update shop set sangpum=?,danga=? where idx=?";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, danga);
			pstmt.setInt(3, idx);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}

	}
	
	//search
	public List<Vector<String>> getSearchData(String searchWord)
	{
		List<Vector<String>> list=new Vector<Vector<String>>();
		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from shop where sangpum like ? order by idx";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+searchWord+"%");
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("sangpum"));
				data.add(rs.getString("su"));
				data.add(rs.getString("danga"));
				data.add(rs.getString("ipgoday"));

				int total=rs.getInt("su")*rs.getInt("danga");
				data.add(String.valueOf(total));
				data.add(rs.getString("ipgoday").substring(0,10));

				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return list;
	}

}

