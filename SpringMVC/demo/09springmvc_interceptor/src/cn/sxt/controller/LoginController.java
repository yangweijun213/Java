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
//将要写入session中key 通过注解来设置
@SessionAttributes("user")
public class LoginController {
	@RequestMapping("/login.do")
	public String loginUser(String name,ModelMap map){
		//如果@SessionAttributes有modelmap中的key,那么会将值设置到session中
		map.addAttribute("user", name);
		return "forward:/WEB-INF/jsp/index.jsp";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "forward:/WEB-INF/jsp/login.jsp";
	}
	@RequestMapping("/hello.do")
	public String hello(){
		return "forward:/WEB-INF/jsp/hello.jsp";
	}
}
