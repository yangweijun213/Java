package cn.sxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 自定义的Controller需要实现Controller接口
 * */
public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//调用类来进行处理
		System.out.println("-----hello controller-------"); 
		//创建一个ModelAndView对象  该对象最后被视图渲染器渲染为指定视图
		ModelAndView mv = new ModelAndView();
		//封装要显示到视图中的数据 （添加结果数据  该数据可以在页面中通过el表达式获取）
		mv.addObject("msg", "first spring mvc app");
		//设置视图名称 ----最后解析为指定的页面
		mv.setViewName("hello");  //相当于去web-inf/jsp/hello.jsp
		return mv;
	}
}
