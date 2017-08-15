package com.ssu.splug.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.ssu.service.BoardPager;
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
	public ModelAndView notification(Locale locale, @RequestParam(defaultValue="") String keyword,
            @RequestParam(defaultValue="1") int curPage) throws Exception {
		logger.info("client at home", locale);
		
	    // 레코드의 갯수 계산
	    int count = boardService.countArticle("notification_board");
	    	    
	    // 페이지 나누기 관련 처리
	    BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin()-1;
	    int end = boardPager.getPageEnd();
	    	
		
        List<BoardVO> list = boardService.listAll(start,end,"notification");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list); // list
        map.put("count", count); // 레코드의 갯수
        map.put("boardPager", boardPager);
        
        
        // ModelAndView - 모델과 뷰
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notification"); // 뷰를 list.jsp로 설정
        mv.addObject("map", map); // 데이터를 저장
                  

		return mv;
	}
	
	@RequestMapping(value = "recruit", method = RequestMethod.GET)
	public ModelAndView recruit(Locale locale,@RequestParam(defaultValue="") String keyword,
            @RequestParam(defaultValue="1") int curPage) throws Exception {
		logger.info("client at recruit", locale);
		
	    // 레코드의 갯수 계산
	    int count = boardService.countArticle("recruit_board");
	    	    
	    // 페이지 나누기 관련 처리
	    BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin()-1;
	    int end = boardPager.getPageEnd();
	    	
		
        List<BoardVO> list = boardService.listAll(start,end,"recruit");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list); // list
        map.put("count", count); // 레코드의 갯수
        map.put("boardPager", boardPager);
        
        
        // ModelAndView - 모델과 뷰
        ModelAndView mv = new ModelAndView();
        mv.setViewName("recruit"); // 뷰를 list.jsp로 설정
        mv.addObject("map", map); // 데이터를 저장
        
            

	                
		return mv;
	}
	@RequestMapping(value = "agora", method = RequestMethod.GET)
	public ModelAndView agora(Locale locale, @RequestParam(defaultValue="1") int curPage) throws Exception {
		logger.info("client at agora", locale);
		System.out.println("Agora");
		
	    // 레코드의 갯수 계산
	    int count = boardService.countArticle("agora_board");
	    	    
	    // 페이지 나누기 관련 처리
	    BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin()-1;
	    int end = boardPager.getPageEnd();
	    	
		
        List<BoardVO> list = boardService.listAll(start,end,"agora");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list); // list
        map.put("count", count); // 레코드의 갯수
        map.put("boardPager", boardPager);
        
        
        // ModelAndView - 모델과 뷰
        ModelAndView mv = new ModelAndView();
        mv.setViewName("agora"); // 뷰를 list.jsp로 설정
        mv.addObject("map", map); // 데이터를 저장
        
                
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
	@RequestMapping(value = "log", method = RequestMethod.GET)
	public ModelAndView meetingLog(Locale locale, @RequestParam(defaultValue="") String keyword,
            @RequestParam(defaultValue="1") int curPage) throws Exception {
		logger.info("client at meetingLog", locale);
		
	    // 레코드의 갯수 계산
	    int count = boardService.countArticle("log_board");
	    	    
	    // 페이지 나누기 관련 처리
	    BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin() -1;
	    int end = boardPager.getPageEnd();
	    	
		
        List<BoardVO> list = boardService.listAll(start,end,"log");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list); // list
        map.put("count", count); // 레코드의 갯수
        map.put("boardPager", boardPager);
        
        
        // ModelAndView - 모델과 뷰
        ModelAndView mv = new ModelAndView();
        mv.setViewName("log"); // 뷰를 list.jsp로 설정
        mv.addObject("map", map); // 데이터를 저장

		return mv;
	}
	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "signup")
	public String signup() {
		return "login/signup";
	}

}
