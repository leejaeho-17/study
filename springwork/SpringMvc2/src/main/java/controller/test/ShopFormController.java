package controller.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ShopFormController {
	@GetMapping("/form1")
	public String form1() {
		return "shop/form1";
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "shop/form2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "shop/form3";
	}
	
	@GetMapping("/process1")
	public String list1(Model model,
			//방법 1
//			@RequestParam("myid") String myid,
//			@RequestParam("mypass") String mypass) 
			
			//방법 2 : 폼태그의 name 읽을 변수명이 같을 경우 name 은 생략가능
//			@RequestParam String myid,
//			@RequestParam String mypass
			
			//방법 3 : 이름이 같을 경우 @requestparam 도 생략가능(권장x)
			String myid,
			String mypass,
			 
			//특정값이 넘어올 때도 있고 안넘어 올때도 있을경우
			//아예 pageNum 이라는 폼태그 자체가 없을 경우 null 값이 넘어온다
			//이경우 디폴트값을 지정할 수 있다
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum
			
			)
	{
		String result="";
		if(mypass.equals("12345")) {
			result = myid + "님이 로그인 했습니다";
		} else {
			result = "비밀번호가 맞지 않습니다";
		}
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		
		return "shop/list1";
	}
	
	@PostMapping("/process2")
	//public String list2(@ModelAttribute("dto") ShopDto dto) { //dto 로 통째로 읽어서 모델에 저장(저장 시 shopDto 로 저장)
	public String list2(@ModelAttribute("dto") ShopDto dto) { //dto 로 통째로 읽어서 모델에 저장(저장 시 dto 로 저장)
		return "shop/list2";	
	}
	
	@PostMapping("/process3")
	public String list3(Model model,
			@RequestParam Map<String, String> map) { //폼태그의 name 이 key 값으로 , 입력값이 value 로 넘어온다
		model.addAttribute("name", map.get("name"));
		model.addAttribute("age", map.get("age"));
		model.addAttribute("addr", map.get("addr"));
		model.addAttribute("gender", map.get("gender"));
		
		return "shop/list3";
	}
}
