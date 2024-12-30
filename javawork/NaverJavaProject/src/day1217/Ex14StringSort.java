package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"박남정","공효진","김미나","이진","손석구","adams"};
		//이름의 오름차순으로 출력
		for(int i=0;i<names.length-1;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				//if(names[i].compareTo(names[j])>0)//문자열의 오름차순 : 아스키코드의 번호를 뺀 값이 양수일 때 자리를 바꾼다
				if(names[i].compareTo(names[j])<0)//문자열의 내림차순
				{
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}
		for(int i=0;i<names.length;i++)
		{
			System.out.println(i+":"+names[i]);
		}

	}

}
