package com.basic.service;

import java.util.List;


import com.basic.vo.BoardVO;

public interface BoardService {
	void createContents(BoardVO boardvo);
	void updateContents(BoardVO boardvo);
	void deleteContents(String memberid, int idx);
	List<BoardVO> selectAll();
	BoardVO selectTitle(String title);
}
