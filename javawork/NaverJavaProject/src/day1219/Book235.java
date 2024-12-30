package day1219;

public class Book235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator myCals=new calculator();//객체생성
		
		myCals.powerOn();//메소드 호출
		
		//plus 메소드 호출 시 5,6을 매개값으로 제공하고, 
		//덧셈 결과를 리턴받아 result1 변수에 대입
		int result1=myCals.plus(5, 6);
		System.out.println("result1="+result1);
		
		int x=10;
		int y=4;
		//divide() 메소드 호출 시 변수 x,y를 매개값으로 제공하고,
		//나눗셈 결과를 리턴받아 result2 변수에 대입
		double result2=myCals.divide(x, y);
		System.out.println("result2="+result2);
		//리턴값이 없는 메소드 호출
		myCals.powerOff();

	}

}
