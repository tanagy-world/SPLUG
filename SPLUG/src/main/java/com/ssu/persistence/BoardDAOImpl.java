package com.ssu.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssu.domain.BoardVO;
@Repository    // 현재 클래스를 dao bean으로 등록
public class BoardDAOImpl implements BoardDAO {
    @Inject
    SqlSession SqlSession;
    // 01. 게시글 작성
    @Override
    public void create(BoardVO vo) throws Exception {
        SqlSession.insert("com.ssu.mapper.boardMapper.insert", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public BoardVO read(int bno) throws Exception {
        return SqlSession.selectOne("com.ssu.mapper.boardMapper.view", bno);
    }
    // 03. 게시글 수정
    @Override
    public void update(BoardVO vo) throws Exception {
        SqlSession.update("com.ssu.mapper.boardMapper.updateArticle", vo);
 
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int bno,String where) throws Exception {
    	
        SqlSession.delete("com.ssu.mapper.boardMapper.deleteArticle",bno);
    }
    // 05. 게시글 전체 목록
    @Override
    public List<BoardVO> listAll() throws Exception {
        return SqlSession.selectList("com.ssu.mapper.boardMapper.listAll");
    }
    // 게시글 조회수 증가
    @Override
    public void increaseViewcnt(int bno) throws Exception {
        SqlSession.update("com.ssu.mapper.boardMapper.increaseViewcnt", bno);
    }
 
}
