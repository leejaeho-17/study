package day1220;

import day1220_2.DbServerSystem;

class Dataprocess extends DbServerSystem
{
	private String sql;
	
	public Dataprocess() {
		sql="select";
		this.dbServerName="Mysql";//protected 인 경우 직접 접근가능(상속관계인 경우만)
		//this.serverPort=9000;//	오류 : default 멤버 변수는 상속관계라 하더라도 접근불가
	}
	
	public Dataprocess(String dbServerName, int serverPort, String sql)
	{
		super(dbServerName,serverPort);
		this.sql=sql;
	}
	
	public void process() 
	{
		//서브클래스에 오버라이드 메소드가 없는 경우 this 로 호출해도 상속받은 메소드가 호출된다
		//이런경우 this 로 호출해도 되고 super 로 호출해도 된다
		//하지만 오버라이드 메소드가 있는 경우 부모메소드 호출 시 반드시 super 로 호출
		//this.serverStart();
		super.serverStart();
		System.out.println("SQL문 "+sql+"처리함");
		this.serverClose();
		System.out.println();
		
	}
}

public class Ex3Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dataprocess data1=new Dataprocess();
		Dataprocess data2=new Dataprocess("Maria",9020,"java");
		
		data1.process();
		data2.process();
		
	}

}
