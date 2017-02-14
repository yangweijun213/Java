package cn.sxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.sxt.vo.User;

/**
 * @author Administrator
 *
 */
@Controller
public class UserController {
	//login.do的请求
	@RequestMapping("/login")
	public String login(User user, HttpSession session){
		if ("siggy".equals(user.getName())&&"1111".equals(user.getPwd())){
			//将uer放在session里面
			session.setAttribute("user", user);
			//跳转
			return "redirect:/index.jsp";
		}
		//如果信息不同
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/add")
	public String add(){
		System.out.println("add");
		return "redirect:/login.jsp";
	}

}
