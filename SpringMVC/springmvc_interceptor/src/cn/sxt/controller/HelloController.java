package cn.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("hello controller");
		return "index.jsp";
	}
}
