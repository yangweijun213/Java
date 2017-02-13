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
	//ͨ��ʹ��@RequestMapping ע�� ����ָ�������url�� ӳ�䵽�÷����� - û����ͼ������ 
	@RequestMapping("/hello.do")
	public void hello(HttpServletRequest resq, HttpServletResponse resp) throws ServletException, IOException{
			//ʹ��servelt api���ؽ��
			resp.getWriter().println("hello spring mvc use httpservlet api");
			//ʵ���ض���
			//resp.sendRedirect("index.jsp");		
			//ͨ��HttpServletRequest ʵ��ת��
//			resq.setAttribute("msg", "servlet api forward");
//			resq.getRequestDispatcher("index.jsp").forward(resq, resp);	
	}
	
	//ͨ��spring mvc ��ʵ��ת�����ض���-û����ͼ������ 
	@RequestMapping("/hello1.do")
	public String hello() {
		//ת�� - ����1
		//return "index.jsp";
		
		//ת�� - ���� 2
		//return "forward:index.jsp";
		
		//�ض��� 
		return "redirect:index.jsp";
	}
	
	//ͨ��spring mvc ��ʵ��ת��������ͼ������ ���ͺ��ض���(û����ͼ������)
	@RequestMapping("/hello2.do")   
	public String hello2(){
		//return "hello";   //ת��,ʵ���ϵ���web-inf/jsp/hello.jsp  (�õ�����ͼ������)
		return "redirect:hello.do";  //�ض��� (û���õ���ͼ������)
	}
}
