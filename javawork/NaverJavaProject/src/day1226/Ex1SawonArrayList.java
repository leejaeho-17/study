package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1SawonArrayList {
	List<Sawon> sawonlist=new ArrayList<Sawon>();
	static final String SAWONFILE="/Users/jaeho/Desktop/naver1210/mysawon.txt";
	public Ex1SawonArrayList()
	{
		//생성 시 파일 불러오기
		this.sawonFileRead();
	}

	//파일에서 읽어서 sawonlist 에 넣기
	public void sawonFileRead() 
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(SAWONFILE);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String sawonInfo=br.readLine();
				if(sawonInfo==null)
					break;
				
				String []s=sawonInfo.split("\\|");
				Sawon sawon=new Sawon();
				sawon.setSawonName(s[0]);
				sawon.setAge(Integer.parseInt(s[1]));
				sawon.setHp(s[2]);
				sawon.setAddress(s[3]);
				
				//List에 추가
				sawonlist.add(sawon);
			}
			System.out.println("총 "+sawonlist.size()+"명 읽음");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 사원 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}

	//파일 저장
	public void sawonFileSave() 
	{
		//사원리스트의 정보를 파일에 저장하자
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(SAWONFILE);
			
			for(Sawon sawon:sawonlist)
			{
				String s=sawon.getSawonName()+"|"+sawon.getAge()+"|"+sawon.getHp()+"|"+sawon.getAddress()+"\n";
				//파일에 추가
				fw.write(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	
	//사원 추가
	public void addSawon(Sawon sawon) 
	{	
		//list 에 추가
		sawonlist.add(sawon);
		System.out.println(sawon.getSawonName()+" 님의 정보를  추가했어요");
	}

	//이름 입력 시 인덱스 반환
	public int getSearchName(String name) 
	{
		int idx=-1;
		for(int i=0;i<sawonlist.size();i++)
		{
			Sawon sawon=sawonlist.get(i);
			if(sawon.getSawonName().equals(name))
			{
				idx=i;
				break;
			}
		}
		return idx;
	}

	//사원삭제
	public void deleteSawon(String name) 
	{
		int idx=this.getSearchName(name);
		if(idx==-1)
			System.out.println(name+" 사원은 존재하지 않습니다");
		else
		{
			System.out.println(name+"사원의 정보를 삭제하겠습니다");
			sawonlist.remove(idx);
		}
	}

	//사원검색
	public void searchName(String name) 
	{
		/*
		 * 없을 경우 "이영자님은 사원 명단에 없습니다"
		 * 있을 경우 (예)
		 *    ** 이영자님의 개인정보 **
		 *    나이 : 22세
		 *    핸드폰 : 010-2222-3333
		 *    주 소 : 제주도
		 */
		int idx=this.getSearchName(name);
		if(idx==-1)
			System.out.println(name+" 님은 사원 명단에 없습니다");
		else
		{
			System.out.println("\t\t** "+name+" 님의 개인정보 **");
			Sawon sawon=sawonlist.get(idx);//인덱스 번지에 해당하는 사원정보를 얻는다
			System.out.println("나이 : "+sawon.getAge()+"세");
			System.out.println("핸드폰 : "+sawon.getHp());
			System.out.println("주소 : "+sawon.getAddress());
		}
	}

	//사원목록 출력
	public void writeSawonList() 
	{
		System.out.println("\t\t[전체 사원 정보]\n");
		System.out.println("번호\t사원명\t나이\t핸드폰\t\t주소");
		System.out.println("=".repeat(60));
		
		int n=0;
		for(Sawon s:sawonlist)
		{
			System.out.println(++n+"\t"+s.getSawonName()+"\t"+s.getAge()+"세\t"+s.getHp()+"\t"+s.getAddress());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1SawonArrayList ex1=new Ex1SawonArrayList();
		Scanner sc=new Scanner(System.in);
		int menu=0;

		while(true){
			System.out.println("*** 사원 관리 메뉴 ***");
			System.out.println("1. 사원정보추가");
			System.out.println("2. 사원정보검색");
			System.out.println("3. 사원삭제");
			System.out.println("4. 전체사원출력");
			System.out.println("5. 저장 후 종료");
			System.out.print("번호를 선택하세요");

			try {
				menu=Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				menu=4;
			}

			switch(menu)
			{
			case 1->{
				//사원추가
				System.out.println("사원명은 ?");
				String name=sc.nextLine();
				System.out.println("나이는 ?");
				int age=Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰은 ?");
				String hp=sc.nextLine();
				System.out.println("주소는 ?");
				String addr=sc.nextLine();
				
				//사원객체 생성
				Sawon sawon=new Sawon(name, age, hp, addr);
				//메소드 호출
				ex1.addSawon(sawon);
			}
			case 2->{
				System.out.println("검색할 사원의 이름을 입력하세요");
				String name=sc.nextLine();
				ex1.searchName(name);
			}
			case 3->{
				System.out.println("삭제할 사원의 이름을 입력하세요");
				String name=sc.nextLine();
				ex1.deleteSawon(name);
			}
			case 4->{
				ex1.writeSawonList();
			}
			default->{
				ex1.sawonFileSave();
				System.out.println("사원정보를 파일에 저장 후 종료합니다");
				System.exit(0);
			}
			}
			System.out.println("-".repeat(40));
		}

	}

}
