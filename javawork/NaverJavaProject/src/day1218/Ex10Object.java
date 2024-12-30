package day1218;

import java.text.NumberFormat;

public class Ex10Object {

	public static void showTitle()
	{
		System.out.println("번호\t자동차명\t가격");
		System.out.println("=".repeat(30));
	}
	public static void writeCar(int num,Car myCar)
	{
		NumberFormat nf=NumberFormat.getInstance();
		System.out.println(num+"\t"+myCar.getCarName()+"\t"+nf.format(myCar.getCarPrice())+"만원");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체 배열
		Car []cars=new Car[5];//메모리 할당 시 객체는 무조건 초기값이 null
		//배열 5개의 각 Car 객체는 따로 생성해줘야한다.
		for(int i=0;i<cars.length;i++)
			cars[i]=new Car();

		cars[0].setData("그랜져", 5600);
		cars[1].setData("소나타", 3000);
		cars[2].setData("아반테", 4000);
		cars[3].setData("스포티지", 5000);
		cars[4].setData("모닝", 2300);

		//제목부터 출력
		showTitle();
		//내용출력
		for(int i=0;i<cars.length;i++)
		{
			writeCar(i+1, cars[i]);
		}
		System.out.println();
		//다른방법으로 출력
		int n=0;
		for(Car car:cars)
		{
			writeCar(++n, car);
		}

	}

}
