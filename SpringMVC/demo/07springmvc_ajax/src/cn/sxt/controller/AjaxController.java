package cn.sxt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sxt.vo.User;

@Controller
public class AjaxController {
	@RequestMapping("/ajax.do")
	public void ajax(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.getWriter().print("ajax data");
	}
	@RequestMapping("/json.do")
	@ResponseBody
	//将会把返回值 转换为json对象
	public List<User> json(){
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"zhansan",22));
		list.add(new User(2,"wangwu",21));
		list.add(new User(3,"zhaosi",33));
		list.add(new User(4,"wangdana",14));
		return list;
	}
}
