package bit.day0417.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bit.day0417.data.UserEntity;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userData = userRepository.findByUsername(username);
		if(username == null) {
			System.out.println(username + "아이디는 DB에 존재하지 않음");
		} else {
			System.out.println(username + "아이디로 로그인함 !");
			return new CustomUserDetail(userData);
		}
		return null;
	}

}
