package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class BoardController {

	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	//버켓이름 
	private String bucketName = "bitcamp-bucket-121";
	

}
