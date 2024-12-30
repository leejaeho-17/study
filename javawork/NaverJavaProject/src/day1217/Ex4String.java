package day1217;

public class Ex4String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str1;
		str1= new String[4];
		str1[0]="Hello";
		str1[3]="Kitty";
		for(int i=0;i<str1.length;i++)
		   System.out.println("str1["+i+"]="+str1[i]);
		
		System.out.println("=".repeat(30));
		String []str2;
		str2= new String[] {"초록색","분홍색"};
		for(String s:str2)
			System.out.println(s);
		System.out.println("=".repeat(30));
		
		String []str3= {"김미","안지","홍길동",};
		str1= new String[4];
		for(int i=0;i<str3.length;i++)
			   System.out.println("str3["+i+"]="+str3[i]);
//		for(String s:str3)
//			System.out.println(s);
		
		
		
	}

}
