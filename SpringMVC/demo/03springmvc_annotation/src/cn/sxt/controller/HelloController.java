package cn.sxt.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//使用注解开发 spring mvc
//使用该注解 spring容器将会根据注解创建一个bean对象  该对象的id为类名(首字母小写)
//<bean id="helloController" class="cn.sxt.controller.HelloController"/>
@Controller
public class HelloController {
	//通过使用@RequestMapping 注解 可以指定请求的url被 映射到该方法上
	@RequestMapping(value="/hi.do")
	public ModelAndView hello(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("msg", "annotation ------");
		return mv;
	}
}
