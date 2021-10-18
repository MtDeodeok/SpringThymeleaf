package com.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.basic.service.BoardService;
import com.basic.service.MemberService;
import com.basic.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService bs;
	
	@GetMapping("/board")
	public void board(Model model, BoardVO boardVO) {
		model.addAttribute("boardList",bs.selectAll());
	}
	
	@GetMapping("/createContentsForm")
	public void createContentsForm() {
		
	}
	
	@PostMapping("/createContents")
	public String createContents(BoardVO boardvo) {
		System.out.println("cont "+boardvo);
		bs.createContents(boardvo);
		return "redirect:/board";
	}
	
	@GetMapping("/detailpage")
	public void detailPage() {
		
	}
	@PostMapping("detail")
	public String detail(Model model,String title) {
		model.addAttribute("detail", bs.selectTitle(title));
		return "/detailPage";
	}
	
	@PostMapping("updateContents")
	public String updateContents(BoardVO boardvo) {
		bs.updateContents(boardvo);
		return "redirect:/board";
	}
	
	@PostMapping("deleteContents")
	public String deleteContents(String memberid, int idx) {
		bs.deleteContents(memberid, idx);
		return "redirect:/board";
	}
	
}
