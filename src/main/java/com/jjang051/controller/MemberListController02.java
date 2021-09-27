package com.jjang051.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

public class MemberListController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDao  memberDao = new MemberDao();
		List<MemberDto> memberList = memberDao.showAllMember();
		ModelAndView mav=null;
		String nextPage="member/list";
		mav=new ModelAndView(nextPage);
		mav.addObject("memberList", memberList);
		
		return mav;
	}

}
