package cn.sxt.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String name;
	private int age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
