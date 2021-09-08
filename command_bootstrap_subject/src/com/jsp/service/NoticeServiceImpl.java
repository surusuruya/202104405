package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.NoticeDAO;
import com.jsp.dto.MemberVO;
import com.jsp.dto.NoticeVO;
import com.jsp.request.Criteria;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class NoticeServiceImpl implements NoticeService {
	private SqlSessionFactory sqlSessionFactory;
	private NoticeDAO noticeDAO;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public NoticeVO getNotice(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			NoticeVO notice = noticeDAO.selectNoticeByNno(session, nno);
			return notice;
			
		} finally {
			session.close();
		}
	}

	@Override
	public List<NoticeVO> getNoticeList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session);
			return noticeList;
		} finally {
			session.close();
		}
	}

	@Override
	public List<NoticeVO> getNoticeList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session,cri);
			return noticeList;
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session,cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(noticeDAO.selectNoticeListCount(session, cri));
			
			dataMap.put("noticeList", noticeList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		} finally {
			session.close();
		}
	}

	
	@Override
	public void regist(NoticeVO notice) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			noticeDAO.insertNotice(session, notice);
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			noticeDAO.updateNotice(session, notice);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			noticeDAO.deleteNotice(session, nno);
		} finally {
			session.close();
		}
	}

}
