package com.task.ou.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.task.ou.page.Criteria;
import com.task.ou.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> getBoardList(); //글목록
	public List<BoardVO> getBoardListWithPaging(Criteria criteria); //글목록 페이징
	public int getTotalCount(); //글갯수 카운팅
	public BoardVO read(int bid); //글보기
	public void insert(BoardVO boardVO); //글쓰기
	public void delete(int bid); //글삭제
	public void modify(BoardVO boardVO); //글수정
	public void upHit(int bid); //조회수
	public void updateShape(BoardVO boardVO); //답글이 달릴 위치 조정
	public void insertReply(BoardVO boardVO); //답글 등록
	

}
