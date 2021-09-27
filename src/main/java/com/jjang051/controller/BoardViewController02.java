package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;

public class BoardViewController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		String clickedPage=request.getParameter("clickedPage");
	  
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = null;
		replyDto = replyDao.getSelectOne(no);
	
		
		// 클릭한 것의 이전 페이지 모든 정보 dto
		ReplyDto prevReplyDto = null;
		prevReplyDto = replyDao.getSelectPrev(num);
	
		// 클릭한 것의 이전 페이지 모든 정보 dto
		ReplyDto nextReplyDto = null;
		nextReplyDto = replyDao.getSelectNext(num);
		
		ModelAndView mav=null;
		String nextPage="board/view";
		mav=new ModelAndView(nextPage);
		mav.addObject("clickedPage", clickedPage);
		mav.addObject("replyDto", replyDto);
		mav.addObject("prevReplyDto", prevReplyDto);
		mav.addObject("nextReplyDto", nextReplyDto);
			
		
		return mav;
	}

}
