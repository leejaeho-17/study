package day1218;

class Car1
{
	String company="현대자동차";
	String model="그랜저";
	String color="검정";
	int maxSpeed=350;
	int speed;
}
public class Book219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car1 myCar=new Car1();
		
		System.out.println("제작회사 : "+myCar.company);
		System.out.println("모델명 : "+myCar.model);
		System.out.println("색깔 : "+myCar.color);
		System.out.println("최고속도 : "+myCar.maxSpeed);
		System.out.println("현재속도 : "+myCar.speed);
		
		myCar.speed=60;
		System.out.println("수정된 속도: "+myCar.speed);

	}

}
