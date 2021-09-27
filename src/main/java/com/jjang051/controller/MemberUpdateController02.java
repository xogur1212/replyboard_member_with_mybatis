package com.jjang051.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

public class MemberUpdateController02 implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		   request.setCharacterEncoding("utf-8");  // 요청으로 들어오는 한글 인코딩을 utf-8로 처리하겠다.
		   response.setContentType("text/html; charset=utf-8");// 출력용 한글깨짐 방짐...
		   String userId = request.getParameter("userId");
		   String userPw = request.getParameter("userPw"); 
		   String userName = request.getParameter("userName");
		   int zipcode =  Integer.parseInt(request.getParameter("address01"));
		   String address =  request.getParameter("address02")+" "+request.getParameter("address03");
		   String phone = request.getParameter("phoneNumber")+request.getParameter("phoneMiddleNumber")+request.getParameter("phoneLastNumber");
		   String userEmail = request.getParameter("userEmail");
		   
		   MemberDao memberDao=new MemberDao();
		   MemberDto memberDto=new MemberDto();
		   
		   PrintWriter out =response.getWriter();
		   memberDto.setId(userId);
		   memberDto.setPassword(userPw);
		   memberDto.setName(userName);
		   memberDto.setZipcode(zipcode);
		   memberDto.setAddress(address);
		   memberDto.setHp(phone);
		   memberDto.setEmail(userEmail);
		  int result= memberDao.updateMember(memberDto);
		  ModelAndView mav=null;
		  String nextPage="BoardList02.do";
		  
		   
		  if(result>0){
			  
			mav=new ModelAndView(nextPage,"alertMsg","수정완료되었습니다.");  
		
		  }
		  else{
			  
			mav=new ModelAndView(nextPage,"backMsg","다시 입력하세요."); 
			

		  }

		return mav;
	}

}
