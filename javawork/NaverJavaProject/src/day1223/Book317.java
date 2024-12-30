package day1223;

class Tire {
	public void roll() {
		System.out.println("회전합니다");
	}
}

class HankookTire extends Tire {
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다");
	}
}

class KumhoTire extends Tire {
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호 타이어가 회전합니다");
	}
}

class Car {
	
	public Tire tire;
	
	public void run() {
		tire.roll();
	}
}
public class Book317 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		
		car1.tire=new Tire();
		car1.run();
		System.out.println();
		car1.tire=new HankookTire();
		car1.run();
		System.out.println();
		car1.tire=new KumhoTire();
		car1.run();
		
	}

}
