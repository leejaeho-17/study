package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.react.data.UserEntity;
import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	//username 이 존재하는지 true/false 로 반환
	Boolean existsByUsername(String username);
	//해당 username 정보를 UserEntity 타입으로 반환
	UserEntity findByUsername(String username);
}
