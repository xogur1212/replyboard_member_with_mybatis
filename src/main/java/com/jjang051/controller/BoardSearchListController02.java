package com.jjang051.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
import com.jjang051.model.SearchDto;

public class BoardSearchListController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String searchSelect = request.getParameter("searchSelect");
		String searchWord = request.getParameter("searchWord");
		
		if(searchSelect == null) searchSelect = "";
		if(searchWord == null) searchWord = "";
		
		ReplyDao replyDao = new ReplyDao();
		String clickedPage = request.getParameter("clickedPage");
		if(clickedPage==null) {
			clickedPage = "1";  // clickedPage는 null값으로 들어올때도 있다.  header 에 있는  게시판을 클릭했을때...
		}
		int currentPage = Integer.parseInt(clickedPage); //정수변환

		int total = 0; //10
		int listPerCount = 7;   //  한번에 보여지는 리스트 갯수 (tr)
		int pageGroupCount = 3; // pagination의 한번에 보여지는 갯수
		
		total =  replyDao.getSearchTotal(searchSelect,searchWord);  // 검색 글 갯수
		
		System.out.println("total===="+total);
		
		int lastPage = (int) ( total / listPerCount ) + 1;
		
		int startPage = (int) ((currentPage - 1)/pageGroupCount)*pageGroupCount + 1;
		int endPage = startPage + pageGroupCount - 1;

		if(endPage > lastPage) {
			endPage = lastPage;
		}
	

		int start = (currentPage - 1)*listPerCount+1;
		int end = start+listPerCount;
		
		
		List<ReplyDto> replyList = null;
		//replyList = replyDao.getSearchAllList(searchSelect,searchWord,start,end);
		SearchDto searchDto = new SearchDto();
		searchDto.setField(searchSelect);
		searchDto.setSearchWord(searchWord);
		searchDto.setStart(start);
		searchDto.setEnd(end);
		replyList = replyDao.getSearchAllList(searchDto);
		ModelAndView mav=null;
		String nextPage="board/search_list";
		mav=new ModelAndView(nextPage);
		mav.addObject("lastPage",lastPage);
		mav.addObject("listPerCount",listPerCount);
		mav.addObject("startPage",startPage);
		mav.addObject("endPage",endPage);
		mav.addObject("currentPage",currentPage);
		mav.addObject("pageGroupCount",pageGroupCount);
		mav.addObject("total",total);
		mav.addObject("replyList", replyList);
		
		return mav;
	}

}
