package com.jjang051.frontcontroller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.jjang051.controller.AbstractController;
import com.jjang051.controller.ModelAndView;
import com.jjang051.utils.ScriptWriterUtil;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String context=request.getContextPath(); //현재 서버에 올라가 있는것중 실행중인 contexntㅇ더어오기
		String uri=request.getRequestURI(); //전체요청 주소
		String command =uri.substring(context.length());// ****.do만뽑아옴
		
		ModelAndView mav=null;
		HandlerMapping mappings =new HandlerMapping();
		ViewResolver viewResolver =new ViewResolver();
		viewResolver.setPrefix("WEB-INF/");
		viewResolver.setSuffix(".jsp");
		
		
		
		AbstractController controller =null;
		controller=mappings.getController(command);
		//넘어온 주소와 mapping 해야함
		
		mav=controller.requestHandler(request, response);
		String tempPage=mav.getNextPage();
		String nextPage=null;
		if(tempPage.contains(".do")) {
			nextPage=tempPage;
		}else {
			nextPage =viewResolver.getViewPage(mav.getNextPage());
		}
		
		Map<String,Object> model =mav.getModel();
		for(String key: model.keySet()) {
			request.setAttribute(key, model.get(key));//반복문 돌려서 값 뽑아오기
			
		}
		String alertMsg=(String)model.get("alertMsg");
		String backMsg=(String)model.get("backMsg");
		if(alertMsg!=null) {
			ScriptWriterUtil.alertAndNext(response, alertMsg, nextPage);
		}else if(backMsg!=null) {
			ScriptWriterUtil.alertAndBack(response,backMsg);
		}else {
			RequestDispatcher dispatcher =request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
		
	
		
		}

}
