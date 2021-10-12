package com.basic.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.dao.MemberDAO;
import com.basic.util.ShaUtils;
import com.basic.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberDAO memberdao;
	
	private final ShaUtils shautils;
	
	@Override
	public void insertMember(MemberVO membervo) {
		LocalDate now = LocalDate.now();
		membervo.setRegistDate(now);
		String password = shautils.encodingPw(membervo.getPw());
		membervo.setPw(password);
		memberdao.insertMember(membervo);
	}

	@Override
	public void updateMember(MemberVO membervo) {

	}

	@Override
	public void deleteMember(String id) {

	}

	@Override
	public List<MemberVO> selectAll() {
		
		return null;
	}

	@Override
	public MemberVO selectId(String id) {
		
		return null;
	}

	@Override
	public int memberCheck(String id, String pw) {
		String password = shautils.encodingPw(pw);
		return memberdao.memberCheck(id, password);
	}

}
