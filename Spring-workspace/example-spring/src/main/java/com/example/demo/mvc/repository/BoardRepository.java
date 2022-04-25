package com.example.demo.mvc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.parameter.BoardParameter;
/**
 * 게시판 레포지토리
 * @author 곰돌이
 *
 */
@Repository
public interface BoardRepository {
	List<Board> getList();
	Board get(int boardSeq);
	void save(BoardParameter board);
	void saveList(Map<String, Object> paramMap);
	void update(BoardParameter board);
	void delete(int boardSeq);
}
