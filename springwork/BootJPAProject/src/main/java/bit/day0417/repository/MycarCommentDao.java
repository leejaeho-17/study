package bit.day0417.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bit.day0417.data.MycarCommentDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarCommentDao {
	MycarCommentRepository commentRepository;

	public void insertComment(MycarCommentDto dto) {
		commentRepository.save(dto);
	}
	
	public void deleteComment(@Param("idx") int idx) {
		commentRepository.deleteById(idx);
	}
	
	public List<MycarCommentDto> getCommentList(@Param("num") Long num) {
		return commentRepository.getMycarCommentList(num);
	}
}
