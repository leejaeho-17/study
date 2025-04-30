package bit.react.controller;

import org.springframework.web.bind.annotation.RestController;

import bit.react.repository.BoardService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	private final NcpObjectStorageService storageService;

	private String uploadFilename;

	// 네이버 클라우드 버켓네임
	private String bucketName = "bitcamp-bucket-121";
	// 스토리지의 폴더명
	private String folderName = "board";

}
