package day1219;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCar {
	private String carName;
	private String guipDay;
	private int carPrice;
	private String carColor;

	public MyCar() {
		// TODO Auto-generated constructor stub
		//생성되는 시간을 guipDay 구해서 넣어보자
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		guipDay=sdf.format(new Date());

		carColor="흰색";

	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getGuipDay() {
		return guipDay;
	}

	public void setGuipDay(String guipDay) {
		this.guipDay = guipDay;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public MyCar(String carName, int carPrice, String carColor) {
		//생성되는 시간을 guipDay 구해서 넣어보자
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		guipDay=sdf.format(new Date());

		this.carName = carName;
		this.carPrice = carPrice;
		this.carColor = carColor;
	}

	@Override
	public String toString() {
		return "MyCar [carName=" + carName + ", carPrice=" + carPrice +", carColor=" + carColor + ", guipDay=" + guipDay + "]";
	}



	

}
