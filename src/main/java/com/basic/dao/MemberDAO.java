package com.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.basic.vo.MemberVO;

@Mapper
public interface MemberDAO {
	void insertMember(MemberVO membervo);
	void updateMember(MemberVO membervo);
	void deleteMember(@Param("id") String id);
	List<MemberVO> selectAll();
	MemberVO memberLogin(@Param("id") String id);
	int memberCheck(@Param("id") String id,@Param("pw")  String pw);
}
