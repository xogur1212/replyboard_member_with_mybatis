package com.jjang051.frontcontroller;

import java.util.HashMap;

import com.jjang051.controller.*;


//여기에서 넘어오는 주소를 controller랑 매핑하는 역할을 한다.
public class HandlerMapping {
	private HashMap<String,AbstractController> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String,AbstractController>();
		//board
		mappings.put("/BoardList02.do", new BoardListController02());
		mappings.put("/BoardWriteForm02.do", new BoardWriteFormController02());
		mappings.put("/BoardWrite02.do", new BoardWriteController02());
		mappings.put("/BoardView02.do", new BoardViewController02());
		mappings.put("/BoardSearchList02.do", new BoardSearchListController02());
		mappings.put("/BoardReplyForm02.do", new BoardReplyFormController02());
		mappings.put("/BoardReplyWrite02.do", new BoardReplyWriteController02());
		mappings.put("/BoardDeleteForm02.do", new BoardDeleteFormController02());
		mappings.put("/BoardDelete02.do", new BoardDeleteController02());
		//member
		mappings.put("/MemberJoinForm02.do", new MemberJoinFormController02());
		mappings.put("/MemberJoin02.do", new MemberJoinController02());
		mappings.put("/MemberLoginForm02.do", new MemberLoginFormController02());
		mappings.put("/MemberLogin02.do", new MemberLoginController02());
		mappings.put("/MemberList02.do", new MemberListController02());
		mappings.put("/MemberInfo02.do", new MemberInfoController02());
		mappings.put("/MemberModifyForm02.do", new MemberModifyFormController02());
		mappings.put("/MemberDeleteForm02.do", new MemberDeleteFormController02());
		mappings.put("/MemberDelete02.do",new MemberDeleteController02());
		mappings.put("/LogOut02.do", new MemberLogoutController02());
		mappings.put("/MemberUpdate02.do", new MemberUpdateController02());
		
	
		
		
	}
	public AbstractController getController(String key) {
		return mappings.get(key);
		
	}
	
}
