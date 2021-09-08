package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeModifyAction implements Action {
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// modify 라는 걸 알려줌으로써 조회수를 올리지 않는다.
		String url = "redirect:notice/detail.do?from=modify&nno="+request.getParameter("nno");

		XSSResolver.parseXSS(request);
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		String title = (String)request.getAttribute("XSStitle");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		NoticeVO notice = new NoticeVO();
		notice.setNno(nno);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setContent(writer);
		
		noticeService.modify(notice);
		
		return url;
	}

}
