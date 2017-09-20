package com.ssu.splug.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
		else if (where.equals("data"))
			where="<자료실>";
		
		model.addAttribute("where" , where);

		return "/write/boardWrite";
	}
	
	
	@RequestMapping(value = "writeContent", method = RequestMethod.POST)
	 public String writeContetent(@ModelAttribute BoardVO vo,@RequestParam String where,Model model,HttpServletRequest request) throws Exception {	
		
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
		else if(where.equals("<자료실>")){
			path="data";
		    boardService.create(vo,"data",request);
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
		else if (where.equals("data")){
			where="<자료실>";
	        mv.addObject("file_info", boardService.read(bno));
		}
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
		else if(where.equals("<자료실>")){
			where="data"; 
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
		else if(where.equals("<자료실>")){
			where="data";
		}   
    	
    	boardService.delete(bno,where);
        return "redirect:"+where;
    }
    
    @RequestMapping(value="downloadFile")
    public void downloadFile(@RequestParam Map<String,Object> getParam, HttpServletResponse response) throws Exception{
    	Map<String,Object> map = boardService.read_file_info(Integer.parseInt((String) getParam.get("bno")));
        String storedFileName = (String)map.get("fullname");
        String originalFileName = (String)map.get("oriname");
        byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\Users\\hbLee\\git\\SPLUG\\SPLUG\\src\\main\\webapp\\resources\\upload\\"+storedFileName));
         
        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
         
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


	
}
