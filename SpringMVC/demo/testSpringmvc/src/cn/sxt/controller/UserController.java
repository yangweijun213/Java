package cn.sxt.controller;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.sxt.vo.User;

@Controller
public class UserController {
	@RequestMapping(value="/add.do",method=RequestMethod.GET)
	public ModelAndView add1(@RequestParam("uname") String name) throws UnsupportedEncodingException{
		System.out.println("name="+name);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg", "添加成功");
		return mv;
	}
}
