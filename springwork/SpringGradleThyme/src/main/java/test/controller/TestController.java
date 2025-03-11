package test.controller;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.data.FoodDto;


@Controller
public class TestController {
	
	@GetMapping("/")
	public String home() {
		return "food/home";
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "have a nice day");
		model.addAttribute("myfood", "angry.png");
		return "food/hello";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model, @RequestParam("name") String name, @RequestParam("age") int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "food/hello2";
	}
	
	@GetMapping("/hello3")
	public String hello3(Model model) {
		FoodDto dto = FoodDto.builder()
				.foodName("망고빙수")
				.foodPhoto("11.jpg")
				.foodPrice(15000)
				.build();
		model.addAttribute("dto", dto);
		model.addAttribute("bgcolor", "#00ff7f");
		model.addAttribute("today", new Date());
		return "food/hello3";
	}
	
	@GetMapping("/hello4")
	public String hello4(Model model) {
		List<FoodDto> list = new Vector<>();
		list.add(new FoodDto("야채샌드위치", 12000, "1.jpg"));
		list.add(new FoodDto("망고빙수", 14000, "11.jpg"));
		list.add(new FoodDto("햄마요덮밥", 12000, "10.jpg"));
		list.add(new FoodDto("순두부라면", 13000, "12.jpg"));
		list.add(new FoodDto("솥밥", 9000, "7.jpg"));
		
		model.addAttribute("list", list);
		
		return "food/hello4";
	}
	
	@GetMapping("/hello5")
	public String hello5(Model model, @RequestParam("myid") String myid,
			HttpSession session) {
		session.setAttribute("loginid", myid);
		return "food/hello5";
	}
	
}

