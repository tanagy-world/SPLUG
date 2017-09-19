package com.ssu.persistence;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssu.domain.ReplyVO;
 
 
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
    @Inject
    SqlSession sqlSession;
    
    // 댓글 목록
    @Override
    public List<ReplyVO> list(Integer bno,String where) {
    	System.out.println("reIMPLE list where : " + where);
    	
		if(where.equals("<자유게시판>")){
	        return sqlSession.selectList("com.ssu.mapper.replyMapper.listReplyAgora", bno);
		}
		else if(where.equals("<공지사항>")){
	        return sqlSession.selectList("com.ssu.mapper.replyMapper.listReplyNotification", bno);
		}
		else if(where.equals("<선배의 잡담>")){
	        return sqlSession.selectList("com.ssu.mapper.replyMapper.listReplyRecruit", bno);
		}
		else if(where.equals("<자료실>")){
	        return sqlSession.selectList("com.ssu.mapper.replyMapper.listReplyData", bno);
		}
		else{ //if(where.equals("<회의록>")){
	        return sqlSession.selectList("com.ssu.mapper.replyMapper.listReplyLog", bno);
		}    	
    	
    }
    // 댓글 작성 
    @Override
    public void create(ReplyVO vo,String where) {
     
		if(where.equals("<자유게시판>")){
	        sqlSession.insert("com.ssu.mapper.replyMapper.insertReplyAgora", vo);
		}
		else if(where.equals("<공지사항>")){
	        sqlSession.insert("com.ssu.mapper.replyMapper.insertReplyNotification", vo);
		}
		else if(where.equals("<선배의 잡담>")){
	        sqlSession.insert("com.ssu.mapper.replyMapper.insertReplyRecruit", vo);
		}
		else if(where.equals("<자료실>")){
	        sqlSession.insert("com.ssu.mapper.replyMapper.insertReplyData", vo);
		}
		else{ //if(where.equals("<회의록>")){
	        sqlSession.insert("com.ssu.mapper.replyMapper.insertReplyLog", vo);
		}    	
    	    	
    }
    // 댓글 수정
    @Override
    public void update(ReplyVO vo) {
        // TODO Auto-generated method stub
 
    }
    // 댓글 삭제
    @Override
    public void delete(Integer rno) {
        // TODO Auto-generated method stub
 
    }
 
}