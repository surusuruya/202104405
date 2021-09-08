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
		session = sqlSessionFactory.openSession();
		menuDAO = new MenuDAOImpl();
	}
	
	@Test
	public void testSelectMainMenu() throws SQLException{
		List<MenuVO> menuList = menuDAO.selectMainMenu(session);
		
		int cnt = 5;
		
		Assert.assertEquals(cnt, menuList.size());
	}
	
	public void testSelectSubMenu() throws SQLException{
		String testMcode = "M010000";
		
		List<MenuVO> menuList = menuDAO.selectSubMenu(session, testMcode);
		
		Assert.assertEquals(testMcode, menuList.get(0).getUpcode());
		
	}
	
	public void testSelectByMcode() throws SQLException{
		String testMcode = "M010000";
		
		MenuVO menu = menuDAO.selectMenuByMcode(session, testMcode);
		
		Assert.assertEquals(testMcode, menu.getMcode());
	}
	
	public void testSelectByMname() throws SQLException{
		String testMname = "회원관리";
		
		MenuVO menu = menuDAO.selectMenuByMname(session, testMname);
		
		Assert.assertEquals(testMname, menu.getMname());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
