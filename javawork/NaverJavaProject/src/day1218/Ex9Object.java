package day1218;


class Car
{
	static String carCompany="현대";

	private String carName;
	private int carPrice;

	public static void setCarcompany(String carCompany)
	{
		//static 메소드에서는 static 변수만이 접근 가능하다
		Car.carCompany=carCompany;
	}
	//setter method 
	public void setCarName(String carName)
	{
		this.carName=carName;
	}
	public void setCarPrice(int carPrice)
	{
		this.carPrice=carPrice;
	}

	//getter method
	public String getCarName()
	{
		return carName;//this 는 생략 가능
	}
	public int getCarPrice()
	{
		return carPrice;//this 는 생략 가능
	}

	public void setData(String carName,int carPrice)
	{
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}
	//	public void showData()
	//	{
	//		System.out.println("자동차 회사명 : "+carName+",자동차 가격 : "+carPrice);
	//	}
}
public class Ex9Object {

	public static void writeCarInfo(Car mycar)
	{
		System.out.println("자동차명 : "+mycar.getCarName());
		System.out.println("가격 : "+mycar.getCarPrice());
		System.out.println("=".repeat(30));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 자동차회사명:"+Car.carCompany);
		Car.setCarcompany("삼성");
		System.out.println("변경된 자동차 회사명 :"+Car.carCompany);

		Car car1=new Car();
		car1.setCarName("그랜져");
		car1.setCarPrice(3900);

		Car car2=new Car();
		car2.setData("소나타", 3200);

		Car car3=new Car();
		car3.setData("미니", 5000);

		//		System.out.println("car1 자동차명 : "+car1.getCarName());
		//		System.out.println("car1 가격 : "+car1.getCarPrice());
		//		System.out.println("=".repeat(30));
		//		System.out.println("car2 자동차명 : "+car2.getCarName());
		//		System.out.println("car2 가격 : "+car2.getCarPrice());

		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
	}

}
