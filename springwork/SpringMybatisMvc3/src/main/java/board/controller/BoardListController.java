package board.controller;

import org.springframework.stereotype.Controller;

import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class BoardListController {
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	
	@GetMapping("/board/list")
	public String list() {
		
		return "board/boardlist";
	}
	
}
