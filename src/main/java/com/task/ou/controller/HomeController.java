package com.task.ou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.task.ou.page.Criteria;
import com.task.ou.page.PageVO;
import com.task.ou.service.BoardService;
import com.task.ou.vo.BoardVO;


@RestController
public class HomeController {
	
	@Autowired
	private BoardService boardService;

	//글목록(메인)
	@GetMapping("/")
	public ModelAndView getList(ModelAndView view, Criteria criteria) {

		//view.addObject("boardList", boardService.getBoardList()); //글목록(페이징적용x)
		//======페이징 적용 후 =======
		view.addObject("boardList", boardService.getBoardListWithPaging(criteria));
		view.addObject("pageMaker", new PageVO(criteria, boardService.getTotalCount()));
		
		view.setViewName("/list");
		return view;
	}
	
	//글보기
	@GetMapping("/content_view")
	public ModelAndView getBoardDetail(BoardVO boardVO, ModelAndView view) {

		view.addObject("board", boardService.getBoard(boardVO.getBid())); //선택한 게시글정보
		
		view.setViewName("/content_view");
		return view;
	}
	
	//글쓰기 페이지로 이동 
	@GetMapping("/write_view")
	public ModelAndView write_view(ModelAndView view) {
	
		view.setViewName("/write_view");
		return view;
	}
	
	//글작성
	@PostMapping("/write")
	public ModelAndView writeBoard(BoardVO boardVO, ModelAndView view) {

		boardService.insertBoard(boardVO); //글등록
		
		view.setViewName("redirect:/");
		return view;
	}
	
	//글삭제
	@GetMapping("/delete")
	public ModelAndView deleteBoard(BoardVO boardVO, ModelAndView view) {

		boardService.deleteBoard(boardVO.getBid()); //글삭제
		
		view.setViewName("redirect:/");
		return view;
	}
	
	//글수정 페이지로 이동
	@GetMapping("/modify_view")
	public ModelAndView modify_view(BoardVO boardVO, ModelAndView view) {

		view.addObject("board", boardService.getBoard(boardVO.getBid())); //선택한 게시글정보
		
		view.setViewName("/modify_view");
		return view;
	}
	
	//글수정
	@PostMapping("/modify")
	public ModelAndView modifyBoard(BoardVO boardVO, ModelAndView view) {

		boardService.modifyBoard(boardVO); //글등록
		
		view.setViewName("redirect:/");
		return view;
	}
	
	//답글등록 페이지로 이동
	@GetMapping("/reply_view")
	public ModelAndView reply_view(BoardVO boardVO, ModelAndView view) {

		view.addObject("board", boardService.getBoard(boardVO.getBid())); //선택한 게시글정보
		
		view.setViewName("/reply_view");
		return view;
	}
	
	//답글등록
	@PostMapping("/reply")
	public ModelAndView replyBoard(BoardVO boardVO, ModelAndView view) {

		boardService.insertReply(boardVO); //글등록
		
		view.setViewName("redirect:/");
		return view;
	}
	
	//======================================================================권한체크 해야할것 4/5
	@GetMapping("/board/test")
	public ModelAndView test(ModelAndView view) {
		
		view.setViewName("/board/test");
		return view;
	}
	
	
}
