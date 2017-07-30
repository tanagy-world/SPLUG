package com.ssu.service;

import javax.servlet.http.HttpSession;

import com.ssu.domain.MemberVO;

public interface memberService {
	public boolean registration(MemberVO vo);
	public boolean logincheck(MemberVO vo, HttpSession session);
	public void logout(HttpSession session);
}
