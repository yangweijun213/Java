package cn.sxt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sxt.vo.User;

@Controller
public class JsonContoller {
	
	@RequestMapping("/json")
	@ResponseBody
	public List<User> jsons(){
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"ja","male"));
		list.add(new User(2,"ba","female"));
		list.add(new User(3,"ca","male"));
		return list;
	}

}
