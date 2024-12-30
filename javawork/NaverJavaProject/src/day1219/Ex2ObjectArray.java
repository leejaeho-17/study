package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {

	public static void dataInput(Student s)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("학생 이름은? ");
		String name=sc.nextLine();
		System.out.println("학생 주소는? ");
		String addr=sc.nextLine();
		System.out.println("학생 혈액형은? ");
		String blood=sc.nextLine();

		s.changeStudent(name, addr, blood);
		System.out.println();
	}

	public static void showTitle()
	{
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(30));
	}
	public static void writeStudent(Student s)
	{
		System.out.println(s.getStuName()+"\t"+s.getStuBlood().toUpperCase()+"형\t"+s.getStuAddress());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int inwon;
		Student []stuArrays;

		System.out.println("입력할 인원수는? ");
		inwon=Integer.parseInt(sc.nextLine());
		//메모리 할당
		stuArrays=new Student[inwon];

		//데이터 입력
		for(int i=0;i<stuArrays.length;i++)
		{
			stuArrays[i]=new Student();//생성
			dataInput(stuArrays[i]);
		}
		//제목출력
		showTitle();
		//내용출력
		for(int i=0;i<stuArrays.length;i++)
			writeStudent(stuArrays[i]);
	}

}
