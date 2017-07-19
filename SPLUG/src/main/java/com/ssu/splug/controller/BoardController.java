package com.ssu.splug.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class BoardController {
	
    @Inject
    BoardService boardService;
    
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "boardWrite", method = RequestMethod.GET)
	public String write(Locale locale, Model model, @RequestParam("where") String where) {
		
		logger.info("client write at "+where, locale);
		
		if(where.equals("agora")){
			where="<자유게시판>";
		}
		else if (where.equals("notification")){
			where="<공지사항>";
		}
		
		model.addAttribute("where" , where);

		return "/write/boardWrite";
	}
	
	
	@RequestMapping(value = "writeContent", method = RequestMethod.POST)
	 public String writeContetent(@ModelAttribute BoardVO vo,@RequestParam String where,Model model) throws Exception {	
		
		String path="home";
		
		if(where.equals("<자유게시판>"))
			path="agora";

	    boardService.create(vo);

		
		return "redirect:"+path;
	}

	
	   // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    @RequestMapping(value="boardView", method=RequestMethod.GET)
    public ModelAndView boardView(@RequestParam int bno, @RequestParam String where ,HttpSession session) throws Exception{

		if(where.equals("agora")){
			where="<자유게시판> ";
		}
		else if (where.equals("notification")){
			where="<공지사항> ";
		}
		
    	
        ModelAndView mv = new ModelAndView();
        // 뷰의 이름
        mv.setViewName("write/boardView");
        // 뷰에 전달할 데이터
        mv.addObject("dto", boardService.read(bno));
        mv.addObject("where",where);
        
        boardService.increaseViewcnt(bno, session);
        
        
        return mv;
    }
	
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO vo) throws Exception{
        boardService.update(vo);
        return "redirect:list.do";
    }
    
    // 05. 게시글 삭제
    @RequestMapping(value="delete",method=RequestMethod.POST)
    public String delete(@RequestParam int bno , @RequestParam String where) throws Exception{
        boardService.delete(bno,where);
        return "redirect:agora";
    }
	
}
