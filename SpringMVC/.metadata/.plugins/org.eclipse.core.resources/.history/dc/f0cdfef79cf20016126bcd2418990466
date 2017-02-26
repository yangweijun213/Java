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
//提交的域名称和方法参数一致 -不需要视图解析器
//public class HelloController {
////	public HelloController(){
////		System.out.println("hello constructor");
////	}
//	@RequestMapping("/hello")
//	public String hello(String name){
//		System.out.println(name);
//		return "index.jsp";
//	}
//}

//提交的域名称和方法参数不一致
/*public class HelloController {
	@RequestMapping("/hello")
//	@RequestParam("uname") uname 是提交的域的名称
	public String hello(@RequestParam("uname")String name){
		System.out.println(name);
		return "index.jsp";
	}
}*/

//提交的是对象
/*public class HelloController {
	@RequestMapping("/user")
	public String user (User user){
		System.out.println(user);
		return "index.jsp";
	}
}*/

//将数据显示UI,通过ModelMap来实现-不需要视图解析器
public class HelloController {
@RequestMapping("/hello")
/*@RequestParam("uname") uname 是提交的域的名称
 * 
 */
public String hello(@RequestParam("uname")String name, ModelMap model){
	//相当于request.setAttribute("name",name)
	model.addAttribute("name", name);
	System.out.println(name);
	return "index.jsp";
}
}