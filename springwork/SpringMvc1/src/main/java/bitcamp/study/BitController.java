package bitcamp.study;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class BitController {
	//@RestController 는 json 출력 시 @ResponseBody 안붙여도 됌
	@GetMapping("/hello")
	public List<TestDto> list() {
		List<TestDto> list = new Vector<>();
		list.add(new TestDto("강호동", "서울", "010-2222-3333"));
		list.add(new TestDto("강호동1", "서울1", "010-2222-3333"));
		list.add(new TestDto("강호동2", "서울2", "010-2222-3333"));
		list.add(new TestDto("강호동3", "서울3", "010-2222-3333"));
		return list;
	}
}
