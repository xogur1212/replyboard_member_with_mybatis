package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public interface AbstractController {
	//method
	
	public ModelAndView requestHandler(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException; 
		
	
}
