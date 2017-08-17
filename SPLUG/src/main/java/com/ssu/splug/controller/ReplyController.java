package com.ssu.splug.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssu.domain.ReplyVO;
import com.ssu.service.ReplyService;

// REST : Representational State Transfer
// 하나의 URI가 하나의 고유한 리소스를 대표하도록 설계된 개념

// http://localhost/spring02/list?bno=1 ==> url+파라미터
// http://localhost/spring02/list/1 ==> url
// RestController은 스프링 4.0부터 지원
// @Controller, @RestController 차이점은 메서드가 종료되면 화면전환의 유무

@Controller
// @RestController
// @RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	ReplyService replyService;

	// 댓글 입력
	@RequestMapping("insertReply")
	public void insert(@ModelAttribute ReplyVO vo, @RequestParam String where, HttpSession session) {
		// String userId = (String) session.getAttribute("userId");
		// vo.setReplyer(userId);
		vo.setReplyer("None");

		replyService.create(vo, where);
	}

	// 댓글 목록(@Controller방식 : veiw(화면)를 리턴)
	@RequestMapping("listReply")
	public ModelAndView list(@RequestParam int bno,@RequestParam String where, ModelAndView mav) {
		List<ReplyVO> list = replyService.list(bno,where);
		
		// 뷰이름 지정
		mav.setViewName("reply/replyList");
		// 뷰에 전달할 데이터 지정
		mav.addObject("list", list);
		mav.addObject("recnt",list.size());
		// replyList.jsp로 포워딩
		return mav;
	}

}
