package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
import com.jjang051.utils.ScriptWriterUtil;

public class BoardWriteController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = new ReplyDto();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		replyDto.setName(userName);
		replyDto.setEmail(email);
		replyDto.setSubject(subject);
		replyDto.setPassword(password);
		replyDto.setContents(contents);
		
		//reGroup, reStep, reLevel
		
		// 경고 , 경고창 띄우고 다음 페이지로 넘기기, 경고창 띄우고 이전 페이지로 돌아가기
		int result = replyDao.insertBoard(replyDto);
		
		ModelAndView mav=null;
		
		String nextPage="BoardList02.do";
		
		
		if(result > 0) {
			mav=new ModelAndView(nextPage,"alertMsg","글이 등록되었습니다.");
		}else {
			mav=new ModelAndView(nextPage,"backMsg","글이 등록되지않았습니다.");
		}
		return mav;
	}

}
