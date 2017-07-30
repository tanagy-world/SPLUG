package com.ssu.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public abstract class GenericDAOImpl<E, K> implements GenericDAO<E, K> {
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.ssu.mapper.MemberMapper";
	
	@Override
	public void register(E vo) {
		sqlSession.insert(namespace + ".register", vo);
	}
	
	@Override
	public boolean loginCheck(E vo) {
		if(sqlSession.selectOne(namespace + ".loginCheck", vo) == null)
			return false;
		else
			return true;
	}
	
	@Override
	public E get(K userid) {
		return sqlSession.selectOne(namespace + ".get", userid);
	}
	
	@Override
	public int delete(K userid) {
		return sqlSession.delete(namespace + ".delete", userid);
	}
	
	@Override
	public List<E> getList() {
		return sqlSession.selectList(namespace + ".getList");
	}

}
