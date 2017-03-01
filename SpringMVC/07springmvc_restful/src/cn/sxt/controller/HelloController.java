package cn.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.sxt.vo.User;

@Controller

public class HelloController {

	// ��ͳ��ʽ1
	@RequestMapping("/hello")
	public String hello(@RequestParam("name") String name, ModelMap model) {
		// �൱��request.setAttribute("name",name)���������ݵ�ҳ��
		model.addAttribute("name", name);
		System.out.println(name);
		return "index.jsp";
	}

	// ��ͳ��ʽ2 hello2.do?name=jeff
	@RequestMapping(value = "/hello2.do")
	public String hello2(@RequestParam("name") String name) {
		System.out.println("name=" + name);
		return "index.jsp";
	}

	// ʹ��Restful /123/hello3.do
	@RequestMapping("/{id}/hello3.do")
	public String hello3(@PathVariable("id") Integer id) {
		System.out.println("id=" + id);
		return "index.jsp";
	}

	// ʹ��Restful /hello4/123.do
	@RequestMapping("/hello4/{id}")
	public String hello4(@PathVariable("id") Integer id) {
		System.out.println("id=" + id);
		return "index.jsp";
	}

	// ʹ��Restful ����������  /restful/123/456/hello5.do
	@RequestMapping("/{id}/{uid}/hello5.do")
	public String hello5(@PathVariable("id") Integer id,@PathVariable("uid") Integer uid) {
		System.out.println("id=" + id);
		System.out.println("uid=" + uid);
		return "index.jsp";
	}
}