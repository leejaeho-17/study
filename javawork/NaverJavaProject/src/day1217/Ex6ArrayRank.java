package day1217;

public class Ex6ArrayRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//등수 구하기 - 동점은 동순위 부여
		int []score= {56,89,100,89,67,12,3123,12};
		int []rank=new int[score.length];
		for(int i=0;i<score.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<score.length;j++)
			{
				if(score[i]<score[j])
				rank[i]++;
			}
		}
		System.out.println("번호\t점수\t등수");
		System.out.println("=".repeat(30));
		for(int i=0;i<score.length;i++)
			System.out.println(i+1+"\t"+score[i]+"\t"+rank[i]);
		
		
	}

}