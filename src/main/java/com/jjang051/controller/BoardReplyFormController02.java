package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReplyFormController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no =  Integer.parseInt( request.getParameter("no") );
		int reGroup =  Integer.parseInt( request.getParameter("reGroup") );
		int reStep =  Integer.parseInt( request.getParameter("reStep") );
		int reLevel =  Integer.parseInt( request.getParameter("reLevel") );
		
		System.out.println(no+"==="+reGroup+"==="+reStep+"==="+reLevel);
		
		ModelAndView mav=null;
		String nextPage="board/reply_write";
		mav=new ModelAndView(nextPage);
		
		mav.addObject("no", no);
		mav.addObject("reGroup", reGroup);
		mav.addObject("reStep", reStep);
		mav.addObject("reLevel", reLevel);
		
		return mav;
	}

}
