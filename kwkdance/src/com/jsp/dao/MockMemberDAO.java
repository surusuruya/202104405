package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;

public class MockMemberDAO implements MemberDAO {

	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {

		MemberVO member = null;
		
		if (id.equals("kwk")) {
			member = new MemberVO();
			member.setId("kwk");
			member.setPwd("0916");
			member.setName("kwk");
		}
		
		return member;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(SqlSession session, MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(SqlSession session, MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(SqlSession session, String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableMember(SqlSession session, String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enabledMember(SqlSession session, String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
