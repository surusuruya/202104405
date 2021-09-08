package kwkdance;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class TestOraclMybatisSqlSessionFactory {

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
		
		String testID = "kwk";
		
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", testID);
		
		Assert.assertEquals(testID, member.getName());
	}

	@After
	public void complete() {
		session.close();
	}
	
}
