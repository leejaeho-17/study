package day1223;

import javax.management.relation.InvalidRelationTypeException;

interface InterA
{
	public void study(); 
}
//인터페이스끼리의 상속은 extends
interface InterB extends InterA
{
	public void play();
}

//클래스가 인터페이스 구현시 implements
class MyInter implements InterB
{	
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("그룹 스터디를 합니다");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("그룹 모임을 합니다");
	}

	public void job() {
		System.out.println("밀린 일처리를 합니다");
	}
}
public class Ex1InterfaceInheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//상속관계에 따른 호출 메소드 차이를 알아본다.
		InterA interA=new MyInter();
		interA.study();
		//다운캐스팅을 하는 이유는 대부분의 메소드는 오버라이드가 되어있지만, 오버라이드 하지 않은 메소드가 필요할 때 사용한다. 
		//참고 : 코드에 표시된 x 표시를 누르면 일반적으로 다운캐스팅 코드가 자동으로 생성된다
		((MyInter) interA).job(); 
		System.out.println("=".repeat(30));
		InterB interB=new MyInter();
		interB.play();
		interB.study();
		//다운캐스팅으로 job 을 호출
		((MyInter) interB).job();//다운캐스팅 : ((상속된 클래스)상속클래스).호출하고싶은 메소드();
		System.out.println("=".repeat(30));

		MyInter myInter=new MyInter();
		myInter.play();
		myInter.study();
		myInter.job();
		System.out.println("=".repeat(30));

	}

}
