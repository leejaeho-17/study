package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []numbers=new int[20];
		/*
		 * 배열에 1~50사이의 난수 20개를 구하여 넣고
		 * 오름차순으로 정렬해서 출력을 하시오 
		 */
		Loop:
		for(int i=0;i<numbers.length;i++)
		{
			numbers[i]=(int)(Math.random()*50)+1;
			for(int j=0;j<i;j++)
			{
				if(numbers[i]==numbers[j])
				{
					i--;
					//break;//방법 1
					continue Loop;
				}
			}
			
			//이전에 발생한 값이랑 같을 경우 다시 구하기 - 중복처리로직 추가
		}
		for(int i=0;i<numbers.length;i++)
		{
			for(int j=i+1;j<numbers.length;j++)
			{
				if(numbers[i]>numbers[j])
				{
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		//출력 - 한줄에 5개씩만 출력
		for(int i=0;i<numbers.length;i++)
		{
			System.out.print(+i+":"+numbers[i]+"\t");
			if((i+1)%5==0) 
			{
				System.out.println();	
			}
				
		}
	}

}
