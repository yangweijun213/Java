package cn.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	//通过使用@RequestMapping 注解 可以指定请求的url被 映射到该方法上 - 没有视图解析器 
	@RequestMapping("/hello.do")
	public void hello(HttpServletRequest resq, HttpServletResponse resp) throws ServletException, IOException{
			//使用servelt api返回结果
			resp.getWriter().println("hello spring mvc use httpservlet api");
			//实现重定向
			//resp.sendRedirect("index.jsp");		
			//通过HttpServletRequest 实现转发
//			resq.setAttribute("msg", "servlet api forward");
//			resq.getRequestDispatcher("index.jsp").forward(resq, resp);	
	}
	
	//通过spring mvc 来实现转发和重定向-没有视图解析器 
	@RequestMapping("/hello1.do")
	public String hello() {
		//转发 - 方法1
		//return "index.jsp";
		
		//转发 - 方法 2
		//return "forward:index.jsp";
		
		//重定向 
		return "redirect:index.jsp";
	}
	
	//通过spring mvc 来实现转发（有视图解析器 ）和和重定向(没有视图解析器)
	@RequestMapping("/hello2.do")   
	public String hello2(){
		//return "hello";   //转发,实际上到了web-inf/jsp/hello.jsp  (用到了视图解析器)
		return "redirect:hello.do";  //重定向 (没有用到视图解析器)
	}
}
