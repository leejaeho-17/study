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
		//model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-121");
		model.addAttribute("fronturl", "https://hit24cex8733.edge.naverncp.com/e0XP0bC7Fl");
		model.addAttribute("backurl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
		return "member/memberlist";
	}
	
	
	
}
