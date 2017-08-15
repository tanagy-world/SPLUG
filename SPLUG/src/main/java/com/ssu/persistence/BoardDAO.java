package com.ssu.persistence;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.ssu.domain.BoardVO;

public interface BoardDAO {
    // 01. 게시글 작성
    public void create(BoardVO vo,String where) throws Exception;
    // 02. 게시글 상세보기
    public BoardVO read(int bno,String where) throws Exception;
    // 03. 게시글 수정
    public void update(BoardVO vo,String where) throws Exception;
    // 04. 게시글 삭제
    public void delete(int bno,String where) throws Exception;
    // 05. 게시글 전체 목록
    public List<BoardVO> listAll(int start, int end,String where) throws Exception;
    // 06. 게시글 조회 증가
    public void increaseViewcnt(int bno,String where) throws Exception;
    // 07. 전체 게시글 수 조회
	public int countArticle(String where);
    }