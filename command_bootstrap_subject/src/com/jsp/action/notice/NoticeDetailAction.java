package com.jsp.action.notice;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeDetailAction implements Action {
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/detail";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
//		String title = request.getParameter("title");
		
		NoticeVO vo = new NoticeVO();
		vo.setNno(nno);
//		vo.setTitle(title);
		
		NoticeVO notice = noticeService.getNotice(nno);
		request.setAttribute("notice", notice);
		
		return url;
	}

}
