package day1219;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex12SawonArray {
	/* showTitle: 제목출력Ø
	 * 사원명 직급 기본급 수당 가족수당 세금 실수령액
	 * 
	 */
	public static void showTitle()
	{
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
	}
	/*
	 * writeSawon(Sawon sawon) : 한개의 사원 데이터 출력
	 */
	public static void writeSawon(Sawon sawon)
	{
		NumberFormat nf=NumberFormat.getInstance();

		System.out.println(sawon.getSawonName()+"\t"+sawon.getPosition()+"\t"+nf.format(sawon.getgibonPay())+ 
				"\t"+nf.format(sawon.getsudang())+"\t"+nf.format(sawon.getFamSudang())+
				"\t"+nf.format(sawon.getTax())+"\t"+nf.format(sawon.getNetPay()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inwon;
		Sawon []mySawon;
		Scanner sc=new Scanner(System.in);
		/*
		 * 인원수를 입력 후 인원수 만큼 배열 메모리 할당
		 */
		
		System.out.println("입력할 사원의 수는?");
		inwon=Integer.parseInt(sc.nextLine());

		mySawon=new Sawon[inwon];
		/*배열에 데이터 입력 후 생성자 통해서 데이터 저장하기*/
		
		for(int i = 0; i<inwon; i++)
		{
			System.out.println("사원명은 ?");
			String sawonName=sc.nextLine();
			System.out.println("직급은 ?");
			String pos=sc.nextLine();
			System.out.println("가족수는 ?");
			int famSu=Integer.parseInt(sc.nextLine());

			System.out.println();

			//사원 생성 방법 1
			//			mySawon[i]=new Sawon();
			//			mySawon[i].setSawonName(sawonName);
			//			mySawon[i].setPosition(pos);
			//			mySawon[i].setFamSu(famSu);
			//사원 생성 방법 2
			mySawon[i]=new Sawon(sawonName,pos,famSu);
			
		}
		
		
		for(int j = 0; j < inwon; j++) {
			System.out.println(j+1 + "번째 사원은 " + mySawon[j].getSawonName() + "입니다.");
		}
		
		/*제목 출력*/
		showTitle();

		/*반복문 통해서 데이터 출력하는 메소드 호출*/
		for(Sawon s:mySawon)
			writeSawon(s);
	}

}
