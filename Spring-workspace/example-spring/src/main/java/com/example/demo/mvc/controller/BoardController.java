package com.example.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.exception.BaseException;
import com.example.demo.configuration.http.BaseResponse;
import com.example.demo.configuration.http.BaseResponseCode;
import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.parameter.BoardParameter;
import com.example.demo.mvc.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 게시판 컨트롤러
 * @author 곰돌이
 *
 */
@RestController
@RequestMapping("/board")
@Api(tags="게시판API")
public class BoardController {
	@Autowired
	private BoardService boardService;
	/**
	 * 목록 리턴
	 * @return
	 */
	@GetMapping
	@ApiOperation(value="목록조회",notes="게시물 목록 정보를 조회할 수 있습니다.")
	public BaseResponse<List<Board>> getList(){
		return new BaseResponse<List<Board>>(boardService.getList());
	};

	/**
	 * 상세 정보 리턴
	 * @param boardSeq
	 * @return
	 */
	@ApiOperation(value="상세조회",notes="게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardSeq",value="게시물 번호", example="1")
	})
	@GetMapping("/{boardSeq}") //boardSeq를 url에 받음
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if(board==null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
		}
		return new BaseResponse<Board>(board);
	};
	/**
	 * 등록/수정 처리
	 * @param parameter
	 */
	@PutMapping
	@ApiOperation(value="등록/수정 처리",notes="신규 게시물 저장 및 기존 게시물 업데이트 할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardSeq",value="게시물 번호", example="1"),
		@ApiImplicitParam(name="title",value="제목", example="제목1"),
		@ApiImplicitParam(name="contents",value="내용", example="내용1"),
	})
	public BaseResponse<Integer> save(BoardParameter parameter) {
		boardService.save(parameter);
		return new BaseResponse<Integer>(parameter.getBoardSeq());
	};
	/**
	 * 삭제 처리
	 * @param board
	 */
	@DeleteMapping("/{boardSeq}")
	@ApiOperation(value="삭제 처리",notes="게시물 번호에 해당하는 정보를 삭제합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardSeq",value="게시물 번호", example="1"),
	})
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if(board==null) {
			return new BaseResponse<Boolean>(false);
		}
		boardService.delete(boardSeq);
		return new BaseResponse<Boolean>(true);
	};
}
