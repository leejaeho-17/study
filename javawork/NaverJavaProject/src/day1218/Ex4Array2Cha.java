package day1218;

public class Ex4Array2Cha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2차원 배열에 선언시 초기값 지정	
		int [][]arr1= {
				{67,89,90},
				{100,13,41},
				{57,12,53,61}
		};
		System.out.println("행갯수 : "+arr1.length);
		System.out.println("0번행의 열갯수 : "+arr1[0].length);
		System.out.println("1번행의 열갯수 : "+arr1[1].length);
		System.out.println("2번행의 열갯수 : "+arr1[2].length);
		
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr1[i].length;j++)
			{
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}

	}

}
