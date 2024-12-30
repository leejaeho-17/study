package day1219;

public class Sawon {

	/*
	 * 멤버 변수 사원명 sawonName, 직급 position, 가족수 famSu
	 */
	private String sawonName;
	private String position;
	private int famSu;
	/*
	 * 디폴트 생성자
	 * 
	 * 사원명, 직급, 가족수 를 인자로 받는 생성자
	 */
	public Sawon() {
		super();
	}
	public Sawon(String sawonName, String position, int famSu) {
		super();
		this.sawonName = sawonName;
		this.position = position;
		this.famSu = famSu;
	}
	/* setter & getter method */
	public String getSawonName() {
		return sawonName;
	}
	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getFamSu() {
		return famSu;
	}
	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	/*
	 * 직급에 따라 기본급을 gibonPay 를 구하는데 부장 ->450, 과장 ->300, 대리 ->250, 사원 ->150
	 * getGibonPay()
	 */
	public int getgibonPay() {
		int gibon=switch(position){
		case "부장"->4500000;
		case "과장"->3000000;
		case "대리"->2500000;
		case "사원"->1500000;
		default->0;

		};
		return gibon;
		//		switch(position)
		//		{
		//		case "부장":
		//			return 450;
		//		case "과장":
		//			return 300;
		//		case "대리":
		//			return 250;
		//		case "사원":
		//			return 150;
		//		default:
		//			System.out.println("일치하는 직급이 없습니다.");
		//		}return getgibonPay();
	}
	/*
	 * 직급에 따라 수 수당을 구하는데 부장,과장 ->70, 대리,사원 ->50
	 * getSudang()
	 */
	public int getsudang() {
		int sudang=switch(position) {
		case "부장","과장"->700000;
		case "대리","사원"->500000;
		default->0;
		};
		return sudang;
		//		switch(position)
		//		{
		//		case "부장","과장":
		//			return 70;
		//		case "대리","사원":
		//			return 50;
		//		default:
		//			System.out.println("일치하는 직급이 없습니다.");
		//		}return getsudang();
	}
	/*
	 * getGibonPay() 값을 반환 받아서 세금 5프로를 구해서 반환하는
	 * getTax()
	 */
	public int getTax() 
	{
		int tax=getgibonPay()*5/100;
		return tax;
	}
	/*
	 * 가족수가 5인 이상이면 30 반환, 5인 미만 2인 이상은 10반환, 나머지는 0
	 * getFamSudang()
	 */
	public int getFamSudang()
	{
		int famSudang=0;

		if(famSu>=5) famSudang=300000;
		else if(famSu>=2) famSudang=100000;	
		else famSudang=0;

		return famSudang;
	}
	/*
	 * 실수령액을 구해서 반환하는 메소드 기보급+수당-세금+가족수당을 구해서 반환
	 * getNetPay()
	 */
	public int getNetPay()
	{
		return getgibonPay()+getsudang()-getTax()+getFamSudang();
	}
}
