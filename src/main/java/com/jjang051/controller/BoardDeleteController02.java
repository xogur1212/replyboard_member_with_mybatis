package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jjang051.model.ReplyDao;

public class BoardDeleteController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no") );
		String password =  request.getParameter("userPw");
		ReplyDao replyDao = new ReplyDao();
		String dbPassword = replyDao.getPassword(no);
		System.out.println(password);
		System.out.println(dbPassword);
		ModelAndView mav=null;
		String nextPage="BoardList02.do"; 
		if(dbPassword.equals(password)) {
			int result = replyDao.deleteBoard(no);
			System.out.println(result);
			if(result>0) {
			mav=new ModelAndView(nextPage,"alertMsg","삭제되었습니다..");
			}
			
		} else {
			mav=new ModelAndView(nextPage,"backMsg","다시하세요.");
		}
		return mav;
		
	}

}
