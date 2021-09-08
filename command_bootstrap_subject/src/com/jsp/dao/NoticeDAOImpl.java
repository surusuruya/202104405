package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NoticeVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException {
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNno", nno);
		return notice;
	}

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList");
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<NoticeVO> noticeList
		= session.selectList("Notice-Mapper.selectSearchNoticeList", null, rowBounds);
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<NoticeVO> noticeList
		= session.selectList("Notice-Mapper.selectSearchNoticeList", cri, rowBounds);
		return noticeList;
	}
	
	@Override
	public int selectNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = 0;
		count=session.selectOne("Notice-Mapper.selectSearchNoticeListCount", cri);
		return count;
	}
	
	@Override
	public void insertNotice(SqlSession session, NoticeVO notice) throws SQLException {
		session.update("Notice-Mapper.insertNotice", notice);
	}

	@Override
	public void updateNotice(SqlSession session, NoticeVO notice) throws SQLException {
		session.update("Notice-Mapper.updateNotice", notice);
	}

	@Override
	public void deleteNotice(SqlSession session, int nno) throws SQLException {
		session.update("Notice-Mapper.deleteNotice", nno);
		
	}



}
