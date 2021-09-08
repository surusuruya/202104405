package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.NoticeVO;

public class TestNoticeDAOImpl {

	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	private NoticeDAO noticeDAO;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession(false);
		noticeDAO = new NoticeDAOImpl();
	}
	
	@Test
	public void testSelectNoticeByNno() throws SQLException{
		int testNno = 27;
		
		NoticeVO notice = noticeDAO.selectNoticeByNno(session, testNno);
		
		Assert.assertEquals(testNno, notice.getNno());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
}
