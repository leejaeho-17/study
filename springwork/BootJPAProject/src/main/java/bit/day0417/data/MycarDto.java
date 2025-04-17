package bit.day0417.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//entity란 “DB 테이블과 1:1로 매핑되는 자바 클래스”
@Entity
@Table(name = "jpamycar") //db 에 jpamycar 테이블이 생성된다
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {
	
	@Id //각 엔티티를 구별할 수 있도록 식별 아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	//@Column(name = "dbcarname") // 변수명과 달리 db 에는 dbcarname 으로 생성됌.
	@Column(length = 30) //name 은 생략 시 변수명과 같은 이름으로 컬럼명이 생성된다
	private String carname;
	
	private int carprice; //name 은 같은 이름으로 생성할거라 필요없고 나머지 설정도 없다면 @column 생략 가능
	
	@Column(length = 30)
	private String carcolor;
	
	@Column(length = 20)
	private String carimage;
	
	@Column(length = 20)
	private String carquip;
	
	//writeday 는 자동으로 현재시간으로 추가되어야 하고 수정시에는 제외되어야 한다
	@CreationTimestamp
	@Column(updatable = false) //수정할 때 제외되는 기능 updatable = false
	private Timestamp writeday;
	
	//@Transient : 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용가능한 멤버변수
	@Transient
	private String message;
	
	@Transient
	private int commentcount;
}
	