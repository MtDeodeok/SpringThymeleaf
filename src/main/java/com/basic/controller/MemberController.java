package com.basic.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String Login(Model model,String id, String pw) {
		int check = ms.memberCheck(id, pw);
		if(check>0) {
			model.addAttribute("loginMember", ms.memberLogin(id));
			return "main";
		}
		return "/Login";
	}
	
	@GetMapping("/join") // 회원가입
	public void join() {
		
	}
	
	@PostMapping("/join") 
	public String join(@RequestParam("profileimg") MultipartFile file, MemberVO membervo,HttpServletRequest req) {
		String imgName = membervo.getId()+file.getOriginalFilename();

		String uploadPath = req.getSession().getServletContext().getRealPath("/");
		String imgUploadPath = uploadPath+"profileImg\\";
		File save = new File(imgUploadPath+imgName);
		
		File destdir = new File(imgUploadPath);
		if(!destdir.exists()) {
			destdir.mkdirs();
		}
		try {
			file.transferTo(save);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		membervo.setProfile("\\profileImg\\"+imgName);
		ms.insertMember(membervo);
		return "/Login";
	}
}
