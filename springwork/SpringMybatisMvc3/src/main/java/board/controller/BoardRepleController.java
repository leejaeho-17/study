package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardRepleDto;
import data.service.BoardRepleService;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardRepleController {

	final MemberService memberService;
	final BoardRepleService repleService;
	final NcpObjectStorageService storageService;
	
	//버켓이름 
	private String bucketName = "bitcamp-bucket-121";
	
	private String uploadFilename;
	
	@PostMapping("/repleupload")
	public String upload(@RequestParam("upload") MultipartFile upload) {
		uploadFilename = storageService.uploadFile(bucketName, "board", upload);
		return uploadFilename;
	}
	
	@GetMapping("/replephotodel")
	public void photoDel(@RequestParam String fname) {
		storageService.deleteFile(uploadFilename, "board", fname);
		uploadFilename = null;
	}
	
	@PostMapping("/addreple")
	public void addreple(@RequestParam int idx, @RequestParam String message,
			HttpSession session) {
		//로그인한 아이디 
		String loginid = (String)session.getAttribute("loginid");
		
		//클래스명.builder() 로 시작하여 값을 세팅 후 build()를 호출하여 객체 생성
		BoardRepleDto dto = BoardRepleDto.builder()
						.idx(idx)
						.message(message)
						.myid(loginid)
						.photo(uploadFilename)
						.build();
		repleService.insertReple(dto);
		uploadFilename = null;
		
	}
	
	@GetMapping("/replelist")
	public List<BoardRepleDto> getRepleList(@RequestParam int idx) {
		
		List<BoardRepleDto> rlist = repleService.getSelectReples(idx);
		for(int i=0;i<rlist.size();i++) {
			String writer = memberService.getSelectByMyid(rlist.get(i).getMyid()).getMname();
			String profilePhoto = memberService.getSelectByMyid(rlist.get(i).getMyid()).getMphoto();
			rlist.get(i).setWriter(writer);
			rlist.get(i).setProfile(profilePhoto);
		}
		
		return rlist;
	}
	@GetMapping("/repledel")
	public void repleDelete(@RequestParam int num) {
		//num 에 해당하는 이미지명 얻ㄱ기
		String replePhoto = repleService.getSelectData(num).getPhoto();
		//null 이 아닐경우 스토리지에서 삭제
		if(replePhoto!=null)
			storageService.deleteFile(bucketName, "board", replePhoto);
		
		//db에서 삭제
		repleService.deleteReple(num);
	}
	
}
