package bit.day0417.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.day0417.data.MycarDto;

//JpaRepository 가 가진 기본 CRUD 메서드를 상속받아 사용
public interface MycarRepository extends JpaRepository<MycarDto, Long>{

	//connt() 가 전체 갯수를 구하는 메소드로 제공되지만 직접 구현하고 싶다면
	
	//@query : repository 에 원하는 쿼리를 작성하게 해주는 어노테이션
	//value 속성 : 쿼리 작성부
	//nativeQuery : jpa 에서 지정한 규칙을 모두 무시할 수 있는 속성
	@Query(value = "select count(*) from jpamycar",nativeQuery = true)
	public Long getTotalMycount();
	
	@Query(value = "select * from jpamycar where carname like concat('%',:search,'%')",nativeQuery = true)
	public List<MycarDto> getSearchList(@Param("search") String search);
	
	
	public List<MycarDto> findByCarnameContaining(String search);
}
