package day1220;
class SuperObj2
{
	private String schoolName;
	
	public SuperObj2()
	{
		schoolName="청담고등학교";
	}
	
	SuperObj2(String schoolName)
	{
		this.schoolName=schoolName;
	}
	
	public void write()
	{
		System.out.println("학교명 : "+schoolName);
	}
}

class subObj2 extends SuperObj2
{
	private String studentName;
	
	public subObj2()
	{
		studentName="이름없음";
	}
	
	subObj2(String schoolName,String studentName)
	{
		super(schoolName);
		this.studentName=studentName;
	}
	
	@Override//부모의 메소드를 재정의 했다는 의미
	public void write() {
		super.write();//부모가 처리한 로직 실행 - 호출 위치는 상관없음
		System.out.println("학생 이름 :"+studentName);
	}
}

class subObj22 extends SuperObj2
{
	private String teacherName;
	
	public subObj22()
	{
		teacherName="이름없음";
	}
	
	subObj22(String schoolName, String teacherName)
	{
		super(schoolName);
		this.teacherName=teacherName;
	}
	
	public void write() {
		System.out.println("선생님이름 :"+teacherName);
		super.write();
	}
}
/////////////////////////////////////////
public class Ex2Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subObj2 s1=new subObj2();
		subObj2 s2=new subObj2("강남고등학교","홍길동");
		subObj22 s11=new subObj22();
		subObj22 s22=new subObj22("강남고등학교","이재호");
		
		s1.write();
		System.out.println();
		s2.write();
		System.out.println();
		s11.write();
		System.out.println();
		s22.write();

	}

}
