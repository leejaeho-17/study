package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex4MysqlJoin {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	//db 에 접근하려면 url 과 id,password 가 필요하다
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="alsxm12@34";
	
	public Ex4MysqlJoin() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패:"+e.getMessage());
		}
	}
	
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
	
	public void personBloodGroup()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=this.getConnection();
		//방법 1
		//String sql="select name,age,blood,hp,date_format(today,\"%Y-%m-%d %H:%i\") today from person";
		//방법 2 - jdk17 에서 추가된 기능-멀티라인텍스트
		String sql="""
				select blood,count(*) count,round(avg(age),1) avgage from person 
				group by blood order by count
				""";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("혈액형\t핼액갯수\t나이평균");
			System.out.println("=".repeat(30));
			while(rs.next())
			{
				String blood=rs.getNString(1);
				int count=rs.getInt(2);
				int avgage=rs.getInt(3);

				System.out.println(blood+"\t"+count+"\t"+avgage);
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
		Ex4MysqlJoin ex4=new Ex4MysqlJoin();
		ex4.personBloodGroup();
	}

}
