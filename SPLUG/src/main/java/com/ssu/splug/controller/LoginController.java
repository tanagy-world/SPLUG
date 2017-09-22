package com.ssu.splug.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssu.domain.MemberVO;
import com.ssu.service.memberService;
import com.ssu.util.MailService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	memberService memberservice;
	
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String login(HttpServletRequest request, MemberVO vo) {
		vo.setUserid((String) request.getParameter("user_id"));
		vo.setUserpw((String) request.getParameter("user_pwd"));
		vo.setUsername((String)request.getParameter("user_name"));
		vo.setEmail((String) request.getParameter("email"));
		vo.setPhone((String) request.getParameter("user_phone"));
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
	
	@RequestMapping(value = "/idCheck", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String idCheck(@RequestParam (value= "id") String id) {

		boolean check=memberservice.idCheck(id);
		return check+"";
	}
	
	//메일  인증
	@RequestMapping(value = "/regiMail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String sendMailAuth(HttpSession session, @RequestParam String email) {
		
	
		
        int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
        String joinCode = String.valueOf(ran);
        session.setAttribute("joinCode", joinCode);
 
        String subject = "회원가입 인증 코드 발급 안내 입니다.";
        StringBuilder sb = new StringBuilder();
        sb.append("귀하의 인증 코드는 " + joinCode + " 입니다.");
         boolean check=mailService.send(subject, sb.toString(), "lhb5759@gmail.com", email, null);
         

         return check+"";
	
	}
	@RequestMapping(value = "/regiMail_check", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String checkMailAuth(HttpSession session, @RequestParam String code) {
		
		String joincode=(String)session.getAttribute("joinCode");
		
		return joincode.equals(code)+"";
		
	
	}
}
