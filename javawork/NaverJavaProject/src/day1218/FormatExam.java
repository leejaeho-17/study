package day1218;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date);;//Wed Dec 18 15:54:02 KST 2024

		//내가 원하는 포멧양식으로 출력해보자
		//M:월, m:분, H:24시간, h:12시간, E:요일, a:오전/오후
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy년MM월dd일 HH:mm EEE");
		SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");

		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));

		int num1=45678900;
		int num2=34567;

		NumberFormat nf1=NumberFormat.getInstance();
		System.out.println("num1="+nf1.format(num1));
		System.out.println("num2="+nf1.format(num2));

		System.out.println("₩"+nf1.format(num1));
		System.out.println("$"+nf1.format(num2));
		// 		글꼴 때문에 오류가 남(맥은 안난다)
		//		NumberFormat nf2=NumberFormat.getCurrencyInstance();
		//		System.out.println("num1="+nf2.format(num1));
		//		System.out.println("num1="+nf2.format(num2));	
	}



}
