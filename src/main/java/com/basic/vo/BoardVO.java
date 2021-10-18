package com.basic.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardVO {
	private int idx;
	private String title;
	private String memberid;
	private String contents;
	private LocalDate writeDate;
	private LocalDate modifiyDate;
	private int state;
}
