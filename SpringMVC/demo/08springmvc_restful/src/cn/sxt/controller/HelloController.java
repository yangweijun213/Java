package cn.sxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	//传统的方式
	@RequestMapping(value="/hi.do")
	//http://localhost:8080/restful/hi.do?id=2
	public ModelAndView hello(@RequestParam("id") Integer id){
		System.out.println("id=="+id);
		return null;
	}
	//使用Restful方式获取参数
	@RequestMapping("/{id}/hello.do")
	public void helloRestful(@PathVariable("id") int id){
		System.out.println("id=="+id);
	}
	//通过ServletAPI来使用session
	@RequestMapping("/login1.do")
	public String login(HttpSession session,String name){
		session.setAttribute("user", name);
		return "forward:/index.jsp";
	}
}
