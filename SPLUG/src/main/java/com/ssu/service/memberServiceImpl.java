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
		if(dao.get(vo.getUserid())==null) {
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

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		
		return dao.idCheck(id);
	}
}
