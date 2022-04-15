package com.example.demo.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.mvc.domain.Board;
/**
 * 게시판 레포지토리
 * @author 곰돌이
 *
 */
@Repository
public interface BoardRepository {
	List<Board> getList();
	Board get(int boardSeq);
	void save(Board board);
	void update(Board board);
	void delete(int boardSeq);
}
