package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {

	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";

	public Ex3OracleJoin() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패"+e.getMessage());
		}
	} 
	
	String url="jdbc:oracle:thin:@localhost:1521/xe";
	String username="angel";
	String password="pw1234";
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("오라클 접속 실패:"+e.getMessage());
		}
		return conn;	
	}
	
	public void shopWriteData() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select \n"
				+ "    s.sangcode,sangname,sangprice,cntnum,to_char(cartday,'yyyy-mm-dd') cartday\n"
				+ "from shop s,cart c\n"
				+ "where s.sangcode=c.sangcode";
		
		conn=this.getConnection();
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("상품코드\t상품이름\t상품가격\t상품갯수\t상품날짜");
			System.out.println("=".repeat(50));
			while(rs.next())
			{
				String code=rs.getString(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				int num=rs.getInt(4);
				String day=rs.getString(5);
				
				System.out.println(code+"\t"+name+"\t"+price+"\t"+num+"\t"+day);
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류:"+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3OracleJoin ex3=new Ex3OracleJoin();
		ex3.shopWriteData();
	}

}
