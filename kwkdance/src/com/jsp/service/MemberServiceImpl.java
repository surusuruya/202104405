package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public class MemberServiceImpl implements MemberService {

	// dao 와 sqlSessionFactory 호출
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIdException, 
														InvalidPasswordException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			MemberVO member = memberDAO.selectMemberById(session, id);
			
			if (member == null) 
				throw new NotFoundIdException();
			if (!pwd.equals(member.getPwd()))
				throw new InvalidPasswordException();
			
		} finally {
			session.close();
		}
	}



	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session);
			return memberList;
			
		} finally {
			session.close();
		}
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
			
		} finally {
			session.close();
		}
	}


	@Override
	public void regist(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			memberDAO.insertMember(session, member);
		} finally {
			session.close();
		}
	}


	@Override
	public void modify(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.updateMember(session, member);
		} finally {
			session.close();
		}
		
	}


	@Override
	public void remove(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.deleteMember(session, id);
		} finally {
			session.close();
		}
	}


	@Override
	public void disabled(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.disableMember(session, id);
		} finally {
			session.close();
		}
		
	}


	@Override
	public void enabled(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.enabledMember(session, id);
		} finally {
			session.close();
		}
		
	}

}
