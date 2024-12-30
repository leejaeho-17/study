package day1220;

import java.security.PublicKey;
import java.util.List;

/*
 * interface 는 음식점의 메뉴판과 같다
 * 실체가 없이 메뉴목록만 있기 때문이다
 * 실제로 주문을 해야 음식이 만들어지는것처럼
 * 구현을 해야함ㄴ 기능을 구현할 수 있다
 * 
 * 인터페이스에는 추상메소드와 상수만이 올 수 있다
 * 이때 abstract 나 final 은 생략한다
 */
interface InterA
{
	public void process();		
}

//InterA 를 구현하는 클래스
class SubInter implements InterA
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Sub 클래스의 process");
	}
	
}

public class Ex9Interface {
	public static void process(InterA inter) {
		inter.process();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA inter=new SubInter();//InterA로 선언 inter=InterA의 값을 출력하기 위한 인자 new subInter() 서브인터에 있는 값을 inter에 넣음
		inter.process();
		
		//메소드 호출
		process(new SubInter());//process 는 누구나 접근 가능한 static 이기때문에 그냥 process만 해도 메소드 호출 가능
		
	}

}
