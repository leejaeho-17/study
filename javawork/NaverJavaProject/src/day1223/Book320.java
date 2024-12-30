package day1223;

//class Vehicle{
//	public void run() {
//		System.out.println("차량이 달립니다");
//	}
//}
//abstract class Vehicle 클래스에는 일반 메소드도 올 수 있꼬 추상메소드도  올 수 있ㄷㅏ
//{
//	public abstract void run();
//}

interface Vehicle
{
	public void	run(); 
}
class Bus implements Vehicle {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("버스가 달립니다");
	}
}

class Taxi implements Vehicle {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다");
	}
}

class Driver
{
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
/**
 * 
 */
public class Book320 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver=new Driver();
		
		Bus bus=new Bus();
		driver.drive(bus);
		System.out.println();
		Taxi taxi=new Taxi();
		driver.drive(taxi);
		
	}

}
