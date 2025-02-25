package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import data.service.MemberService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoginController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/login")
	public Map<String, String> login(
			@RequestParam String loginid,@RequestParam String loginpass,
			HttpSession session) {
		Map<String, String> map = new HashMap<>();
		boolean b = memberService.loginCheck(loginid, loginpass);
		//아이디와 비번이 맞을 경우 세션 저장
		if(b) {
			session.setMaxInactiveInterval(60*60*4);//4시간 유지
			session.setAttribute("loginstatus", "success");
			session.setAttribute("loginid", loginid);
			
			String photo = memberService.getSelectByMyid(loginid).getMphoto();
			session.setAttribute("loginphoto", photo);
			
		}
		map.put("result", b?"success":"fail");
		
		return map;
	}
	
	@GetMapping("/member/logout")
	public void memberLogout(HttpSession session) {
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		session.removeAttribute("loginphoto");
	}
	
}
