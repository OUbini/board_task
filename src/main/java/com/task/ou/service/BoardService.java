package com.task.ou.service;


import java.util.List;

import com.task.ou.page.Criteria;
import com.task.ou.vo.BoardVO;


public interface BoardService {
	
	public List<BoardVO> getBoardList(); //게시판 글목록 조회
	public List<BoardVO> getBoardListWithPaging(Criteria criteria); //게시판 글목록 조회(페이징)
	public int getTotalCount(); //게시글 갯수 카운팅
	public BoardVO getBoard(int bid); //게시판 글보기
	public void insertBoard(BoardVO boardVO); //게시판 글작성
	public void deleteBoard(int bid); //게시판 글삭제
	public void modifyBoard(BoardVO boardVO); //게시판 글수정
	public void upHit(int bid); //조회수 상승
	public void insertReply(BoardVO boardVO); //답글등록
 	
}
