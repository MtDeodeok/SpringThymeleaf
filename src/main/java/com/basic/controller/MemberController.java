package com.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.basic.service.MemberService;
import com.basic.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService ms;
	
	@GetMapping("main")
	public void main() {
		
	}
	
	@GetMapping("/Login") // 로그인
	public void Login() {
		
	}
	
	@PostMapping("/Login") 
	public String Login(String id, String pw) {
		int check = ms.memberCheck(id, pw);
		if(check>0) {
			return "main";
		}
		return "/Login";
	}
	
	@GetMapping("/join") // 회원가입
	public void join() {
		
	}
	
	@PostMapping("/join") 
	public String join(MemberVO membervo) {
		ms.insertMember(membervo);
		return "/Login";
	}
}
