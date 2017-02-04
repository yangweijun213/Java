package cn.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	@RequestMapping(value="/hi.do")
	public ModelAndView hello(){
		return null;
	}
	@RequestMapping(value="/hi1.do")
	public void hello(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//req.getRequestDispatcher("/index.jsp").forward(req, resp);
		resp.sendRedirect("/jsp/hello.jsp");
	}
	@RequestMapping("/hi2.do")
	public String hello2(ModelMap map){
		return "forward:index.jsp";
	}
	@RequestMapping("/hi3.do")
	public String hello3(ModelMap map){
		map.addAttribute("msg", "helloworld");
		return "redirect:/WEB-INF/jsp/hello.jsp";
	}
}
