package com.ssu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssu.domain.ReplyVO;
import com.ssu.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
   
   @Inject
   ReplyDAO replyDao;
   
   // 댓글 목록
   @Override
   public List<ReplyVO> list(Integer bno,String where) {
       return replyDao.list(bno,where);
   }
   // 댓글 작성
   @Override
   public void create(ReplyVO vo,String where) {
       replyDao.create(vo,where);
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