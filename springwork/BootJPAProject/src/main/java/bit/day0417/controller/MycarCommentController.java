package bit.day0417.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.day0417.data.MycarCommentDto;
import bit.day0417.data.MycarDto;
import bit.day0417.service.MycarCommentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
public class MycarCommentController {
	final MycarCommentService commentService;
	
	@PostMapping("/addcomment")
	public void addComment (@RequestParam("nickname") String nickname, @RequestParam("comment") String comment,
			@RequestParam("num") Long num) {
		//먼저 mycardto 에 num 값을 넣은 후 mycarcommentdto 에 넣는다(외부키로 지정된값)
		MycarDto mycar = MycarDto.builder().num(num).build();
		
		MycarCommentDto  commentDto = MycarCommentDto.builder()
				.nickname(nickname)
				.comment(comment)
				.mycar(mycar)
				.build();
		
		//db insert
		commentService.insertComment(commentDto);
	}
	
	@GetMapping("/commentlist")
	public List<MycarCommentDto> commentList(@RequestParam("num") Long num) {
		return commentService.getCommentList(num);
	}
	
	@DeleteMapping("/commentdel")
	public String deleteComment(@RequestParam("idx") int idx) {
		commentService.deleteComment(idx);
		return "comment delete ok";
	}
	
	
}
