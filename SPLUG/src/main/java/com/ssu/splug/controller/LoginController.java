package com.ssu.splug.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssu.domain.MemberVO;
import com.ssu.service.memberService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	memberService memberservice;
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String login(HttpServletRequest request, MemberVO vo) {
		vo.setUserid((String) request.getParameter("id"));
		vo.setUserpw((String) request.getParameter("password"));
		vo.setUsername((String)request.getParameter("name"));
		vo.setEmail((String) request.getParameter("email"));
		vo.setPhone((String) request.getParameter("phone"));
		vo.setStdid((String) request.getParameter("stdid"));
				
		if(memberservice.registration(vo) == true)
			return "home";
		else
			return "signup";
	}
	
	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, MemberVO vo) {
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("password");
		vo.setUserid(id);
		vo.setUserpw(pw);
		boolean result = memberservice.logincheck(vo, session);
		if(result) {
//			String remember = (String) request.getParameter("remember");
//			if(remember.equals("Remember Me")) {
//				Cookie[] cookie = request.getCookies();
//			}
			return "home";
		}
		return "nlogin";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		memberservice.logout(session);
		return "home";
	}
}
