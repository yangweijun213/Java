package cn.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sxt.dao.NewsDao;
import cn.sxt.vo.News;

@Controller
public class NewsController {
	private NewsDao newsDao = new NewsDao();
	@RequestMapping("/list.do")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("list", newsDao.list());
		return mv;
	}
	@RequestMapping("/{id}/findById.do")
	public String findById(@PathVariable int id,ModelMap map){
		map.addAttribute("news", newsDao.getById(id));
		return "forward:/WEB-INF/jsp/edit.jsp";
	}
	@RequestMapping("/update.do")
	public String update(News news){
		if(newsDao.update(news)>0){
			return "redirect:/list.do";
		}
		return "forward:/WEB-INF/jsp/error.jsp";
	}
}
