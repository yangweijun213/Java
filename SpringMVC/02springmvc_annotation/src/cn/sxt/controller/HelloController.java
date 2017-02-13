package cn.sxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//ʹ��ע�⿪�� spring mvc
@Controller
public class HelloController {
	//ͨ��ʹ��@RequestMappingע�⣬����ָ�������url��ӳ�䵽�÷�����
	@RequestMapping(value="/hello.do") //����Ǵ����ࡣ��������һ�����󣬾�ӳ�䵽����������ϡ�
	//���������ӳ�䵽���������һ��������
	public ModelAndView hello(HttpServletRequest req,
			HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		//��װҪ��ʾ����ͼ�е�����
		mv.addObject("msg", "hello annotation ------"); 
		//��ͼ��
		mv.setViewName("hello"); //web-inf/jsp/hello.jsp
		return mv;
	}
	
	//�������Լ���д�������ӳ�䷽��
}
