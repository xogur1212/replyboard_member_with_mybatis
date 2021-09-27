package com.jjang051.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/SummerNoteFileUpload.do")
public class SummerNoteFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SummerNoteFileUploadController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String savePath = "upload";
		ServletContext context =  this.getServletContext();// 현재 내가 서비스하는 context;
		String realPath = context.getRealPath(savePath); // context path
	
		int fileSize = 1024*1024*100; // 파일 크기 지정
		String encoding ="UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = new MultipartRequest(request,realPath,fileSize,encoding, filePolicy);
		
		//직접 만든 form이 아닌 섬머노트에서 업로드 하고 있음....
		Enumeration files = multipartRequest.getFileNames();
		String file = (String)files.nextElement();
		String fileRealName = multipartRequest.getFilesystemName(file);
		String uploadPath = savePath+"/"+fileRealName;

		HashMap<String, String> fileUrlMap = new HashMap<String,String>();
		Gson gson = new Gson();
		
		fileUrlMap.put("url", uploadPath);
		String fileUrl = gson.toJson(fileUrlMap);  //json으로 파일 변환....
		//{"url":"upload/jfkjffjkd.jpg"}  
		// json   {"url":"fjdksjf"}
		
		request.setAttribute("fileUrl", fileUrl);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/summernote_file_upload.jsp");
		dispatcher.forward(request, response);
	}
}




