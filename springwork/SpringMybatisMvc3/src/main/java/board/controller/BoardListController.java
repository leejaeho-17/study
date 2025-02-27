package board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import data.dto.BoardDto;
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
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			Model model) {
		//페이징처리
		int perPage = 3;//한 페이지당 출력할 글의 갯수
		int perBlock = 3;//한 블럭당 출력할 페이지 갯수
		int totalCount;//전체 게시글 갯수
		int totalPage;//총 페이지수
		int startNum;//각 페이지에서 가져올 시작번호(mysql은 첫 데이터가 0번, 오라클은 1번)
		int startPage;//각 블럭에서 출력할 시작페이지
		int endPage;//각 블럭에서 출력할 끝 페이지
		int no;//각페이지에서 출력할 시작번호
		List<BoardDto> list=null; //페이징에 필요한 데이타

		totalCount=boardService.getTotalCount();//총 글 갯수
		//totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);// 총 페이지 갯수,나머지가 있으면 무조건 1페이지를 더한다
		totalPage = (int) Math.ceil((double) totalCount / perPage);// 방법 2, 무조건 올림함수를 이용해서 구하는 방법
		startPage = (pageNum - 1) / perBlock * perBlock + 1;//예 : 현재페이지가 7일 경우 startPage 가 6
		endPage = startPage + perBlock - 1;//끝페이지
		//endPage 는 totalPage 를 넘을 수 없다
		if (endPage > totalPage)
			endPage = totalPage;

		startNum = (pageNum-1)*perPage;//mysql 은 첫글이 0번(오라클은 1번 이므로 +1 해야한다)

		//System.out.println("totalPage="+totalPage);

		list=boardService.getPagingList(startNum, perPage);
		//마지막페이지에 1개 남은 글을 지우고 다시 해당 페이지를 
		//왔을 경우 데이터가 안나오는 현상
		if(list.size()==0) {
			return "redirect:./list?pageNum="+(pageNum-1);
		}
		
		//list 의 각 dto 에 사진 갯수 저장하기
		for(int i=0;i<list.size();i++) {
			BoardDto dto = list.get(i);
			int count = fileService.getFiles(dto.getIdx()).size();
			list.get(i).setPhotoCount(count);
		}
		//각페이지의 글 앞에 출력할 시작번호(예:총 글이 20개일 경우 1페이지는 20, 2페이지는 15,,)
		no = totalCount - (pageNum - 1) * perPage;
		
		//request 에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		//페이지 출력에 필요한 모든 변수를 request에 넣는다
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("no", no);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalPage);

		return "board/boardlist";
	}

}
