package crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crud.dto.CrudDto;
import crud.service.CrudService;


@Controller
public class CrudController {
	
	@Autowired
	CrudService crudService;
	
	@GetMapping("/main") //href 이용해서 버튼 누르면 해당 페이지로 이동 구현하기
	public String main() {
		return "main";
	}
	
	@GetMapping("/select") //회원 정보 가져오기
	public String list(Model model) {
		//select * from crud order by num
		List<CrudDto> list = crudService.selectAll();
		model.addAttribute("crud", list);
		return "list";
	}
	
	@GetMapping("/insert") //insert 로 이동하기 위한 매핑
	public String insertForm() {
	
		return "insert";
	}
	
	@PostMapping("/insert") //회원 정보 입력하기
	public String insert(@ModelAttribute CrudDto cruddto) {
		//insert into crud (name,email,age) values (#{name},#{email},#{age})
		crudService.insertCrud(cruddto);
		return "redirect:/select";
	}
	
	@GetMapping("/update") 
	// update 로 이동하기 위한 매핑 
	// 왜 수정이 안되나 했더니, getmapping 할 때, 즉 list.jsp 에서 update 폼으로 넘어갈 때 dto에 있는 데이터를 넘겨받지 못했음..
	// selectOne 서비스를 만들어야 해서 sql 짜고 매퍼,서비스 생성하고, dto에 num 에 따른 dto에 있는 데이터를 넣어주니 update 폼에서 데이터 읽기를 성공했다 !
	public String updateForm(@RequestParam("num") int num, Model model) { // requestparam 으로 num 을 바인딩(?대충 묶어준다는 뜻 같은데) 해주고 
		CrudDto cruddto = crudService.selectOne(num); 
		model.addAttribute("crud", cruddto);
		return "update";
	}
	
	@PostMapping("/update") //회원 정보 업데이트
	public String update(@ModelAttribute CrudDto cruddto) {
		//update crud set name = #{name}, email = #{email}, age = #{age} where num = #{num}
		crudService.updateCrud(cruddto);
		return "redirect:/select";
	}
	 
	@GetMapping("/delete") //회원 정보 삭제하기
	public String delete(@RequestParam("num") int num, Model model) {
		//delete from crud where num = #{num}
		model.addAttribute("num", num);
		crudService.deleteCrud(num);
		return "redirect:/select";
	}
	
}
