package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	//db 에 접근하려면 url 과 id,password 가 필요하다
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="alsxm12@34";

	public Ex2MysqlConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패:"+e.getMessage());
		}
	}

	//db 연결성공부 Connection 을 반환하는 메소드
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("mysql 접속 성공");
		} catch (SQLException e) {
			System.out.println("mysql 접속 실패:"+e.getMessage());
		}
		return conn;
	}

	public void personWriteData()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;

		conn=this.getConnection();
		//방법 1
		//String sql="select name,age,blood,hp,date_format(today,\"%Y-%m-%d %H:%i\") today from person";
		//방법 2 - jdk17 에서 추가된 기능-멀티라인텍스트
		String sql="""
				select name,age,blood,hp,date_format(today,"%Y-%m-%d %H:%i") today from person
				""";

		
	try {
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		System.out.println("이름\t나이\t혈액형\t전화번호\t\t날짜");
		System.out.println("=".repeat(50));
		while(rs.next())
		{
			String name=rs.getNString(1);
			int age=rs.getInt(2);
			String blood=rs.getString(3);
			String hp=rs.getString(4);
			String today=rs.getString(5);
			
			System.out.println(name+"\t"+age+"\t"+blood+"\t"+hp+"\t\t"+today);
		}
	} catch (SQLException e) {
		System.out.println("mysql문 오류:"+e.getMessage());
	} finally {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException|NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2MysqlConnect ex2=new Ex2MysqlConnect();
		ex2.personWriteData();
	}

}
