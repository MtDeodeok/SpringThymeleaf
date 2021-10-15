package com.basic.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private LocalDate registDate;
	private int grade;
	private String profile;
}
