package board.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	//버켓이름 
	private String bucketName = "bitcamp-bucket-121";
	
	@GetMapping("/writeform")
	public String writeForm(
			//아래 4개의 값은 답글일때만 넘어온다, 새글일 떄는 null 값이 넘어오므로
			//required 를 false 로 주거나 defaultvalue 를 지정해야한다
			@RequestParam(value = "idx", defaultValue = "0") int idx,
			@RequestParam(value = "regroup", defaultValue = "0") int regroup,
			@RequestParam(value = "restep", defaultValue = "0") int restep,
			@RequestParam(value = "relevel", defaultValue = "0") int relevel,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			Model model
			) {
		model.addAttribute("idx", idx);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNum", pageNum);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload,
			HttpSession session
			) {
		//세션으로부터 아이디를 얻는다
		String myid = (String)session.getAttribute("loginid");
		String writer = memberService.getSelectByMyid(myid).getMname();
		
		//아이디를 이용해서 멤버테이블에서 작성자를 얻는다

		dto.setMyid(myid);
		dto.setWriter(writer);
		//게시판 내용을 일단 db 에 저장(그래야만 dto 가 idx 를 얻어올 수 있다)
		boardService.insertBoard(dto);
		
		//파일이 있는 경우에만 해당, 네이버 스토리지에 저장 후 파일저장(이때 필요한게 idx,filename)
		if(!upload.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile file:upload) {
				String filename = storageService.uploadFile(bucketName, "board", file);
				BoardFileDto bdto = new BoardFileDto();
				bdto.setIdx(dto.getIdx());
				bdto.setFilename(filename);
				//boardfile 에 insert
				fileService.insertBoardFile(bdto);
				}
		}
		
		return "redirect:./list?pageNum="+pageNum;
	}
	
	
	@GetMapping("/detail")
	public String detail(
			@RequestParam int idx,
			@RequestParam(defaultValue = "1") int pageNum,
			Model model
			) {
		//조회수 1 증가
		boardService.updateReadcount(idx);
		//idx 에 해당하는 dto 얻기
		BoardDto dto = boardService.getSelectByIdx(idx);
		//idx 글에 등록된 파일들 가져오기
		List<String> fileList = new Vector<>();
		List<BoardFileDto> flist = fileService.getFiles(idx);
		for(BoardFileDto fdto:flist) {
			fileList.add(fdto.getFilename());
		}
		
		dto.setPhotos(fileList);
		
		//해당 아이디에 대한 사진을 멤버 테이블에서 얻기
		String memberPhoto = memberService.getSelectByMyid(dto.getMyid()).getMphoto();
		//모델에 저장
		model.addAttribute("dto", dto);
		model.addAttribute("memberPhoto", memberPhoto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+bucketName);
		
		return "board/boarddetail";
	}
	
}
