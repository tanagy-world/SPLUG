package com.ssu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssu.domain.BoardVO;

public interface BoardService {
    // 01. 게시글 작성
    public void create(BoardVO vo, String where) throws Exception;
    public void create(BoardVO vo, String where,HttpServletRequest request) throws Exception;
    // 02. 게시글 상세보기
    public BoardVO read(int bno, String where) throws Exception;
    // 03. 게시글 수정
    public void update(BoardVO vo,String where) throws Exception;
    // 04. 게시글 삭제
    public void delete(int bno,String where) throws Exception;
    // 05. 게시글 전체 목록
    public List<BoardVO> listAll(int start, int end,String string) throws Exception;
    // 06. 게시글 조회
    public void increaseViewcnt(int bno, HttpSession session,String where) throws Exception;
    
    // 07. 전체 게시글의 수
    public int countArticle(String where);
    
}