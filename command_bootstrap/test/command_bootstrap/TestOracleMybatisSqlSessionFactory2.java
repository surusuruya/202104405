package command_bootstrap;


import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;
import com.jsp.dto.NoticeVO;

public class TestOracleMybatisSqlSessionFactory2 {
	
	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;

	@Before
	public void init() {
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testNotNullSession() {
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testNotNullConnection() {
		Assert.assertNotNull(session.getConfiguration());
	}

	@Test
	public void testSQL() throws SQLException {
		
		int testNno = 27;
		
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNno", testNno);
		
		Assert.assertEquals(testNno, notice.getNno());
	}
	
	
}
