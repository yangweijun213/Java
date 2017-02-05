package cn.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.sxt.vo.User;


@Controller

//�ύ��������
/*public class HelloController {
	public HelloController(){
		System.out.println("hello constructor");
	}
	@RequestMapping("/hello")
	public String hello(String name){
		System.out.println(name);
		return "index.jsp";
	}
}*/

//�ύ��������
/*public class HelloController {
	public HelloController(){
		System.out.println("hello constructor");
	}
	@RequestMapping("/hello")
//	@RequestParam("uname") uname ���ύ���������
	public String hello(@RequestParam("uname")String name){
		System.out.println(name);
		return "index.jsp";
	}
}*/

//�ύ����
/*public class HelloController {
	public HelloController(){
		System.out.println("hello constructor");
	}
	@RequestMapping("/hello")
//	@RequestParam("uname") uname ���ύ���������
	public String hello(@RequestParam("uname")String name){
		System.out.println(name);
		return "index.jsp";
	}
	@RequestMapping("/user")
	public String user (User user){
		System.out.println(user);
		return "index.jsp";
	}
}*/

//��������ʾUI,ͨ��ModelMap��ʵ��-����Ҫ��ͼ������
public class HelloController {
public HelloController(){
	System.out.println("hello constructor");
}
@RequestMapping("/hello")
//@RequestParam("uname") uname ���ύ���������
public String hello(@RequestParam("uname")String name, ModelMap model){
	//�൱��request.setAttribute("name",name)
	model.addAttribute("name", name);
	System.out.println(name);
	return "index.jsp";
}
}