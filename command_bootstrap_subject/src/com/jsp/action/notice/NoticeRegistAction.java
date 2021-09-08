package com.jsp.action.notice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String url = "notice/regist_success";
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String start = fm.format(date);
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		notice.setStartDate(fm.parse(start));
	      
	    noticeService.regist(notice);
	    
		return url;
	}

}
