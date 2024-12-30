package day1220;
/*
 * command 라는 인터페이스에 process() 추상메소드를 추가하고
 * 
 * 인터페이스 command 를 구현하는 List(출력),Insert(추가),Delete(삭제),Update(수정) 클래스를 구현하시오
 * 
 * 메인에서 while 문을 통해 다음과 같이 메뉴가 나오면
 * 1.추가 2.출력 3.삭제 4.수정 5.종료
 * 
 * 1번을 누르면 데이터가 추가되었습니다
 * 2번을 누르면 데이터를 출력합니다
 * 3번을 누르면 데이터가 삭제되었습니다
 * 4번을 누르면 데이터가 수정되었습니다
 * 5번을 누르면 프로그램을 종료합니다 -> 실제 종료
 * 
 * 호출하는 메소드는 
 * public static void dbProcess(Command comm)
 * {
 * 		comm.process(); //이부분이 다형성 처리가 되도록
 * }
 */

import java.util.Scanner;

interface Command
{
	public void process(); 
	public void List(); 
	public void Insert(); 
	public void Delete(); 
	public void Update(); 
}

class DB implements Command
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 출력합니다");

	}

	@Override
	public void List() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 추가되었습니다");
	}

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 출력합니다");
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 삭제되었습니다");
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 수정되었습니다");
	}

}
public class Ex11InterfaceMunje {
	public static void dbProcess(Command comm) 
	{

		comm.process();//다형성 처리
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Command Comm=new DB();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.추가\t2.출력\t3.삭제\t4.수정\t5.종료");
		System.out.println("=".repeat(50));
		System.out.print("숫자를 입력하세요(종료:5):");
		
		
		//		while(num<=5) 
		//		{
		//			switch(num)
		//			{
		//			case 1->Comm.List();
		//			case 2->Comm.Insert();
		//			case 3->Comm.Delete();
		//			case 4->Comm.Update();
		//			case 5->Comm.process();
		//			};return;
		//
		//		}
		boolean check = true;
		
		while(check) 
		{
			num=sc.nextInt();
			if(num==5)
				check = false;
				//break;
			if(num==1)
				Comm.List();
			else if(num==2)
				Comm.Insert();
			else if(num==3)
				Comm.Delete();
			else if(num==4)
				Comm.Update();
		}
		System.out.println("프로그램을 종료합니다");
	}

}
