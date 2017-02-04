package cn.sxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//ʹ��ע�⿪�� spring mvc
//ʹ�ø�ע�� spring�����������ע�ⴴ��һ��bean����  �ö����idΪ����(����ĸСд)
//<bean id="helloController" class="cn.sxt.controller.HelloController"/>
@Controller

public class HelloController {
	//ͨ��ʹ��@RequestMapping ע�� ����ָ�������url�� ӳ�䵽�÷�����
	@RequestMapping(value="/hello.do")
	public ModelAndView hello(HttpServletRequest req,
			HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		//��ͼ��
		mv.setViewName("hello"); //web-inf/jsp/hello.jsp
		//��װҪ��ʾ����ͼ�е�����
		mv.addObject("msg", "hello annotation ------"); 
		return mv;
	}
}
