package day1217;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []datas= {12,34,23,45,56,67,13,43};
		System.out.println("인원수:"+datas.length);
		/*
		 * 위의 데이터를 분석하여 10대부터 40대까지 각각의 인원수를 구하시오
		 * 배열변수 []age 를 이용해서 구하시오
		 * 0번지에는 10대 인원수....
		 * 
		 * 출력양식
		 * 10대 : 1명
		 * 20대 : 3명
		 * .
		 * .
		 */
		int []age=new int[7];
		for(int i=0;i<datas.length;i++)
		{
			//연령 별 인원수 구하기
			//10대 일경우 0번지 증가, 20대일 경우 1번지 증가
			age[datas[i]/10-1]++;
		}
		for(int i=0;i<age.length;i++)
		{
			System.out.println((i+1)*10+"대:"+age[i]+"명");
		}
	}

}
