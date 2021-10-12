package com.basic.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.basic.vo.MemberVO;

public interface MemberService {
	void insertMember(MemberVO membervo);
	void updateMember(MemberVO membervo);
	void deleteMember(@Param("id") String id);
	List<MemberVO> selectAll();
	MemberVO selectId(@Param("id") String id);
	int memberCheck(@Param("id") String id,@Param("pw")  String pw);
}
