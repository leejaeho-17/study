package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.MysqlConnection;

import db.connect.MysqlConnect;

public class Ex1ShopMysql {
	MysqlConnect mysqlConnect=new MysqlConnect();

	//Shop 에 상품 추가
	public void insertShop(String sangpum,int su,int danga) {
		System.out.println("상품을 추가합니다");

		Connection conn=null;
		PreparedStatement pstmt=null;

		String sql="insert into shop (sangpum,su,danga,ipgoday) values (?,?,?,now())";
		//db 연결
		conn=mysqlConnect.getConnection();

		try {
			pstmt=conn.prepareStatement(sql);//이때 sql 문을 검사한다
			//? 갯수만큼 데이터를 넣어준다(바인딩 이라고 한다)
			//첫번째 물음표부터 1번,2번 ...
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, danga);

			//바인딩을 모두 마친후 실행을 하는데 이때 sql문을 보내면 안됨, 그냥 실행만
			pstmt.execute();
			System.out.println("상품추가를 하였습니다");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	//전체 shop 데이터 출력
	public void writeShop() {
		System.out.println("전체 상품을 출력합니다");
		System.out.println("인덱스\t상품명\t수량\t단가\t총금액");
		System.out.println("=".repeat(60));


		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from shop order by idx";
		conn=mysqlConnect.getConnection();

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();//ResultSet 을 반환하는 실행문

			while(rs.next())
			{
				int su=rs.getInt("su");
				int dan=rs.getInt("danga");
				int total=su*dan;

				System.out.println(rs.getInt("idx")+"\t"+rs.getString("sangpum")
				+"\t"+su+"\t"+dan+"\t"+total+"\t"+rs.getString("ipgoday").substring(0,16));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}

	}

	//shop 데이터 삭제
	public void deleteShop(String sangpum) {
		System.out.println("상품을 삭제합니다");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from shop where sangpum=?";
		
		conn=mysqlConnect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sangpum);
			//실행 - int 반환 값을 받는 실행문
			int n=pstmt.executeUpdate();
			if(n==0)
				System.out.println("["+sangpum+"] 제품은 존재하지 않습니다");
			else
				System.out.println("총"+n+"개의 ["+sangpum+"] 상품을 삭제했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	//상품조회
	public void searchSangpum(String sangpum) {
		System.out.println("["+sangpum+"] 상품을 조회합니다");
		System.out.println("인덱스\t상품명\t수량\t단가\t총금액");
		System.out.println("=".repeat(60));


		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from shop where sangpum like ? order by idx";

		conn=mysqlConnect.getConnection();

		try {
			pstmt=conn.prepareStatement(sql);
			//? 자리에 바인딩
			pstmt.setString(1, "%"+sangpum+"%");
			rs=pstmt.executeQuery();//ResultSet 을 반환하는 실행문
			int count=0;
			while(rs.next())
			{
				count++;
				int su=rs.getInt("su");
				int dan=rs.getInt("danga");
				int total=su*dan;

				System.out.println(rs.getInt("idx")+"\t"+rs.getString("sangpum")
				+"\t"+su+"\t"+dan+"\t"+total+"\t"+rs.getString("ipgoday").substring(0,16));
			}
			
			if(count==0)
				System.out.println("["+sangpum+"] 관련 제품이 없습니다" );
			else
				System.out.println("["+sangpum+"] 관련 제품이 총"+count+"개 있습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}

	}

	//상품수정
	public void updateShop(int idx,int su,int danga) {
		System.out.println("상품을 수정합니다");
		//idx 에 해당하는 su,danga 수정
		//excuteUpdate 로 int 타입 반환값을 받아서
		//0 이면 해당상품이 없습니다
		//0 이 아니면 해당 상품 정보를 수정했습니다
		Connection conn=null;	
		PreparedStatement pstmt=null;
		String sql="update shop set su=?,danga=? where idx=?";

		conn=mysqlConnect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, su);
			pstmt.setInt(2, danga);
			pstmt.setInt(3, idx);
			//실행
			int n=pstmt.executeUpdate();
			if(n==0)
				System.out.println("해당 상품이 없습니다");
			else
				System.out.println("해당 상품 정보를 수정했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Ex1ShopMysql ex=new Ex1ShopMysql();
		while(true)
		{
			System.out.println("\t** 상품관리 메뉴 **\n");
			System.out.println("1.상품추가 2.전체출력 3.상품조회 4.상품삭제  5.상품수정 6.종료");
			System.out.println("번호 선택(1-6) : ");
			int menu=Integer.parseInt(sc.nextLine());

			switch(menu)
			{
			case 1->{
				System.out.println("상품명을 입력하세요");
				String sang=sc.nextLine();
				System.out.println("수량을 입력하세요");
				int su=Integer.parseInt(sc.nextLine());
				System.out.println("단가를 입력하세요");	
				int dan=Integer.parseInt(sc.nextLine());

				ex.insertShop(sang, su, dan);
			}
			case 2->{
				ex.writeShop();
			}
			case 3->{
				System.out.println("검색할 상품명을 입력하세요");
				String sangpum=sc.nextLine();
				ex.searchSangpum(sangpum);
			}
			case 4->{
				System.out.println("삭제할 상품명을 입력하세요");
				String sangpum=sc.nextLine();
				ex.deleteShop(sangpum);
			}
			case 5->{
				//idx,su,danga 입력
				System.out.println("수정할 상품번호를 입력하세요");
				int idx=Integer.parseInt(sc.nextLine());
				System.out.println("수정할 갯수를 입력하세요");
				int su=Integer.parseInt(sc.nextLine());
				System.out.println("수정할 단가를 입력하세요");
				int dan=Integer.parseInt(sc.nextLine());
				ex.updateShop(idx, su, dan);
			}

			default->{
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
			}
		}
	}

}
