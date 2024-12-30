package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import day1219.Student;

public class Ex5TableStudent extends JFrame {
	JTable table;
	static final String FILENAME="/Users/jaeho/Desktop/naver1210/student.txt";
	List<student> list=new ArrayList<student>();
	
	public Ex5TableStudent() {
		super("학생성적관리");
		this.setBounds(300, 100, 400, 400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void studentFileRead() 
	{
		//파일을 읽어서 list 변수에 담기
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			while(true)
			{
				String studentInfo=br.readLine();
				if(studentInfo==null)
					break;
				
				student student=new student();
				String []t=studentInfo.split("\\|");
				student.setName(t[0]);
				student.setKor(Integer.parseInt(t[1]));
				student.setEng(Integer.parseInt(t[2]));
				
				//List에 추가
				list.add(student);
				
			}
			System.out.println("총 "+list.size()+"명 읽음");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 학생 정보가 없습니다");
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
	
	public void initDesign() 
	{
		this.studentFileRead();//파일을 읽어서 list 변수에 담는다
		//list 의 데이터를 읽어서 테이블에 출력 후
		//프레임에 출력하시오
		//제목은 이름,국어,영어,총점,평균
		Vector<String> title=new Vector<String>();
		title.add("학생이름");
		title.add("국어점수");
		title.add("영어점수");
		title.add("총점");
		title.add("평균");
		
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		
		for(student t:list)
		{
			Vector<String> student=new Vector<String>();
			student.add(t.getName());
			student.add(String.valueOf(t.getKor()));
			student.add(String.valueOf(t.getEng()));
			int total=t.getKor()+t.getEng();
			double avg=total/2.0;
			student.add(String.valueOf(total));
			student.add(String.valueOf(avg));
			
			data.add(student);
			
			table=new JTable(data, title);
			
			this.add("Center",new JScrollPane(table));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5TableStudent();
	}

}
