package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문자열 str 을 입력후 엔터를 누르면
		 * 문자열을 분석해서 대문자,소문자,숫자 각각의 갯수를 구해서
		 * 출력하시오
		 * 사용할 문자메소드 : length(),charAt(인덱스)
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		
		String str1;
		int upper=0,lower=0,num=0;
		System.out.println("문자열을 입력하세요");
		str1=sc.nextLine();
		for(int i=0;i<str1.length();i++)
		{
			char ch=str1.charAt(i);
			if(ch>='A' && ch<='Z')
				upper++;
			else if(ch>='a' && ch<='z')
				lower++;
			else if(ch>='0' && ch<='9')
				num++;
		}
			
		System.out.println("문자열의 대문자 갯수 : "+upper);
		System.out.println("문자열의 소문자 갯수 : "+lower);
		System.out.println("문자열의 숫자 갯수 : "+num);		
	}

}
