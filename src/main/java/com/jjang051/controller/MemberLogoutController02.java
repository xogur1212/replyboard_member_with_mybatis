package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mav=null;
		String nextPage="BoardList02.do";
		mav=new ModelAndView(nextPage,"alertMsg","로그아웃되었습니다");
		HttpSession session =request.getSession();
		session.invalidate();
		return mav;
	}

}
