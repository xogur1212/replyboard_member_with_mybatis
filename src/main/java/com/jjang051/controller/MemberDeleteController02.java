package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;

public class MemberDeleteController02 implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt( request.getParameter("no") );
		String password =  request.getParameter("userPw");
		MemberDao memberDao = new MemberDao();
		String dbPassword = memberDao.getPassword(no);
		ModelAndView mav=null;
		String nextPage="MemberList02.do"; 
		if(dbPassword.equals(password)) {
			int result = memberDao.deleteMember(no);
			if(result>0) {
				mav=new ModelAndView(nextPage,"alertMsg","삭제되었습니다..");
			}
		} else {
			mav=new ModelAndView(nextPage,"backMsg","다시하세요.");
		}
		return mav;
	}

}
