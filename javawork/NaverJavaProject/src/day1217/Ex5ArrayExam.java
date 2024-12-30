package day1217;

public class Ex5ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {23,134,123,5,123,51,-321,5,5,11,501,-1203};
		int max=data[0];//일단은 첫 데이터를 최대값을 지정한다.
		int min=data[0];
		//1번지부터 끝까지 비교해서 max보다 더 큰값이 나오면 그 값을 max에 저장
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i]) 
			{
				max=data[i];
			}
			
			if(min>data[i])
			{
				min=data[i];
			}
		}
		System.out.println("max="+max);
		System.out.println("min="+min);	
	}

}
