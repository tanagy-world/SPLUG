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
		else if (where.equals("recruit"))
			where="<선배의 잡담>";
		else if (where.equals("log"))
			where="<회의록>";
		
		model.addAttribute("where" , where);

		return "/write/boardWrite";
	}
	
	
	@RequestMapping(value = "writeContent", method = RequestMethod.POST)
	 public String writeContetent(@ModelAttribute BoardVO vo,@RequestParam String where,Model model) throws Exception {	
		
		String path="home";
				
		if(where.equals("<자유게시판>")){
			path="agora";
		    boardService.create(vo,"agora");
		}
		else if(where.equals("<공지사항>")){
			path="notification";
		    boardService.create(vo,"notification");
		}
		else if(where.equals("<선배의 잡담>")){
			path="recruit";
		    boardService.create(vo,"recruit");
		}
		else if(where.equals("<회의록>")){
			path="log";
		    boardService.create(vo,"log");
		}
			
		return "redirect:"+path;
	}

	
	   // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    @RequestMapping(value="boardView", method=RequestMethod.GET)
    public ModelAndView boardView(@RequestParam int bno, @RequestParam String where ,@RequestParam int curPage,
    		HttpSession session) throws Exception{
    	
    	//조회수 증가
        boardService.increaseViewcnt(bno, session, where);
    	
        ModelAndView mv = new ModelAndView();
        // 뷰의 이름
        mv.setViewName("write/boardView");    
        // 뷰에 전달할 데이터
        mv.addObject("dto", boardService.read(bno,where));
        mv.addObject("curPage",curPage);
        
        System.out.println("DTO  : " +  boardService.read(bno,where).getRecnt());
             
		if(where.equals("agora")){
			where="<자유게시판>";
		}
		else if (where.equals("notification")){
			where="<공지사항>";
		}
		else if (where.equals("recruit"))
			where="<선배의 잡담>";
		else if (where.equals("log"))
			where="<회의록>";
		        
        mv.addObject("where",where);
                        
        return mv;
    }
    
	//수정 페이지를 보여준다
    @RequestMapping(value="ContentUpdateView",method=RequestMethod.POST)
    public ModelAndView updateView(@ModelAttribute BoardVO vo, @RequestParam String where) throws Exception{
 
    	ModelAndView mv = new ModelAndView();
    	
        mv.setViewName("write/ContentUpdateView");    
        mv.addObject("vo", vo);   
        mv.addObject("where",where);
    	
        return mv;
    }
	
    @RequestMapping(value="ContentUpdate", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO vo,  @RequestParam String where) throws Exception{
		
		if(where.equals("<자유게시판>")){
			where="agora";
		}
		else if(where.equals("<공지사항>")){
			where="notification";
		}
		else if(where.equals("<선배의 잡담>")){
			where="recruit";
		}
		else if(where.equals("<회의록>")){
			where="log"; 
		}    	
    	    	
        boardService.update(vo, where);
        
        return "redirect:"+where;
    }
    
    // 05. 게시글 삭제
    @RequestMapping(value="Contentdelete",method=RequestMethod.POST)
    public String delete(@RequestParam int bno , @RequestParam String where) throws Exception{

		if(where.equals("<자유게시판>")){
			where="agora";
		}
		else if(where.equals("<공지사항>")){
			where="notification";
		}
		else if(where.equals("<선배의 잡담>")){
			where="recruit";
		}
		else if(where.equals("<회의록>")){
			where="log";
		}   	
    	
    	boardService.delete(bno,where);
        return "redirect:"+where;
    }
	
}
