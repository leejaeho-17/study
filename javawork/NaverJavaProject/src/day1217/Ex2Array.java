package day1217;

public class Ex2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch;//선언
		
		ch=new char[4];//0~3번 인덱스까지 넣을 수 있음.
		System.out.println("배열크기:"+ch.length);
		//배열에 데이터 넣기
		
		ch[0]='h';
		ch[1]=65;
		ch[2]='x';
		ch[3]='t';
		
		//출력 #1
		for(int i=0;i<ch.length;i++)
			System.out.println("ch["+i+"]="+ch[i]);
		System.out.println();
		//출력 #2
		for(char a:ch)
			System.out.println(a);
		
		
		System.out.println("=".repeat(50));
		char []ch2=new char[5];
		ch2= new char[]{'a','n','x','y','u'};
		for(int i=0;i<ch2.length;i++)
		{
			System.out.println("ch2["+i+"]="+ch2[i]);
			
		}
		System.out.println("=".repeat(50));
		char []ch3=new char[5];
		ch3= new char[]{'s','d','a','n','z'};
		for(char a:ch3)
			System.out.println(a);

	}

}
