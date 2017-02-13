package cn.sxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//使用注解开发 spring mvc
@Controller
public class HelloController {
	//通过使用@RequestMapping注解，可以指定请求的url被映射到该方法上
	@RequestMapping(value="/hello.do") //这个是处理类。例如来了一个请求，就映射到这个处理类上。
	//这个处理类映射到下面的其中一个方法上
	public ModelAndView hello(HttpServletRequest req,
			HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		//封装要显示到视图中的数据
		mv.addObject("msg", "hello annotation ------"); 
		//视图名
		mv.setViewName("hello"); //web-inf/jsp/hello.jsp
		return mv;
	}
	
	//。。可以继续写处理类和映射方法
}
