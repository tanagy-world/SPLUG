package com.ssu.splug.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssu.domain.BoardVO;
import com.ssu.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
    @Inject
    BoardService boardService;
    
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("client at home", locale);
		
		return "home";
	}
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("client at home", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "notification", method = RequestMethod.GET)
	public String notification(Locale locale, Model model) {
		logger.info("client at home", locale);
		
		
		return "notification";
	}
	@RequestMapping(value = "recruit", method = RequestMethod.GET)
	public String recruit(Locale locale, Model model) {
		logger.info("client at recruit", locale);
			
		return "recruit";
	}
	@RequestMapping(value = "agora", method = RequestMethod.GET)
	public ModelAndView agora(Locale locale, Model model) throws Exception {
		logger.info("client at agora", locale);
		
        List<BoardVO> list = boardService.listAll();
        // ModelAndView - 모델과 뷰
        ModelAndView mv = new ModelAndView();
        mv.setViewName("agora"); // 뷰를 list.jsp로 설정
        mv.addObject("list", list); // 데이터를 저장
        
                
		return mv;
	}
	@RequestMapping(value = "galary", method = RequestMethod.GET)
	public String galary(Locale locale, Model model) {
		logger.info("client at galary", locale);

		return "galary";
	}
	@RequestMapping(value = "data", method = RequestMethod.GET)
	public String data(Locale locale, Model model) {
		logger.info("client at data", locale);

		
		return "data";
	}
	@RequestMapping(value = "meetingLog", method = RequestMethod.GET)
	public String meetingLog(Locale locale, Model model) {
		logger.info("client at meetingLog", locale);

		return "meetingLog";
	}
	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "signup")
	public String signup() {
		return "signup";
	}

}
