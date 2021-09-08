package com.jsp.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;

public class LogoutAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// index.jsp 요청
		String url = "redirect:";
		
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 갱신
		return url;
	}

}
