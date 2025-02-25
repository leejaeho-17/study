package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import data.dto.MemberDto;
import data.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member")
public class MemberListController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/list")
	public String memberList(Model model) {
		
		List<MemberDto> memberlist = memberService.getAllMember();
		
		model.addAttribute("memberlist", memberlist);
		
		return "member/memberlist";
	}
	
	
	
}
