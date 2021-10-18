package com.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.basic.vo.BoardVO;

@Mapper
public interface BoardDAO {
	void createContents(BoardVO boardvo);
	void updateContents(BoardVO boardvo);
	void deleteContents(@Param("memberid")String memberid,@Param("idx") int idx);
	List<BoardVO> selectAll();
	BoardVO selectTitle(@Param("title") String title);
}
