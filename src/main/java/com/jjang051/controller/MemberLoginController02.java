package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;


public class MemberLoginController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		ModelAndView mav=null;
		String nextPage="BoardList02.do";
		System.out.println(loggedMember);
		if (loggedMember != null) {
			// session 내장객체는 jsp에 사용가능
			HttpSession session = request.getSession(); // servlet에서 session을 사용할려면 request.getSession()을 통해 생성
			//수정이필요해보임
			session.setAttribute("loggedMember", loggedMember);
			mav=new ModelAndView(nextPage,"alertMsg","로그인 되었습니다..");
		} else {
			mav=new ModelAndView(nextPage,"backMsg","패스워드확인하세요");
		}
		return mav;
	}

}
