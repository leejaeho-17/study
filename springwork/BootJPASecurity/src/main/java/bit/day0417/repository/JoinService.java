package bit.day0417.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bit.day0417.data.JoinDto;
import bit.day0417.data.UserEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinService {
	final UserRepository userRepository;
	final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(JoinDto dto) {
		//db에 이미 동일한 username 을 가진 회원이 존재하는지 ?
		boolean isUser = userRepository.existsByUsername(dto.getUsername());
		if(isUser) {
			System.out.println(dto.getUsername()+"이미 존재함!");
			return;
		} else {
			System.out.println(dto.getUsername()+"DB 저장함!");
		}
		
		UserEntity data = new UserEntity();
		data.setUsername(dto.getUsername());
		data.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));//암호화 되어 저장
		data.setRole(dto.getRole());
		
		try {
		    userRepository.save(data);
		    System.out.println("DB 저장 성공!");
		} catch (Exception e) {
		    System.out.println("DB 저장 실패! " + e.getMessage());
		    e.printStackTrace();
		}
	}
}
