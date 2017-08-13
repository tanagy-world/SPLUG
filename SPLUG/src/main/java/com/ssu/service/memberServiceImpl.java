package com.ssu.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssu.domain.MemberVO;
import com.ssu.persistence.MemberDAO;

@Service
public class memberServiceImpl implements memberService{
	@Inject
	private MemberDAO dao; 
	@Override
	public boolean logincheck(MemberVO vo, HttpSession session) {
		boolean result = dao.loginCheck(vo);
		if(result) {
			MemberVO vo2 = dao.get(vo.getUserid());
			session.setAttribute("userId", vo2.getUserid());
			session.setAttribute("userName", vo2.getUsername());
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Transactional
	@Override
	public boolean registration(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberVO vo2 = dao.get(vo.getUserid());
		
		System.out.println("vo : "+vo.getUserid());
		System.out.println("vo2 : " + vo2);
		
		if(vo2 == null) {
			dao.register(vo);
			return true;
		}
		return false;
	}
	
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}
}
