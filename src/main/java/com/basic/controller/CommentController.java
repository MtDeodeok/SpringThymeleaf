package com.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.basic.service.BoardService;
import com.basic.service.CommentService;
import com.basic.vo.CommentVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService cs;
	private final BoardService bs;
	
	@GetMapping("createComment")
	public void createComment() {
		
	}
	
	@PostMapping("createComment")
	public String createComment(CommentVO commentvo) {
		cs.createComment(commentvo);
		return "redirect:/board";
	}
	
	@PostMapping("updateComment")
	public String updateComment(CommentVO commentvo) {
		System.out.println(commentvo);
		cs.updateComment(commentvo);
		return "redirect:/board";
	}
	
	@PostMapping("deleteComment")
	public String deleteComment(int id) {
		cs.deleteComment(id);
		return "redirect:/board";
	}
}
