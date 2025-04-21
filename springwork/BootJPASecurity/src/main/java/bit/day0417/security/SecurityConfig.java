package bit.day0417.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,
			CustomLoginSuccessHandler loginSuccessHandler) throws Exception {
		http
		.authorizeHttpRequests(auth -> auth //스프링부트 3점대 부터는 무조건 람다식(화살표 함수)으로 코딩해야만 한다
				.requestMatchers("/","/login","/join","/joinproc").permitAll() //모든 접근 허용(role 상관없이)
				.requestMatchers("/admin").hasRole("ADMIN")//admin 롤만 접근 가능(db 에는 ROLE_ADMIN 으로 저장)
				.requestMatchers("/mypage/**").hasAnyRole("ADMIN","USER")//ADMIN, USER 롤만 접근 가능
				.anyRequest().authenticated()//그 이외에는 로그인을 해야만 접근가능한 페이지등
				);
		
		http
		.formLogin(auth -> auth.loginPage("/login")
			.loginProcessingUrl("/loginproc")//loginproc 매핑이 들어오면 로그인 처리 페이지로 자동 이동
			//.defaultSuccessUrl("/mypage")//로그인 성공 후 이동할 페이지
			.successHandler(loginSuccessHandler) //custom 한 로그인 메서드 호출
			.permitAll()
			)
		.logout(logout -> logout
				.logoutUrl("/logout")//로그아웃 url 설정
				.logoutSuccessUrl("/login"));//로그아웃 성공 후 이동할 페이지
		//접근 불가 페이지 접근 시 오류페이지 띄우기
		http
		.exceptionHandling(exception -> exception
			.accessDeniedPage("/access-denied"));
		
		http
		.csrf(auth -> auth.disable());//csrf 비활성화
	
		return http.build();
	}
}
