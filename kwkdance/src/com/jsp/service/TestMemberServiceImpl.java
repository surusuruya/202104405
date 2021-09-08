package com.jsp.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dao.MockMemberDAO;
import com.jsp.datasource.MockSqlSessionFactory;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;

public class TestMemberServiceImpl {
	
	// 검증 완료된 db와 연결
	private SqlSessionFactory sqlSessionFactory = new MockSqlSessionFactory();

	private MemberDAO memberDAO;
	private MemberServiceImpl memberService;
	
	@Before
	public void init() {
		memberDAO = new MockMemberDAO(); // 검증 완료된 dao
		
		memberService = new MemberServiceImpl();
		memberService.setSqlSessionFactory(sqlSessionFactory);
		memberService.setMemberDAO(memberDAO);
	}
	
	@Test
	public void testLogin() throws Exception {
		String testID = "kwk", testPwd = "0916";
		
		memberService.login(testID, testPwd);
		
	}
}
