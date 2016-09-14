package com.jun.demo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StudentIDCard {

	private int id;
	private String kinds;
	private Date datePublished;

	@Id
	@GeneratedValue // 可以定义单独的自增序列，这里共用一个
	public int getId() {
		return id;
	}

}
