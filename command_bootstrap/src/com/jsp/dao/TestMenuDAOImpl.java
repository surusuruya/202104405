package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MenuVO;

public class TestMenuDAOImpl {

	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	
	private MenuDAO menuDAO;
	
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession(false);
		menuDAO = new MenuDAOImpl();
	}
	
	@Test
	public void testselectMainMenu() throws SQLException{
		List<MenuVO> menuList = menuDAO.selectMainMenu(session);
		
		int cnt = 5;
		
		Assert.assertEquals(cnt, menuList.size());
	}
	
	@Test
	public void testsselectSubMenu() throws SQLException{
		String testMCode = "M010000";
		
		List<MenuVO> menu = menuDAO.selectSubMenu(session, testMCode);
		
		String upCode = menu.get(0).getUpcode();
		Assert.assertEquals(testMCode, upCode);
	}
	
	@Test
	public void testselectMenuByMcode() throws SQLException{
		String testMCode = "M010000";
		
		MenuVO menu = menuDAO.selectMenuByMcode(session, testMCode);
		
		Assert.assertEquals(testMCode, menu.getMcode());
	}
	
	@Test
	public void testselectMenuByMname() throws SQLException{
		String testMName = "회원관리";
		
		MenuVO menu = menuDAO.selectMenuByMname(session, testMName);
		
		Assert.assertEquals(testMName, menu.getMname());
	}
	
	@After
	public void complet() {
		session.rollback();
		session.close();
	}
}
