package com.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.service.BoardService;
import com.basic.service.CommentService;
import com.basic.vo.BoardVO;
import com.basic.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService bs;
	private final CommentService cs;
	
	@GetMapping("/board")
	public void board(HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member!=null) {
			model.addAttribute("loginMember",member);
		}
		model.addAttribute("boardList",bs.selectAll());
	}
	
	@GetMapping("/createContentsForm")
	public void createContentsForm(HttpSession session) {
		
	}
	
	@PostMapping("/createContents")
	public String createContents(HttpSession session,BoardVO boardvo) {
		boardvo.setMemberid((String) session.getAttribute("memberID"));
		System.out.println(boardvo.getMemberid());
		
		bs.createContents(boardvo);
		return "redirect:/board";
	}
	
	@GetMapping("/detailPage")
	public void detailPage() {
		
	}
	
	@PostMapping("detail")
	public String detail(Model model,String title, int idx) {
		model.addAttribute("detail", bs.selectTitle(title));
		model.addAttribute("boardComment",cs.selectBoardComment(idx));
		return "/detailPage";
	}
	
	@PostMapping("updateContents")
	public String updateContents(BoardVO boardvo) {
		bs.updateContents(boardvo);
		return "redirect:/board";
	}
	
	@PostMapping("deleteContents")
	public String deleteContents(String memberid, int idx) {
		cs.deleteBoardComment(idx);
		bs.deleteContents(memberid, idx);
		return "redirect:/board";
	}
	
}
