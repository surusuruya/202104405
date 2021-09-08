package com.jsp.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.NoticeDAO;
import com.jsp.dao.NoticeDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;

public class TestNoticeServiceImpl {

	// 검증된 object
	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	
//	private SqlSessionFactory sqlSessionFactory = new MockSqlSessionFactory();
	private NoticeDAO noticeDAO;
	private NoticeServiceImpl noticeService;
	
	
	@Before public void init() {
		noticeDAO = new NoticeDAOImpl();
		
		noticeService = new NoticeServiceImpl();
		noticeService.setSqlSessionFactory(sqlSessionFactory);
		noticeService.setNoticeDAO(noticeDAO);
	}
	
	@Test
	public void testLogin() throws Exception {
		int testNno = 27;
		
		noticeService.getNotice(testNno);
		
	}
}
