package cn.sxt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sxt.dao.UserDao;

@Controller
public class UserController {
	private UserDao userDao = new UserDao();
	@RequestMapping("/list.do")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("list", userDao.list());
		return mv;
	}
	@RequestMapping("/delete.do")
	public String delete(int id,ModelMap map){
		//ModelAndView mv = new ModelAndView("l");
		if(userDao.delete(id)>0){
			//mv.addObject("msg", "删除成功！");
			return "redirect:/list.do";
		}else{
			//mv.addObject("msg", "删除失败！");
		}
		return null;
	}
	@RequestMapping("/toAdd.do")
	public ModelAndView toAdd(){
		return new ModelAndView("add");
	}
	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req){
		//System.out.println(user.getBirthday());
		System.out.println(req.getParameter("u.name")+"----");
		System.out.println(req.getParameter("r.name"));
		ModelAndView mv = new ModelAndView("info");
//		if(userDao.add(user)>0){
//			mv.addObject("msg", "添加成功！");
//		}else{
//			mv.addObject("msg", "添加失败！");
//		}
		return mv;
	}
}
