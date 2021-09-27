package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

public class MemberInfoController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no =Integer.parseInt( request.getParameter("no") );
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMember = null;
		loggedMember = memberDao.getSelectOne(no);
	
		ModelAndView mav=null;
		String nextPage="member/member_info";
		mav=new ModelAndView(nextPage);
		mav.addObject("loggedMember", loggedMember);
		return mav;
	}

	
}
