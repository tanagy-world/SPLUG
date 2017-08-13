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
    public void create(BoardVO vo,String where) throws Exception {

    	if(where.equals("agora"))
    		SqlSession.insert("com.ssu.mapper.boardMapper.insertAgora", vo);
    	else if(where.equals("notification"))
    		SqlSession.insert("com.ssu.mapper.boardMapper.insertNotification", vo);
    	else if(where.equals("recruit"))
    		SqlSession.insert("com.ssu.mapper.boardMapper.insertRecruit", vo);
    	else if(where.equals("log"))
    		SqlSession.insert("com.ssu.mapper.boardMapper.insertLog", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public BoardVO read(int bno,String where) throws Exception {
        System.out.println("where DAOImple : "+where);
    	
    	if(where.equals("agora")){
            return SqlSession.selectOne("com.ssu.mapper.boardMapper.viewAgora", bno);
    	}
    	else if(where.equals("notification")){
    		return SqlSession.selectOne("com.ssu.mapper.boardMapper.viewNotification", bno);
    	}
    	else if(where.equals("recruit")){
    		return SqlSession.selectOne("com.ssu.mapper.boardMapper.viewRecruit", bno);
    	}
    	else if(where.equals("log")){
    		return SqlSession.selectOne("com.ssu.mapper.boardMapper.viewLog", bno);
    	}
    	else
    		return SqlSession.selectOne("com.ssu.mapper.boardMapper.viewLog", bno);

        
    }
    
    // 03. 게시글 수정
    @Override
    public void update(BoardVO vo,String where) throws Exception {

    	if(where.equals("agora"))
            SqlSession.update("com.ssu.mapper.boardMapper.updateArticleAgora", vo);
    	else if(where.equals("notification"))
            SqlSession.update("com.ssu.mapper.boardMapper.updateArticleNotification", vo);
    	else if(where.equals("recruit"))
            SqlSession.update("com.ssu.mapper.boardMapper.updateArticleRecruit", vo);
    	else if(where.equals("log"))
            SqlSession.update("com.ssu.mapper.boardMapper.updateArticleLog", vo);
 
    }
    
    // 04. 게시글 삭제
    @Override
    public void delete(int bno,String where) throws Exception {
        
    	if(where.equals("agora"))
            SqlSession.delete("com.ssu.mapper.boardMapper.deleteArticleAgora",bno);
    	else if(where.equals("notification"))
            SqlSession.delete("com.ssu.mapper.boardMapper.deleteArticleNotification",bno);
    	else if(where.equals("recruit"))
            SqlSession.delete("com.ssu.mapper.boardMapper.deleteArticleRecruit",bno);
    	else if(where.equals("log"))
            SqlSession.delete("com.ssu.mapper.boardMapper.deleteArticleLog",bno);
        
    }
    // 05. 게시글 전체 목록
    @Override
    public List<BoardVO> listAll(String where) throws Exception {

    	if(where.equals("agora")){
    		return SqlSession.selectList("com.ssu.mapper.boardMapper.listAllAgora");
    	}
    	else if(where.equals("notification")){
    		return SqlSession.selectList("com.ssu.mapper.boardMapper.listAllNotification");
    	}
    	else if(where.equals("recruit")){
    		return SqlSession.selectList("com.ssu.mapper.boardMapper.listAllRecruit");
    	}
    	else if(where.equals("log")){
    		return SqlSession.selectList("com.ssu.mapper.boardMapper.listAllLog");
    	}
    	 	
		//일단 아무거나 ...
    	return SqlSession.selectList("com.ssu.mapper.boardMapper.listAllRecruit");
    	
    }
    // 게시글 조회수 증가
    @Override
    public void increaseViewcnt(int bno,String where) throws Exception {        

    	if(where.equals("agora"))
            SqlSession.update("com.ssu.mapper.boardMapper.increaseViewcntAgora", bno);
    	else if(where.equals("notification"))
            SqlSession.update("com.ssu.mapper.boardMapper.increaseViewcntNotification", bno);
    	else if(where.equals("recruit"))
            SqlSession.update("com.ssu.mapper.boardMapper.increaseViewcntRecruit", bno);
    	else if(where.equals("log"))
            SqlSession.update("com.ssu.mapper.boardMapper.increaseViewcntLog", bno);
    }

 
}
