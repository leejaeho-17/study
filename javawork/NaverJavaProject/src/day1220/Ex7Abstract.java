package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성 처리 예
		List<String> list=null;
		list=new Vector<String>();
		list.add("red");//add 라는 메소드는 오버라이드 메소드
		list.add("green");
		for(String s:list)
			System.out.println(s);
		
		//현재 할당된 크기를 알아보는 capacity() 이 메소드는
		//Vector 만이 가지고 있다
		int n=((Vector<String>)list).capacity();//다운캐스팅((작은 거)더 큰 거).~~~(); - 자식에 있는 값 불러오기
		System.out.println(n);

	}

}
