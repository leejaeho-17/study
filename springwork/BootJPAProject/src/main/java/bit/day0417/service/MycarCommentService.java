package bit.day0417.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import bit.day0417.data.MycarCommentDto;
import bit.day0417.repository.MycarCommentDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MycarCommentService {
	MycarCommentDao commentDao;
	
	public void insertComment(MycarCommentDto dto) {
		commentDao.insertComment(dto);
	}
	
	public void deleteComment(@Param("idx") int idx) {
		commentDao.deleteComment(idx);
	}
	
	public List<MycarCommentDto> getCommentList(@Param("num") Long num) {
		return commentDao.getCommentList(num);
	}
}
