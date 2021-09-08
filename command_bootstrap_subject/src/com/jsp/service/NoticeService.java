package com.jsp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jsp.dto.NoticeVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;

public interface NoticeService {

	// 공지사항 정보 조회
	NoticeVO getNotice(int nno) throws SQLException;
	
	// 공지사항 리스트 조회
	List<NoticeVO> getNoticeList() throws SQLException;
	List<NoticeVO> getNoticeList(Criteria cri) throws SQLException;
	Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	// 공지사항 등록
	public void regist(NoticeVO notice) throws SQLException;
	
	// 공지사항 수정
	void modify(NoticeVO notice) throws SQLException;
	
	// 공지사항 삭제
	void remove(int nno) throws SQLException;
	
}
