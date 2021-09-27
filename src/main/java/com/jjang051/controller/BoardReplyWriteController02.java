package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
import com.jjang051.utils.ScriptWriterUtil;

public class BoardReplyWriteController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReplyDto replyDto = new ReplyDto();
		ReplyDao replyDao = new ReplyDao();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		
		int no =   Integer.parseInt( request.getParameter("no") );
		int reGroup = Integer.parseInt( request.getParameter("reGroup") );
		int reStep = Integer.parseInt( request.getParameter("reStep") );
		int reLevel = Integer.parseInt( request.getParameter("reLevel") );
	
		//no, reGroup,reStep,reLevel
		//System.out.println(no+"==="+reGroup+"==="+reStep+"==="+reLevel);
		
		replyDto.setName(userName);
		replyDto.setEmail(email);
		replyDto.setSubject(subject);
		replyDto.setPassword(password);
		replyDto.setContents(contents);
		replyDto.setNo(no);
		replyDto.setReGroup(reGroup);
		replyDto.setReStep(reStep);
		replyDto.setReLevel(reLevel);
		
		int result = replyDao.insertReplyBoard(replyDto);
		ModelAndView mav=null;
		String nextPage="BoardList02.do";
		if(result > 0) {
			mav=new ModelAndView(nextPage,"alertMsg","답글이 등록되었습니다.");
		}else {	
			mav=new ModelAndView(nextPage,"backMsg","글이 등록되지않았습니다.");
		}
		return mav;
	}
	
}
