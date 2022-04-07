package com.task.ou.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.ou.mapper.BoardMapper;
import com.task.ou.page.Criteria;
import com.task.ou.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList(){
		return boardMapper.getBoardList();
	}
	
	@Override
	public List<BoardVO> getBoardListWithPaging(Criteria criteria){
		return boardMapper.getBoardListWithPaging(criteria);
	}
	
	@Override
	public int getTotalCount(){
		return boardMapper.getTotalCount();
	}
	
	@Override
	public BoardVO getBoard(int bid){
		upHit(bid);
		return boardMapper.read(bid);
	}

	@Override
	public void insertBoard(BoardVO boardVO){
		boardMapper.insert(boardVO);
	}
	
	@Override
	public void deleteBoard(int bid){
		boardMapper.delete(bid);
	}
	
	@Override
	public void modifyBoard(BoardVO boardVO){
		boardMapper.modify(boardVO);
	}
	
	@Override
	public void upHit(int bid){
		boardMapper.upHit(bid);
	}

	@Override
	public void insertReply(BoardVO boardVO){
		boardMapper.updateShape(boardVO);
		boardMapper.insertReply(boardVO);
	}
	
	
}
