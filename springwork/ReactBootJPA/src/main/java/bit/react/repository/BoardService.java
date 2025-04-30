package bit.react.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bit.react.data.BoardEntity;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	public void insertBoard(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);
	}

	// 목록 출력
	public List<BoardEntity> getAllBoard() {
		// num 의 내림차순으로 정렬
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "num"));
	}

	// 상세보기
	public BoardEntity getData(int num) {
		return boardRepository.getReferenceById(num);
	}

	// 게시글 삭제
	public void deleteBoard(int num) {
		boardRepository.deleteById(num);
	}

	// 조회수 상승
	public void updateReadCount(int num) {
		boardRepository.updateReadCount(num);
	}
	
	// 게시글 업데이트
	public void updateBoard(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);
	}
}
